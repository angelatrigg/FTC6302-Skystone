package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.teamcode.robot.TensorFlowDetector;
import org.firstinspires.ftc.teamcode.robot.VuforiaDetector;
import org.firstinspires.ftc.teamcode.robot.VuforiaKey;

import java.util.ArrayList;
import java.util.List;

@TeleOp(name = "Tensor Flow Detector - DEV")
public class TensorFlowDetectorOp extends LinearOpMode {

    private VuforiaDetector vuforiaDetector;
    private TensorFlowDetector tfod;

    @Override
    public void runOpMode() throws InterruptedException {
        List<Recognition> recognitions;
        boolean detectedGold = false;

        vuforiaDetector = new VuforiaDetector();
        tfod = new TensorFlowDetector();

        vuforiaDetector.init(hardwareMap, VuforiaKey.VUFORIA_KEY);
        tfod.init(hardwareMap, vuforiaDetector.getVuforia());

        telemetry.addData(">", "Press START to start tracking minerals");
        telemetry.update();
        
        waitForStart();

        if (tfod.getDetector() != null) {
            tfod.getDetector().activate();
        }

        while (opModeIsActive()) {
            // Get new list of updated recognitions
            recognitions = tfod.getDetector().getUpdatedRecognitions();

            if (recognitions != null) {
                for (Recognition recognition : recognitions) {
                    if (recognition.getLabel().equals(TensorFlowDetector.LABEL_GOLD_MINERAL)) {
                        detectedGold = true;
                    }
                }

                telemetry.addData("# objects", recognitions.size());
                telemetry.addData("detected gold", detectedGold);
            }
            telemetry.update();

            detectedGold = false;
        }

        if (tfod.getDetector() != null) {
            tfod.getDetector().deactivate();
        }
    }
}