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
    <h1 class="mt-5">投票系统</h1>

    <p class="lead">
        测试，晚餐投票系统，总数${voteSummaries?size}
    </p>
    <button class="btn btn-info btn-lg" onclick="location.href = '/createnew'" type="button">新建投票</button>

    <table class="mt-5 table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">序号</th>
            <th scope="col">时间 / 店名</th>
            <th scope="col">选项</th>
            <th scope="col">整体满意度</th>
        </tr>
        </thead>
        <tbody>
        <#list voteSummaries as item>
            <tr>
                <th scope="row"><a href="/vote/${item.id}">${item.id}</a></th>
                <td>${item.title}</td>
                <td>${item.options}</td>
                <td>${item.satisfactionRatio}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>

<footer class="footer">
    <div class="container">
    </div>
</footer>


<script src="/bootstrap/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="/jquery/jquery-3.5.1.min.js" crossorigin="anonymous"></script>

</body>
</html>