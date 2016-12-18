var app = angular.module( 'studentsApp',['ngRoute','ngResource'] )
.config(function($routeProvider,$locationProvider){
	
	$routeProvider
	.when('/home', {
        templateUrl : '/index.html'
    })
    .when('/add', {
        templateUrl : '/parciales/add.html'
    })
    .when('/edit', {
        templateUrl : 'parciales/edit.html'
    })
    .when('/remove', {
        templateUrl : 'parciales/remove.html'
    })
    .otherwise(
        { redirectTo: '/'}
    );

	// use the HTML5 History API
	$locationProvider.html5Mode(true);
	

});

//var app = angular.module( 'studentsApp',[] );


//app.config( function($routeProvider) {
//	$routeProvider
//	    .when('/', {
//	        templateUrl : '/',
//	        controller : studentsController
//	    })
//	    .when('/add', {
//	        templateUrl : 'partiales/add.html',
//	        controller : studentsController
//	    })
//	    .when('/edit', {
//	        templateUrl : 'partiales/edit.html',
//	        controller : studentsController
//	    })
//	    .when('/remove', {
//	        templateUrl : 'partiales/remove.html',
//	        controller : studentsController
//	    });
//	
//	// use the HTML5 History API
////	$locationProvider.html5Mode(true);
//	
//} );