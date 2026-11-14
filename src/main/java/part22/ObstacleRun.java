package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3–6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Rover and sends it round the box to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "obstacles")
// Annotation configuring the MBotLab simulation environment with the "obstacles" world
public class ObstacleRun {
// Declares the public class named ObstacleRun

    public static void main(String[] args) {
        // Defines the standards main entry point method for application execution

        Rover rover = new Rover("Dash");
        // Instantiates a new Rover object named "rover" with the identifier "Dash"
        rover.reachGoal();
        // Invokes the reachGoal method on the rover object to navigate through obstacles to the destination
        System.out.println(rover + " reached the goal");
        // Prints the rover's string representation combined with completion text to the console

    }
    // Ends the main method block

}
// Ends the ObstacleRun class block
