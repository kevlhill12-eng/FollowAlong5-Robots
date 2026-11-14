package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–3 and 6
//
// Part 24 — overriding: your robot keeps a method's name, but changes what it does.
//
// SECTION A — FOLLOW ALONG: type the CarefulBot class from the guide.
//    Leave the "package part24;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
public class CarefulBot extends MBot2 {
    // Declares the CarefulBot public class which inherits from the MBot2 base robot class
    public CarefulBot() {
// Defines the constructor method for instantiating CarefulBot objects
        super();
// Calls the parent class MBot2 constructor to initialize inherited properties
    }
    // Ends the constructor scope
    @Override
// Indicates that this method overrides a method defined in the parent class MBot2
    public void straight(double cm) {
// Overrides the straight movement method, accepting a distance in centimeters
        if (readUltrasonic() > cm + 20) {
// Checks if the distance measured by the ultrasonic sensor is greater than the target distance plus 20cm
            super.straight(cm);
// Calls the parent class straight method to drive the robot forward by the specified distance
        } else {
// Executes if the obstacle is too close (sensor reading is less than or equal to cm + 20)
            turnLedOn(1, 255, 0, 0);
// Turns on LED 1 with red color (RGB: 255, 0, 0) to signal a warning state
            System.out.println("CarefulBot: not driving " + cm + " cm, too close");
// Prints a warning message to the console indicating the robot refused to move due to proximity
        }
// Ends the conditional block
    }
// Ends the straight method scope

    @Override
// Indicates that this method overrides the run method defined in the parent class
    public void run() {
// Overrides the run method which defines the robot's main execution routine
        for (int i = 0; i < 5; i++) {
// Initializes a loop that runs 5 times to execute movement steps iteratively
            straight(40);
// Calls the overridden straight method to attempt driving forward 40 cm in each iteration
        }
// Ends the loop scope
    }
// Ends the run method scope
}
// Ends the CarefulBot class scope
