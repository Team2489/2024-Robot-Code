// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.DriveArcadeCustomized;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {


  XboxController xboxController = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  // The robot's subsystems and commands are defined here...
  DriveTrain dDrive = new DriveTrain();
  Intake noteIntake;
  //DigitalInput digitalInput = new DigitalInput(Constants.LINE_BREAKER_PORT); 

  // Replace with CommandPS4Controller or CommandJoystick if needed

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    dDrive.setDefaultCommand(new DriveArcadeCustomized(dDrive, xboxController::getLeftY, xboxController::getRightX, 0.3, 0.2, 0.8, xboxController));
  }


  private void configureBindings() {

    //new JoystickButton(xboxController, Button.kRightBumper.value).whileTrue(new IntakeIn(noteIntake, 1, xboxController)); // add digitalInput
    //new JoystickButton(xboxController, Button.kLeftBumper.value).whileTrue(new IntakeOut(noteIntake, 1, xboxController));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
