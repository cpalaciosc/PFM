/**
 * AngularJS ProjectController
 */
projectApp.controller(
	  'projectController', function ($scope, test) {  
	  
	  !test && initJSFScope($scope);
	  var start;
	  var end;
	
	  $scope.projectBean.project.start = moment(new Date($scope.projectBean.project.start));
	  $scope.projectBean.project.end = moment(new Date($scope.projectBean.project.end));
	  console.log($scope.projectBean.project.start);
	  console.log($scope.projectBean.project.end);
	  $scope.workDays = 0;
	  $scope.naturalDays = 0;
	  
	  $scope.$watchGroup(['projectBean.project.start', 'projectBean.project.end'], function(newValues, oldValues, scope) {
		  var days=0;
		  start = $scope.projectBean.project.start;
		  end = $scope.projectBean.project.end;	
		  console.log($scope.workingDays);
		  for (var m = moment(start); m.isBefore(end); m.add(1, 'days')) {
			  if(($scope.workingDays).indexOf(m.day())>-1)
				  days++	
			}
		  $scope.workDays = days;
		  
		  $scope.naturalDays= end.add(1,'days').diff(start,'days');
	  });
	  
	  $scope.naturalMonths = function(){
		  return $scope.naturalDays/30;
	  }
	  
	  $scope.workMonths = function(){
		  return $scope.workDays/$scope.projectBean.projectSchedule.workDays;
	  }
	  	  
	  $scope.workHours = function(){
		  return 1;
	  }
	  
	  $scope.costNaturalMonth = function(){
		  return (($scope.projectBean.project.cost/$scope.naturalMonths()).toFixed(2)/1);
	  }
	  
	  $scope.costNaturalDay = function(){
		  return (($scope.projectBean.project.cost/$scope.naturalDays).toFixed(2)/1);
	  }
	  
	  $scope.costWorkMonth = function(){
		  return $scope.projectBean.project.cost/$scope.workMonths();
	  }
	  
	  $scope.costWorkDay = function(){
		  return $scope.projectBean.project.cost/$scope.workDays;
	  }
	  
	  $scope.costWorkHour = function(){
		  return $scope.projectBean.project.cost/$scope.workHours();
	  }
	  	   
});
