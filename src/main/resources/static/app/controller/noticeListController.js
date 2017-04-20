'use strict';

app.controller('noticeListController', (noticeService, uibDateParser, $scope, $location) => {

    console.log('noticeListController');

    $scope.types = [
        {
            name : '제목',
            value : 'title'
        },
        {
            name : '내용',
            value : 'content'
        }];

    $scope.selectedType = $scope.types[0];

    noticeService.getNotices()
                .then(
                    (response) => {
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

    $scope.noticeSearch = () => {
        noticeService.getNotices(0, $scope.selectedType.value, $scope.keyword)
            .then(
                (response) => {
                    $scope.notices = response.data.content;
                },
                (error) => {
                    console.log(error);
                }
            );
    }
});