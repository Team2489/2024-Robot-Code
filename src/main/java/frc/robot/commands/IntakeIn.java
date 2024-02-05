// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.subsystems.Intake;

public class IntakeIn extends CommandBase {
  Intake noteIntake;
  double power = 0.0;
  DigitalInput digitalInput;

  /** Creates a new IntakeIn. */
  public IntakeIn(Intake noteIntake, double power, DigitalInput digitalInput) { // add                                                                                              // parameter
    // Use addRequirements() here to declare subsystem dependencies.
    this.noteIntake = noteIntake;
    this.power = power;
    this.digitalInput = digitalInput;
    addRequirements(noteIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    noteIntake.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (digitalInput.get()) {
      noteIntake.stop();
    } else {
      noteIntake.intakeRun(power);
    }
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
