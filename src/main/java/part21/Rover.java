package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 2–8
//
// Part 21 — composition: a Rover HAS-A Chassis and HAS-AN Ultrasonic.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part21;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
//
// SECTION C — STRETCH B adds a LineSensor and two methods to this class.
@MBotLab(world = "wall-ahead")
// Annotation configuring the MBotLab simulation environment with the "wall-ahead" world
public class Rover {
// Declares the public class named Rover

    private String name;
    // Declares a private String instance variable to store the rover's name
    private Chassis base;
    // Declares a private Chassis instance variable representing the rover's drivetrain/base
    private Ultrasonic eyes;
    // Declares a private Ultrasonic instance variable representing the rover's distance sensor

    public Rover(String name){
        // Constructor taking a name parameter to initialize a new Rover instance
        this.name = name;
        // Assigns the constructor's name parameter to the class's name instance variable
        this.base = new Chassis();
        // Instantiates and assigns a new Chassis object to the base variable
        this.eyes = new Ultrasonic(base);
        // Instantiates and assigns a new Ultrasonic sensor connected to the base
    }
    // Ends the Rover constructor block

    public String toString(){
        // Overrides the default toString method to provide a custom string representation
        return name + " the rover";
        // Returns the concatenated string combining the rover's name and label text
    }
    // Ends the toString method block

    public boolean somethingAhead(double cm){
        // Defines a method to check if an object is within a specified distance threshold in centimeters
        return eyes.distance() < cm;
        // Evaluates and returns true if the sensor distance reading is less than the given threshold
    }
    // Ends the somethingAhead method block

    public void driveUntilBlocked(){
        // Defines a method to command the rover to move forward continuously until an obstacle is detected
        while(!somethingAhead(20)){
            // Starts a while loop that executes as long as there is no object closer than 20 cm
            base.straight(5);
            // Commands the chassis base to drive straight forward by 5 units
        }
        // Ends the while loop block
    }
    // Ends the driveUntilBlocked method block

    public static void main(String[] args) {
        // Defines the standard main entry point method for application execution
    }
    // Ends the main method block
}
// Ends the Rover class block
