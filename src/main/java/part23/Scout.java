package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–5
//
// Part 23 — inheritance: your own robot class, built on top of MBot2.
//
// SECTION A — FOLLOW ALONG: type the Scout class from the guide.
//    Step 1 changes the class line below: that is the one line you DO change.
//    Leave the "package part23;" line and the "import mbot.*;" line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

public class Scout extends MBot2 {
    // Declares the public class 'Scout' that inherits from 'MBot2'
    private String name;
    // Declares a private String variable 'name' to store the scout's identifier
    private Scanner scanner;
    // Declares a private Scanner object 'scanner' for environmental scanning

    public Scout(String name) {
        // Constructor for the Scout class taking a name parameter
        super();
        // Calls the constructor of the parent class (MBot2)
        this.name = name;
        // Assigns the constructor parameter to the instance variable 'name'
        this.scanner = new Scanner(this);
        // Initializes the scanner object, passing the current Scout instance
    }
    public String toString() {
        // Overrides the toString method to provide a custom string representation
        return name + " the scout";
        // Returns the scout's name followed by " the scout"
    }
    public int driveUntilBlocked() {
        // Declares a method that drives the robot forward until blocked and returns move count
        int moves = 0;
        // Initializes a counter variable 'moves' to zero
        while (readUltrasonic() > 25) {
            // Loops as long as the ultrasonic sensor reading is greater than 25 cm
            straight(5);
            // Commands the robot to drive straight forward by 5 units
            moves++;
            // Increments the move counter by 1
        }
        return moves;
        // Returns the total number of moves made
    }
    public int openestIndex() {
        // Declares a method that scans surroundings and returns the index of the clearest direction
        double[] d = scanner.scan();
        // Calls the scan method and stores the distance array in 'd'
        int best = 0;
        // Initializes the tracker for the best index to 0
        for (int i = 1; i < d.length; i++) {
            // Loops through the array elements starting from index 1
            if (d[i] > d[best]) {
                // Checks if the current reading is greater than the best recorded reading
                best = i;
                // Updates 'best' to the current index
            }
        }
        return best;
        // Returns the index of the openest direction
    }
    public void turnTowardOpenSide() {
        // Declares a method to turn the robot toward the openest side detected
        int i = openestIndex();
        // Retrieves the index of the openest direction
        if (Scanner.ANGLES[i] > 0) {
            // Checks if the angle at index 'i' is greater than 0 (left side)
            turnLeft(90);
            // Turns the robot 90 degrees to the left
        } else {
            // Executes if the angle is less than or equal to 0 (right side)
            turnRight(90);
            // Turns the robot 90 degrees to the right
        }
    }

}