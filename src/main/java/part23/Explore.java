package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 3, 5 and 6
//
// SECTION A — FOLLOW ALONG: type the main method from the guide in this class.
//    It makes a Scout and sends it through the junctions to the goal.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "junctions")
// Specifies the virtual robot lab environment and sets the world simulation to "junctions"
public class Explore {
    // Declares the public class named Explore
    public static void main(String[] args) {
        // Main method entry point where the program execution begins
        Scout scout = new Scout("Pathfinder");
        // Instantiates a new Scout object named "Pathfinder"
        for (int leg = 1; leg <= 3; leg++) {
            // Loops through 3 distinct navigation legs/segments
            int moves = scout.driveUntilBlocked();
            // Commands the scout to drive forward until blocked and stores the move count
            System.out.println("Leg " + leg + ": " + moves + " moves");
            // Prints the leg number and the number of moves taken
            if (leg < 3) {
                // Checks if the current leg is less than 3 (before the final leg)
                scout.turnTowardOpenSide();
                // Turns the scout toward the openest side detected by its scanner
            }
        }
        System.out.println(scout + " reached the goal");
        // Prints the scout's string representation followed by " reached the goal"
    }
}
