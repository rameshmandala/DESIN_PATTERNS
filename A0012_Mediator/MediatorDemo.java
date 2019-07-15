package com.mylearning.designpatterns.A0012_Mediator;

// 1. The "intermediary"
class Mediator {
  // 4. The Mediator arbitrates
  private boolean slotFull = false;
  private int number;
  public synchronized void storeMessage( int num ) {
    // no room for another message
    while (slotFull == true) {
      try {
        wait();
      }
      catch (final InterruptedException e ) { }
    }
    slotFull = true;
    number = num;
    notifyAll();
  }
  public synchronized int retrieveMessage() {
    // no message to retrieve
    while (slotFull == false)
    {
        try {
            wait();
          }
          catch (final InterruptedException e ) { }
    }
    slotFull = false;
    notifyAll();
    return number;
  }
}

class Producer extends Thread {
  // 2. Producers are coupled only to the Mediator
  private final Mediator med;
  private final int    id;
  private static int num = 1;
  public Producer( Mediator m ) {
    med = m;
    id = num++;
  }
  @Override
public void run() {
    int num;
    while (true) {
      med.storeMessage( num = (int)(Math.random()*100) );
      System.out.print( "p" + id + "-" + num + "  " );
    }
  }
}

class Consumer extends Thread {
  // 3. Consumers are coupled only to the Mediator
  private final Mediator med;
  private final int    id;
  private static int num = 1;
  public Consumer( Mediator m ) {
    med = m;
    id = num++;
  }
  @Override
public void run() {
    while (true) {
      System.out.print("c" + id + "-" + med.retrieveMessage() + "  ");
    }
  }
}

class MediatorDemo {
  public static void main( String[] args ) {
    final Mediator mb = new Mediator();
    new Producer( mb ).start();
    new Producer( mb ).start();
    new Consumer( mb ).start();
    new Consumer( mb ).start();
    new Consumer( mb ).start();
    new Consumer( mb ).start();
  }
}
