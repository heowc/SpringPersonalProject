'use strict';

var app = angular.module('app', ['ngRoute', 'ngSanitize', 'ngCookies', 'ui.bootstrap', 'summernote']);

var isAuthentication = (cookies, email) => cookies.get('id') !== undefined && cookies.get('id') === email;