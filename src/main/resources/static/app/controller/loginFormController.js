'use strict';

app.controller('loginFormController', (memberService, $scope, $location, $cookies) => {

    console.log('loginFormController');

    $scope.login = () => {
        memberService.login($scope.member)
            .then(
                (response) => {
                    console.log($cookies.get('JSESSIONID'));
                },
                (error) => {
                    console.log(error);
                }
            );
    }
});