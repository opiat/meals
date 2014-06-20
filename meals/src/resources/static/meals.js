(function(){
	var app = angular.module('meals', []);
	
	app.controller('MealsController', ['$http', '$filter', function($http, $filter){
		this.date = new Date();
		this.getDateFormatted = function(){
			return  $filter('date')(this.date, 'dd-MM-yyyy');
		};
	
		this.meals = [];
		var that = this;
		this.refreshMeals = function(){
			$http.get('/meals/list/byDate/' + this.getDateFormatted()).success(function(data){
				that.meals = angular.copy(data);
			});
		};
		this.refreshMeals();
		
		this.addMeal = function(meal){	
			meal.date = this.getDateFormatted();
			$http.post('/meals/add', meal).success(function(){
				that.refreshMeals();
			});
		};
		
		this.showPreviousDay = function(){
			this.date.setDate(this.date.getDate() - 1);
			this.refreshMeals();
		};
		
		this.showNextDay = function(){
			this.date.setDate(this.date.getDate() + 1);
			this.refreshMeals();
		};
	}]);
	
})(); 