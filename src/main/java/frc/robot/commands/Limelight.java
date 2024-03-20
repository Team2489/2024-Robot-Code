package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.DriveTrain;

public class Limelight {
  // Limelight
  public void autoAlign() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    // NetworkTableEntry ta = table.getEntry("ta");

    DriveTrain drivetrain = new DriveTrain();

    // read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    // double area = ta.getDouble(0.0);

    double KpAim = -0.1;
    double KpDistance = -0.1;
    double min_aim_command = 0.05;

    double heading_error = -x;
    double distance_error = -y;
    double steering_adjust = 0.0;

    if (x > 1.0) steering_adjust = KpAim*heading_error - min_aim_command;
    else if (x < -1.0) steering_adjust = KpAim*heading_error + min_aim_command;

    double distance_adjust = KpDistance * distance_error;

    drivetrain.rightMotors(steering_adjust + distance_adjust);
    drivetrain.leftMotors(steering_adjust + distance_adjust);

    // intake function
  }

  /* estimate Distance based  
  public double estimateDistance() {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");  
    NetworkTableEntry ty = table.getEntry("ty");
    double targetOffsetAngle_Vertical = ty.getDouble(0.0);

    // degrees back the limelight rotated from perfectly vertical
    double limelightMountAngleDegrees = 25.0; 

    // distance from the center of the Limelight lens to the floor
    double limelightLensHeightInches = 20.0; 

    // distance from the target to the floor
    double goalHeightInches = 60.0; 

    double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;
    double angleToGoalRadians = angleToGoalDegrees * (Math.PI / 180.0);

    // final distance 
    return (goalHeightInches - limelightLensHeightInches) / Math.tan(angleToGoalRadians);
  } */
}