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
      //debugger;
      let cards = document.querySelectorAll('.card-body');

      let direction = {}; // direzione di movimento left - right
      angular.forEach(cards, (card, key) => { direction[key] = 1; })
      //global start value
      let x = cards[0].offsetLeft;
      let _x = x;
      $scope.pos = {
        "container": document.querySelector('.rowUsers').getBoundingClientRect(),
        "mouse": {
          "_cur": 0,
          "_old": 0
        },
        "card": {
          "x": x,
          "_x": _x
        },
        "turn": direction
      }
    };

    $scope.onMouseMove = function ($event) {
      $scope.pos.mouse._cur = $event.clientX;
      if ($scope.pos.mouse._cur != $scope.pos.mouse._old && $scope.pos.mouse._old != 0) {
        //debugger;
        /* let diff = $scope.pos.mouse._cur - $scope.pos.mouse._old;
         if (diff > 0) {
           $scope.pos.card.x = $scope.pos.card.x + 1;
         }
         else {
           $scope.pos.card.x = $scope.pos.card.x - 1;
         }*/

        SwipeCardAnimation($scope.pos);
      }

      $scope.pos.mouse._old = $event.clientX;
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

const SwipeCardAnimation = function (pos) {
  let cards = document.querySelectorAll('.card-body');
  let diff = pos.mouse._cur - pos.mouse._old;
  let turn;
  //console.log(pos.init)
  angular.forEach(cards, function (card, key) {
    //check turn
    turn = (card.offsetLeft + card.offsetWidth) - pos.container.width;
    if (turn + 1 > 0 || card.offsetLeft - 1 < 0) { pos.turn[key] = -pos.turn[key]; }

    if (diff > 0) {
      pos.card.x = pos.card.x + 1 * pos.turn[key];
    }
    else {
      pos.card.x = pos.card.x - 1 * pos.turn[key];
    }

    card.style.left = pos.card.x + 'px';
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