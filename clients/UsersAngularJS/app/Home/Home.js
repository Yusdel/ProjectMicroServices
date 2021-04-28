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
  .config(function ($mdThemingProvider) {
    /**
     * ngMaterial config theming
     */
    $mdThemingProvider.theme('default')
      .dark();

    /**
     * Enable browser color 
     * This feature is for mobile devices only.
     */
    $mdThemingProvider.enableBrowserColor({
      theme: 'default', // Default is 'default'
      palette: 'accent', // Default is 'primary', any basic material palette and extended palettes are available
      hue: '200' // Default is '800'
    });

  })
  .controller('HomeCtrl', function ($scope, $interval, $location, $rootScope, getAllUsers) {
    $rootScope.loggedIn = false; //global variable for "login"

    debugger;
    let io;
    io = getAllUsers.data();
    debugger;
    //start not used
    this.elevation = 3;
    this.showFrame = 6;
    let larg = window.screen.availWidth;
    let alt = window.screen.availHeight;
    $scope.size = { "alt": alt, "larg": larg };
    $scope.info = { "name": "", "psw": "" };

    this.nextElevation = function () {
      if (++this.elevation == 25) {
        this.elevation = 3;
      }
    };

    $interval(this.nextElevation.bind(this), 500);

    this.toggleFrame = function () {
      this.showFrame = this.showFrame == 6 ? -1 : 6;
    };
    //end not used here

    /**
     * on click event get user informations
     * and redirect to view with data
     */
    $scope.getUserInfo = function () {
      if ($scope.info.name == 'admin' && $scope.info.psw == '123abc') {
        $location.path('/info');
        $rootScope.loggedIn = true;
      } else {
        alert("hey");
      }
    }
  });
