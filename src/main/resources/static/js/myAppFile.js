var app = angular.module( 'studentsApp',['ngRoute','ngResource'] )
.config(function($routeProvider,$locationProvider){
	$routeProvider
	    .when('/add', {
	        templateUrl : '/parciales/add.html',
	        controller: 'studentsController'
	    })
	    .when('/edit', {
	        templateUrl : 'parciales/edit.html',
	        controller: 'studentsController'
	    })
	    .when('/remove', {
	        templateUrl : 'parciales/remove.html',
	        controller: 'studentsController'
	    })
	    .when('/list', {
	        templateUrl : 'parciales/list.html',
	        controller: 'studentsController'
	    })
	    .otherwise(
	        { redirectTo: '/'}
	    );

	// use the HTML5 History API
	$locationProvider.html5Mode(true);
	

});