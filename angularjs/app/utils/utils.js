/**
 * Created by prayoon-pc on 4/18/2017.
 */
function removeArray(arr) {
    var what, a = arguments, L = a.length, ax;
    while (L > 1 && arr.length) {
        what = a[--L];
        while ((ax= arr.indexOf(what)) !== -1) {
            arr.splice(ax, 1);
        }
    }
    return arr;
}

function handlerException($scope, response){
        console.log(response);
        $scope.responseMessage.msgCode = 'error';
        $scope.responseMessage.msgDesc = 'Error can\'t connect server';
}
function handlerSuccess($scope, response) {
    $scope.responseMessage.msgCode = 'success';
    $scope.responseMessage.msgDesc = '';
}