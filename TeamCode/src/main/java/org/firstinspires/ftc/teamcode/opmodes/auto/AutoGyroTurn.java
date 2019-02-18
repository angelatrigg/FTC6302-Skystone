package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * This class implements the Rev Hub's Imu for gyro turns.
 * @author Henry
 * @version 1.0
 */
@Autonomous(name = "Auto Gyro Turn", group = "test")
public class AutoGyroTurn extends AutoOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        while (!isStarted()) {
            telemetry.addData("status", "waiting for start...");
            telemetry.update();
        }

        robot.turnByGyro(TURN_SPEED, 90, 5);

        telemetry.addData("ststus", "sleeping 1 second");
        telemetry.update();
        sleep(1000);

        robot.turnByGyro(TURN_SPEED, -90, 5);
    }
}