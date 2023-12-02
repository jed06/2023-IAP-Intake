// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class Constants {
    //ID for Solenoids
    public static final class SolenoidPorts
    {
        public static final int DoubleSolenoidPort1 = 0;
        public static final int DoubleSolenoidPort2 = 1;
    }

    public static final class IntakePorts
    {
        public static final int Flywheel = 3;
        // double check this via pheonix tuner
        
    }

    //Constants for Joystick USB Order
    public static final class Joysticks
    {
        public static final int Zero = 0;
        public static final int One = 1;
    }

    //Button Bindings
    public static final class Buttons
    {
        public static final int Forward = 3; // orange button on x box ctrl
        public static final int Reverse = 1; // green button on x box ctrl
        public static final int Off = 2; // red button on x box ctrl
        // look at x box controller button map if ur still confused 
    }
}
