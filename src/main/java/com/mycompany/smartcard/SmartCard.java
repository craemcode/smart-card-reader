/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.smartcard;

//import java.util.List;


/**
 *
 * @author USER
 */
public class SmartCard {
    
    

    public static void main(String[] args) {
        CardController contr = new CardController();
        //contr.showTerminals();
        contr.connectToCard();
    }
}
