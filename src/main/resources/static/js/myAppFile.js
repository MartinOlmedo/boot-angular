var app = angular.module( 'studentsApp',['ngRoute','ngResource'] )
.config(function($routeProvider){
	
	$routeProvider
    .when('/add', {
        templateUrl : 'add.htm'
    })
    .when('/edit', {
        templateUrl : 'edit.htm'
    })
    .when('/remove', {
        templateUrl : 'remove.htm'
    });

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