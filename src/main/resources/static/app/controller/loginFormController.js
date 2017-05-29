'use strict';

app.controller('loginFormController', (memberService, modalService, $scope, $cookies, base64) => {

    console.log('loginFormController');

    $scope.input = {
        email    : 'heowc1992@gmail.com',
        password : '123412341234'
    };

    $scope.login = () => {

        memberService.login(encryptMember($scope.input))
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

    $scope.openSearchPasswordModal = () => {
        modalService.closeLoginModal();
        modalService.openSearchPasswordModal();
    };


    const encryptMember = (member) => {
        let _member = {};
        _member['email'] = base64.encode(member.email);
        _member['password'] = base64.encode(member.password);
        return _member;
    };
});