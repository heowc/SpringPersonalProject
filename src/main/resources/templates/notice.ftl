<!DOCTYPE html>
<html lang="ko">
<head>
    <base href="/">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Won Chul's Personal Project</title>

    <#include "./include/library.ftl">
</head>
<body ng-app="app">
    <div id="wrap">
        <div id="header"></div>
        <div id="container" class="container">
            <div class="text-center">
                <p>Won Chul's Personal Project</p>
                <p class="text-success">I will continue this work.</p>
            </div>

            <ng-view></ng-view>

            <div class="btn-group float-left">
                <a ng-href="notice" class="btn btn-primary">Main</a>
                <a ng-href="notice/write" class="btn btn-primary">Write</a>
            </div>
        </div>
        <div id="footer"></div>
    </div>
</body>

</html>