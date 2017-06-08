'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'myApp.view1',
    'myApp.view2',
    'myApp.version',
    'myApp.user-mng'
]).config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
    $locationProvider.hashPrefix('!');

    $routeProvider.otherwise({redirectTo: '/view1'});
}]).
controller('driversController', function($scope) {
    $scope.responseMessage = {msgCode: null, msgDesc: ''};

    $scope.appInfo = {name: null, version: ''};
    $scope.appInfo.name = 'AngularJS';
    $scope.appInfo.version = angular.version.full;

});
