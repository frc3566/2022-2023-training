// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//
package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveWithJoystick extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final DriveSubsystem drive;

  private Joystick JS;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveWithJoystick(Joystick joystick, DriveSubsystem driveSubsystem) {
    drive = driveSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
    JS = joystick;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // double x = -JS.getRawAxis(1);
    // double y = JS.getRawAxis(0);
    // double leftPower = (y + x) ;
    // double rightPower = -(y - x);
    double x = JS.getRawAxis(0);
    double y = - JS.getRawAxis(1);
    double leftPower = y + x;
    double rightPower = y - x;

    //double scaleConstant = 1.0;
    //// get y value as speed
    //double speed = JS.getRawAxis(1);
    //// get x value as "direction"
    //double leftPower = JS.getRawAxis(0) + scaleConstant * speed;
    //double rightPower = -1 * JS.getRawAxis(0) + scaleConstant * speed;
    drive.setPower(leftPower, rightPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
