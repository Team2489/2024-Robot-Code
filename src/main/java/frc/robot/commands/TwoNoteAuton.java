// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class TwoNoteAuton extends SequentialCommandGroup {
  /** Creates a new RedAuton2. */
  public TwoNoteAuton(DriveTrain driveTrain, Intake noteIntake, Shooter shooter, DigitalInput digitalInput) {
    addCommands(
      new Shoot(shooter, 1, 1).withTimeout(2),
      new ShootIntakeAuto(shooter, 1, 1, 1, noteIntake).withTimeout(2),
    //  new IntakeIn(noteIntake, -1, digitalInput).withTimeout(5),
       new ParallelCommandGroup(
         new IntakeIn(noteIntake, 1, digitalInput).withTimeout(2),
         new DriveAuton(driveTrain, 0.24, 0).withTimeout(0.9)
         ),
        new DriveAuton(driveTrain, -0.24, 0).withTimeout(0.8),
        new Shoot(shooter, 1, 1).withTimeout(2),
        new ShootIntakeAuto(shooter, 1, 1, 1, noteIntake).withTimeout(2)
       );
  }

}
