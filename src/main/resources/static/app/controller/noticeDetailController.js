'use strict';

app.controller('noticeDetailController', (noticeService, $scope, $routeParams) => {

    console.log('noticeDetailController');

    $scope.options = {
        toolbar: [],
        buttons: {
            save: SaveButton
        },
        popover: {
            image: [],
            link: [],
            air: []
        }
    };

    noticeService.getById($routeParams)
                    .then(
                        (response) => {
                            $scope.notices = response.data.content;
                        },
                        (error) => {
                            console.log(error);
                        }
                    );
});