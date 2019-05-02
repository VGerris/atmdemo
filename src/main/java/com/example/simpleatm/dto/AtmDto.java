package com.example.simpleatm.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.simpleatm.dto.TransactionDto;

public class AtmDto {
    Integer atmId;
    String atmName;
    Integer stashOf20;
    Integer stashOf50;
    Integer stashOf100;
    Integer stashOf200;
    Integer stashOf500;
    Integer stashOf1000;

    List<TransactionDto> transactionDtos = new ArrayList<>();

    public AtmDto(String atmName, List<TransactionDto> transactionDtos) {
        this.atmName = atmName;
        this.transactionDtos = transactionDtos;
    }

    public AtmDto(Integer atmId, String atmName, Integer stashOf20, Integer stashOf50, Integer stashOf100, Integer stashOf200, Integer stashOf500, Integer stashOf1000) {
        this.atmId = atmId;
        this.atmName = atmName;
        this.stashOf20 = stashOf20;
        this.stashOf50 = stashOf50;
        this.stashOf100 = stashOf100;
        this.stashOf200 = stashOf200;
        this.stashOf500 = stashOf500;
        this.stashOf1000 = stashOf1000;
    }

    public AtmDto() {
    }

    public Integer getAtmId() {
        return atmId;
    }

    public void setAtmId(Integer atmId) {
        this.atmId = atmId;
    }

    public Integer getStashOf20() {
        return stashOf20;
    }

    public void setStashOf20(Integer stashOf20) {
        this.stashOf20 = stashOf20;
    }

    public Integer getStashOf50() {
        return stashOf50;
    }

    public void setStashOf50(Integer stashOf50) {
        this.stashOf50 = stashOf50;
    }

    public Integer getStashOf100() {
        return stashOf100;
    }

    public void setStashOf100(Integer stashOf100) {
        this.stashOf100 = stashOf100;
    }

    public Integer getStashOf200() {
        return stashOf200;
    }

    public void setStashOf200(Integer stashOf200) {
        this.stashOf200 = stashOf200;
    }

    public Integer getStashOf500() {
        return stashOf500;
    }

    public void setStashOf500(Integer stashOf500) {
        this.stashOf500 = stashOf500;
    }

    public Integer getStashOf1000() {
        return stashOf1000;
    }

    public void setStashOf1000(Integer stashOf1000) {
        this.stashOf1000 = stashOf1000;
    }

    public void setTransactionDtos(List<TransactionDto> transactionDtos) {
        this.transactionDtos = transactionDtos;
    }

    public String getAtmName() {
        return atmName;
    }

    public void setAtmName(String atmName) {
        this.atmName = atmName;
    }

    public List<TransactionDto> getTransactionDtos() {
        return transactionDtos;
    }

    public void addBillOf20(Integer amount) {
        stashOf20 = stashOf20 + amount;
    }

    public void addBillOf50(Integer amount) {
        stashOf50 = stashOf50 + amount;
    }

    public void addBillOf100(Integer amount) {
        stashOf100 = stashOf100 + amount;
    }
    
    public void addBillOf200(Integer amount) {
        stashOf200 = stashOf200 + amount;
    }

    public void addBillOf500(Integer amount) {
        stashOf500 = stashOf500 + amount;
    }

    public void addBillOf1000(Integer amount) {
        stashOf1000 = stashOf1000 + amount;
    }

    public void removeBillOf20(Integer amount) {
        stashOf20 = stashOf20 - amount;
    }

    public void removeBillOf50(Integer amount) {
        stashOf50 = stashOf50 - amount;
    }

    public void removeBillOf100(Integer amount) {
        stashOf100 = stashOf100 - amount;
    }

    public void removeBillOf200(Integer amount) {
        stashOf200 = stashOf200 - amount;
    }

    public void removeBillOf500(Integer amount) {
        stashOf500 = stashOf500 - amount;
    }

    public void removeBillOf1000(Integer amount) {
        stashOf1000 = stashOf1000 - amount;
    }

    public void depositBills(Integer addStashOf20, Integer addStashOf50, Integer addStashOf100, Integer addStashOf200, Integer addStashOf500, Integer addStashOf1000) {

        addBillOf20(addStashOf20);
        addBillOf50(addStashOf50);
        addBillOf100(addStashOf100);
        addBillOf200(addStashOf200);
        addBillOf500(addStashOf500);
        addBillOf1000(addStashOf1000);
    }

    /**
     * Find possible options for removal of amount and pick one with highest bills
     * based on : https://stackoverflow.com/questions/22128759/atm-algorithm-of-giving-money-with-limited-amount-of-bank-notes
     * */
    public void removeFromStashes(Float amount) {
        // TODO use transaction class to represent transaction

        // first we find if there is an option
        int[] values = {20, 50, 100, 200,500,1000};
        int[] amounts = {stashOf20,stashOf50,stashOf100,stashOf200,stashOf500,stashOf1000};
        System.out.println("Stash before remove: " + stashOf20 + " " + stashOf50 + " " + stashOf100 + " " + stashOf200 + " " + stashOf500 + " " + stashOf1000);

        List<Integer[]> results = solutions(values, amounts, new int[6], amount.intValue(), 0);

        for (Integer[] result : results) {
            System.out.println("stash option: " + Arrays.toString(result));
        }

        if (results.size() > 0) {
            // spec is highest bills first, which is the last element
            Integer[] optimal = results.get(results.size()-1);
            removeBillOf20(optimal[0]);
            removeBillOf50(optimal[1]);
            removeBillOf100(optimal[2]);
            removeBillOf200(optimal[3]);
            removeBillOf500(optimal[4]);
            removeBillOf1000(optimal[5]);

            System.out.println("Stash after remove: " + stashOf20 + " " + stashOf50 + " " + stashOf100 + " " + stashOf200 + " " + stashOf500 + " " + stashOf1000);
            // This shows the order of bills in the application log
            System.out.println("Bills given out in order: -- 1000 * " + optimal[5] + " -- 500 * " + optimal[4] + " -- 200 * " + optimal[3] + " -- 100 * " + optimal[2]+ " -- 50 * " + optimal[1]+ " -- 20 * " + optimal[0] );

        } else {
            System.out.println("Stash TOO LOW. current: " + stashOf20 + " " + stashOf50 + " " + stashOf100 + " " + stashOf200 + " " + stashOf500 + " " + stashOf1000);
            // TODO we already withdrew from the account - needs to be implemented to not withdraw
        }

    public static List<Integer[]> solutions(int[] values, int[] ammounts, int[] variation, int price, int position) {
        List<Integer[]> list = new ArrayList<>();
        int value = compute(values, variation);
        if (value < price) {
            for (int i = position; i < values.length; i++) {
                if (ammounts[i] > variation[i]) {
                    int[] newvariation = variation.clone();
                    newvariation[i]++;
                    List<Integer[]> newList = solutions(values, ammounts, newvariation, price, i);
                    if (newList != null) {
                        list.addAll(newList);
                    }
                }
            }
        } else if (value == price) {
            list.add(myCopy(variation));
        }
        return list;
    }

    public static int compute(int[] values, int[] variation) {
        int ret = 0;
        for (int i = 0; i < variation.length; i++) {
            ret += values[i] * variation[i];
        }
        return ret;
    }

    public static Integer[] myCopy(int[] ar) {
        Integer[] ret = new Integer[ar.length];
        for (int i = 0; i < ar.length; i++) {
            ret[i] = ar[i];
        }
        return ret;
    }

}
