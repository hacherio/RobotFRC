

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController; 

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_driveTrain;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private Spark m_intakeMotor;
  private Spark m_climbMotor; 
  private Spark m_secClimbMotor;


  @Override
  public void robotInit() {
    m_driveTrain = new DifferentialDrive(new Spark(0), new Spark(1));
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);



    m_intakeMotor = new Spark(4);
    m_climbMotor = new Spark(2);
    m_secClimbMotor = new Spark(3);

    // m_intakeMotor.set(speed);
  }

 @Override
  public void teleopPeriodic() {
    // m_driveTrain.tankDrive(m_leftStick.getY(), m_rightStick.getY());
    m_driveTrain.arcadeDrive(m_leftStick.getY(), m_leftStick.getX());
    runIntake(m_rightStick.getRawButton(1), m_rightStick.getRawButton(2));
    runClimb(m_rightStick.getRawButton(3), m_rightStick.getRawButton(5));
  }

  void runIntake(boolean isIntakeButtonPressed, boolean isOutakeButtonPressed){
    if (isOutakeButtonPressed) {
     m_intakeMotor.set(-1);
    } else {
      if (isIntakeButtonPressed) {
        m_intakeMotor.set(1);
      } else {
          m_intakeMotor.set(0);
      } // end if (isIntakeButtonPressed) {
    }
  }
  void runClimb(final boolean isAscendButtonPressed, final boolean IsDesendButtonPressed) {
    if (isAscendButtonPressed) {
      m_climbMotor.set(1);
    } else {
      if (IsDesendButtonPressed) {
        m_climbMotor.set(-1); 
       } else {
         m_climbMotor.set(0); 
      }
    }
  } //comment

} //end class
