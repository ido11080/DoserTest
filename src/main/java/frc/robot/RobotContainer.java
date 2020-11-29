/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.coreCommands.ElevatorCommands.DebagActivateElevator;
import frc.robot.commands.coreCommands.FeederCommands.ActivateFeeder;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.FeederArmSubsystem;
import frc.robot.subsystems.FeederSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  private final FeederSubsystem feeder;
  private final ElevatorSubsystem elevator;
  private final FeederArmSubsystem arm;
  private final XboxController joystick1;
  private final DriveTrain driveTrain;
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    this.feeder = new FeederSubsystem();
    this.elevator = new ElevatorSubsystem();
    this.arm = new FeederArmSubsystem();
    this.driveTrain = new DriveTrain();
    this.joystick1 = new XboxController(Constants.kJoystick1Port);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //ActivateFeeder button A
    JoystickButton bActivateFeeder = new JoystickButton(this.joystick1, 1);
    bActivateFeeder.whenHeld(new ActivateFeeder(this.feeder, 0.8));

    //DebagActivateElevator button B
    JoystickButton bDebagActivateElevator = new JoystickButton(this.joystick1, 2);
    bDebagActivateElevator.whenHeld(new DebagActivateElevator(this.elevator));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
