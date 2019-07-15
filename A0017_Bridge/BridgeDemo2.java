package com.mylearning.designpatterns.A0017_Bridge;

/* abstraction */
abstract class Soda {
   SodaImp sodaImp;

   public void setSodaImp() {
       this.sodaImp = SodaImpSingleton.getTheSodaImp();
   }
   public SodaImp getSodaImp() {
       return this.sodaImp;
   }

   public abstract void pourSoda();
}

/* RefinedAbstraction */
 class MediumSoda extends Soda {
   public MediumSoda() {
       setSodaImp();
   }

   @Override
public void pourSoda() {
       final SodaImp sodaImp = this.getSodaImp();
       for (int i = 0; i < 2; i++) {
           System.out.print("...glug...");
           sodaImp.pourSodaImp();
       }
       System.out.println(" ");
   }
}

class SuperSizeSoda extends Soda {
   public SuperSizeSoda() {
       setSodaImp();
   }

   @Override
public void pourSoda() {
       final SodaImp sodaImp = this.getSodaImp();
       for (int i = 0; i < 5; i++) {
           System.out.print("...glug...");
           sodaImp.pourSodaImp();
       }
       System.out.println(" ");
   }
}

/* Implementation */
 abstract class SodaImp {
   public abstract void pourSodaImp();
}

class CherrySodaImp extends SodaImp {
   CherrySodaImp() {}

   @Override
public void pourSodaImp() {
       System.out.println("Yummy Cherry Soda!");
   }
}

class GrapeSodaImp extends SodaImp {
   GrapeSodaImp() {}

   @Override
public void pourSodaImp() {
       System.out.println("Delicious Grape Soda!");
   }
}

class OrangeSodaImp extends SodaImp {
   OrangeSodaImp() {}

   @Override
public void pourSodaImp() {
       System.out.println("Citrusy Orange Soda!");
   }
}

class SodaImpSingleton {
    private static SodaImp sodaImp;

    public SodaImpSingleton(SodaImp sodaImpIn) {
        SodaImpSingleton.sodaImp = sodaImpIn;
    }

    public static SodaImp getTheSodaImp() {
        return sodaImp;
    }
}





public class BridgeDemo {
   public static void testCherryPlatform() {
       final SodaImpSingleton sodaImpSingleton =
         new SodaImpSingleton(new CherrySodaImp());
       System.out.println(
         "testing medium soda on the cherry platform");
       final MediumSoda mediumSoda = new MediumSoda();
       mediumSoda.pourSoda();
       System.out.println(
         "testing super size soda on the cherry platform");
       final SuperSizeSoda superSizeSoda = new SuperSizeSoda();
       superSizeSoda.pourSoda();
   }

   public static void testGrapePlatform() {
       final SodaImpSingleton sodaImpSingleton =
         new SodaImpSingleton(new GrapeSodaImp());
       System.out.println(
         "testing medium soda on the grape platform");
       final MediumSoda mediumSoda = new MediumSoda();
       mediumSoda.pourSoda();
       System.out.println(
         "testing super size soda on the grape platform");
       final SuperSizeSoda superSizeSoda = new SuperSizeSoda();
       superSizeSoda.pourSoda();
   }

   public static void testOrangePlatform() {
       final SodaImpSingleton sodaImpSingleton =
         new SodaImpSingleton(new OrangeSodaImp());
       System.out.println(
         "testing medium soda on the orange platform");
       final MediumSoda mediumSoda = new MediumSoda();
       mediumSoda.pourSoda();
       System.out.println(
         "testing super size soda on the orange platform");
       final SuperSizeSoda superSizeSoda = new SuperSizeSoda();
       superSizeSoda.pourSoda();
   }

   public static void main(String[] args) {
        testCherryPlatform();
        testGrapePlatform();
        testOrangePlatform();
   }
}
