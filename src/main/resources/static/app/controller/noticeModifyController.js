'use strict';

app.controller('noticeModifyController', (noticeService, $scope, $location, $routeParams, $sce) => {

    console.log('noticeModifyController');

    $scope.options = {
        popover: {
            image: [],
            link: [],
            air: []
        }
    };

    noticeService.getById($routeParams.id)
        .then(
            (response) => {
                $scope.notice = response.data;
            },
            (error) => {
                console.log(error);
            }
        );

    $scope.modify = () => {

        if($scope.notice.content.length > 0) {
            noticeService.update($scope.notice)
                .then(
                    (response) => {
                        alert('success!!');
                        $location.path('notice');
                    },
                    (error) => {
                        console.log(error);
                    }
                );
        }
    };
});