/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.smartcard;

//import java.util.List;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 *
 * @author USER
 */
public class SmartCard implements ActionListener {
    
    //declare all the components we will need
    JFrame frame;
    JTextField textfield;
    JTextArea textarea;
    JButton sendcommand;
    JButton retry;
    JButton clear;
    JLabel arealabel;
    JLabel commandlabel;
    JPanel bpanel;
    
    Font consolefont = new Font("Courier",Font.PLAIN,15);
    Font commandfont = new Font("Ink Free", Font.BOLD, 20);
    
    
    //constructor for this class
    public SmartCard(){
        //frame
        frame = new JFrame("CardInterface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,600);
        frame.setResizable(false);
        frame.setLayout(null);
        
        //console text area
        textarea = new JTextArea();
        textarea.setBounds(50, 50, 450, 300);
        textarea.setFont(consolefont);
        textarea.setEditable(false);
        
        //command textfield
        textfield = new JTextField();
        textfield.setBounds(50,450,450,50);
        textfield.setFont(commandfont);
        
        //labels
        arealabel = new JLabel("Output Console");
        arealabel.setBounds(50, 20, 100, 20);
        
        commandlabel = new JLabel("Input Command");
        commandlabel.setBounds(50, 430, 100, 20);
        
        //buttons
        sendcommand = new JButton("send Command");
        sendcommand.setBounds(500, 450, 150, 25);
        sendcommand.addActionListener(this);
        sendcommand.setFocusable(false);
        
        
        retry = new JButton("Connect to Card");
        retry.addActionListener(this);
        retry.setFocusable(false);
        
        
        clear = new JButton("Clear Console");
        clear.addActionListener(this);
        clear.setFocusable(false);
        
        
        //panel for buttons
        bpanel = new JPanel();
        bpanel.setBounds(500,100,200,100);
        bpanel.setLayout(new GridLayout(2,1,10,50));
        
        
        //add buttons to panel
        bpanel.add(retry);
        bpanel.add(clear);
        
        //add components to the frame
        frame.add(bpanel);
        frame.add(arealabel);
        frame.add(textarea);
        frame.add(textfield);
        frame.add(sendcommand);
        frame.add(commandlabel);
        
        //make frame visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
    }

    public static void main(String[] args) {
        /*
        CardController contr = new CardController();
        
        contr.showTerminals();
        contr.connectToCard();
                        //CLA       INS             P1          P2          LC
        byte[] c1 = {(byte) 0x80, (byte) 0xCA, (byte) 0x00, (byte)0x5A, (byte) 0x00};
        
        contr.sendAPDU(c1);
        */
        SmartCard sc = new SmartCard();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //to add implementation
    
    }
}
