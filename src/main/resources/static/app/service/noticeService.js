'use strict';

app.factory('noticeService', ($http) => {
    return {
        getNotices : (size = 0, type = '', keyword = '') => {
            return $http.get(`api/notice/search?size=${size}&type=${type}&keyword=${keyword}`);
        },

        getById : (idx) => {
            return $http.get(`api/notice/${idx}`)
        },

        deleteById : (idx) => {
            return $http.delete(`api/notice/${idx}`)
        },

        create : (notice) => {
            return $http.post('api/notice', notice);
        }
    };
});