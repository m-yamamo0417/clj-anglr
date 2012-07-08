angular.module('components', []).
    // *counter
    //   counts how many times loaded
    directive('counter', function() {
	return {
	    restrict: 'E',
	    transclude: true,
	    scope: {},
	    controller: function($scope, $http){
		$scope.count = 0;
		$scope.countUp = function() {
		    $http.get('/count').success(function(data){
			$scope.count = data;
		    });
		};
	    },
	    template: '<div ng-init="countUp()">{{count}}</div>',
	    replace: true
	};
    });
	    
	    
		
					       