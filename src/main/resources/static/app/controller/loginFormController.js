'use strict';

app.controller('loginFormController', (memberService, modalService, $scope, $cookies) => {

    console.log('loginFormController');

    $scope.member = {
        email    : 'heowc1992@gmail.com',
        password : '1234'
    };

    $scope.login = () => {
        memberService.login($scope.member)
            .then(
                (response) => {
                    if( response.data !== '' ) {
                        let expireDate = new Date();
                        expireDate.setDate(expireDate.getDate() + 1000 * 60 * 20);
                        $cookies.put('id', response.data.email, { expires : expireDate});
                        modalService.closeLoginModal();
                    }
                },
                (error) => {
                    console.log(error);
                }
            );
    };

    $scope.openJoinModal = () => {
        modalService.closeLoginModal();
        modalService.openJoinModal();
    };

});