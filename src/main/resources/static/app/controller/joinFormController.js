'use strict';

app.controller('joinFormController', (memberService, modalService, $scope) => {

    console.log('joinFormController');

    $scope.member = {
        email    : 'naeun@gmail.com',
        password : '1234',
        nickName : 'naeun'
    };

    $scope.join = () => {
        encryptMember();
        memberService.join($scope.member)
            .then(
                (response) => {
                    modalService.closeJoinModal();
                },
                (error) => {
                    decryptMember();
                    if (error.status === 500) {
                        alert(error.data.message);
                    }

                    if (error.status === 400) {
                        alert(error.data.defaultMessage);
                    }
                }
            );
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