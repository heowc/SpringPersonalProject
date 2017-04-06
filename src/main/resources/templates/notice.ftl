<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Won Chul's Personal Project</title>
</head>
<body ng-app="app">
    <div id="wrap">
        <div id="header"></div>
        <div id="container">
            <div id="notice-area">
                <table ng-controller="getNoticeCtrl">

                </table>
            </div>
        </div>
        <div id="footer"></div>
    </div>
</body>
<script type="application/javascript" src="webjars/angular/1.6.4/angular.min.js"></script>
<script type="application/javascript" src="/js/notice.js"></script>
</html>