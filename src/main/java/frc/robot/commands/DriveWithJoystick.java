package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;

public class DriveWithJoystick extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private DriveSubsystem driveSubsystem;
  private Joystick JS;

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
      driveSubsystem.setSparkMaxPower(x + y, x - y);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}