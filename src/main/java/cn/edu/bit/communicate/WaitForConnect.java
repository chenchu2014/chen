package cn.edu.bit.communicate;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chu on 2015/5/28.
 */

public class WaitForConnect implements Runnable {

    private String host;

    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public WaitForConnect(String host, int port) {
        this.port = port;
        this.host = host;
        new Thread(this).start();
    }

    public void run() {

        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

        while (!Thread.interrupted()) {
            try {
                Socket accept = serverSocket.accept();
                CommService commService = new CommService(accept);
                commService.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
