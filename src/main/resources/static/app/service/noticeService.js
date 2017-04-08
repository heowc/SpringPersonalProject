'use strict';

app.factory('noticeService', ($http) => {
    return {
        getNotices : () => {
            return $http.get('api/notice');
        }
    };
});