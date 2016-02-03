'use strict';

var rentControllers = angular.module('rentControllers', []);

rentControllers.controller("rentController", function($scope,$http,$routeParams) {

	$http.get('http://localhost:8080/Angular-master/rentedcar').
	  success(function(data, status, headers, config) {
		$scope.orginal = [
		                  {
		                	  plateNumber:"11AA22",
		                	  plateType:"Citroen",
		                	  setPlateSeat:2,
		                	  rented:false
		                	  },
		                  {
		                		  plateNumber:"22BB33",
		                		  plateType:"Mercedes-Benz",
		                		  setPlateSeat:4,
			                	  rented:false
			                  },
		                	  {
		                		  plateNumber:"33CC44",
		                		  plateType:"Bayerische Motoren Werke AG",
		                		  setPlateSeat:4,
			                	  rented:false
			                  },
		                	  {
		                		  plateNumber:"44DD55",
		                		  plateType:"Citroen",
		                		  setPlateSeat:6,
			                	  rented:false
			                  },
		                	  {
		                		  plateNumber:"55EE66",
		                		  plateType:"BUICK",
		                		  setPlateSeat:4,
			                	  rented:false
			                  }
		                	  ];
		$scope.carsList = data;
	  	$scope.selected = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });

////////////////////////////////////////

////////////////////////////////////////
	$http.get('http://localhost:8080/Angular-master/notrentedcar').
	  success(function(data, status, headers, config) {
		$scope.orginal = [
		                  {
		                	  plateNumber:"11AA22",
		                	  plateType:"car",
		                	  rented:false
		                	  },
		                  {
		                		  plateNumber:"22BB33",
		                		  plateType:"vechile",
			                	  rented:false
			                  },
		                	  {
		                		  plateNumber:"33CC44",
		                		  plateType:"car",
			                	  rented:false
			                  },
		                	  {
		                		  plateNumber:"44DD55",
		                		  plateType:"vechile",
			                	  rented:false
			                  },
		                	  {
		                		  plateNumber:"55EE66",
		                		  plateType:"hahahahaha",
			                	  rented:false
			                  }
		                	  ];
		$scope.carsList2 = data;
	  	$scope.selected = data[0];
	  }).
	  error(function(data, status, headers, config) {
	  });
	///////////////////////////////////////////

	///////////////////////////////////////////	
	
	
	
	
	$scope.rent = function(selected) {
		$http.delete('http://localhost:8080/Angular-master/car/'+selected.plateNumber).
		  success(function(data, status, headers, config) {
		  	alert('rent ok');
		  	window.location.reload();
		  }).
		  error(function(data, status, headers, config) {
			  alert('erreur');
		  });
	};
	
	///////////////////////////////////////////

	///////////////////////////////////////////       
	$scope.back = function(selected) {
		$http.put('http://localhost:8080/Angular-master/car/'+selected.plateNumber).
		  success(function(data, status, headers, config) {
		  	alert('renturn ok, Thank you for your rented');
		  	window.location.reload();
		  }).
		  error(function(data, status, headers, config) {
			  alert('erreur');
		  });
	};
		
});
