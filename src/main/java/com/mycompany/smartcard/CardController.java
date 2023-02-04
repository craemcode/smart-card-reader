/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smartcard;

//imports
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
    
    //class variables. all are private since. i would have made the class final
    private List<CardTerminal> terminals;
    private TerminalFactory factory;
    private Card card;
    
    //the constructor prepares the card terminals for use
    public CardController(){

        factory = TerminalFactory.getDefault();
        try {
            terminals = factory.terminals().list();
        } catch (CardException ex1) {
            System.out.println(ex1);
        }

    }
    
    // this function establishes connection to the smart card
    // a future implementation can accept an index value for a specific terminal
    //for now we use 0 since we have only one terminal 
    public void connectToCard(){
        
        if (terminals != null && !terminals.isEmpty()) {
            
                // Use the first terminal
                CardTerminal terminal = terminals.get(0);
                try{
                    // Connect with the card
                    card = terminal.connect("T=0");
                    System.out.println("Card Successfully connected \n card: " + card);
                
               
                    
                
                }catch(CardException ce){
                    System.out.println(ce);
                }
                
        } else {
            System.out.println("No pcsc terminal found");
        }
        
    }
    
    //send APDU commands. the method accept an array of APDU bytes and prints the result
    public void sendAPDU(byte [] c1){
        //establish a communication channel
        try{
        CardChannel channel = card.getBasicChannel();
                                
        //send the APDU command and display the response.
               
        ResponseAPDU r = channel.transmit(new CommandAPDU(c1));
        System.out.println("response: " + r.toString());
        
        disconnectCard();
        
         }catch(CardException ce2){
             System.out.println(ce2);
         
         }catch(Exception npe){
             System.out.println("Please check card connection");
         }
    
    
    }
    // disconnect the card. use this after every operation. should be private
    private void disconnectCard() throws CardException{
        // Disconnect
        
        card.disconnect(false);
        System.out.println("Card Disconnected");
    }
    
    public void showTerminals(){
            
        System.out.println("Terminal : "+factory);
        System.out.printf("%d card terminals\n", terminals.size());
    }
        
}
