'use strict';

let ft = angular.module('UserHttp', []);

/**
 * Http Request Server1 Users
 */
ft.factory('usersFactory', function ($http) {
  return {
    getAllUser: function () {
      return $http.get("http://localhost:8080/api/users/");
    },
    getUserById: function (id) {
      let buildUrl = "http://localhost:8080/api/users/" + id;

      return $http({
        method: 'GET',
        url: buildUrl
      })
    },
    modifyUser: function (userJson) {
      return $http({
        method: 'PUT',
        url: 'http://localhost:8080/api/users/modify',
        headers: {
          'Content-Type': 'application/json'
        },
        data: userJson
      })
    },
    createUser: function (userJson) {
      return $http({
        method: 'POST',
        url: 'http://localhost:8080/api/users/create',
        headers: {
          'Content-Type': 'application/json'
        },
        data: userJson
      })
    }
  }
})

/**
 * https://www.c-sharpcorner.com/article/pass-data-from-one-page-to-other-using-factory-or-service-in-angularjs/
 * per effettuare il passagio dei dati da un model/view all'altro/a
 */
ft.factory("userData", function () {
  let savedData = {};

  function set(data) {
    savedData = data;
  }

  function get() {
    return savedData;
  }

  return {
    set: set,
    get: get
  }
})