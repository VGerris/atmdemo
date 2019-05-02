'use strict'

angular.module('demo.services', []).factory('UserService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getUserById = function(userId) {
				var url = CONSTANTS.getUserByIdUrl + userId;
				return $http.get(url);
			}
			service.getAllUsers = function() {
				return $http.get(CONSTANTS.getAllUsers);
			}
			service.saveUser = function(userDto) {
				return $http.post(CONSTANTS.saveUser, userDto);
			}
			service.saveUserBalance = function(userDto) {
				return $http.post(CONSTANTS.saveUserBalance, userDto);
			}
			service.withdrawFunds = function (userDto, withdrawal) {
				var url = CONSTANTS.withdrawFundsUrl + withdrawal;
				return $http.post(url, userDto);
			}
			service.depositFunds = function (userDto, deposit) {
				var url = CONSTANTS.depositFundsUrl + deposit;
				return $http.post(url, userDto);
			}
			return service;
		} ]);