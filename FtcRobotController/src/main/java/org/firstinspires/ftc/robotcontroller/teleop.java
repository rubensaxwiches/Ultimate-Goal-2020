package org.firstinspires.ftc.robotcontroller;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

//LinearOpMode
@TeleOp(name = "firstTeleOp")
public class teleop extends OpMode {
    //DcMotor etc
    DcMotor frontLeft, frontRight, backLeft, backRight;
    Servo servoMan;

    @Override
    public void init() {
    //Declaring Hardware
    //Motors - Order is extremely important
    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    frontRight = hardwareMap.dcMotor.get("frontRight");
    backLeft = hardwareMap.dcMotor.get("backLeft");
    backRight = hardwareMap.dcMotor.get("backRight");
    //Servos
    servoMan = hardwareMap.servo.get("servoMan");

    //Changes direction so all are positive when going forward
    frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
    //Real code

    //Controls the left side of the robot
    if (Math.abs(gamepad1.left_stick_y) > .1) {
        frontLeft.setPower(-gamepad1.left_stick_y); //It's negative because of the reverse values, take note
        backLeft.setPower(-gamepad1.left_stick_y);
    }
    else {
        frontLeft.setPower(0);
        backLeft.setPower(0);
    }
    if (Math.abs(gamepad1.right_stick_y) > .1) {
        frontRight.setPower(-gamepad1.right_stick_y);
        backRight.setPower(-gamepad1.right_stick_y);
    }
    else {
        frontLeft.setPower(0);
        backLeft.setPower(0);
    }
    if (gamepad1.left_bumper) {
        servoMan.setPosition(1);
    }
    if (gamepad1.right_bumper) {
        servoMan.setPosition(0);
    }

    }
}
