let options = 2;

function addOption() {
    $("#close" + options).remove();
    ++options;
    let append = "" +
        "<div class=\"option" + options + "\">\n" +
        "    <div class=\"input-group mb-3\">\n" +
        "        <span class=\"input-group-text\">选项" + options + "</span>\n" +
        "        <input class=\"form-control\" id=\"option" + options + "\" type=\"text\">\n" +
        "        <div class=\"cls\"></div>\n" +
        "        <span class=\"input-group-text\" id=\"close" + options + "\">\n" +
        "            <button class=\"btn btn-sm\" type=\"button\" onclick=\"delOption()\">\n" +
        "               <i class=\"bi bi-x\"></i>\n" +
        "            </button>\n" +
        "        </span>\n" +
        "    </div>\n" +
        "</div>";
    $(".add").append(append);
}

function delOption() {
    $(".option" + options).remove();
    --options;
    $(".option" + options + " .cls").after("" +
        "<span class=\"input-group-text\" id=\"close" + options + "\">\n" +
        "   <button class=\"btn btn-sm\" type=\"button\" onclick=\"delOption()\">\n" +
        "       <i class=\"bi bi-x\"></i>\n" +
        "   </button>\n" +
        "</span>");
}

function createNewPoll() {
    $(".isError").html("");
    setTimeout(function () {
        if (checkContent()) {
            let str = "";
            for (let i = 1; i <= options; ++i) {
                let text = $("#option" + i).val();
                if (i === 1) {
                    str += text;
                } else {
                    str += ";" + text;
                }
            }

            let params = {};
            params.shop = $("#form-shop").val();
            params.options = str;

            $.post({
                url: '/createnew',
                data: params,
                success: function (data) {
                    setTimeout(function () {
                        location.href = '/success';
                    }, 500);
                }
            });

        } else {
            $(".errorMsg").html("<span style='color: red; '>尚有内容未填写，请检查输入</span>");
        }
    }, 500);
}

function checkContent() {
    return $("input").filter(function () {
        return $.trim($(this).val()).length === 0
    }).length === 0;
}

function vote() {
    $(".isError").html("");
    setTimeout(function () {
        if (checkOptionSelected()) {
            let id = $("input[name='voteOptionRadio']:checked").attr("id");

            let params = {};
            params.voteId = $("#voteId").val();
            params.voteFor = $("label[for='" + id + "']").text().trim();
            params.rating = $("#rating").val();

            $.post({
                url: '/vote',
                data: params,
                success: function (data) {
                    setTimeout(function () {
                        location.href = '/success';
                    }, 500);
                }
            });
        } else {
            $(".errorMsg").html("<span style='color: red; '>请选择至少一个选项</span>");
        }
    }, 500)
}

function checkOptionSelected() {
    return $("input[name='voteOptionRadio']:checked").length === 1;
}