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
                        //CLA       INS             P1          P2          LC
        byte[] c1 = {(byte) 0x80, (byte) 0xCA, (byte) 0x00, (byte)0x5A, (byte) 0x00};
        
        contr.sendAPDU(c1);
    }
}
