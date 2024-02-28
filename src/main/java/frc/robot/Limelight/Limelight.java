package frc.robot.Limelight;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.DriveTrain;

public class Limelight {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    DriveTrain drivetrain = new DriveTrain();

    // read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);

    // post to smart dashboard periodically
    // SmartDashboard.putNumber("LimelightX", x);
    // SmartDashboard.putNumber("LimelightY", y);
    // SmartDashboard.putNumber("LimelightArea", area);
    public void autoAimAutoRange() {
        double KpAim = -0.1;
        double KpDistance = -0.1;
        double min_aim_command = 0.05;

        if () {
            double heading_error = -tx;
            double distance_error = -ty;
            double steering_adjust = 0.0;

            if (tx > 1.0) steering_adjust = KpAim*heading_error - min_aim_command;
            else if (tx < -1.0) steering_adjust = KpAim*heading_error + min_aim_command;

            double distance_adjust = KpDistance * distance_error;

            drivetrain.rightFrontSpark.set(steering_adjust + distance_adjust);
            drivetrain.rightBackSpark.set(steering_adjust + distance_adjust);
            drivetrain.leftFrontSpark.set(-1*(steering_adjust + distance_adjust));
            drivetrain.leftBackSpark.set(-1*(steering_adjust + distance_adjust));
        }
    }
    

    // Estimate Distance
        public double estimateDistance() {   
            NetworkTableEntry ty = table.getEntry("ty");
            double targetOffsetAngle_Vertical = ty.getDouble(0.0);

            // how many degrees back is your limelight rotated from perfectly vertical?
            double limelightMountAngleDegrees = 25.0; 

            // distance from the center of the Limelight lens to the floor
            double limelightLensHeightInches = 20.0; 

            // distance from the target to the floor
            double goalHeightInches = 60.0; 

            double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;
            double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);

            //calculate distance
            return (goalHeightInches - limelightLensHeightInches) / Math.tan(angleToGoalRadians);
        }

}
