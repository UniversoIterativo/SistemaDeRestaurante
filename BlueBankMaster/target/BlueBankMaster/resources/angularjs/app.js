var app = angular.module("NodeJSApp", []);

app.controller("NodeJSCtrl", function ($scope, $http){
	$http.get("/api/tecnologies").success(function (response) {
		$scope.tecnologies = response;
	});
});