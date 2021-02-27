<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="/bootstrap/css/bootstrap-reboot.min.css" rel="stylesheet">
    <link href="/bootstrap/css/bootstrap-utilities.min.css" rel="stylesheet">
    <link href="/custom.css" rel="stylesheet">


    <title>Hello, world!</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="/">Dinner Voter</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="/">首页</a>
                <a class="nav-link" href="/createnew">新投票</a>
                <a class="nav-link" href="/list">列表</a>
                <a class="nav-link" href="/about">关于</a>
            </div>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="mt-5">为 ${voteOptionDetail.getTitle()} 投票</h1>

    <p class="lead">
        目前共有${voteOptionDetail.getTotalVote()}人投票
    </p>

    <input hidden id="voteId" value="${voteId}">

    <#list voteOptionDetail.getOptions() as item>
        <div class="form-check vote-option-radio">
            <input class="form-check-input" type="radio" name="voteOptionRadio" id="voteOptionRadio${item?counter}">
            <label class="form-check-label" for="voteOptionRadio${item?counter}">
                <div class="fs-3">${item.left}</div>
            </label>
            <div class="fs-5"> - 共有${item.middle}选择此项，满意度${item.right}</div>
        </div>
    </#list>

    <hr class="my-3">

    <p class="lead">
        <label for="rating" class="form-label">评分: <span id="ratingValue" style="color: #0a53be; font-weight: bold">5</span></label>
    </p>
    <input id="rating" type="range" class="slider" min="1" max="10" value="5">

    <p>
    <div class="errorMsg"></div>
    </p>

    <section>
        <button onclick="vote()" class="btn btn-primary">提交</button>
    </section>

</div>

<footer class="footer">
    <div class="container">
    </div>
</footer>


<script src="/bootstrap/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/jquery/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
<script src="/custom.js" crossorigin="anonymous"></script>
<script>
    let slider = document.getElementById("rating");
    let output = document.getElementById("ratingValue");
    output.innerHTML = slider.value;

    slider.oninput = function () {
        output.innerHTML = this.value;
    }
</script>

</body>
</html>