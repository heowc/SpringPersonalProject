'use strict';

app.controller('searchPasswordFormController', (memberService, modalService, $scope) => {

    console.log('searchPasswordFormController');

    $scope.input = {
        email    : 'heowc1992@gmail.com',
    };

    $scope.searchPassword = () => {
        memberService.searchPassword($scope.input)
            .then(
                (response) => {
                    modalService.closeSearchPasswordModal();
                },
                (error) => {
                }
            );
    };

    $scope.closeModal = () => {
        modalService.closeSearchPasswordModal();
    }
});