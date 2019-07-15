package com.mylearning.designpatterns.A0016_Proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface MyRemote extends Remote {
  public int sum(int i, int j) throws RemoteException;
 }
