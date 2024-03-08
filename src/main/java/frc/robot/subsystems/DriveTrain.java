// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;;



public class DriveTrain extends SubsystemBase {

  CANSparkMax rightFrontSpark = new CANSparkMax(Constants.RIGHT_FRONT_SPARK, MotorType.kBrushless);
  CANSparkMax rightBackSpark = new CANSparkMax(Constants.RIGHT_BACK_SPARK, MotorType.kBrushless);
  CANSparkMax leftFrontSpark = new CANSparkMax(Constants.LEFT_FRONT_SPARK, MotorType.kBrushless);
  CANSparkMax leftBackSpark = new CANSparkMax(Constants.LEFT_BACK_SPARK, MotorType.kBrushless);

  MotorControllerGroup rightMotors;
  MotorControllerGroup leftMotors;
  DifferentialDrive dDrive;


  /** Creates a new DriveTrain. */
  public DriveTrain() {
    rightFrontSpark.setInverted(false);
    rightBackSpark.setInverted(false);
    leftFrontSpark.setInverted(true);
    leftBackSpark.setInverted(true);

    rightFrontSpark.restoreFactoryDefaults();
    rightBackSpark.restoreFactoryDefaults();
    leftFrontSpark.restoreFactoryDefaults();
    leftBackSpark.restoreFactoryDefaults();

    rightFrontSpark.enableVoltageCompensation(12);
    rightBackSpark.enableVoltageCompensation(12);
    leftFrontSpark.enableVoltageCompensation(12);
    leftBackSpark.enableVoltageCompensation(12);

    rightMotors = new MotorControllerGroup(rightFrontSpark, rightBackSpark);
    leftMotors = new MotorControllerGroup(leftFrontSpark, leftBackSpark);
    dDrive = new DifferentialDrive(leftMotors, rightMotors);

    dDrive.arcadeDrive(0, 0);
    arcadeDriveCustomized(0, 0);

  }

  public void arcadeDriveCustomized(double speed, double rotation){
    rightFrontSpark.set(rotation-speed);
    rightBackSpark.set(rotation-speed);
    leftFrontSpark.set(speed+rotation);
    leftBackSpark.set(speed+rotation);
  }
  public void stopMotors(){
    rightFrontSpark.set(0);
    rightBackSpark.set(0);
    leftFrontSpark.set(0);
    leftBackSpark.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
