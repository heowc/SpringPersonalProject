'use strict';

app.controller('noticeWriteController', (noticeService, $scope, $location, $cookies) => {

    console.log('noticeWriteController');

    $scope.options = {
        popover: {
            image: [],
            link: [],
            air: []
        }
    };

    $scope.notice = {};

    $scope.save = () => {

        if( !isAuthentication($cookies) ) {
            alert('can not write!!');
            return;
        }

        if($scope.notice.content.length > 0) {
            noticeService.create($scope.notice)
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