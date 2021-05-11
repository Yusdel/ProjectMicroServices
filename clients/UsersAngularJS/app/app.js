'use strict';

// Declare app level module which depends on views, and core components
angular.module('Sacrum', [
  'ngRoute',
  'ngMaterial',
  'ngMessages',
  'Home',
  'UserInfo',
  'UserHttp',
  'Carousel'
]).
  config([
    '$locationProvider',
    '$routeProvider',
    '$mdThemingProvider',
    function ($locationProvider, $routeProvider, $mdThemingProvider) {
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
    }]);

