<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/bootstrap/css/bootstrap-grid.min.css" rel="stylesheet">
    <link href="/bootstrap/css/bootstrap-icons.css" rel="stylesheet">
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
                <a class="nav-link" aria-current="page" href="/">首页</a>
                <a class="nav-link active" href="/createnew">新投票</a>
                <a class="nav-link" href="/list">列表</a>
                <a class="nav-link" href="/about">关于</a>
            </div>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="mt-5">新投票</h1>
    <p class="lead">
        投票填写后，无法再对投票进行编辑/删除
    </p>

    <div class="input-group mb-3">
        <span class="input-group-text" id="form-title"><i class="bi bi-house"></i></span>
        <input type="text" class="form-control" placeholder="店名" aria-label="店名" aria-describedby="form-title">
    </div>

    <hr class="my-3">

    <div class="option1">
        <div class="input-group mb-3">
            <span class="input-group-text">选项1</span>
            <input class="form-control" id="option1" type="text">
        </div>
    </div>

    <div class="option2">
        <div class="input-group mb-3">
            <span class="input-group-text">选项2</span>
            <input class="form-control" id="option2" type="text">
        </div>
    </div>

    <div class="add"></div>

    <button class="btn btn-outline-dark float-end" onclick="addOption()" type="button">
        <i class="bi bi-plus"></i>
    </button>

</div>

<footer class="footer">
    <div class="container">
    </div>
</footer>


<script src="/bootstrap/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/jquery/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
<script src="/custom.js" crossorigin="anonymous"></script>

</body>
</html>