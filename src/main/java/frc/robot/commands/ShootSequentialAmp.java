// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class ShootSequentialAmp extends SequentialCommandGroup {
  /** Creates a new BlueAuton1. */
  public ShootSequentialAmp(Intake noteIntake, Shooter shooter) {
    addCommands(
      new Shoot(shooter, 0.4, 0.52).withTimeout(2),
      new IntakeForShooting(noteIntake, 1).withTimeout(1)
    );
  }

}
