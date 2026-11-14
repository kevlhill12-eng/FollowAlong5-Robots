package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 4–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and drives it until it is close to the wall.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "wall-ahead")
// Annotation configuring the MBotLab simulation environment with the "wall-ahead" world
public class FollowAlong {
// Declares the public class named FollowAlong

    public static void main(String[] args) {
        // Defines the standard main entry point method for application execution
        Rover scout = new Rover ("Scout");
        // Instantiates a new Rover object named "scout" with the identifier "Scout"
        System.out.println(scout + " is ready");
        // Prints the rover's string representation combined with readiness text to the console

        scout.driveUntilBlocked();
        // Invokes the driveUntilBlocked method on the scout object to move forward until an obstacle is detected
        System.out.println(scout + " stopped. Something is less than 20 cm ahead.");
        // Prints a message to the console indicating the rover has stopped because an obstacle is within 20 cm
    }
    // Ends the main method block
}
// Ends the FollowAlong class block
