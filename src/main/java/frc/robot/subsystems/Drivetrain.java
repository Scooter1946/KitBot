// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new drivetrain. */
  TalonFX flMotor, frMotor, brMotor, blMotor;
  public Drivetrain() {
    flMotor = new TalonFX(1);
    frMotor = new TalonFX(3);
    brMotor = new TalonFX(0);
    blMotor = new TalonFX(2);
    flMotor.setInverted(true);
    blMotor.setControl(new Follower(1, false));
    brMotor.setControl(new Follower(3, false));
    //motor id
  }

  /**
   * pass in values ranging from 0 to 1
   * @param forward positive = forward, negative = backward
   * @param turn positive = right, negative = left
   * forward is always some value between 0 and 0.5, as is turn.
   */
  public void move(double forward, double turn){
    flMotor.set((0.5) * (forward + turn));
    frMotor.set((0.5) * (forward - turn));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
