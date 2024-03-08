// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command {
  Shooter shooter;
  double power = 0.0;
  double runFrontRollerPower = 0.0;
  double runBackRollerPower = 0.0;
  // base class for shooting speaker and amp(coming soon)

  public Shoot(Shooter shooter, double runFrontRollerPower, double runBackRollerPower) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooter = shooter;
    this.runFrontRollerPower = runFrontRollerPower;
    this.runBackRollerPower = runBackRollerPower;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooter.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Run it up first before shooting, possibly avoids note being stuck
    shooter.runFrontRoller(runFrontRollerPower);
    shooter.runBackRoller(runBackRollerPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
