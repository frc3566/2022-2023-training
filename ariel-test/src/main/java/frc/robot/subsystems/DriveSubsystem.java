// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends SubsystemBase {

  private CANSparkMax left1;
  private CANSparkMax left2;
  private CANSparkMax left3;
  private CANSparkMax right1;
  private CANSparkMax right2;
  private CANSparkMax right3;

  // Set inverted to false

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    left1 = new CANSparkMax(4, MotorType.kBrushless);
    left1.setInverted(false);;
    // leftController = left1.getPIDController();
    // setControler(leftController);

    left2 = new CANSparkMax(5, MotorType.kBrushless);
    left2.follow(left1); // Makes this motor mirror left1

    left3 = new CANSparkMax(6, MotorType.kBrushless);
    left3.follow(left1);

    right1 = new CANSparkMax(1, MotorType.kBrushless);
    right1.setInverted(true);
    // rightController = right1.getPIDController();
    // setControler(rightController);

    right2 = new CANSparkMax(2, MotorType.kBrushless);
    right2.follow(right1);

    right3 = new CANSparkMax(3, MotorType.kBrushless);
    right3.follow(right1);
  }

  public void setPower(Double leftPower, Double rightPower) {
    left1.set(leftPower);
    left2.set(leftPower);
    left3.set(leftPower);
    right1.set(rightPower);
    right2.set(rightPower);
    right3.set(rightPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

}
