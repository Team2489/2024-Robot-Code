// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeIn extends CommandBase {
  Intake noteIntake;
  double power = 0.0;
  XboxController xboxController;
  boolean done = false;
  DigitalInput digitalInput;

  /** Creates a new IntakeIn. */
  public IntakeIn(Intake noteIntake, double power, XboxController xboxController, DigitalInput digitalInput) { //add sensor parameter
    // Use addRequirements() here to declare subsystem dependencies.
    this.noteIntake = noteIntake;
    this.power=power;
    this.xboxController = xboxController;
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
      if(!digitalInput.get()) {
        done = true;
        System.out.println(done);
      }
      if(done) {
        noteIntake.stop();
      } else if (xboxController.getLeftBumper()) {
        noteIntake.runFrontIntake(power);
        noteIntake.runBackIntake(-0.5);//arbitrary
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    noteIntake.stop();
    done = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
