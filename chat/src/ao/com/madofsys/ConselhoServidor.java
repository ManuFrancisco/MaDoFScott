/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.com.madofsys;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Manuel Francisco
 */
public class ConselhoServidor {
    
    public static void main(String[]args)throws Exception{
	ServerSocket server = new ServerSocket(5000);
	while(true){
	    Socket socket = server.accept();
	    try (PrintWriter w = new PrintWriter(socket.getOutputStream())){
		w.println("Aprenda JAVA e seja contratado!");
	     
	    }
	}
    }
    
}
    
