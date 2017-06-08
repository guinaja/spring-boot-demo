/**
 * Created by prayoon-pc on 4/18/2017.
 */
'use strict';

angular.module('myApp').factory('UserService', ['$http', '$q', function ($http, $q) {

    var REST_SERVICE_URI = 'http://localhost:8080/user/';
    var factory = {
        fetchAllUsers: fetchAllUsers,
        createUser: createUser,
        updateUser: updateUser,
        deleteUser: deleteUser,
        isDupEmail: isDupEmail
    };

    return factory;

    function createUser() {
    }

    function updateUser() {
    }

    function deleteUser() {
    }

    function isDupEmail($scope, user) {
        user.id = 0;
        console.log("isDupEmail - " + REST_SERVICE_URI + 'dup');
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI + 'dup/', user)
            .then(
                function (response) {
                    console.log(response.data);
                    deferred.resolve(response.data);
                    handlerSuccess($scope, response);
                }, function (response) {
                    handlerException($scope, response);
                }
            ).catch(function (data, status) {
                console.error('Gists error', response.status, response.data);
            }).finally(function () {
                console.log("finally finished gists");
            });
        return deferred.promise;
    }

    function fetchAllUsers() {
        console.log("fetchAllUsers - " + REST_SERVICE_URI + 'findAll');
        var deferred = $q.defer();

        $http.get(REST_SERVICE_URI + 'findAll/')
            .then(
                function (response) {
                    console.log(response.data);
                    deferred.resolve(response.data);
                    handlerSuccess($scope, response);
                }, function (response) {
                    handlerException($scope, response);
                }
            );
        return deferred.promise;
    }

}]);