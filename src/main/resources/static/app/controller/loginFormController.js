'use strict';

app.controller('loginFormController', (memberService, modalService, $scope, $cookies) => {

    console.log('loginFormController');

    $scope.member = {
        email    : 'heowc1992@gmail.com',
        password : '123412341234'
    };

    $scope.login = () => {
        console.log($scope.member);
        encryptMember();
        console.log($scope.member);
        memberService.login($scope.member)
            .then(
                (response) => {
                    if( response.data !== '' ) {
                        let expireDate = new Date();
                        expireDate.setTime(expireDate.getTime() + 1000 * 60 * 20);
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

    const encryptMember = () => {
        $scope.member.email = toEncrypt($scope.member.email);
        $scope.member.password = toEncrypt($scope.member.password);
    };

    const decryptMember = () => {
        $scope.member.email = toDecrypt($scope.member.email);
        $scope.member.password = toDecrypt($scope.member.password);
    };
});