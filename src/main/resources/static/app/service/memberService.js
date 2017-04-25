'use strict';

app.factory('memberService', ($http) => {
    return {
        login : (member) => {
            return $http.post(`login`, member);
        }
    };
});