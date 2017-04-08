'use strict';

app.controller('noticeController', (noticeService, $scope) => {

    noticeService.getNotices()
        .then(
            (response) => {
                $scope.notices = response.data.content;
            },
            (error) => {
                console.log(error);
            }
        );
});