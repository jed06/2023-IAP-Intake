package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Flywheel;
import frc.robot.commands.Pneumatics;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer 
{
  //initialize all commands, subsystems, and joysticks
  private static Intake Intake;
  private static Joystick Joystick;
  private static Pneumatics Pneumatics;
  private static Flywheel Flywheel;

  //constructor
  public RobotContainer() 
  {
    Joystick = new Joystick(Constants.Joysticks.Zero);
    Intake = new Intake();
    Pneumatics = new Pneumatics(Intake);
    Flywheel = new Flywheel(Intake,Joystick);
    Intake.setDefaultCommand(Pneumatics);
    Intake.setDefaultCommand(Flywheel);
    configureButtonBindings();
  }

  //getter functions
  public static Joystick getJoy()
  {
    return Joystick;
  }

  private void configureButtonBindings() 
  {

  }

  public Command getAutonomousCommand() 
  {
    return Pneumatics;
  }
}