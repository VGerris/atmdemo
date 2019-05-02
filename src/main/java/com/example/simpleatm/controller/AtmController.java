package com.example.simpleatm.controller;

import com.example.simpleatm.dto.AtmDto;
import com.example.simpleatm.service.AtmService;
import com.example.simpleatm.utils.Constants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vgerris on 29/4/19.
 */
@RequestMapping("/atm")
@RestController
public class AtmController {
    @Autowired
    AtmService atmService;

    @RequestMapping(Constants.GET_ATM_BY_ID)
    public AtmDto getUserById(@PathVariable Integer atmId) {
        return atmService.getAtmById(atmId);
    }

    @RequestMapping(Constants.GET_ALL_ATMS)
    public List<AtmDto> getAllAtms() {
        return atmService.getAllAtms();
    }

    @RequestMapping(value = Constants.SAVE_ATM, method = RequestMethod.POST)
    public void saveAtm(@RequestBody AtmDto atmDto) {
        atmService.saveAtm(atmDto);
    }

    @RequestMapping(value = Constants.WITHDRAW_BILLS, method = RequestMethod.POST)
    public void withdrawBills(@RequestBody AtmDto atmDto, @PathVariable Float withdraw) {
        if (withdraw != 0 && !withdraw.isNaN()) {
            atmService.withdrawBills(atmDto, withdraw);
        } else {
            System.out.println("withdrawBills received an invalid amount, NOT sending.");
        }
    }

    @RequestMapping(value = Constants.DEPOSIT_BILLS, method = RequestMethod.POST)
    public void depositBills(@RequestBody AtmDto atmDto,
                             @PathVariable Float deposit20,
                             @PathVariable Float deposit50,
                             @PathVariable Float deposit100,
                             @PathVariable Float deposit200,
                             @PathVariable Float deposit500,
                             @PathVariable Float deposit1000
    ) {
        if (deposit20 == null || deposit20.isNaN()) deposit20 = 0F;
        if (deposit50 == null || deposit50.isNaN()) deposit50 = 0F;
        if (deposit100 == null || deposit100.isNaN()) deposit100 = 0F;
        if (deposit200 == null || deposit200.isNaN()) deposit200 = 0F;
        if (deposit500 == null || deposit500.isNaN()) deposit500 = 0F;
        if (deposit1000 == null || deposit1000.isNaN()) deposit1000 = 0F;


        System.out.println("depositBills in controller params :"
                + deposit20 + " " + deposit50 + " " + deposit100 + " " + deposit200 + " " + deposit500 + " " + deposit1000);

        atmService.depositBills(atmDto, deposit20, deposit50, deposit100, deposit200, deposit500, deposit1000);

    }
}
