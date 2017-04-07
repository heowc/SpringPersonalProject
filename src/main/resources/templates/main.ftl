<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Won Chul's Personal Project</title>
    <link rel="stylesheet" href="webjars/angular-bootstrap/2.5.0/ui-bootstrap-csp.css">
</head>
<body ng-app="app">
    <div id="wrap">
        <div id="header"></div>
        <div id="container">
            <div id="notice-area">
                <table ng-controller="noticeController" >
                    <tr ng-repeat="notice in notices">
                        <td>{{notice.title}}</td>
                        <td>{{notice.content}}</td>
                        <td>{{notice.writer}}</td>
                        <td>{{notice.createDateTime}}</td>
                        <td>{{notice.modifyDateTime}}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div id="footer"></div>
    </div>
</body>
<script type="application/javascript" src="webjars/angular/1.6.4/angular.js"></script>
<script type="application/javascript" src="webjars/angular-bootstrap/2.5.0/ui-bootstrap-tpls.min.js"></script>
<script type="application/javascript" src="/app/app.js"></script>
<script type="application/javascript" src="/app/controller/noticeController.js"></script>
</html>