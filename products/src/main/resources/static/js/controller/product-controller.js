// Module controller
app.controller("productController", function($scope, $http) {

	$scope.products = [];
	$scope.product = {};

	loadProducts = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/products'
		}).then(function(response) {
			$scope.products = response.data;

		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});
	};

	$scope.saveProduct = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8080/products',
			data : $scope.product
		}).then(function(response) {
			$scope.products.push(response.data);
			loadProducts();
			$scope.cancelAlter();

		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});

	};

	$scope.deleteProduct = function(product) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/products/' + product.id

		}).then(function(response) {

			pos = $scope.products.indexOf(product);
			$scope.products.splice(pos, 1);

		}, function(response) {
			console.log(response.data);
			console.log(response.status);
		});

	};

	$scope.alterProduct = function(product) {
		$scope.product = angular.copy(product);
//		$http({
//			method : 'PUT',
//			url : 'http://localhost:8080/products',
//
//		}).then(function(response) {
//			
//			pos = $scope.products.indexOf(product);
//			$scope.products
//
//		}, function(response) {
//			console.log(response.data);
//			console.log(response.status);
//		});

	};
	
	$scope.cancelAlter = function(){
		$scope.product={};
	};

	loadProducts();
});