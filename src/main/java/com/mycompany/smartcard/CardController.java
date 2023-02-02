/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartcard;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

/**
 *
 * @author USER
 */
public class CardController {
    private List<CardTerminal> terminals;
    private TerminalFactory factory;
    
    public CardController(){

        factory = TerminalFactory.getDefault();
        try {
            terminals = factory.terminals().list();
        } catch (CardException ex1) {
            System.out.println(ex1);
        }

    }
    
    
    public void connectToCard(){
        if (terminals != null && !terminals.isEmpty()) {
            try {
                // Use the first terminal
                CardTerminal terminal = terminals.get(0);
                
                // Connect with the card
                Card card = terminal.connect("T=0");
                System.out.println("card: " + card);
                
                
                
                
                CardChannel channel = card.getBasicChannel();
                byte[] c1 = {(byte) 0x00, (byte) 0xA2, (byte) 0x00, (byte)0x00, (byte) 0x02, (byte) 0xEF, (byte) 0x08, (byte) 0x0D};
               
                ResponseAPDU r = channel.transmit(new CommandAPDU(c1));
                System.out.print("response: " + r.toString());
                
                // Disconnect the card
                card.disconnect(false);
            } catch (Exception ex) {
               System.out.println(ex);
            }
        } else {
            System.out.println("No pcsc terminal found");
        }
    
    }
    
    public void showTerminals(){
            
        System.out.println("Terminal : "+factory);
        System.out.printf("%d card terminals\n", terminals.size());
    }
        
}
