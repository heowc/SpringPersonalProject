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

    $scope.save = () => {

        if( !isAuthentication($cookies) ) {
            alert('can not write!!');
            return;
        }

        let notice = {
            title   : $scope.title,
            content : $scope.content
        };

        if($scope.notice.content.length > 0) {
            noticeService.create(notice)
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