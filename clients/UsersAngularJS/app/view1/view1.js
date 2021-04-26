'use strict';

angular.module('View1', ['ngRoute'])

  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/view1', {
      templateUrl: 'view1/view1.html',
      controller: 'View1Ctrl'
    });
  }])

  .controller('View1Ctrl', function ($scope) {
    $scope.utente = { nome: "Marco", cognome: "Kitty" };
    $scope.hello = function () {
      return "Hello kitty!! " + $scope.utente.nome;
    }
  });
