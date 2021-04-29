'use strict';

angular.module('Home', [
  'ngRoute',
  'ngMaterial',
  'ngMessages',
  'UserHttp'
])
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
      templateUrl: 'Home/Home.html',
      controller: 'HomeCtrl'
    });
  }])
  .controller('HomeCtrl', function ($scope, $interval, $location, $rootScope, usersFactory, userData) {
    $rootScope.loggedIn = false; //global variable for "login"

    usersFactory.getAllUser().then(function (res) {
      $scope.users = res.data;
    }, function (err) {
      alert(err)
    })
    /*
    debugger;
    let io;
    let test = {
      "name": "Polpettone23",
      "surname": "Minchiuz",
      "mail": "Marchettone68@gmail.com"
    }

    io = usersFactory.createUser(test).then(function (res) {
      debugger;
    }, function (err) {
      debugger;
      alert('something was wrang!');
    })
*/
    /**
     * on click event get user informations
     * and redirect to view with data
     */
    $scope.getUserInfo = function (rw, a, b) {
      debugger;
      if (a == 'admin' && b == '123abc') {
        $rootScope.loggedIn = true;
        userData.set(rw);
        $location.path('/info');
      } else {
        alert("hey");
      }
    }
  });
