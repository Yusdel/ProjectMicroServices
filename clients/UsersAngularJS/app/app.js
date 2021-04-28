'use strict';

// Declare app level module which depends on views, and core components
angular.module('Sacrum', [
  'ngRoute',
  'ngMaterial',
  'ngMessages',
  'Home',
  'UserInfo',
  'UserHttp'
]).
  config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('');

    $routeProvider
      .otherwise({ redirectTo: '/' });

    /**
     * example router
     * $routeProvider
     * .when('/home', handler)
     * .when('/home/users', handler)
     * .otherwise({redirectTo:'/home'});
     */

  }]);
