'use strict';

app.controller('noticeWriteController', (noticeService, $scope, $location) => {

    console.log('noticeWriteController');

    $scope.options = {
        popover: {
            image: [],
            link: [],
            air: []
        }
    };

    $scope.save = () => {

        let notice = {
            title   : $scope.title,
            content : $scope.content,
            member  : {
                email : 'heowc1992@gmail.com'
            }
        };

        if($scope.content.length > 0) {
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