/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.TeleopDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;


/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Talon leftFrontTalon = null;
  Talon leftBackTalon = null;
  Talon rightFrontTalon = null;
  Talon rightBackTalon = null;

  DifferentialDrive differentialDrive = null;


  public DriveTrain() {
    leftFrontTalon = new Talon(0);
    leftBackTalon = new Talon(1);
    rightFrontTalon = new Talon(2);
    rightBackTalon = new Talon(3);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontTalon, leftBackTalon);      //sol motorları gruplandırarak kontrol yönetimi sağladık
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontTalon, rightBackTalon);   //sağ motorlar için de aynı şeyleri yapptık

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);     //DifferantialDrive construct'ını oluşturduk
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed){        //differantialDrive için arcadeDrive methodu oluşturduk başka Drive türleri de vardır
    differentialDrive.arcadeDrive(moveSpeed,rotateSpeed);
  }




  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new TeleopDrive());
  }
}
