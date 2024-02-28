// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class ShootSpeaker extends ParallelCommandGroup {

  /** General shooting strategy so note won't get stuck while gradually allowing itself into the shooter. */
  public ShootSpeaker(Shooter shooter, Intake noteIntake, double power) {
    // Use addRequirements() here to declare subsystem dependencies.
    new Shoot(shooter, power, power).withTimeout(4);
    new IntakeForShooting(noteIntake, 0.5).withTimeout(0.2);
    addRequirements(shooter);
    addRequirements(noteIntake);
  }
}
