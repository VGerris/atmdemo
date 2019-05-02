package com.example.simpleatm.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vgerris on 21/4/19.
 * The Atm represents a machine which can execute transactions (withdrawal).
 * It has slots with stashes of various bills - these are current existing Swedish Krona (SEK) bills
 */
@Entity
public class Atm {

    private final int BILL20 = 20;
    private final int BILL50 = 50;
    private final int BILL100 = 100;
    private final int BILL200 = 200;
    private final int BILL500 = 500;
    private final int BILL1000 = 1000;

    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer atmId;
    @Column
    private String atmName;
    @Column
    private Integer stashOf20;
    @Column
    private Integer stashOf50;
    @Column
    private Integer stashOf100;
    @Column
    private Integer stashOf200;
    @Column
    private Integer stashOf500;
    @Column
    private Integer stashOf1000;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> transactions = new LinkedList<>();

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

    public Atm() {
    }

    public Atm(String atmName, Integer stashOf20, Integer stashOf50, Integer stashOf100, Integer stashOf200, Integer stashOf500, Integer stashOf1000) {

        this.atmName = atmName;
        this.stashOf20=stashOf20;
        this.stashOf50=stashOf50;
        this.stashOf100=stashOf100;
        this.stashOf200=stashOf200;
        this.stashOf500=stashOf500;
        this.stashOf1000=stashOf1000;

    }

    public Integer getAtmId() {
        return atmId;
    }

    public void setAtmId(Integer atmId) {
        this.atmId = atmId;
    }

    public String getAtmName() {
        return atmName;
    }

    public void setAtmName(String userName) {
        this.atmName = atmName;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
