'use strict';

app.controller('noticeWriteController', (noticeService, $scope) => {

    console.log('noticeWriteController');

    $scope.options = {
        popover: {
            image: [],
            link: [],
            air: []
        }
    };
});