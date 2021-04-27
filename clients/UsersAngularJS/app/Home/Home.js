'use strict';

angular.module('Home', [
  'ngRoute',
  'ngMaterial',
  'ngMessages'
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
  .controller('HomeCtrl', function ($scope, $interval) {
    this.elevation = 3;
    this.showFrame = 6;
    let larg = window.screen.availWidth;
    let alt = window.screen.availHeight;
    $scope.size = { "alt": alt, "larg": larg };

    this.nextElevation = function () {
      if (++this.elevation == 25) {
        this.elevation = 3;
      }
    };

    $interval(this.nextElevation.bind(this), 500);

    this.toggleFrame = function () {
      this.showFrame = this.showFrame == 6 ? -1 : 6;
    };
  });
