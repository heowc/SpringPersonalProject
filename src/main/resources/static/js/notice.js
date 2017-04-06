'use strict';

const notice = angular.module('app', []);

notice.controller('getNoticeCtrl', ($scope, $http) => {

    $http.get('api/notice?size=0&type=&keyword=')
        .then(
            (response) => {
                console.log(response.data);
            },
            (error) => {
                console.log(error);
            }
        );
});