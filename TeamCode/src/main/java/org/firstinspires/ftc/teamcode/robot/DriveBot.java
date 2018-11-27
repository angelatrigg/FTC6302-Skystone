package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * This class provides as the framework for the robot which can be used for any purposes
 */
public class DriveBot implements Bot {

    protected HardwareMap hwMap;
    protected Telemetry telemetry;

    // Drive motors
    protected DcMotor motorDriveLeftFront;
    protected DcMotor motorDriveLeftRear;
    protected DcMotor motorDriveRightFront;
    protected DcMotor motorDriveRightRear;

    protected Lift lift;
    protected Sweeper sweeper;
    protected Pusher pusher;
    protected Dumper dumper;

    public void init(HardwareMap ahwMap, Telemetry atelemetry) {
        hwMap = ahwMap;
        telemetry = atelemetry;

        lift = new Lift();
        sweeper = new Sweeper();
        pusher = new Pusher();
        dumper = new Dumper();

        // Get hardware references from the robot controller's configuration for hardware devices
        motorDriveLeftFront  = hwMap.get(DcMotor.class, "motor_drive_lf");
        motorDriveLeftRear   = hwMap.get(DcMotor.class, "motor_drive_lr");
        motorDriveRightFront = hwMap.get(DcMotor.class, "motor_drive_rf");
        motorDriveRightRear  = hwMap.get(DcMotor.class, "motor_drive_rr");

        // Reverses the right drive motors' direction
        motorDriveRightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        motorDriveRightRear.setDirection(DcMotorSimple.Direction.REVERSE);

        lift.init(hwMap);
        sweeper.init(hwMap);
        pusher.init(hwMap);
        dumper.init(hwMap);
    }

    public void setDriveMode(DcMotor.RunMode runMode) {
        motorDriveLeftFront.setMode(runMode);
        motorDriveLeftRear.setMode(runMode);
        motorDriveRightFront.setMode(runMode);
        motorDriveRightRear.setMode(runMode);
    }

    /**
     * Set the drive power of the left and right motors.
     * @param leftPower  Left Power
     * @param rightPower Right Power
     */
    public void setDrivePower(double leftPower, double rightPower) {
        motorDriveLeftFront.setPower(leftPower);
        motorDriveLeftRear.setPower(leftPower);
        motorDriveRightFront.setPower(rightPower);
        motorDriveRightRear.setPower(rightPower);
    }

    /**
     * Set the drive power of the left and right motors which the robot drives sideways.
     * @param leftPower  Left Power
     * @param rightPower Right Power
     */
    public void setDrivePowerSideways(double leftPower, double rightPower) {
        motorDriveLeftFront.setPower(-leftPower);
        motorDriveLeftRear.setPower(leftPower);
        motorDriveRightFront.setPower(rightPower);
        motorDriveRightRear.setPower(-rightPower);
    }

    public Lift getLift() {
        return lift;
    }

    public Sweeper getSweeper() {
        return sweeper;
    }

    public Pusher getPusher() {
        return pusher;
    }

    public Dumper getDumper() {
        return dumper;
    }

    public HardwareMap getHardwareMap() {
        return hwMap;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public DcMotor getMotorDriveLeftFront() {
        return motorDriveLeftFront;
    }

    public DcMotor getMotorDriveLeftRear() {
        return motorDriveLeftRear;
    }

    public DcMotor getMotorDriveRightFront() {
        return motorDriveRightFront;
    }

    public DcMotor getMotorDriveRightRear() {
        return motorDriveRightRear;
    }
}
