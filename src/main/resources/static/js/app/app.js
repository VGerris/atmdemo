'use strict'

var demoApp = angular.module('demo', [ 'ui.bootstrap', 'demo.controllers',
		'demo.services' ]);
demoApp.constant("CONSTANTS", {
	getUserByIdUrl : "/user/getUser/",
	getAllUsers : "/user/getAllUsers",
	saveUser : "/user/saveUser",
	saveUserBalance : "/user/saveUserBalance",
	withdrawFundsUrl : "/user/withdrawFunds/",
	depositFundsUrl : "/user/depositFunds/",

	getAtmByIdUrl : "/atm/getAtm/",
	getAllAtms : "/atm/getAllAtms",
	saveAtm : "/atm/saveAtm",
	withdrawBillsUrl : "/atm/withdrawBills/",
	depositBillsUrl : "/atm/depositBills/"

});