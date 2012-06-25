function ChatCtrl($scope, $http){
    $scope.message = '';
    $scope.messages = '';
    
    $scope.sendMessage = function() {
	$http.post('/send', {message: $scope.message})
	    .success($scope.fetchMessages);
	$scope.message = '';
    };

    $scope.fetchMessages = function() {
	$http.get('/fetch').success(function(data){
	    $scope.messages = data;
	})
    };
}