app.controller('studentsController',function($scope,$location,$http){
	var basicUrl = $location.protocol()+'://'+$location.host()+':'+$location.port();
	
	$scope.nombre = 'Ruben Martin Olmedo';
//	$scope.listaAmigos = ['Maria','Consuelo','Teresa'];
	$scope.listaAmigos = [{nombre:'Maria',edad:55},{nombre:'Consuelo',edad:35},{nombre:'Teresa',edad:59}];
//	$scope.saluda = function(){console.log('holiiii !')};
	$scope.saluda = function(){alert('holiiii !, estas en -->> '+ $location.absUrl() )};
	$scope.listaEstudiantes ;
	$scope.listaSubjectos  ;
	$scope.addStuden= aniadeEstudiante ; 
	$scope.estudianteForm = {
			name:'',
			subject:''
	};
	
	function aniadeEstudiante(){
		$http({
	        url: basicUrl+'/rest/student/add',
	        method: "POST",
	        data: $scope.estudianteForm
	    })
	    .then(function(response) {
	            alert('insercion de estudiante correcta');
	    }, 
	    function(response) { // optional
	            console.log('falla insercion estudiante');
	    });
	}	
	
	
	$http({
        method : 'GET',
        url : basicUrl +'/rest/student/'
    }).then(function (response) {
    	$scope.listaEstudiantes = response.data;
    }, function (response) {
        console.log('KO SERVICIO GETlISTAESTUDIANTES');
    });


	$http({
        method : 'GET',
        url : basicUrl +'/rest/student/getSubjects'
    }).then(function (response) {
    	$scope.listaSubjectos = response.data;
    }, function (response) {
        console.log('KO SERVICIO GETlISTAESTUDIANTES');
    });


});

