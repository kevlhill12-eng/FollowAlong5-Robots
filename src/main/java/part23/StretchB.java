package part23;
import mbot.*;

public class StretchB{

}

class Painter extends MBot2 {
    private ColorSensor eye;

    Painter() {
        super();
        eye = new ColorSensor(this);
    }

    void showColor() {
        String c = eye.color();
        if (c.equals("red")) {
            turnLedOn(1, 255, 0, 0);
        } else if (c.equals("green")) {
            turnLedOn(1, 0, 255, 0);
        } else if (c.equals("blue")) {
            turnLedOn(1, 0, 0, 255);
        } else if (c.equals("yellow")) {
            turnLedOn(1, 255, 200, 0);
        } else {
            turnLedOff(1);
        }
    }

    void driveToRed() {
        String last = "";
        while (!eye.color().equals("red")) {
            String c = eye.color();
            if (!c.equals(last)) {
                System.out.println("Now on " + c);
                last = c;
            }
            showColor();
            straight(5);
        }
        showColor();
        System.out.println("Stopped on red");
    }
}