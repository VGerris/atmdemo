'use strict'

var module = angular.module('demo.controllers');
module.controller("AtmController", [ "$scope", "AtmService",
    function($scope, AtmService) {

        $scope.atmDto = {
            atmId : null,
            atmName : null,
            transactionDtos : []
        };

        $scope.atmDto1 = {
            atmId : 1,
            atmName : "ATMuser",
            transactionDtos : []
        };

        $scope.accounts = [];
        $scope.atm1 = null;
        $scope.account1 = null;

        $scope.init = function () {
            AtmService.getAtmById(1);
        };

        AtmService.getAtmById(1).then(function(value) {
            $scope.atm1 = value.data;
            $scope.atm1Name = $scope.atm1.atmName; // we only use 1 ATM for this demo
            $scope.stash1Of20 = $scope.atm1.stashOf20;
            console.log("getAtmById value name: " + $scope.atm1Name
                + " StashOf20: " +$scope.stash1Of20
                + " StashOf50: " +$scope.atm1.stashOf50
                + " StashOf100: " +$scope.atm1.stashOf100
                + " StashOf200: " +$scope.atm1.stashOf200
                + " StashOf500: " +$scope.atm1.stashOf500
                + " StashOf1000: " +$scope.atm1.stashOf1000
            );
        }, function(reason) {
            console.log("error occured");
        }, function(value) {
            console.log("no callback");
        });

        $scope.saveAtm = function() {
        //    $scope.atmDto.transactions = $scope.accounts.map(transaction => {
        //        return {transactionId: null, transactionName: transaction};
        //}); TODO - implement for transactions
            AtmService.saveAtm($scope.atmDto).then(function() {
                console.log("works");
                AtmService.getAllAtms().then(function(value) {
                    $scope.allAtms= value.data;
                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });

                $scope.transactions = [];
                $scope.atmDto = {
                    atmId : null,
                    atmName : null,
                    transactionDtos : []
                };
            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }

        $scope.withdrawBills = function() {
            console.log("wdBill curBal: " + $scope.atm1.balance);
            console.log("wdBill withdraw: " + parseFloat($scope.balance));
            AtmService.withdrawBills($scope.atm1, parseFloat($scope.balance)).then(function() {
                console.log("withdraw works");
                AtmService.getAtmById(1).then(function(value) {
                    console.log("withdraw bills balance= " + $scope.balance + " value20s= " + value.data.stashOf20);

                    $scope.atm1 = value.data;
                    console.log("getAtmById value name after wdBills: " + $scope.atm1Name
                        + " StashOf20: " +$scope.stash1Of20
                        + " StashOf50: " +$scope.atm1.stashOf50
                        + " StashOf100: " +$scope.atm1.stashOf100
                        + " StashOf200: " +$scope.atm1.stashOf200
                        + " StashOf500: " +$scope.atm1.stashOf500
                        + " StashOf1000: " +$scope.atm1.stashOf1000
                    );

                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });

                //$scope.balance = null;

            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }

        $scope.depositBills = function(param20bill,param50bill,param100bill,param200bill,param500bill,param1000bill) {
            console.log("current bills: 20: " + $scope.atm1.stashOf20 + " 50: " + $scope.atm1.stashOf50);
            console.log("deposit bills: " + param20bill);
            AtmService.depositBills($scope.atm1, parseFloat(param20bill),parseFloat(param50bill),parseFloat(param100bill),parseFloat(param200bill),parseFloat(param500bill),parseFloat(param1000bill)).then(function() {
                console.log("deposit bills works");
                AtmService.getAtmById(1).then(function(value) {
                    console.log("atm by id executed");
                    // this should update the ui
                    $scope.atm1 = value.data;

                }, function(reason) {
                    console.log("error occured");
                }, function(value) {
                    console.log("no callback");
                });

                //$scope.balance = null;

            }, function(reason) {
                console.log("error occured");
            }, function(value) {
                console.log("no callback");
            });
        }

    } ]);