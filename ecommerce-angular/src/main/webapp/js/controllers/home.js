(function() {
	var app = angular.module("home", []);
	
	app.controller('homeCtrl', ['$scope', function($scope){
		$scope.message = "Welcome !";
	}]);
	
	app.directive("home", function(){
		return {
			restrict: 'E',
			templateUrl: "home.html",
			controller: 'HomeController',
			controllerAs: 'homeCtrl'
		};
	});
})(); 