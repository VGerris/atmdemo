'use strict'

var module = angular.module('demo.controllers', []);
module.controller("UserController", [ "$scope", "UserService", "AtmService",
		function($scope, UserService, AtmService) {

			$scope.userDto = {
				userId : null,
				userName : null,
				accountDtos : []
			};

			$scope.userDto1 = {
				userId : 1,
				userName : "ATMuser",
				accountDtos : []
			};

			$scope.accounts = [];
			$scope.user1 = null;
			$scope.account1 = null;

			$scope.init = function () {
				UserService.getUserById(1);
			};

			UserService.getUserById(1).then(function(value) {
				$scope.user1 = value.data;
				$scope.account1 = $scope.user1.accountDtos[0]; // we only use 1 account for this demo
				$scope.balance1 = $scope.account1.balance;
				console.log("getUserById value balance: " + $scope.balance1 + " accID: " + $scope.account1.accountId);
			}, function(reason) {
				console.log("error occured");
			}, function(value) {
				console.log("no callback");
			});

			$scope.saveUser = function() {
				$scope.userDto.accountDtos = $scope.accounts.map(account => {
					return {accountId: null, accountName: account};
				});
				UserService.saveUser($scope.userDto).then(function() {
					console.log("works");
					UserService.getAllUsers().then(function(value) {
						$scope.allUsers= value.data;
					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});

					$scope.accounts = [];
					$scope.userDto = {
						userId : null,
						userName : null,
						accountDtos : []
					};
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}

			$scope.saveUserBalance = function() {
				console.log("saveBal: " + $scope.user1.accountDtos[0].balance);
				$scope.user1.accountDtos[0].balance = parseFloat($scope.balance);
				console.log("NEW Bal: " + $scope.user1.accountDtos[0].balance);
				UserService.saveUserBalance($scope.user1).then(function() {
					console.log("works");
					UserService.getUserById(1).then(function(value) {
						console.log("balance= " + $scope.balance + " value= " + value.data.accountDtos[0].balance);
						//$scope.balance = value.data;
					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});

					$scope.balance = null;

				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}

			$scope.withdrawFunds = function() {
				console.log("curBal: " + $scope.user1.accountDtos[0].balance);
				console.log("withdraw: " + parseFloat($scope.balance));
				UserService.withdrawFunds($scope.user1, parseFloat($scope.balance)).then(function() {
					console.log("withdraw works");
					UserService.getUserById(1).then(function(value) {
						console.log("balance= " + $scope.balance + " value= " + value.data.accountDtos[0].balance);
						// instead of : $scope.account1.balance=value.data.accountDtos[0].balance;
						// we update the value on the DTO so angular will update the other mappings also if needed
						$scope.user1.accountDtos[0].balance =  value.data.accountDtos[0].balance;

					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});

					$scope.balance = null;

				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}

			$scope.depositFunds = function(param) {
				console.log("curBal: " + $scope.user1.accountDtos[0].balance);
				console.log("deposit: " + $scope.balance);
				UserService.depositFunds($scope.user1, parseFloat(param)).then(function() {
					console.log("deposit works");
					UserService.getUserById(1).then(function(value) {
						console.log("balance= " + $scope.balance + " value= " + value.data.accountDtos[0].balance);
						// instead of : $scope.account1.balance=value.data.accountDtos[0].balance;
						// we update the value on the DTO so angular will update the other mappings also if needed
						$scope.user1.accountDtos[0].balance =  value.data.accountDtos[0].balance;
					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});

					/*AtmService.depositBills(parseInt(20)).then(function (value) {
						console.log("balance atm bills= " + $scope.balance + " value= " + value.data);
					}, function(reason) {
						console.log("error occured");
					}, function(value) {
						console.log("no callback");
					});*/

					$scope.balance = null;

				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}

		} ]);