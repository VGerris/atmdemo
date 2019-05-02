'use strict'

angular.module('demo.services').factory('AtmService',
    [ "$http", "CONSTANTS", function($http, CONSTANTS) {
        var service = {};
        service.getAtmById = function(atmId) {
            var url = CONSTANTS.getAtmByIdUrl + atmId;
            return $http.get(url);
        }
        service.getAllAtms = function() {
            return $http.get(CONSTANTS.getAllAtms);
        }
        service.saveAtm = function(atmDto) {
            return $http.post(CONSTANTS.saveAtm, atmDto);
        }
        service.withdrawBills = function (atmDto, withdrawal) {
            var url = CONSTANTS.withdrawBillsUrl + withdrawal;
            return $http.post(url, atmDto);
        }
        service.depositBills = function (atmDto, deposit20bill, deposit50bill, deposit100bill, deposit200bill, deposit500bill, deposit1000bill) {
            var url = CONSTANTS.depositBillsUrl + deposit20bill + "/" + deposit50bill +"/" + deposit100bill + "/" + deposit200bill + "/" + deposit500bill + "/" + deposit1000bill;
            return $http.post(url, atmDto);
        }
        return service;
    } ]);