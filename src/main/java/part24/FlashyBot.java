package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4 and 6
//
// SECTION A — FOLLOW ALONG: type the FlashyBot class from the guide.
//    Leave the package, import and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

public class FlashyBot extends MBot2 {
    // Declares the FlashyBot public class which inherits from the MBot2 base robot class
    public FlashyBot() {
// Defines the constructor method for instantiating FlashyBot objects
        super();
// Calls the parent class MBot2 constructor to initialize inherited properties
    }
// Ends the constructor scope

    @Override
// Indicates that this method overrides a method defined in the parent class MBot2
    public void turnLeft(double degrees) {
// Overrides the turnLeft movement method, accepting degrees to turn
        System.out.println("Flash! Turning left " + degrees);
// Prints a message to the console indicating the left turn action with the specified degrees
        turnLedOn(1, 0, 0, 255);
// Turns on LED 1 with blue color (RGB: 0, 0, 255) to flash during the turn
        super.turnLeft(degrees);
// Calls the parent class turnLeft method to actually execute the turn by the specified degrees
        turnLedOff(1);
// Turns off LED 1 after the turn is complete
    }
// Ends the turnLeft method scope

    @Override
// Indicates that this method overrides the turnRight method defined in the parent class
    public void turnRight(double degrees) {
// Overrides the turnRight movement method, accepting degrees to turn
        System.out.println("Flash! Turning right " + degrees);
// Prints a message to the console indicating the right turn action with the specified degrees
        turnLedOn(1, 0, 255, 0);
// Turns on LED 1 with green color (RGB: 0, 255, 0) to flash during the turn
        super.turnRight(degrees);
// Calls the parent class turnRight method to actually execute the turn by the specified degrees
        turnLedOff(1);
// Turns off LED 1 after the turn is complete
    }
// Ends the turnRight method scope

    @Override
// Indicates that this method overrides the run method defined in the parent class
    public void run() {
// Overrides the run method which defines the robot's main execution routine
        for (int i = 0; i < 4; i++) {
// Initializes a loop that runs 4 times to trace a square path or execute 4 movement cycles
            straight(40);
// Calls the straight method to drive the robot forward by 40 cm
            turnLeft(90);
// Calls the overridden turnLeft method to turn the robot 90 degrees to the left
        }
// Ends the loop scope
    }
// Ends the run method scope
}
// Ends the FlashyBot class scope
