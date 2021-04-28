'use strict';

let dr = angular.module("Directives", []);

dr.directive("test", function () {
    return {
        restrict: "E",
    }
})