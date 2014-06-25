var app = angular.module("geektic", ['ngRoute']);
/*
app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});
app.controller('Hello2Ctrl', function($scope, $http) {
    $http.get('/api/hello/test').success(function(helloMessage) {
        $scope.helloMessage2 = helloMessage;
    });
});
app.controller('ListGeekCtrl', function($scope, $http) {
    $http.get('/api/geek').success(function(geek) {
        $scope.geek = geek;
    });
});
*/
app.controller('GeekCtrl', function($scope, $http) {    
    
	$scope.constructionCombo = function()
	{
		$http.get('/api/geek/combo').success(function(interets) {
            $scope.interets = interets;
        });
	}
	
	$scope.constructionCombo();
	
	$scope.recherche = function()
    {
		if ($scope.sexe == "" || $scope.sexe == null || $scope.interet == "" || $scope.interet == null )
			{
				alert("Vous devez sélectionner un genre et un centre d'interêt.");
				return;
			}
    	$http.get('/api/geek/bysex/' + $scope.sexe + '/' + $scope.interet).success(function(geeks) {
            $scope.geeksbysex = geeks;
        });
    };    
});