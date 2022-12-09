package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexerSubsystem extends SubsystemBase {
	private CANSparkMax indexer = new CANSparkMax(12, MotorType.kBrushless);

	private RelativeEncoder indexerEncoder;

	private SparkMaxPIDController indexerPID;

	private DigitalInput entranceIR = new DigitalInput(0);
	private DigitalInput lowIR = new DigitalInput(1);
	private DigitalInput highIR = new DigitalInput(2);

	private NetworkTableInstance instance = NetworkTableInstance.getDefault();
	private NetworkTable networkTable = instance.getTable("LiveWindow/IndexerSubsystem");
	private NetworkTableEntry ballCountEntry = networkTable.getEntry("ball_count");

	private int ballCount;

	public IndexerSubsystem() {
		indexer.setInverted(false);
		indexer.setClosedLoopRampRate(0.3);
		indexer.setIdleMode(IdleMode.kCoast);

		indexerEncoder = indexer.getEncoder();
		indexerEncoder.setPositionConversionFactor(1);
		indexerEncoder.setVelocityConversionFactor(1);

		indexerPID = indexer.getPIDController();
		indexerPID.setP(0.3);
		indexerPID.setD(0.01);

		ballCount = 1;
	}

	public void setIndexer(double power) {
		indexer.set(power);
	}
	
	public void setBallCount(int count) {
		count = Math.max(count, 0);
		count = Math.min(count, 2);
		ballCount = count;
	}
	
	public int getBallCount() {
		return ballCount;
	}
	
	public boolean getEntranceIR() {
		return !entranceIR.get();
	}

	public boolean getLowIR() {
		return !lowIR.get();
	}

	public boolean getHighIR() {
		return !highIR.get();
	}

	public void disable() {
		indexer.set(0);
	}  

	@Override
	public void periodic() {
		ballCountEntry.setDouble(ballCount);
	}

	@Override
	public void simulationPeriodic() {}
}