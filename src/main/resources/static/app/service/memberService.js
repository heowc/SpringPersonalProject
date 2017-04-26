'use strict';

app.factory('memberService', ($http) => {
    return {
        login : (member) => {
            return $http.post(`login`, member);
        },

        join : (member) => {
            return $http.post(`api/member`, member);
        }
    };
});