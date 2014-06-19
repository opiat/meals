(function(){
	var app = angular.module('meals', []);
	
	app.controller('MealsController', ['$http', function($http){
		this.meals = [];
		var that = this;
		this.refreshMeals = function(){
			$http.get('/meals/all').success(function(data){
				that.meals = data;
			});
		};
		this.refreshMeals();
		
		this.addMeal = function(meal){		
			$http.post('/meals/add', meal).success(function(){
				that.refreshMeals();
			});
		};
	}]);
	
})(); 