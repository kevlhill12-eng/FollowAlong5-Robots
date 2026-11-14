package part24;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 2, 5 and 7
//
// SECTION A — FOLLOW ALONG: type the mission method and the main method from the guide.
//    Leave the package, import, @MBotLab and class lines alone. Type everything else.
//
// SECTION B — COMMENTS: put a // comment ABOVE every line of code, in YOUR OWN WORDS.

@MBotLab(world = "wall-ahead")
// Specifies the virtual world environment configuration for the lab simulation
public class Mission {
    // Declares the main public container class for the program execution
    public static void mission(MBot2 bot) {
// Defines a static helper method to control the robot's execution flow
        System.out.println("Mission start");
// Outputs the starting message to the standard console output
        bot.run();
// Executes the primary movement or behavior routine of the robot instance
        System.out.println("Mission done");
// Outputs the completion message to the standard console output
    }
// Ends the scope of the mission method

    public static void main(String[] args) {
// Defines the standard Java entry point method accepting command-line arguments
        int pick = 3;
// Initializes the selection variable used to determine which robot type to instantiate
        MBot2 bot;
// Declares a variable to hold the reference to the chosen robot instance
        if (pick == 1) {
// Evaluates whether the selection variable equals 1
            bot = new CarefulBot();
// Assigns a newly instantiated CarefulBot object to the bot reference
        } else if (pick == 2) {
// Evaluates whether the selection variable equals 2 if the first condition failed
            bot = new FlashyBot();
// Assigns a newly instantiated FlashyBot object to the bot reference
        } else {
// Handles all other cases where pick is neither 1 nor 2
            bot = new MBot2();
// Assigns a newly instantiated standard MBot2 object to the bot reference as the default
        }
// Ends the conditional control flow block
        mission(bot);
// Invokes the mission method, passing the instantiated robot object as an argument
    }
// Ends the scope of the main method
}
// Ends the scope of the Mission class
