'use strict';

app.controller('noticeListController', (noticeService, uibDateParser, $scope, $location) => {

    console.log('noticeListController');

    noticeService.getNotices()
                .then(
                    (response) => {
                        console.log(response.data.content);
                        $scope.notices = response.data.content;
                    },
                    (error) => {
                        console.log(error);
                    }
                );

    $scope.detail = (index) => {
        $location.path(`notice/detail/${$scope.notices[index].idx}`);
    };

    $scope.delete = (index) => {
        noticeService.deleteById($scope.notices[index].idx)
                    .then(
                        (response) => {
                            $scope.notices.splice(index, 1);
                        },
                        (error) => {
                            console.log(error);
                        }
                    );
    };
});