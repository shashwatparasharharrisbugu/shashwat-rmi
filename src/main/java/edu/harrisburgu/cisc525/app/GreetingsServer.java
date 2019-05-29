package edu.harrisburgu.cisc525.app;

import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingsServer extends UnicastRemoteObject implements GreetingsInterface {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingsServer.class);
    private static final long serialVersionUID = 3471960281840894899L;

    public GreetingsServer() throws RemoteException {
        super();
        LOGGER.info("Constructing ...");
    }

    @Override
    public String hello(String name) throws RemoteException, UnknownHostException {
        String greetings = new Greetings().hello(name);
        LOGGER.info("Receiving call with name {}", name);
        LOGGER.info("Returning greetings with {}", greetings);
        return greetings;
    }

	@Override
	public Message hello(Message message) throws RemoteException, UnknownHostException {
		Message mess = new Message();
	    LOGGER.info("Receiving call with name {}", message.getName());
	    LOGGER.info("Returning greetings with {}", message.getMessage());
	    
	    // Setting the returning message with the object recieved as a parameter
		mess.setMessage(message.getMessage());
		mess.setName(message.getName());
		
		return mess;
	}
    
}