// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class OneNoteRightSide extends SequentialCommandGroup {
  /** Creates a new BlueAuton1. */
  public OneNoteRightSide(DriveTrain driveTrain, Intake noteIntake, Shooter shooter, DigitalInput digitalInput) {
    addCommands(
      new Shoot(shooter, 1, 1).withTimeout(2),
      new Shoot2(shooter, 1, 1, -1, noteIntake).withTimeout(2),
      new DriveAuton(driveTrain, 0.24, -0.12).withTimeout(1.5)
    

    );
  }

}
