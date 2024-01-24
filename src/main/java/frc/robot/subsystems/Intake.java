// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  public CANSparkMax frontIntake;
  public CANSparkMax backIntake;
  /** Creates a new Intake. */
  public Intake() {
    frontIntake = new CANSparkMax(Constants.FRONT_INTAKE, MotorType.kBrushless);
    backIntake = new CANSparkMax(Constants.BACK_INTAKE, MotorType.kBrushless);


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
