'use strict';

app.factory('memberService', ($http) => {
    return {
        login : (member) => {
            return $http.post(`login`, member);
        },

        logout : () => {
            return $http.get(`logout`);
        },

        join : (member) => {
            return $http.post(`api/member`, member);
        },

        searchPassword : (member) => {
            return $http.post(`api/member/search/password`, member);
        }
    };
});