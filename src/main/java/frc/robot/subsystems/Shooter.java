// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  CANSparkMax frontRoller;
  CANSparkMax backRoller;
  /* Might add another motor for rotation of shooter */ 
  /** Creates a new Shooter. */
  public Shooter() {
    frontRoller = new CANSparkMax(Constants.FRONT_SHOOTER_ROLLER, MotorType.kBrushed);
    backRoller = new CANSparkMax(Constants.BACK_SHOOTER_ROLLER, MotorType.kBrushed);
    /**
     * frontRoller is the one furthest from the intake
     * backRoller is the one closest to the intake
     */
    frontRoller.enableVoltageCompensation(12);
    backRoller.enableVoltageCompensation(12);

    frontRoller.restoreFactoryDefaults();
    backRoller.restoreFactoryDefaults();
    
    shoot(0);
    runFrontRoller(0);
    runBackRoller(0);
  }

  public void shoot(double power) {
    frontRoller.set(power);
    backRoller.set(-power);
  }

  public void runFrontRoller(double power) {
    frontRoller.set(power);
  }

  public void runBackRoller(double power) {
    backRoller.set(-power);
  }

  public void stop() {
    frontRoller.set(0);
    backRoller.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
