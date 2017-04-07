'use strict';

app.controller('noticeController', ($scope, $http) => {

    $http
        .get('api/notice')
        .then(
            (response) => {
                console.log(response.data);
                $scope.notices = response.data.content;
            },
            (error) => {
                console.log(error);
            }
        );
});