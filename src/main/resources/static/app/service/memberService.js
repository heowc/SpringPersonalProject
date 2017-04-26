'use strict';

app.factory('memberService', ($http, $uibModal) => {
    return {
        login : (member) => {
            return $http.post(`login`, member);
        }
    };
});