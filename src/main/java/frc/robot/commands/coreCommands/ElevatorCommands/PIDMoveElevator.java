/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.coreCommands.ElevatorCommands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class PIDClimpUpElevator extends CommandBase {
  private final ElevatorSubsystem elevator;
  private final int target;
  private int distance;
  private final int tolerance;
  private final double kp;
  private final double kd;
  private final double ki;
  private final int kf;
  /**
   * Creates a new PIDClimpUpElevator.
   */
  public PIDClimpUpElevator(ElevatorSubsystem elevator, int target, double kp, double ki, double kd, int tolerance, int kf) {
    this.elevator = elevator;
    this.target = target;
    this.kp = kp;
    this.ki = ki;
    this.kd = kd;
    this.kf = kf;
    this.tolerance = tolerance;
    addRequirements(elevator);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.elevator.configPIDSlot(kp,ki,kd,kf,elevator.getPIDSlotID)
    this.elevator.setPosition(this.target);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.distance = Math.abs(target - this.elevator.getPosition());
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.elevator.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   return this.distance <= this.tolerance;
  }
}
