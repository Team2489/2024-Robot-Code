// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.Auton1;
import frc.robot.commands.BlueAuton2;
import frc.robot.commands.BlueAuton3;
import frc.robot.commands.DriveArcadeCustomized;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.RedAuton2;
import frc.robot.commands.RedAuton3;
import frc.robot.commands.ShootSpeaker;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  XboxController xboxController = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  XboxController xboxController2 = new XboxController(Constants.XBOX_CONTROLLER2_PORT);

  // The robot's subsystems and commands are defined here...
  DriveTrain dDrive = new DriveTrain();
  Intake noteIntake;
  Shooter shooter;
  DigitalInput digitalInput = new DigitalInput(Constants.LINE_BREAKER_PORT); 

  SendableChooser<Command> chooser = new SendableChooser<>();

  Auton1 autonomous1 = new Auton1(dDrive);
  BlueAuton2 blueAuton2 = new BlueAuton2(dDrive, noteIntake, shooter, digitalInput);
  BlueAuton3 blueAuton3 = new BlueAuton3(dDrive, noteIntake, shooter, digitalInput);
  RedAuton2 redAuton2 = new RedAuton2(dDrive, noteIntake, shooter, digitalInput);
  RedAuton3 redAuton3 = new RedAuton3(dDrive, noteIntake, shooter, digitalInput);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    dDrive.setDefaultCommand(new DriveArcadeCustomized(dDrive, xboxController::getLeftY, xboxController::getRightX, 0.3, 0.2, 0.8, xboxController));
    chooser.setDefaultOption("Default Auto Command", autonomous1);
    SmartDashboard.putData(chooser);
  }


  private void configureBindings() {
    new JoystickButton(xboxController2, Button.kRightBumper.value).whileTrue(new IntakeIn(noteIntake, 1.0, digitalInput)); // add digitalInput
    new JoystickButton(xboxController2, Button.kLeftBumper.value).whileTrue(new IntakeOut(noteIntake, 1.0));
    new JoystickButton(xboxController2, Button.kRightStick.value).whileTrue(new ShootSpeaker(shooter, 1.0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return chooser.getSelected();
  }
}
