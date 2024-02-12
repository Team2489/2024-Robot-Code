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

    /* Aimbot
        // turning control constants, to find sweet spot of
        double kp = -0.1;
        double min_command = 0.05;

        if (GetRawButton(1)) {
            // margin of error
            double heading_error = -tx;
            // how much to change by, impacted by the turning constatns and how far off AprilTag is from tx
            double steering_adjust = 0;
            if (Math.abs(heading_error) > 1) {
                if (heading_error < 0) steering_adjust = kp * heading_error + min_command;
                else steering_adjust = kp * heading_error - min_command;
            } 
        }
        
        // tank drive turning 
        left_drive(steering_adjust);
        right_drive(-steering_adjust);
    */

    /* Estimate Distance
        public double estimateDistance() {
         
            NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
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
    */

    /* Drive into range
        // distance control constant (again, to find sweet spot of)
        double kpDistance = -0.1;
        double currentDistance = estimateDistance();

        if (getRawButton(2)) {
            double distance_error = desired_distance - current_distance;
            double driving_adjust = kpDistance * distance_error;

            left_drive(driving_adjust);
            right_drive(driving_adjust);
        }
     */
}
