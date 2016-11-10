<!DOCTYPE html>
<html ng-app="ecommerce">
<head>
<meta charset="UTF-8">
<title>{{'TITLE' | translate}}</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/forms.css" />
<link rel="stylesheet" type="text/css" href="css/users.css" />
<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/angular-route.min.js"></script>
<script type="text/javascript" src="js/angular-translate.min.js"></script>
<script type="text/javascript"
	src="js/angular-translate-loader-static-files.min.js"></script>
<script type="text/javascript" src="js/app.js" charset="utf-8"></script>
<script type="text/javascript" src="js/controllers/home.js"	charset="utf-8"></script>
<script type="text/javascript" src="js/controllers/user.js"	charset="utf-8"></script>
<script type="text/javascript" src="js/controllers/commande.js"	charset="utf-8"></script>
<base href="/ecommerce-angular/" />
</head>
<body>

	<div ng-controller="TranslateController as translateCtrl">
		<button ng-click="translateCtrl.changeLanguage('en')"
			translate="BUTTON_EN"></button>
		<button ng-click="translateCtrl.changeLanguage('fr')"
			translate="BUTTON_FR"></button>
	</div>

		<!-- Controller Normal -->
	<section ng-controller="PanelController as panel">
		<ul class="nav nav-pills">
		<li ng-class="{active:panel.isSet('home')}"><a href="#/home"
				ng-click="panel.setTab('home')">Home</a></li>
			<li ng-class="{active:panel.isSet('user')}"><a href="#/user"
				ng-click="panel.setTab('user')">User</a></li>
				<li ng-class="{active:panel.isSet('commande')}"><a href="#/commande"
				ng-click="panel.setTab('commande')">Commande</a></li>
		</ul>
<!-- 
		<home ng-show="panel.isSet('home')"> </home>
		<user ng-show="panel.isSet('user')"> </user>
		<commande ng-show="panel.isSet('commande')"> </commande>
 -->
 
 		<!-- Controller avec Routes -->
 		
 		<!-- <section ng-controller="PanelController as panel">
		<ul class="nav nav-pills">
			<li ng-class="{active:panel.isSet('user')}"><a href="services/user/"
				ng-click="panel.setTab('user')">User</a></li>
				<li ng-class="{active:panel.isSet('commande')}"><a href="services/commande/"
				ng-click="panel.setTab('commande')">Commande</a></li>
		</ul>
		 -->
		<div ng-view></div>
		
	</section>
</body>
</html>