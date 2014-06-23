(function(){
	var app = angular.module('meals', ['ngRoute']);
	
	app.controller('MealsController', ['$http', '$filter', function($http, $filter){
		this.date = new Date();
		this.getDateFormatted = function(){
			return  $filter('date')(this.date, 'dd-MM-yyyy');
		};
	
		this.mealsList = [];
		var that = this;
		this.refreshMeals = function(){
			$http.get('/meals/list/byDate/' + this.getDateFormatted()).success(function(data){
				that.mealsList = angular.copy(data);
			});
		};
		this.refreshMeals();
		
		this.meal = {};
		this.addMeal = function(){	
			this.meal.date = this.getDateFormatted();
			$http.post('/meals/add', this.meal).success(function(){
				that.refreshMeals();
			});
			this.meal = {};
		};
		
		this.showPreviousDay = function(){
			this.date.setDate(this.date.getDate() - 1);
			this.refreshMeals();
		};
		
		this.showNextDay = function(){
			this.date.setDate(this.date.getDate() + 1);
			this.refreshMeals();
		};
		
		this.deleteMeal = function(id){
			$http.post('/meals/delete/' + id).success(function(){
				that.refreshMeals();
			});
		};
	}]);
	
	app.config(['$routeProvider',
	  function($routeProvider) {
	    $routeProvider.
	      when('/meals', {
	        templateUrl: 'partials/meal-list.html',
	        //controller: 'MealsController'
	      }).
	      otherwise({
	        redirectTo: '/meals'
	      });
	  }
	]);
	
})(); 