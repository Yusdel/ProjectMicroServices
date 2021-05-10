'use strict';

angular.module('Home', [
  'ngRoute',
  'ngMaterial',
  'ngMessages',
  'UserHttp',
  'draggableModule'
])
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
      templateUrl: 'Home/Home.html',
      controller: 'HomeCtrl'
    });
  }])
  .controller('HomeCtrl', function ($scope, $location, $window, $rootScope, usersFactory, userData) {
    $rootScope.loggedIn = false; //global variable for "login"
    /*
    usersFactory.getAllUser().then(function (res) {
      $scope.users = res.data;
    }, function (err) {
      alert(err)
    })*/

    /**
     * ResizeObserver row-line
     * get the viewport resize event
     * after load page
     */
    $scope.$on('$viewContentLoaded', function () {
      const obss = document.querySelector('.row-bar');
      const obs = document.querySelector('.line-bar');
      const circ = document.querySelector('.circle-control');
      let observer = new ResizeObserver(function (entries) {
        entries.forEach(function (entry) {
          circ.style.left = (obs.offsetWidth / 2 + obss.offsetLeft - 10) + 'px';
        })
      })
      observer.observe(obs);
    });

    $scope.users = [
      { "name": "Marco", "surname": "Morales", "email": "blabla@io.it" },
      { "name": "Claudia", "surname": "Longo", "email": "blabla@io.it" },
      { "name": "Aurora", "surname": "Polpetta", "email": "blabla@io.it" }
    ]

    /**
     * on click event get user informations
     * and redirect to view with data
     */
    $scope.getUserInfo = function (rw, a, b) {
      if (a == 'admin' && b == '123abc') {
        $rootScope.loggedIn = true;
        userData.set(rw);
        $location.path('/info');
      } else {
        alert("hey");
      }
    }

    /**
     * Start and Stop animation Clock
     */
    /*let promise;
    let stop = function () { $interval.cancel(promise); }
    let start = function ($event) { promise = $interval(SwipeCardAnimation($event), 1000); }

    //cancel all possible interval and run new animation/interval
    $scope.onMouseMouve = function ($event) { stop(); start($event); }

    //stop animation/interval
    $scope.onMouseLeave = function () { stop(); }

    // stops the interval when the scope is destroyed,
    // this usually happens when a route is changed and 
    // the ItemsController $scope gets destroyed.
    $scope.$on('$destroy', function () { stop(); });*/

    /**
     * END Clock
     */

    //call animation
    $window.onload = function () {

      let cards = document.querySelectorAll('.card-body');

      let direction = {}; // direzione di movimento left - right
      let left = {}; // offsetLeft iniziali
      angular.forEach(cards, (card, key) => {
        direction[key] = 1;
        left[key] = cards[0].offsetLeft;
      })
      //global start value
      $scope.pos = {
        "container": document.querySelector('.rowUsers').getBoundingClientRect(),
        "mouse": {
          "_cur": 0,
          "_old": 0
        },
        "left": left,
        "turn": direction
      }
    };

    $scope.onMouseMove = function ($event) {
      /* $scope.pos.mouse._cur = $event.clientX;
       if ($scope.pos.mouse._cur != $scope.pos.mouse._old && $scope.pos.mouse._old != 0) {
         //debugger;
         /* let diff = $scope.pos.mouse._cur - $scope.pos.mouse._old;
          if (diff > 0) {
            $scope.pos.card.x = $scope.pos.card.x + 1;
          }
          else {
            $scope.pos.card.x = $scope.pos.card.x - 1;
          }*/

      /* SwipeCardAnimation($scope);
     }

     $scope.pos.mouse._old = $event.clientX;*/
    }

    $scope.onMouseLeave = function () { $scope.pos.mouse._old = 0; }
  })



/**
 * ANIMATION
 * https://gamedev.stackexchange.com/questions/75880/how-to-move-an-object-using-x-and-y-coordinates-in-javascript
 * https://www.darkcode.info/2020/07/awesome-cursor-animation-on-mousemove.html
 * https://www.youtube.com/watch?v=eZSxp8738AM
 *
 * https://filipows.github.io/angular-animations/
 * //https://docs.angularjs.org/api/ng/service/$interval#!
 */

const SwipeCardAnimation = function ($scope) {
  let cards = document.querySelectorAll('.card-body');
  let turnDX;
  let turnSX;
  let mouseMove = $scope.pos.mouse._cur - $scope.pos.mouse._old;

  angular.forEach(cards, function (card, key) {
    /**
     * SET TURN
     * SWITCH left/right movement 
     * turnDX > 0 = la card è oltre il marigne dx
     * turnSX < 0 = la card è oltre il margine sx
     */
    debugger;
    turnDX = ((card.offsetLeft + card.offsetWidth) - $scope.pos.container.width) + 1 > 0;
    turnSX = card.offsetLeft - 1 < 0;
    if (turnDX || turnSX) { $scope.pos.turn[key] = -$scope.pos.turn[key]; }

    /**
     * Check mouse movement
     * SET left position movement
     */
    if (mouseMove > 0) {
      // turn cab be +1 or -1
      $scope.pos.left[key] = $scope.pos.left[key] + $scope.pos.turn[key];
    }
    else {
      $scope.pos.left[key] = $scope.pos.turn[key] > 0 ? $scope.pos.left[key] - $scope.pos.turn[key] : $scope.pos.left[key] + 1;
    }

    card.style.left = $scope.pos.left[key] + 'px';
  })
}

let mouse = {
  _x: 0,
  _y: 0,
  x: 0,
  y: 0,
  updatePosition: function (event) {

  }
}