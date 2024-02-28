// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class BlueAuton2 extends SequentialCommandGroup {
  /** Creates a new BlueAuton1. */
  public BlueAuton2(DriveTrain driveTrain, Intake noteIntake, Shooter shooter, DigitalInput digitalInput) {
    addCommands(
        new DriveAuton(driveTrain, 1, -1).withTimeout(0.5),
        //new ShootSpeaker(shooter, 1),
        new DriveAuton(driveTrain, 1, 1).withTimeout(0.5),
        new DriveAuton(driveTrain, 1, 0).withTimeout(5),
        new IntakeIn(noteIntake, 1, digitalInput).withTimeout(1)
    );
  }

}
