package com.mylearning.designpatterns.A0019_Command;

class Switch {

    private final Command flipUpCommand;
    private final Command flipDownCommand;

    public Switch(Command flipUpCmd, Command flipDownCmd) {
         this.flipUpCommand = flipUpCmd;
         this.flipDownCommand = flipDownCmd;
    }

    public void flipUp() {
         flipUpCommand.execute();
    }

    public void flipDown() {
         flipDownCommand.execute();
    }
}

/*Receiver class*/
 class Light {

     public Light() {  }

     public void turnOn() {
        System.out.println("The light is on");
     }

     public void turnOff() {
        System.out.println("The light is off");
     }
}

/*the Command interface*/
 interface Command {
    void execute();
}

/*the Command for turning on the light*/
 class FlipUpCommand implements Command {

   private final Light theLight;

   public FlipUpCommand(Light light) {
        this.theLight=light;
   }

   public void execute(){
      theLight.turnOn();
   }
}

/*the Command for turning off the light*/
class FlipDownCommand implements Command {

   private final Light theLight;

   public FlipDownCommand(Light light) {
        this.theLight=light;
   }

   public void execute() {
      theLight.turnOff();
   }
}

/*The test class or client*/
public class PressSwitch {

   public static void main(String[] args) {
       final Light lamp = new Light();
       final Command switchUp = new FlipUpCommand(lamp);
       final Command switchDown = new FlipDownCommand(lamp);

       // See criticism of this model above:
       // The switch itself should not be aware of an lamp details (switchUp, switchDown) either directly or indirectly
       final Switch s = new Switch(switchUp,switchDown);

       try {
           if (args[0].equalsIgnoreCase("ON")) {
                s.flipUp();
           } else if (args[0].equalsIgnoreCase("OFF")) {
               s.flipDown();
           } else {
               System.out.println("Argument \"ON\" or \"OFF\" is required.");
           }
       } catch (final Exception e){
           System.out.println("Arguments required.");
       }
   }
}