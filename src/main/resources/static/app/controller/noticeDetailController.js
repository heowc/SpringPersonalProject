'use strict';

app.controller('noticeDetailController', (noticeService, $scope, $routeParams, $sce) => {

    console.log('noticeDetailController');

    noticeService.getById($routeParams.id)
                    .then(
                        (response) => {
                            $scope.text = $sce.trustAsHtml(response.data.content);
                        },
                        (error) => {
                            console.log(error);
                        }
                    );
});