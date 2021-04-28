'use strict';

let uinfo = angular.module('UserInfo', ['ngRoute']);

uinfo.config(function ($routeProvider) {
  $routeProvider.when('/info/', {
    templateUrl: 'UserInfo/UserInfo.html',
    controller: 'UserInfoCtrl',
    /**
     * redirect to home if not "logged"
     */
    resolve: {
      check: function ($location, $rootScope) {
        if (!$rootScope.loggedIn) {
          $location.path('/');
        }
      }
    }
  })
})

uinfo.controller('UserInfoCtrl', function ($scope) {
  // code
})