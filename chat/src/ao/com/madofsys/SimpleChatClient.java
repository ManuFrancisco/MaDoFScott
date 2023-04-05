/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.com.madofsys;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Manuel Francisco
 */
public class SimpleChatClient {

    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
	SimpleChatClient client = new SimpleChatClient();
	client.go();
    }

    public void go() {
	JFrame frame = new JFrame("Ludiciously Simple chat client");
	JPanel mainPanel = new JPanel();
	incoming = new JTextArea(15, 50);
	incoming.setLineWrap(true);
	incoming.setWrapStyleWord(true);
	incoming.setEditable(false);

	JScrollPane qScroller = new JScrollPane(incoming);
	qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	outgoing = new JTextField(20);
	JButton sendButton = new JButton("Send");
	sendButton.addActionListener(new SendButtonListener());
	mainPanel.add(qScroller);
	mainPanel.add(outgoing);
	mainPanel.add(sendButton);
	setUpNetworking();
	Thread readerThread = new Thread(new IncomingReader());
	readerThread.start();
	frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
	frame.setSize(400, 500);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private void setUpNetworking() {
	try {
	    socket = new Socket("127.0.0.1", 5000);
	    InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
	    reader = new BufferedReader(streamReader);
	    writer = new PrintWriter(socket.getOutputStream());
	    System.err.println("Networking established");
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    @SuppressWarnings("PublicInnerClass")
    public class SendButtonListener implements ActionListener {

	@Override
	@SuppressWarnings("CallToPrintStackTrace")
	public void actionPerformed(ActionEvent ev) {
	    try {
		writer.println(outgoing.getText());
		writer.flush();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    outgoing.setText("");
	    outgoing.requestFocus();
	}
    }

    @SuppressWarnings("PublicInnerClass")
    public class IncomingReader implements Runnable {

	@Override
	@SuppressWarnings({"NestedAssignment", "CallToPrintStackTrace"})
	public void run() {
	    String message;
	    try {
		while ((message = reader.readLine()) != null) {
		    System.out.println("read " + message);
		    incoming.append(message + "\n");
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

}
