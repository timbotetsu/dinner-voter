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