
(function() {
	var app = angular.module("ecommerce", [ "pascalprecht.translate", "home", "user", "commande", "ngRoute" ]);

	app.config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
		  $routeProvider
		  .when("/", {
		    templateUrl : "home.html"
		  })
		  .when("/home", {
		    templateUrl : "home.html"
		  })
		  .when("/user", {
		    templateUrl : 'user.html',
		    controller : 'UserController',
		    controllerAs : 'userCtrl'
		  })
		  .when("/commande", {
			  templateUrl: "commande.html",
			controller: 'CommandeController',
			controllerAs: 'commandeCtrl'
		  })
		  .otherwise({
			  redirectTo: '/'
		  });
		  
		  //$locationProvider.html5Mode(true);
		}]);
	
	app.config(function($translateProvider) {
		$translateProvider.useStaticFilesLoader({
		    prefix: 'i18n/messages-',
		    suffix: '.json'
		});
		$translateProvider.preferredLanguage('en');
		$translateProvider.useSanitizeValueStrategy('escape');
	});
	
	app.controller('TranslateController', function($translate) {
	  this.changeLanguage = function (langKey) {
	    $translate.use(langKey);
	  };
	});

	app.controller("PanelController", function() {
		var self = this;
		self.tab   = null;

		self.setTab = function(currentTab) {
			self.tab = currentTab;
		};

		self.isSet = function(currentTab) {
			return self.tab == currentTab;
		};
	});
})();