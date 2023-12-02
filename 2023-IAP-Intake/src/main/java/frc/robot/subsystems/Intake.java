
package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.RobotContainer;
import frc.robot.commands.*;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Intake extends SubsystemBase 
{
  //initialize double solenoid
  private static DoubleSolenoid doubleSolenoid;
  private static Compressor compressor;

  private final WPI_TalonSRX FlyWheelTalon;
  
  //constructor
  public Intake()
  {
    doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);

    FlyWheelTalon = new WPI_TalonSRX(Constants.IntakePorts.Flywheel);

    FlyWheelTalon.setInverted(false); 

    FlyWheelTalon.configFactoryDefault();
  }

  //getter function for doublesolenoid
  public static DoubleSolenoid getDoubleSolenoid()
  {
    return doubleSolenoid;
  }

  public static Compressor getCompressor()
  {
    return compressor;
  }

  public void setFlywheelPower(double speed) 
  {
    FlyWheelTalon.set(ControlMode.PercentOutput, speed);
  }
  
  public double getCurrent()
  {
    return FlyWheelTalon.getStatorCurrent();
  }

  @Override
  public void periodic()
  {
    //print status of solenoid position while code is running
   // SmartDashboard.putString("DS Position", RobotContainer.getSolenoidPosition());
  }

  @Override
  public void simulationPeriodic()
  {
    
  }
}
