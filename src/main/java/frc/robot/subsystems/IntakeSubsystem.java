package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

	// components
	private CANSparkMax intakeMotor = new CANSparkMax(10, MotorType.kBrushless);
	Solenoid leftSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 2);
  	Solenoid rightSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 4);

	// state variables
	private boolean isExtended;
	private int ballCount;
  
  public IntakeSubsystem() {
		intakeMotor.setInverted(false);
		// sets maximum rate at which the motor controller’s output is allowed to change
		intakeMotor.setClosedLoopRampRate(0.3); 
		// when motor stops, brake will not be activated. keep rolling until momentum runs out
		intakeMotor.setIdleMode(IdleMode.kCoast); 
		isExtended = false;
  }

	public void setIntake(double power) {
		intakeMotor.set(power);
	}

	public void setBallCount(int count) {
		ballCount = count;
	}

	public int getBallCount() {
		return ballCount;
	}

	public void extendIntake() {
		leftSolenoid.set(true);
		rightSolenoid.set(true);
		isExtended = true; // update state
	}

	public void contractIntake() {
		leftSolenoid.set(false);
		rightSolenoid.set(false);
		isExtended = false; // update state
	}

	// TODO is DisabledCommand depracated or something? Why does the import not work

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}