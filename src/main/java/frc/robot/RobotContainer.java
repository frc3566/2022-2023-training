// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.IntakeCommand;

public class RobotContainer {

  // Inputs
  public Joystick js1 = new Joystick(0);
  
  // Subsystems
  private final DriveSubsystem driveSubsystem = new DriveSubsystem("SparkMax");
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

  // Commands
  private final DriveWithJoystick driveWithJoystick = new DriveWithJoystick(js1, driveSubsystem);
  private final IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driveSubsystem.setDefaultCommand(driveWithJoystick);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Intakes object (in)
    // TODO try changing button number to see if it works
    JoystickButton js1_b12 = new JoystickButton(js1, 12);
    js1_b12.whenHeld(intakeCommand);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;
    return null;
  }

  /* button mapping:
    thrustmaster:
      stick:
        trigger:1
        front:
          3   4
            2
      base:
        left:
          5 6 7
          10 9 8
        right:
          13 12 11
          14 15 16
    
    logitech:
      stick:
        trigger: 1
        left: 2
        front:
          5     6
            3 4
      base:
        7 8
        9 10
        11 12
    POV buttons:
          0
      315   45
    270       90
      225   135
         180
  */
}
