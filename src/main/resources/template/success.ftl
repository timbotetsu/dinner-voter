<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="/bootstrap/css/bootstrap-reboot.min.css" rel="stylesheet">
    <link href="/bootstrap/css/bootstrap-utilities.min.css" rel="stylesheet">

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
    <h1 class="mt-5">成功</h1>

    <p class="lead">
        页面将会在3秒内转回首页
    </p>
</div>

<footer class="footer">
    <div class="container">
    </div>
</footer>


<script src="/bootstrap/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/jquery/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
<script>
    window.setTimeout(function () {
        window.location.href = "/";
    }, 3000);
</script>


</body>
</html>