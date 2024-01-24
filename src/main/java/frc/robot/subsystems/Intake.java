// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  public WPI_TalonSRX frontIntake;
  public WPI_TalonSRX backIntake;
  /** Creates a new Intake. */
  public Intake() {
    frontIntake = new WPI_TalonSRX(Constants.FRONT_INTAKE);
    backIntake = new WPI_TalonSRX(Constants.BACK_INTAKE;

    frontIntake.enableVoltageCompensation(12);
    backIntake.enableVoltageCompensation(12);

    intakeRun(0);
  }

  public void intakeRun(double power){
    frontIntake.set(-power);
    backIntake.set(power);
  }

  public void runFrontIntake(double power){
    frontIntake.set(-power);
  }
  
  public void runBackIntake(double power){
    backIntake.set(power);
  }

  public void stop(){
    frontIntake.set(0);
    backIntake.set(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
