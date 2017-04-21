/**
 * Created by prayoon-pc on 4/18/2017.
 */
'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function ($scope, UserService) {
    var self = this;

    self.user = {id: null, username: '', address: '', email: ''};
    //data store on client side
    self.users = [];
    self.checkedItems = [];

    // function declare
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;

    function submit() {}
    function edit() {}
    function remove() {}

    self.checkDupEmail = checkDupEmail;

    function checkDupEmail() {
        UserService.isDupEmail(self.user);
    }


    function reset() {
        self.user = {id: null, username: '', address: '', email: ''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
