/**
 * Created by prayoon-pc on 4/18/2017.
 */
'use strict';

angular.module('myApp.user-mng', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/user-mng', {
            templateUrl: 'usermng/user-mng.html',
            controller: 'UserController'
        });
    }])

    .controller('UserController', [function () {

    }]);