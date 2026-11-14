package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–9
//
// Part 22 — behaviors: methods that use the sensors to decide what the robot does.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part22;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

public class Rover {
    // Declares the public class named Rovers
    private String name;
    // Declares a private String instance variable to store the rover's name
    private Chassis base;
    // Declares a private Chassis instance variable representing the rover's drivetrain/base
    private Ultrasonic eyes;
    // Declares a private Ultrasonic instance variable representing the rover's distance sensor
    private LineSensor floor;
    // Declares a private LineSensor instance variable representing the rover's floor line sensor
    private boolean lineWasLeft;
    // Declares a private boolean instance variable to track whether the line was last detected on the left

    public Rover(String name){
        // Constructor taking a name parameter to initialize a new Rover instance
        this.name = name;
        // Assigns the constructor's name parameter to the class's name instance variable
        this.base = new Chassis();
        // Instantiates and assigns a new Chassis object to the base variable
        this.eyes = new Ultrasonic(base);
        // Instantiates and assigns a new Ultrasonic sensor connected to the base
        this.floor = new LineSensor(base);
        // Instantiates and assigns a new LineSensor object connected to the base

    }
    // Ends the Rover constructor block

    public String toString(){
        // Overrides the default toString method to provide a custom string representation
        return name + " the rover";
        // Returns the concatenated string combining the rover's name and label text
    }
    // Ends the toString method block

    public int driveUntilBlocked(double cm){
        // Defines a method that commands the rover to drive until blocked by an obstacle closer than the given threshold and returns the move count
        int moves = 0;
        // Declares and initializes an integer counter to keep track of movement steps
        while (eyes.distance() > cm){
            // Starts a while loop that continues as long as the obstacle distance is greater than the specified threshold
            base.straight(5);
            // Commands the chassis base to drive straight forward by 5 units
            moves++;
            // Increments the move counter by 1 for each step taken
        }
        // Ends the while loop block
        return moves++;
        // Returns the move count (using post-increment, returning current value before incrementing)
    }
    // Ends the driveUntilBlocked method block

    public void goAroundLeft(double sideways){
        // Defines a method to maneuver the rover around an obstacle by turning left, moving sideways, and turning right
        base.turnLeft(90);
        // Commands the chassis base to turn left by 90 degrees
        base.straight(sideways);
        // Commands the chassis base to drive straight forward by the specified sideways distance
        base.turnRight(90);
        // Commands the chassis base to turn right by 90 degrees
    }
    // Ends the goAroundLeft method block

    public void reachGoal(){
        // Defines a method to navigate the rover to its goal by driving, avoiding obstacles, and maneuvering
        int first = driveUntilBlocked(15);
        // Calls driveUntilBlocked with a 15 cm threshold and stores the returned move count in 'first'
        System.out.println("Blocked after " + first + " moves. Going round.");
        // Prints a status message showing the number of moves before being blocked and indicating it will go around
        goAroundLeft(60);
        // Invokes goAroundLeft to navigate past the obstacle with a distance of 60 units
        int second = driveUntilBlocked(15);
        // Calls driveUntilBlocked again with a 15 cm threshold and stores the result in 'second'
        System.out.println("Blocked after " + second + " moves. That is the far wall.");
        // Prints a message indicating the second block count and identifying it as the far wall
        base.turnRight(90);
        // Commands the chassis base to turn right by 90 degrees
        base.straight(50);
        // Commands the chassis base to drive straight forward by 50 units

    }
    // Ends the reachGoal method block

    public void followLine(int steps) {
        // Defines a method for line-following behavior over a specified number of steps
        for (int i = 0; i < steps; i++) {
            // Starts a for loop that repeats for the specified number of steps
            int s = floor.status();
            // Reads the status integer from the floor line sensor and stores it in 's'
            if (s == 4 || s == 8 || s == 12) {
                // Checks if the sensor status matches specific bitmask values indicating the line is to the left
                base.turnLeft(4);
                // Commands the chassis to turn left slightly by 4 degrees
                lineWasLeft = true;
                // Sets the tracking boolean to true indicating the line was last seen on the left
            } else if (s == 1 || s == 2 || s == 3) {
                // Checks if the sensor status matches values indicating the line is to the right
                base.turnRight(4);
                // Commands the chassis to turn right slightly by 4 degrees
                lineWasLeft = false;
                // Sets the tracking boolean to false indicating the line was last seen on the right
            } else if (s == 0) {
                // Checks if the sensor status is 0 (line lost)
                if (lineWasLeft) {
                    // Evaluates whether the line was previously tracked on the left side
                    base.turnLeft(4);
                    // Turns left by 4 degrees to search for the line on the left side
                } else {
                    // Otherwise, if the line was tracked on the right side
                    base.turnRight(4);
                    // Turns right by 4 degrees to search for the line on the right side
                }
                // Ends the inner conditional block for lost line search
            } else {
                // Catches any other sensor status condition
                base.straight(1);
                // Commands the chassis to drive straight forward by 1 unit
            }
            // Ends the outer conditional block for line sensor status checking
        }
        // Ends the for loop block
    }
    // Ends the followLine method block
}
// Ends the Rover class block

