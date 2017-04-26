<!DOCTYPE html>
<html lang="ko">
<head>
    <base href="/">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Won Chul's Personal Project</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link href="webjars/summernote/0.8.2/dist/summernote.css" rel="stylesheet">
    <link href="/resource/css/style.css" rel="stylesheet">

    <script type="application/javascript" src="/webjars/jquery/3.2.1/dist/jquery.min.js"></script>
    <script type="application/javascript" src="/webjars/angular/1.6.4/angular.min.js"></script><#--all-->
    <script type="application/javascript" src="/webjars/angular-route/1.6.4/angular-route.min.js"></script><#--all-->
    <script type="application/javascript" src="/webjars/angular-sanitize/1.6.4/angular-sanitize.min.js"></script><#--all-->
    <script type="application/javascript" src="/webjars/angular-cookies/1.6.4/angular-cookies.min.js"></script><#--all-->
    <script type="application/javascript" src="/webjars/tether/1.4.0/dist/js/tether.min.js"></script>
    <script type="application/javascript" src="/webjars/bootstrap/4.0.0-alpha.6/dist/js/bootstrap.min.js"></script>
    <script type="application/javascript" src="/webjars/angular-bootstrap/2.5.0/ui-bootstrap-tpls.min.js"></script><#--all-->
    <script type="application/javascript" src="/webjars/summernote/0.8.2/dist/summernote.min.js"></script>
    <script type="application/javascript" src="/webjars/angular-summernote/0.8.1/dist/angular-summernote.min.js"></script>
    <script type="application/javascript" src="/app/app.js"></script><#--all-->
    <script type="application/javascript" src="/app/config/httpProviderConfig.js"></script><#--all-->
    <script type="application/javascript" src="/app/config/routeConfig.js"></script><#--all-->
    <script type="application/javascript" src="/app/service/noticeService.js"></script>
    <script type="application/javascript" src="/app/service/memberService.js"></script>
    <script type="application/javascript" src="/app/service/modalService.js"></script>
    <script type="application/javascript" src="/app/controller/noticeListController.js"></script>
    <script type="application/javascript" src="/app/controller/noticeWriteController.js"></script>
    <script type="application/javascript" src="/app/controller/noticeDetailController.js"></script>
    <script type="application/javascript" src="/app/controller/noticeModifyController.js"></script>
    <script type="application/javascript" src="/app/controller/loginFormController.js"></script>
    <script type="application/javascript" src="/app/component/loginFormModalComponent.js"></script>
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