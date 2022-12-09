package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveWithJoystick extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private Joystick JS;
  private DriveSubsystem driveSubsystem;

  public DriveWithJoystick(Joystick JS, DriveSubsystem driveSubsystem) {
    addRequirements(driveSubsystem);

    this.JS = JS;
    this.driveSubsystem = driveSubsystem;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double x = JS.getRawAxis(0);
    double y = -JS.getRawAxis(1);
    driveSubsystem.setPower(x + y, x - y);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}