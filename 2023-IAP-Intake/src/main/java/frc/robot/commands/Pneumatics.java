// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


public class Pneumatics extends CommandBase {
  private final Intake intake;
  public Pneumatics(Intake intake) {
    this.intake = intake;
    addRequirements(intake);
  }

  @Override
  public void initialize() {}
  @Override
  public void execute() {
    if(RobotContainer.getJoy().getRawButtonPressed(Constants.Buttons.Forward))
    {
      Intake.getDoubleSolenoid().set(kForward);
      
    }
    if(RobotContainer.getJoy().getRawButtonPressed(Constants.Buttons.Reverse))
    {
      Intake.getDoubleSolenoid().set(kReverse);
      
    }
    if(RobotContainer.getJoy().getRawButtonPressed(Constants.Buttons.Off))
    {
      Intake.getCompressor().disable();
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
