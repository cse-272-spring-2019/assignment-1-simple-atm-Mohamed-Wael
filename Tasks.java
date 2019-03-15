package atm;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohamed Wael
 */
public class Tasks {
    public double balance = 0;
    public String getbalance(){
        String y = Double.toString(balance);
        return y;
    }
    public void deposit( String amount){
        double x = Double.parseDouble(amount);
        balance+=x;
    }
        public int withdrawalcheck( String amount){
        double z = Double.parseDouble(amount);
        if(z>balance)
            return 0;
        else{
            withdraw(z);
            return 1;
        }}
        public void withdraw(double amount){
            balance-=amount;
        }
        
    }
