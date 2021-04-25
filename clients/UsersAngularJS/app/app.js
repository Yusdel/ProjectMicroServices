'use strict';

// Declare app level module which depends on views, and core components
angular.module('HomeSacrum', [
  'ngRoute',
  'HomeSacrum.view1',
  'HomeSacrum.view2',
  'HomeSacrum.version'
]).
  config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');

    $routeProvider.otherwise({ redirectTo: '/view1' });
  }]);
