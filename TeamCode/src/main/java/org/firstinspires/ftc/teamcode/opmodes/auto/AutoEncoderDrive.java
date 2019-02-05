package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * In this class, the robot drives forward autonomously using encoders on the driver motors which
 * move the wheel clockwise or counterclockwise.
 *
 * @author Henry
 * @version 1.0
 */
@Autonomous(name = "Auto Encoder Drive Forward", group = "test")
@Disabled
public class AutoEncoderDrive extends AutoOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        robot.setDriveZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        while (!isStarted()) {
            telemetry.addData(">", "Press START to start encoder drive forward");
            telemetry.update();
        }

        // Moves to the left sideways
        robot.moveSidewaysByEncoder(0.1, -60, 5);

        sleep(1000);

        robot.moveByEncoder(DRIVE_SPEED, 1010, 1010, 5);
        sleep(1000);
        setSweeperLiftPower(-0.5, 500);
        robot.moveByEncoder(TURN_SPEED, -740, 740, 5);
        sleep(1000);
        robot.moveByEncoder(DRIVE_SPEED, 1500, 1500, 10);
    }
}
