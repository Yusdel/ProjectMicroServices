'use strict';

let ft = angular.module('UserHttp', []);

/**
 * Get All Users
 */

ft.factory('getAllUsers', function ($http) {
  var myData;
  return {
    getData: function () {
      $http.get("https://my-json-server.typicode.com/typicode/demo/db")
        .then(function success(res) {
          myData = res.data;
        }, function error(err) {
          return err;
        })
    },
    data: function () { return myData; }
  }
})