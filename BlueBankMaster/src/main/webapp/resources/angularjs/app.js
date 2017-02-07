var app = angular.module('app', []);

app.controller('conta', function($scope, $http) {
 
	
	  var carregarConta = function(){
		  $http.get("json").success(function(data){
			  $scope.conta = data;
		  });
	  }	
	  carregarConta();

});