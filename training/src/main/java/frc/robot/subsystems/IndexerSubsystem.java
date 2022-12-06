package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexerSubsystem extends SubsystemBase {
    private CANSparkMax indexer = new CANSparkMax(12, MotorType.kBrushless);

    private RelativeEncoder indexerEncoder;

    private SparkMaxPIDController indexerPID;

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

    public int getBallCount() {
        return ballCount;
    }

    public void disable() {
        indexer.set(0);
    }  

    @Override
    public void periodic() {
      
    }
  
    @Override
    public void simulationPeriodic() {}
}