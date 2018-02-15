//Modulo principal
var app = angular.module("app", [ 'ngRoute' ]);

app.config(function($routeProvider, $locationProvider) {
	$routeProvider.when("/products", {
		templateUrl : 'views/product.html',
		controller : 'productController'
	}).otherwise({
		redirectTo : '/'
	});

	$locationProvider.html5Mode(true);
});