package com.example.yks93.mysocketpractice02;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class RetroNumberData {

    private final String TAG = "RetroNumberData";

    @SerializedName("balance")
    private String balance;
    @SerializedName("amount")
    private String amount;
    @SerializedName("depositOrWithdraw")
    private String depositOrWithdraw;

    public RetroNumberData(String balance, String amount, String depositOrWithdraw) {
        this.balance = balance;
        this.amount = amount;
        this.depositOrWithdraw = depositOrWithdraw;
    }

    public String getBalance() {
        Log.d(TAG, "getBalance: ");
        return balance;
    }
    public void setBalance(String balance) {
        Log.d(TAG, "setBalance: ");
        this.balance = balance;
    }

    public String getAmount() {
        Log.d(TAG, "getAmount: ");
        return amount;
    }
    public void setAmount(String amount) {
        Log.d(TAG, "setAmount: ");
        this.amount = amount;
    }

    public String getDepositOrWithdraw() {
        Log.d(TAG, "getDepositOrWithdraw: ");
        return depositOrWithdraw;
    }
    public void setDepositOrWithdraw(String deposit) {
        Log.d(TAG, "setDepositOrWithdraw: ");
        this.depositOrWithdraw = depositOrWithdraw;
    }

}
