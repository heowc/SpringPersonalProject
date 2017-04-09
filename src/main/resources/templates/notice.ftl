<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Won Chul's Personal Project</title>

    <link href="webjars/bootstrap/4.0.0-alpha.6/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="webjars/summernote/0.8.2/dist/summernote.css" rel="stylesheet">
    <link href="/resource/css/style.css" rel="stylesheet">
</head>
<body ng-app="app" >
    <div id="wrap">
        <div id="header"></div>
        <div id="container" class="container">
            <div class="text-center">
                <p>Won Chul's Personal Project</p>
                <p class="text-success">I will continue this work.</p>
            </div>
            <div id="notice-area" ng-controller="noticeController">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <td>제목</td>
                            <td>글쓴이</td>
                            <td>작성일</td>
                            <td>비고</td>
                        </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="notice in notices"  >
                        <td ng-click="detail($index)">{{notice.title}}</td>
                        <td>{{notice.writer}}</td>
                        <td>{{notice.createDateTime}}</td>
                        <td>
                            <label class="btn btn-warning btn-sm" ng-click="delete($index)">
                            Delete
                            </label>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <div class="btn-group" data-toggle="buttons">
                    <label class="btn btn-primary" ng-click="noticeWrite()">
                        Write
                    </label>
                </div>

                <div summernote></div>
                <#--
                <div uib-alert
                     ng-class="alert-warnung"
                     close="closeAlert($index)"
                     style="background-color: lightpink">alert warning!</div>
                -->
            </div>
        </div>
        <div id="footer"></div>
    </div>
</body>
<script type="application/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js"></script>
<script type="application/javascript" src="webjars/angular/1.6.4/angular.min.js"></script><#--all-->
<script type="application/javascript" src="webjars/tether/1.4.0/dist/js/tether.min.js"></script>
<script type="application/javascript" src="webjars/bootstrap/4.0.0-alpha.6/dist/js/bootstrap.min.js"></script>
<script type="application/javascript" src="webjars/angular-bootstrap/2.5.0/ui-bootstrap-tpls.min.js"></script><#--all-->
<script type="application/javascript" src="webjars/summernote/0.8.2/dist/summernote.min.js"></script>
<script type="application/javascript" src="webjars/angular-summernote/0.8.1/dist/angular-summernote.min.js"></script>
<script type="application/javascript" src="/app/app.js"></script>
<script type="application/javascript" src="/app/service/noticeService.js"></script>
<script type="application/javascript" src="/app/controller/noticeController.js"></script>
</html>