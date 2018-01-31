package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Harshini on 12/8/17.
 */
@Autonomous(name = "FinalUniversalRef",group = "Auto")
public class FinalUniversalRef extends LinearOpMode
{
    NewRobotFinal newRobot;
    public void runOpMode()
    {
        float adjustment = 0;
        newRobot = new NewRobotFinal(hardwareMap);
        newRobot.initAutoFunctions(hardwareMap, this);
        char colorOfPlatform = newRobot.getColor(newRobot.getFloorColorSens());
        telemetry.addData("color = ", colorOfPlatform);
        telemetry.addData("Hue value", newRobot.getHueValue(newRobot.getFloorColorSens()));
        telemetry.update();
        waitForStart();
        char cipher = newRobot.getGlyphCipher();
        switch (colorOfPlatform)
        {
            case 'b':
                newRobot.openOrCloseDoor(true);
                newRobot.moveWing(true);
                newRobot.oldMoveLift(1);
                char colorOfJewel = newRobot.getColor(newRobot.getleftWingColorSens());
                telemetry.addData("jewel color = ", colorOfJewel);
                telemetry.addData("Hue value", newRobot.getHueValue(newRobot.getleftWingColorSens()));
                telemetry.update();
                switch (colorOfJewel)
                {
                    case'r':
                        adjustment = 4;
                        newRobot.driveStraight_In(adjustment);
                        newRobot.moveWing(false);
                        newRobot.driveStraight_In(19 - adjustment);
                        break;
                    case 'b':
                        adjustment = 2;
                        newRobot.driveStraight_In(0 - adjustment);
                        newRobot.moveWing(false);
                        newRobot.driveStraight_In(adjustment + 19);
                        break;
                    default:
                        newRobot.moveWing(false);
                        newRobot.driveStraight_In(19);
                        break;
                }
                telemetry.addData("Cipherr = ", cipher);
                telemetry.update();
                switch (cipher)
                {
                    case 'r':
                        switch (colorOfJewel)
                        {
                            case 'r':
                                newRobot.pivot(-61, .6);
                                break;
                            case 'b':
                                newRobot.pivot(-61, .6);
                                break;
                            default:
                                newRobot.pivot(-61, .6);
                                break;
                        }
                        newRobot.driveStraight_In(4, .5);
                        newRobot.openOrCloseDoor(false);
                        newRobot.driveStraight_In_Stall(18, .5, telemetry);
                        break;

                    case 'l':
                        newRobot.pivot(-22,.6);
                        newRobot.driveStraight_In(4, .5);
                        newRobot.openOrCloseDoor(false);
                        newRobot.driveStraight_In_Stall(18, .5, telemetry);
                        break;
                    case 'c':
                    default:
                        newRobot.pivot(-42,.6);
                        newRobot.driveStraight_In(4, .5);
                        newRobot.openOrCloseDoor(false);
                        newRobot.driveStraight_In_Stall(18, .5, telemetry);
                        break;
                }
                newRobot.driveStraight_In(-3,1);
                newRobot.pivot(-30,.7);
                newRobot.stopAllMotors();
                break;
            case 'r':
                newRobot.openOrCloseDoor(true);
                newRobot.moveWing(true);
                newRobot.oldMoveLift(1);
                colorOfJewel = newRobot.getColor(newRobot.getrightWingColorSens());
                telemetry.addData("jewel color = ", colorOfJewel);
                telemetry.addData("Hue value", newRobot.getHueValue(newRobot.getrightWingColorSens()));
                telemetry.update();
                switch (colorOfJewel)
                {
                    case 'r':
                        adjustment = 2;
                        newRobot.driveStraight_In(0 - adjustment);
                        newRobot.moveWing(false);
                        newRobot.driveStraight_In(adjustment + 19);
                        break;
                    case 'b':
                        adjustment = 4;
                        newRobot.driveStraight_In(adjustment);
                        newRobot.moveWing(false);
                        newRobot.driveStraight_In(18 - adjustment);
                        break;
                    default:
                        newRobot.moveWing(false);
                        newRobot.driveStraight_In(18);
                        break;
                }
                telemetry.addData("Cipherr = ", cipher);
                telemetry.update();
                switch (cipher)
                {
                    case 'l':
                        switch (colorOfJewel)
                        {
                            case 'r':
                                newRobot.pivot(61, .6);
                                break;
                            case 'b':
                                newRobot.pivot(61, .6);
                                break;
                            default:
                                newRobot.pivot(61, .6);
                                break;
                        }
                        newRobot.driveStraight_In(4, .5);
                        newRobot.openOrCloseDoor(false);
                        newRobot.driveStraight_In_Stall(15, .5, telemetry);
                        break;
                    case 'r':
                        newRobot.pivot(22,.6);
                        newRobot.driveStraight_In(4, .5);
                        newRobot.openOrCloseDoor(false);
                        newRobot.driveStraight_In_Stall(15, .5, telemetry);
                        break;
                    case 'c':
                    default:
                        newRobot.pivot(57,.6);
                        newRobot.driveStraight_In(4, .5);
                        newRobot.openOrCloseDoor(false);
                        newRobot.driveStraight_In_Stall(15, .5, telemetry);
                        break;
                }
                newRobot.driveStraight_In(-3);
                newRobot.pivot(30,.7);
                break;
            default:
                newRobot.driveStraight_In(29, .4);
                newRobot.openOrCloseDoor(true);
                newRobot.oldMoveLift(1);
                break;
        }
        newRobot.stopAllMotors();
    }
}