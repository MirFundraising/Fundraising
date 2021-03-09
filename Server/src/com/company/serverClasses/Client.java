package com.company.serverClasses;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client<Net> {
    private String name, address;
    private int port;
    private JTextField txtMessage;
    private JTextArea history;
    private boolean connected = false;
    private Net net = null;

}
