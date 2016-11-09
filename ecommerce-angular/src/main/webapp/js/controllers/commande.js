(function() {
	var app = angular.module("commande", []);
	
	app.controller("CommandeController", function($http) {
		var self = this;
		
		self.commandes = [];
		self.commande = null;
		
		self.users = [];
		
		self.list = function() {
			$http({
				method : 'GET',
				url : 'services/commande/'
			}).then(function successCallback(response) {
				self.commandes = response.data;
			}, function errorCallback(response) {

			});
		};
		
		self.addCommande = function() {
			self.commande={};
			
			$http({
				method : 'GET',
				url : 'services/user/'
			}).then(function successCallback(response) {
				self.users = response.data;
				console.log(self.users);
			}, function errorCallback(response) {

			});
		}; 
		
		
		self.save = function() {
			if(self.commande.id) {
				$http({
					method : 'PUT',
					url : 'services/commande/' + self.commande.id,
					data : self.commande
				}).then(function successCallback(response) {
					self.list();
					self.commande=null;
				}, function errorCallback(response) {
	
				});
			} else {
				$http({
					method : 'POST',
					url : 'services/commande/',
					data : self.commande
				}).then(function successCallback(response) {
					self.list();
					self.commande=null;
				}, function errorCallback(response) {
	
				});
			}
			
			
		}; 
		
		self.edit = function(id) {
			
			$http({
				method : 'GET',
				url : 'services/commande/' + id 
			}).then(function successCallback(response) {
				self.commande = response.data;
				
				$http({
					method : 'GET',
					url : 'services/user/'
				}).then(function successCallback(response) {
					self.users = response.data;
					console.log(self.users);
				}, function errorCallback(response) {

				});
				
			}, function errorCallback(response) {

			});
			
			
			
		}; 
		
		self.remove = function(id) {
			$http({
				method : 'DELETE',
				url : 'services/commande/' + id
			}).then(function successCallback(response) {
				self.list();
			}, function errorCallback(response) {

			});
		}; 
		
		self.list();
	});
	
	app.directive("commande", function(){
		return {
			restrict: 'E',
			templateUrl: "commande.html",
			controller: 'CommandeController',
			controllerAs: 'commandeCtrl'
		};
	});
})(); 