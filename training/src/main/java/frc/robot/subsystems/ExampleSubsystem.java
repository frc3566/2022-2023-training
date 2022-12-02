// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ExampleSubsystem extends SubsystemBase {

  private CANSparkMax left1, left2, left3;

  private CANSparkMax right1, right2, right3;

  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {
    right1 = new CANSparkMax(1, MotorType.kBrushless);
    right1.setInverted(true);
    right1 = new CANSparkMax(2, MotorType.kBrushless);
    right2.follow(right1);
    right1 = new CANSparkMax(3, MotorType.kBrushless);
    right3.follow(right1);

    left1 = new CANSparkMax(4, MotorType.kBrushless);
    left1.setInverted(false);
    left2 = new CANSparkMax(5, MotorType.kBrushless);
    left2.follow(left1);
    left3 = new CANSparkMax(6, MotorType.kBrushless);
    left3.follow(left1);
  }

  public void setPower(Double leftPower, Double rightPower) {
    left1.set(leftPower);
    left2.set(leftPower);
    left3.set(leftPower);

    right1.set(rightPower);
    right2.set(rightPower);
    right2.set(rightPower);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
