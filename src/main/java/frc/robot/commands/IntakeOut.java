// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeOut extends CommandBase {
  Intake noteIntake;
  double power = 0.0;

  /** Creates a new IntakeOut. */
  public IntakeOut(Intake noteIntake, double power) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.noteIntake = noteIntake;
    this.power = power;
    addRequirements(noteIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    noteIntake.intakeRun(-power);
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

