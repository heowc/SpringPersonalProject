'use strict';

app.controller('joinFormController', (memberService, modalService, $scope) => {

    console.log('joinFormController');

    $scope.member = {
        email    : 'naeun@gmail.com',
        password : '1234',
        nickName : 'naeun'
    };

    $scope.join = () => {
        memberService.join($scope.member)
            .then(
                (response) => {
                    modalService.closeJoinModal();
                },
                (error) => {
                    alert(error.data.message);
                }
            );
    };

});