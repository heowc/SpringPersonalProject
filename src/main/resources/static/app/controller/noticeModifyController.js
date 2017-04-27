'use strict';

app.controller('noticeModifyController', (noticeService, $scope, $location, $routeParams, $cookies) => {

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

        if( !isAuthentication($cookies, $scope.notice.member.email) ) {
            alert('warning!!');
            return;
        }

        if($scope.notice.content.length > 0) {
            noticeService.update($scope.notice)
                .then(
                    (response) => {
                        alert('success!!');
                        $location.path('notice');
                    },
                    (error) => {
                        alert(error.data.message);
                    }
                );
        }
    };
});