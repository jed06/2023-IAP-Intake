
package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.*;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Intake extends SubsystemBase {

    // Declare a static DoubleSolenoid and Compressor for pneumatic control
    private static DoubleSolenoid doubleSolenoid;
    private static Compressor compressor;
  
    // Declare a Talon SRX motor controller for the flywheel
    private final WPI_TalonSRX FlyWheelTalon;
  
    public Intake() {
      // Initialize the DoubleSolenoid with the specified ports on the CTREPCM pneumatic module
      doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
      
      // Initialize a Compressor with the specified PCM (Pneumatic Control Module) ID and module type
      Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  
      // Initialize the Talon SRX motor controller for the flywheel with a specific port
      FlyWheelTalon = new WPI_TalonSRX(Constants.IntakePorts.Flywheel);
  
      // Set the inversion of the flywheel motor controller (whether it runs in the opposite direction)
      FlyWheelTalon.setInverted(false);
  
      FlyWheelTalon.configFactoryDefault();
    }
  
    // Getter function to retrieve the DoubleSolenoid instance
    public static DoubleSolenoid getDoubleSolenoid() {
      return doubleSolenoid;
    }
  
    // Getter function to retrieve the Compressor instance
    public static Compressor getCompressor() {
      return compressor;
    }
  
    // Method to set the power of the flywheel motor controller
    public void setFlywheelPower(double speed) {
      FlyWheelTalon.set(ControlMode.PercentOutput, speed);
    }
  
    // Method to retrieve the current drawn by the flywheel motor controller
    public double getCurrent() {
      return FlyWheelTalon.getStatorCurrent();
    }
  
    // Override the periodic method for running code during the robot program execution
    @Override
    public void periodic() {
      // Print the status of the solenoid position to SmartDashboard
      // SmartDashboard.putString("DS Position", RobotContainer.getSolenoidPosition());
    }
  
    @Override
    public void simulationPeriodic() {
      // Simulation-specific code
    }
  }
  