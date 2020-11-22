package org.firstinspires.ftc.robotcontroller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name ="firstAutonomous")
public class autonomous  extends LinearOpMode
{
    //Declare the Hardware
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    Servo servoMan;

    @Override
    public void runOpMode() throws InterruptedException {
        //Phone Configuration
            //Motors
            frontLeft = hardwareMap.dcMotor.get("frontLeft");
            frontRight = hardwareMap.dcMotor.get("frontRight");
            backLeft = hardwareMap.dcMotor.get("backLeft");
            backRight = hardwareMap.dcMotor.get("backRight");
            //Servos
            servoMan = hardwareMap.servo.get("servoMan");

    waitForStart();

    //Meat & Potatoes of Autonomous
        //Moving Forward
        frontLeft.setPower(-1);     //Left sides are naturally counterclockwise so it's negative
        frontRight.setPower(1);
        backLeft.setPower(-1);
        backRight.setPower(1);
        sleep(5000); //Performs the above commands for 5000 milliseconds (5 sec)

        //Moving Backwards
        frontLeft.setPower(.5);
        frontRight.setPower(-.5);
        backLeft.setPower(.5);
        backRight.setPower(-.5);
        sleep(3000);

        //Turning in place to the Right - All 4 will be negative to go counterclockwise
        frontLeft.setPower(-.5);
        frontRight.setPower(-.5);
        backLeft.setPower(-.5);
        backRight.setPower(-.5);
        sleep(3000);

        //Turning in place to the Left - All 4 must be positive to go clockwise
        frontLeft.setPower(.5);
        frontRight.setPower(.5);
        backLeft.setPower(.5);
        backRight.setPower(.5);
        sleep(3000);

        servoMan.setPosition(.5); //Range is 0-1
        sleep(1000);

    }
}
