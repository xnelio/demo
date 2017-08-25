var appCliente = angular.module("appCliente", []);

//Criação de controllers

appCliente.controller("indexController", function($scope){

	$scope.nome = "jao";
	$scope.clientes[];


$http({
  method: 'GET',
  url: 'http://localhost:8080/demo/clientes'
}).then(function successCallback(response) {
    $scope.clientes = response.data;
  }, function errorCallback(response) {
    
  });

});