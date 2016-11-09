(function() {
	var app = angular.module("user", []);
	
	app.controller("UserController", function($http) {
		var self = this;
		
		self.users = [];
		self.user = null;
		
		self.roles = [];
		
		self.list = function() {
			$http({
				method : 'GET',
				url : 'services/user/'
			}).then(function successCallback(response) {
				self.users = response.data;
			}, function errorCallback(response) {

			});
		};
		
		self.addUser = function() {
			self.user={};
			
			$http({
				method : 'GET',
				url : 'services/user/role'
			}).then(function successCallback(response) {
				self.roles = response.data;
				console.log(self.roles);
			}, function errorCallback(response) {

			});
		}; 
		
		
		self.save = function() {
			if(self.user.id) {
				$http({
					method : 'PUT',
					url : 'services/user/' + self.user.id,
					data : self.user
				}).then(function successCallback(response) {
					self.list();
					self.user=null;
				}, function errorCallback(response) {
	
				});
			} else {
				$http({
					method : 'POST',
					url : 'services/user/',
					data : self.user
				}).then(function successCallback(response) {
					self.list();
					self.user=null;
				}, function errorCallback(response) {
	
				});
			}
			
			
		}; 
		
		self.edit = function(id) {
			
			$http({
				method : 'GET',
				url : 'services/user/' + id 
			}).then(function successCallback(response) {
				self.user = response.data;
				$http({
					method : 'GET',
					url : 'services/user/role'
				}).then(function successCallback(response) {
					self.roles = response.data;
					console.log(self.roles);
				}, function errorCallback(response) {

				});
			}, function errorCallback(response) {

			});
			
			
			
		}; 
		
		self.remove = function(id) {
			$http({
				method : 'DELETE',
				url : 'services/user/' + id
			}).then(function successCallback(response) {
				self.list();
			}, function errorCallback(response) {

			});
		}; 
		
		self.list();
	});
	
	app.directive("user", function(){
		return {
			restrict: 'E',
			templateUrl: "user.html",
			controller: 'UserController',
			controllerAs: 'userCtrl'
		};
	});
})(); 