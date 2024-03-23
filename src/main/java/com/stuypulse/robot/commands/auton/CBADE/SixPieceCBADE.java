package com.stuypulse.robot.commands.auton.CBADE;

import com.stuypulse.robot.commands.auton.FollowPathAlignAndShoot;
import com.stuypulse.robot.commands.auton.FollowPathAndIntake;
import com.stuypulse.robot.commands.conveyor.ConveyorShootRoutine;
import com.stuypulse.robot.commands.shooter.ShooterPodiumShot;
import com.stuypulse.robot.commands.swerve.SwerveDriveToPose;
import com.stuypulse.robot.commands.swerve.SwerveDriveToShoot;
import com.stuypulse.robot.constants.Settings.Auton;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class SixPieceCBADE extends SequentialCommandGroup {

    public SixPieceCBADE() {
        addCommands(
            new ParallelCommandGroup(
                new WaitCommand(Auton.SHOOTER_STARTUP_DELAY)
                    .andThen(new ShooterPodiumShot()),
                
                SwerveDriveToPose.speakerRelative(-45)
            ),

            new ConveyorShootRoutine()

            // new FollowPathAndIntake("First Piece to C"),
            // new SwerveDriveToShoot(2.9)
            //     .withTolerance(0.1, 5),
            // new ConveyorShootRoutine(),

            // new FollowPathAndIntake("C to B"),
            // SwerveDriveToPose.speakerRelative(5),
            // new ConveyorShootRoutine(),

            // new FollowPathAndIntake("B to A"),
            // SwerveDriveToPose.speakerRelative(35),
            // new ConveyorShootRoutine(),

            // new FollowPathAndIntake("A to D"),
            // new FollowPathAlignAndShoot("D to Shoot", SwerveDriveToPose.speakerRelative(30)),

            // new FollowPathAndIntake("A to E"),
            // new FollowPathAlignAndShoot("E to Shoot", SwerveDriveToPose.speakerRelative(30))
        );
    }
    
}