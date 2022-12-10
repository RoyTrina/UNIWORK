package Assignment2019;

//Date of backup: 14/12/2019
public class Vehicle {
    //Fields
    public String type;
    public double speed;

    //Constructors
    public Vehicle() {
        this.type = "bicycle";
        this.speed = 20.0;
    }

    public Vehicle(String type, double speed) {
        this.type = type;
        this.speed = speed;
    }

    //Methods
    public void setType(String type) {
        this.type = type;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void speedUp() {
        this.speed = speed * 2;
    }

    public void speedDown() {
        this.speed = speed / 2;
    }
}
