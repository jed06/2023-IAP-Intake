// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class Flywheel extends CommandBase {
   private final Intake intake;
   private final Joystick joy;
   
   public Flywheel(Intake intake, Joystick joy)
   {
     this.intake = intake;
     this.joy = joy;
     addRequirements(intake);
   }
 
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    intake.setFlywheelPower(-joy.getRawAxis(3)); //literally sets the flywheel speed to the y axis (which is 3 on the xbox ctrl)
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
