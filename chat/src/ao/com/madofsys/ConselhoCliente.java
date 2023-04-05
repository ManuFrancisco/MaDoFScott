package ao.com.madofsys;

import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Manuel Francisco
 */
public class ConselhoCliente {
    
    public static void main(String[]args)throws Exception{
	
	Socket socket = new Socket("127.0.0.1", 5000);
	try (Scanner s = new Scanner(socket.getInputStream())) {
	    String msg = s.nextLine();
	    System.out.println("Mensagem: "+msg);
	}
	
    }
    
}
