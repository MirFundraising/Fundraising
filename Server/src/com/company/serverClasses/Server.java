package com.company.serverClasses;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

    private int port;
    private DatagramSocket socket;
    private Thread serverRun, manage, receive;
    private boolean runnig = false;

    public Server(int port) {
        this.port = port;
        try{
            socket = new DatagramSocket(port);
        }
        catch (SocketException se) {
            se.printStackTrace();
        }
        serverRun = new Thread(new Runnable() {
            @Override
            public void run() {
                runnig = true;
                System.out.println("Server started on port " + port);
                manage();
                receive();
            }
        }, "ServerRun");
        serverRun.start();
    }

    private void manage() {
        manage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (runnig) {
                    // TODO(company): manage the clients
                }
            }
        }, "manage");
        manage.start();
    }

    private void receive() {
        receive = new Thread(new Runnable() {
            @Override
            public void run() {
                while (runnig) {
                    byte[] data = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(data, data.length);
                    try {
                        socket.receive(packet);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    String str = new String(packet.getData());
                    System.out.println(str);
                }
            }
        }, "receive");
        receive.start();
    }

}
