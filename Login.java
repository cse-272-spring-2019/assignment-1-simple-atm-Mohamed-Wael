package atm;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohamed Wael
 */
public class Login {
    public boolean validate( String num ){
        int x = 2019;
        int y = Integer.parseInt(num);
        if(x==y)
            return true;
        else
            return false;
        
    }
    
}
