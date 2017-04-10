'use strict';

app.config(($routeProvider) => {

    $routeProvider
        .when('/', {
            templateUrl : '/app/template/noticeList.html'
        })
        .when('/noticeWrite', {
            templateUrl : '/app/template/noticeWrite.html'
        });
});
