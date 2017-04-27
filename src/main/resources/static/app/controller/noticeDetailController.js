'use strict';

app.controller('noticeDetailController', (noticeService, $scope, $routeParams, $sce, $location, $cookies) => {

    console.log('noticeDetailController');

    noticeService.getById($routeParams.id)
                    .then(
                        (response) => {
                            $scope.notice = response.data;
                            $scope.notice.content = $sce.trustAsHtml($scope.notice.content);
                        },
                        (error) => {
                            console.log(error);
                        }
                    );

    $scope.modifyView = () => {
        if( !isAuthentication($cookies, $scope.notice.member.email) ) {
            alert('can not modify!!');
            return;
        }

        $location.path(`notice/modify/${$routeParams.id}`);
    };
});