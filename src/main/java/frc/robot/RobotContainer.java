// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.Auton1;
import frc.robot.commands.OneNoteRightSide;
import frc.robot.commands.OneNoteRightSideDelay;
import frc.robot.commands.OneNoteLeftSide;
import frc.robot.commands.OneNoteLeftSideDelay;
import frc.robot.commands.DriveArcadeCustomized;
import frc.robot.commands.IntakeForShooting;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.RedAuton2;
import frc.robot.commands.RedAuton3;
import frc.robot.commands.ShootAuto;
import frc.robot.commands.ShootSequential;
import frc.robot.commands.ShootSequentialAmp;
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
  DriveTrain dDrive= new DriveTrain();
  Intake noteIntake = new Intake();
  Shooter shooter = new Shooter();
  DigitalInput digitalInput = new DigitalInput(Constants.LINE_BREAKER_PORT); 

  SendableChooser<Command> chooser = new SendableChooser<>();

  Auton1 autonomous1 = new Auton1(dDrive);
  OneNoteRightSide OneNoteRightSide = new OneNoteRightSide(dDrive, noteIntake, shooter, digitalInput);
  OneNoteLeftSide OneNoteLeftSide = new OneNoteLeftSide(dDrive, noteIntake, shooter, digitalInput);
  RedAuton2 redAuton2 = new RedAuton2(dDrive, noteIntake, shooter, digitalInput);
  RedAuton3 redAuton3 = new RedAuton3(dDrive, noteIntake, shooter, digitalInput);
  ShootAuto ShootAuto = new ShootAuto(dDrive, noteIntake, shooter, digitalInput);
  OneNoteLeftSideDelay oneNoteLeftSideDelay = new OneNoteLeftSideDelay(dDrive, noteIntake, shooter, digitalInput);
  OneNoteRightSideDelay oneNoteRightSideDelay = new OneNoteRightSideDelay(dDrive, noteIntake, shooter, digitalInput);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    dDrive.setDefaultCommand(new DriveArcadeCustomized(dDrive, xboxController::getLeftY, xboxController::getRightX, 0.3, 0.2, 0.8, xboxController));
    chooser.setDefaultOption("2 Note Center", redAuton2);
    chooser.addOption("3 Note Center?", redAuton3);
    chooser.addOption("One Note Right Side", OneNoteRightSide);
    chooser.addOption("One Note Left Side", OneNoteLeftSide);
    chooser.addOption("Only Shoot", ShootAuto);
    chooser.addOption("One Note Right Side Delay 5 Seconds", oneNoteRightSideDelay);
    chooser.addOption("One Note Left Side Delay 5 Seconds", oneNoteLeftSideDelay);
    chooser.addOption("literally nothing", autonomous1);
    SmartDashboard.putData(chooser);
  }


  private void configureBindings() {
    new JoystickButton(xboxController2, Button.kRightBumper.value).whileTrue(new IntakeIn(noteIntake, 0.75, digitalInput)); // add digitalInput
    new JoystickButton(xboxController2, Button.kLeftBumper.value).whileTrue(new IntakeOut(noteIntake, -0.5));
    new JoystickButton(xboxController2, Button.kB.value).whileTrue(new ShootSequentialAmp(noteIntake, shooter));
    new JoystickButton(xboxController2, Button.kY.value).whileTrue(new IntakeForShooting(noteIntake, 1));
    new JoystickButton(xboxController2, Button.kX.value).whileTrue(new ShootSequential(noteIntake, shooter));
    //new JoystickButton(xboxController2, Button.kA.value).whileTrue(new Shoot(shooter, 0.8, 0.8));

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
