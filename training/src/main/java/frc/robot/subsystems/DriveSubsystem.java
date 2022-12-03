// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSubsystem extends SubsystemBase {

  private CANSparkMax sparkLeft1, sparkLeft2, sparkLeft3;

  private CANSparkMax sparkRight1, sparkRight2, sparkRight3;

  // private WPI_TalonSRX talonLeft1, talonLeft2;
  // private WPI_TalonSRX talonRight1, talonRight2;

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem(String motorType) {
    if (motorType.equals("SparkMax")) {
      setSparkMax();
    } else if (motorType.equals("TalonSRX")) {
      setTalonSRX();
    }
  }

  public void setSparkMax() {
    sparkLeft1 = new CANSparkMax(1, MotorType.kBrushless);
    sparkLeft1.setInverted(false);
    sparkLeft2 = new CANSparkMax(2, MotorType.kBrushless);
    sparkLeft2.follow(sparkLeft1);
    sparkLeft3 = new CANSparkMax(3, MotorType.kBrushless);
    sparkLeft3.follow(sparkLeft1);

    sparkRight1 = new CANSparkMax(4, MotorType.kBrushless);
    sparkRight1.setInverted(true);
    sparkRight2 = new CANSparkMax(5, MotorType.kBrushless);
    sparkRight2.follow(sparkRight1);
    sparkRight3 = new CANSparkMax(6, MotorType.kBrushless);
    sparkRight3.follow(sparkRight1);
  }

  public void setTalonSRX() {
    // talonLeft1 = new WPI_TalonSRX(1);
    // setTalon(talonLeft1, true);
    // talonLeft2 = new WPI_TalonSRX(2);
    // talonLeft2.follow(talonLeft1);
    
    // talonRight1 = new WPI_TalonSRX(3);
    // setTalon(talonRight1, true);
    // talonRight2 = new WPI_TalonSRX(4);
    // talonRight2.follow(talonRght1);
  }

  public void setSparkMaxPower(Double leftPower, Double rightPower) {
    sparkLeft1.set(leftPower);
    sparkLeft2.set(leftPower);
    sparkLeft3.set(leftPower);

    sparkRight1.set(rightPower);
    sparkRight2.set(rightPower);
    sparkRight3.set(rightPower);
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
