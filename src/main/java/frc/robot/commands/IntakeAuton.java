// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeAuton extends CommandBase {
  // Intake for autonomous(intake in & out are for teleop using XboxController as a parameter)
  Intake noteIntake = null;
  double power = 0.0;
  XboxController xboxController = null;
  boolean done = false;
  DigitalInput digitalInput = null;
  
  public IntakeAuton(Intake noteIntake, double power, DigitalInput digitalInput) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.noteIntake = noteIntake;
    this.power=power;
    this.digitalInput = digitalInput;
    addRequirements(noteIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      noteIntake.intakeRun(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    noteIntake.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
