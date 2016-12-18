app.controller('studentsController',function($scope,$location,$http){
	$scope.nombre = 'Ruben Martin Olmedo';
//	$scope.listaAmigos = ['Maria','Consuelo','Teresa'];
	$scope.listaAmigos = [{nombre:'Maria',edad:55},{nombre:'Consuelo',edad:35},{nombre:'Teresa',edad:59}];
//	$scope.saluda = function(){console.log('holiiii !')};
	$scope.saluda = function(){alert('holiiii !, estas en -->> '+ $location.absUrl() )};
	$scope.listaEstudiantes;
	
//	$http({
//        method : 'GET',
//        url : $location.absUrl()+'/rest/student/'
//    }).then(function (response) {
//    	$scope.listaEstudiantes = response.data;
//    }, function (response) {
//        console.log('KO SERVICIO GETlISTAESTUDIANTES');
//    });
	
	$scope.getListaEstudiantes = function(){
		$http({
	        method : 'GET',
	        url : $location.absUrl()+'/rest/student/'
	    }).then(function (response) {
	    	$scope.listaEstudiantes = response.data;
	    }, function (response) {
	        console.log('KO SERVICIO GETlISTAESTUDIANTES');
	    });
	}
});

