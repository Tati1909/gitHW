package Lesson6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String ... args) {
        startTextServer();
    }

    private static void startTextServer() {
        try(ServerSocket serverSocket = new ServerSocket(8180)){
            System.out.println("Server is listening");
            try(Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream())
            ){
                System.out.println("Client is connected");
                System.out.println("****************************");
                out.println("Hello client");
                out.flush();

                String myMessage = "";
                Thread serverReader = new Thread(() -> {
                    String clientMessage = "";
                    try {
                        while (!clientMessage.equalsIgnoreCase("stop")) {
                            clientMessage = in.readLine();
                            out.flush();
                            System.out.println("Client: " + clientMessage);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                serverReader.start();


                String clientMessage = "";
                Scanner serverMessage = new Scanner(System.in);

                    do{
                        myMessage = serverMessage.nextLine();
                        out.println("Server: " + myMessage);
                        out.flush();

                    }while(!clientMessage.equalsIgnoreCase("stop"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
