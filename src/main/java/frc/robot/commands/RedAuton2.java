// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;

public class RedAuton2 extends SequentialCommandGroup {
  /** Creates a new RedAuton2. */
  public RedAuton2(DriveTrain driveTrain, Intake noteIntake, DigitalInput digitalInput, double speed, double rotation) {
    // Use addRequirements() here to declare subsystem dependencies.
    addCommands(
        new DriveAuton(driveTrain, 1, 1).withTimeout(0.5),
        // shoot
        new DriveAuton(driveTrain, 1, -1).withTimeout(0.5),
        new DriveAuton(driveTrain, 1, 0).withTimeout(5),
        new IntakeAuton(noteIntake, 1, digitalInput).withTimeout(1));
  }

}
