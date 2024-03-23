package com.stuypulse.robot.commands.auton.GHF;

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

public class FourPieceGHF extends SequentialCommandGroup {

    public FourPieceGHF() {
        addCommands(
            new ParallelCommandGroup(
                new WaitCommand(Auton.SHOOTER_STARTUP_DELAY)
                    .andThen(new ShooterPodiumShot()),

                SwerveDriveToPose.speakerRelative(-45)
                    .withTolerance(0.1, 0.1, 2)
            ),

            new ConveyorShootRoutine()

            // new FollowPathAndIntake("Start to G (GHF)"),
            // new FollowPathAlignAndShoot("G to GShoot (GHF)", SwerveDriveToPose.speakerRelative(-45)),
            // new FollowPathAndIntake("GShoot to H (GHF)"),
            // new FollowPathAlignAndShoot("H to HShoot (HGF)", SwerveDriveToPose.speakerRelative(-45)),
            // new FollowPathAndIntake("HShoot to F (GHF)"),
            // new FollowPathAlignAndShoot("F to Shoot (HGF)", SwerveDriveToPose.speakerRelative(-7))
        );
    }

}