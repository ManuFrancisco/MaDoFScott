/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.com.madofsys;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Manuel Francisco
 */
public class SimpleChatServer {
    ArrayList clientOutputStreams;
    
    public class ClientHandler implements Runnable{
	BufferedReader reader;
	Socket socket;
	@SuppressWarnings("CallToPrintStackTrace")
	ClientHandler(Socket clientSocket){
	    try {
		socket = clientSocket;
		InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
		reader = new BufferedReader(isReader);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	@SuppressWarnings("CallToPrintStackTrace")
	@Override
	public void run(){
	    String message;
	    try {
		while((message = reader.readLine())!=null){
		    System.out.println("/*ao.com.madofsys.SimpleChatServer.ClientHandler.run()*/read "+message);
		    tellEveryone(message);
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	@SuppressWarnings("unchecked")
	public void go() throws IOException{
	    clientOutputStreams = new ArrayList();
	    ServerSocket serverSocket = new ServerSocket(5000);
	    while(true){
		Socket clientSocket = serverSocket.accept();
		PrintWriter writer = new PrintWriter(
		clientSocket.getOutputStream());
		clientOutputStreams.add(writer);
		Thread t = new Thread(new ClientHandler(clientSocket));
		t.start();
		System.out.println("got a connection");
	    }
	}
	@SuppressWarnings("CallToPrintStackTrace")
	public void tellEveryone(String message){
	    Iterator it = clientOutputStreams.iterator();
	    while(it.hasNext()){
		try {
		 PrintWriter writer = (PrintWriter)it.next();
		 writer.println(message);
		 writer.flush();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	}
    }
}
