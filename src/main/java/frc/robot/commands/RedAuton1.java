// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

public class RedAuton1 extends SequentialCommandGroup {
  /** Creates a new RedAuton1. */
  public RedAuton1(DriveTrain driveTrain, double power, double rotation) {
    addCommands(
      new DriveAuton(driveTrain, 1, 0).withTimeout(5));
  }
}
