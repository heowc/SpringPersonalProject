'use strict';

app.config(($routeProvider) => {

    $routeProvider
        .when('/', {
            templateUrl : '/app/template/noticeList.html'
        })
        .when('/write', {
            templateUrl : '/app/template/noticeWrite.html'
        })
        .otherwise({redirectTo: '/'});
        // .when('/', {
        //     templateUrl : '/app/template/noticeWrite.html'
        // });
});
