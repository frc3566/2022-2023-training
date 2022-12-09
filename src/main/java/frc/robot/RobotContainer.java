// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.commands.DriveWithJoystick;
import frc.robot.commands.IntakeCommand;

public class RobotContainer {

  // Inputs
  public Joystick js1 = new Joystick(0);
  
  // Subsystems
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final IndexerSubsystem indexerSubsystem = new IndexerSubsystem();

  // Commands
  private final DriveWithJoystick driveWithJoystick = new DriveWithJoystick(js1, driveSubsystem);
  private final IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem);

  public RobotContainer() {
    configureButtonBindings();
    driveSubsystem.setDefaultCommand(driveWithJoystick);
  }

  private void configureButtonBindings() {
    // Intake on press (toggle)
    JoystickButton js1_b3 = new JoystickButton(js1, 3);
    js1_b3.toggleWhenPressed(intakeCommand, true);
    // ^ This doesn't work?
    // Intake when held (in)
    JoystickButton js1_b12 = new JoystickButton(js1, 12);
    js1_b12.whenHeld(new StartEndCommand(() -> intakeSubsystem.setIntake(0.7), () -> intakeSubsystem.setIntake(0)));
    // Intake when held (out)
    JoystickButton js1_b15 = new JoystickButton(js1, 15);
    js1_b15.whenHeld(new StartEndCommand(() -> intakeSubsystem.setIntake(-0.7), () -> intakeSubsystem.setIntake(0)));
    // Extend intake
    JoystickButton js1_b7 = new JoystickButton(js1, 6);
    js1_b7.whenPressed(new InstantCommand(() -> intakeSubsystem.extendIntake()));
    // Contract intake
    JoystickButton js1_b8 = new JoystickButton(js1, 9);
    js1_b8.whenPressed(new InstantCommand(() -> intakeSubsystem.contractIntake()));

    // Indexer up
    JoystickButton js1_b11 = new JoystickButton(js1, 11);
    js1_b11.whenHeld(new StartEndCommand(() -> indexerSubsystem.setIndexer(0.7), () -> indexerSubsystem.setIndexer(0), indexerSubsystem), true);
    // Indexer down
    JoystickButton js1_b16 = new JoystickButton(js1, 16);
    js1_b16.whenHeld(new StartEndCommand(() -> indexerSubsystem.setIndexer(-0.7), () -> indexerSubsystem.setIndexer(0), indexerSubsystem), true);
  }

  public Command getAutonomousCommand() {
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
