'use strict';

angular.module("Carousel", [])
  .directive("carousel", function ($window) {
    return {
      restrict: "E",
      replace: false,
      link: function (scope) {
        $window.onload = function () {
          var
            carousel = document.querySelector('.carousel'),
            figure = carousel.querySelector('figure'),
            nav = carousel.querySelector('nav'),
            numImages = figure.childElementCount,
            theta = 2 * Math.PI / numImages,
            currImage = 0
            ;

          nav.addEventListener('click', onClick, true);

          function onClick(e) {
            e.stopPropagation();
            console.log("hello!");
            var t = e.target;
            if (t.tagName.toUpperCase() != 'BUTTON')
              return;

            if (t.classList.contains('next')) {
              currImage++;
            }
            else {
              currImage--;
            }

            figure.style.transform = `rotateY(${currImage * -theta}rad)`;
          }
        }
      },
      templateUrl: "./Carousel/Carousel.html"
    }
  })