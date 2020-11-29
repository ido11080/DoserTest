/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.coreCommands.FeederArmCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FeederSubsystem;

public class ActivateFeeder extends CommandBase {
  /**
   * Creates a new ActivateFeeder.
   */

  private final FeederSubsystem feederArm;
  private final double power;

  public ActivateFeeder(FeederSubsystem feederArm, double power) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.feederArm = feederArm;
    this.power = power;
    addRequirements(feederArm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.feederArm.set(power);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.feederArm.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
