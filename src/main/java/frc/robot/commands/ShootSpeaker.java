// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Shooter;

public class ShootSpeaker extends SequentialCommandGroup {

  /** General shooting strategy so note won't get stuck while gradually allowing itself into the shooter. */
  public ShootSpeaker(Shooter shooter, double power) {
    // Use addRequirements() here to declare subsystem dependencies.
    new Shoot(shooter, 0.1, 0.1).withTimeout(0.2);
    new Shoot(shooter, power, power).withTimeout(2);
  }
}
