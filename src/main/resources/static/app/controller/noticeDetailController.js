'use strict';

app.controller('noticeDetailController', (noticeService, $scope, $routeParams) => {

    console.log('noticeDetailController');

    // $scope.options = {
    //     toolbar: [],
    //     popover: {
    //         image: [],
    //         link: [],
    //         air: []
    //     }
    // };

    noticeService.getById($routeParams.id)
                    .then(
                        (response) => {
                            $scope.text = response.data.content;
                        },
                        (error) => {
                            console.log(error);
                        }
                    );
});