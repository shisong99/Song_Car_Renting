'use strict';

var app = angular.module('rentCar', [
	'ngRoute','rentControllers'                                               ]);

app.config(['$routeProvider',
	function($routeProvider) {
		$routeProvider.
			when('/rentCars', {
				templateUrl: 'partials/menu.html'
			}).
			when('/rentCars/rent', {
				templateUrl: 'partials/rent.html',
				controller: 'rentController'
			}).
			when('/rentCars/back', {
				templateUrl: 'partials/back.html',
				controller: 'rentController'
			}).
			otherwise({
				redirectTo: '/rentCars'
			});
}]);
