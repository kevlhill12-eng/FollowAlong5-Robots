package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 7–9
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and follows the loop of tape all the way round.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "line-track")
// Annotation configuring the MBotLab simulation environment with the "line-track" world
public class LineRun {
// Declares the public class named LineRun

    public static void main(String[] args) {
        // Defines thes standard main entry point method for application execution
        Rover rover = new Rover("Tracker");
        // Instantiates a new Rover object named "rover" with the identifier "Tracker"
        rover.followLine(400);
        // Invokes the followLine method on the rover object with a parameter of 400
        System.out.println("Halfway round");
        // Prints a message to the console indicating the rover is halfway round
        rover.followLine(325);
        // Invokes the followLine method on the rover object with a parameter of 325
        System.out.println(rover + " finished a lap");
        // Prints a message to the console indicating the rover finished a lap
    }
    // Ends the main method block
}
// Ends the LineRun class block