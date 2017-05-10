'use strict';

var app = angular.module('app', ['ngRoute', 'ngSanitize', 'ngCookies', 'ui.bootstrap', 'summernote', 'ab-base64']);

var isAuthentication = (cookies, email) => cookies.get('id') !== undefined && cookies.get('id') === email;