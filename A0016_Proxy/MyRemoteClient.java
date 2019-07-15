package com.mylearning.designpatterns.A0016_Proxy;

import java.rmi.Naming;

public class MyRemoteClient {
 public static void main(String [] args) {
   try
   {
	final MyRemote service = (MyRemote) Naming.lookup("rmi://cocreate-f18043/RemoteHello");
	 final int sum = service.sum(10,20);
	 System.out.println("Sum(using RMI):"+sum);
	} catch(final Exception e) {
	  e.printStackTrace();
  }
  }
 }