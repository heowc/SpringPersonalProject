'use strict';

app.controller('noticeListController', (noticeService, modalService, memberService, uibDateParser,
                                        $scope, $location, $cookies, $route) => {

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

    $scope.init = () => {
        if ( $cookies.get('id') !== undefined) {
            $scope.isAutentication = true;
            $scope.btnName = 'Logout';
        } else {
            $scope.isAutentication = false;
            $scope.btnName = 'Login';
        }
    };

    $scope.detail = (index) => {
        $location.path(`notice/detail/${$scope.notices[index].idx}`);
    };

    $scope.delete = (index) => {
        noticeService.deleteById($scope.notices[index].idx)
            .then(
                (response) => {
                    $scope.noticeSearch($scope.bigCurrentPage);
                },
                (error) => {
                    alert(error.data.message);
                }
            );
    };

    $scope.noticeSearch = (page) => {
        noticeService.getNotices(page, $scope.selectedType.value, $scope.keyword)
            .then(
                (response) => {
                    setNoticeListView(response.data);
                },
                (error) => {
                    console.log(error);
                }
            );
    };

    const setNoticeListView = (data) => {
        $scope.bigTotalItems = data.totalElements;
        $scope.maxSize = 5;
        $scope.notices = data.content;
    };

    $scope.$watch('bigCurrentPage', (newValue, oldValue) => {
        $scope.noticeSearch($scope.bigCurrentPage-1);
    }, true);

    $scope.clickBtn = () => {
        if ( $scope.isAutentication ) {
            $scope.logout();
        } else {
            $scope.openLoginModal();
        }
    };

    $scope.openLoginModal = () => {
        modalService.openLoginModal();
    };

    $scope.logout = () => {
        memberService.logout();
        $route.reload();
    }
});