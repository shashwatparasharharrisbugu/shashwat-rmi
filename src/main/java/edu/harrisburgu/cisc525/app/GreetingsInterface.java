package edu.harrisburgu.cisc525.app;

import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GreetingsInterface extends Remote {
    public String hello(String name) throws RemoteException, UnknownHostException;
}