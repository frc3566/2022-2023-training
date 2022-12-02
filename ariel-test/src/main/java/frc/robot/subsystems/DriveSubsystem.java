// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveSubsystem extends SubsystemBase {

  private WPI_TalonSRX left1;
  private WPI_TalonSRX left2;
  private WPI_TalonSRX right1;
  private WPI_TalonSRX right2;

  // Set inverted to false

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    left1 = new WPI_TalonSRX(1);
    left1.setInverted(false);
    // leftController = left1.getPIDController();
    // setControler(leftController);

    left2 = new WPI_TalonSRX(2);
    left2.follow(left1); // Makes this motor mirror left1

    right1 = new WPI_TalonSRX(3);
    right1.setInverted(true);
    // rightController = right1.getPIDController();
    // setControler(rightController);

    right2 = new WPI_TalonSRX(4);
    right2.follow(right1);
  }

  public void setPower(Double leftPower, Double rightPower) {
    left1.set(leftPower);
    left2.set(leftPower);
    right1.set(rightPower);
    right2.set(rightPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

}
