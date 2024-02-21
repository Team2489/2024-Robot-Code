package frc.robot.Limelight;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");

    // read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);

    // post to smart dashboard periodically
    // SmartDashboard.putNumber("LimelightX", x);
    // SmartDashboard.putNumber("LimelightY", y);
    // SmartDashboard.putNumber("LimelightArea", area);
    public void autoAimAutoRange() {
        double KpAim = -0.1f;
        double KpDistance = -0.1f;
        double min_aim_command = 0.05f;

        if (joystick->GetRawButton(9)) {
            double heading_error = -tx;
            double distance_error = -ty;
            double steering_adjust = 0.0f;

            if (tx > 1.0) steering_adjust = KpAim*heading_error - min_aim_command;
            else if (tx < -1.0) steering_adjust = KpAim*heading_error + min_aim_command;

            double distance_adjust = KpDistance * distance_error;

            left_command += steering_adjust + distance_adjust;
            right_command -= steering_adjust + distance_adjust;
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
            double distanceFromLimelightToGoalInches = (goalHeightInches - limelightLensHeightInches) / Math.tan(angleToGoalRadians);
        }

}
