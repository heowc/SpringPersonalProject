'use strict';

app.controller('loginFormController', (memberService, $scope) => {

    console.log('loginFormController');

    $scope.member = {
        email    : 'heowc1992@gmail.com',
        password : '1234'
    };

    $scope.login = () => {
        memberService.login($scope.member)
            .then(
                (response) => {
                },
                (error) => {
                    console.log(error);
                }
            );
    };
});