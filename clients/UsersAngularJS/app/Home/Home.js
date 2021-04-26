'use strict';

angular.module('Home', ['ngRoute'])

  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
      templateUrl: 'Home/Home.html',
      controller: 'HomeCtrl'
    });
  }])

  .controller('HomeCtrl', function ($scope) {

  });
