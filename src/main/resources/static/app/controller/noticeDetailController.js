'use strict';

app.controller('noticeDetailController', (noticeService, $scope, $routeParams, $sce) => {

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
                            console.log(response.data.content);
                            $scope.text = $sce.trustAsHtml(response.data.content);
                        },
                        (error) => {
                            console.log(error);
                        }
                    );
});