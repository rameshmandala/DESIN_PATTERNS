package com.mylearning.designpatterns.A0016_Proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

public int sum(int i,int j) {
	return i+j;
}
 public MyRemoteImpl() throws RemoteException{}

public static void main(String[] args) {
  try
     {
	   final MyRemote service = new MyRemoteImpl();
	   Naming.rebind("RemoteHello",service);
	 }catch(final Exception ex)
    {
		ex.printStackTrace();
	}
 }
}