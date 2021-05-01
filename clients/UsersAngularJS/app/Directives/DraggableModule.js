'use strict';

let module = angular.module('draggableModule', []);

module.directive('draggable', ['$document', function ($document) {
    return {
        restrict: 'A',
        link: function (scope, element, att) {
            let startX, initialMouseX;
            element.css({ position: 'fixed' });
            /**
             * Position X to draggable element
             */
            let posX;
            scope.$on('$viewContentLoaded', function () {
                //call it here
                let bodyRect = document.body.getBoundingClientRect();
                let elRect = element[0].getBoundingClientRect();
                posX = bodyRect.left + elRect.left;
            });
            element.bind('mousedown', function ($event) {
                startX = element.prop('offsetLeft');
                initialMouseX = $event.clientX;
                $document.bind('mousemove', mousemove);
                $document.bind('mouseup', mouseup);
                return false;
            });

            function mousemove($event) {
                let dx = $event.clientX - initialMouseX;

                element.css({
                    left: startX + dx + 'px'
                });
                return false;
            }

            function mouseup($event) {
                $document.unbind('mousemove', mousemove);
                $document.unbind('mouseup', mouseup);
                const rowStartPos = document.querySelector('.row-bar');
                const lineBarWidth = document.querySelector('.line-bar');

                element.css({
                    /*left: startX + 'px'*/
                    left: (lineBarWidth.offsetWidth / 2 + rowStartPos.offsetLeft - 10) + 'px'
                })
            }
        }
    }
}])