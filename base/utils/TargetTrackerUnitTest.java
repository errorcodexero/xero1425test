package org.xero1425.base.utils;

import org.junit.Before;
import org.junit.Test;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import org.junit.Assert;

public class TargetTrackerUnitTest {

    @Before
    public void init() {
    }

    @Test
    public void testTargetTrackerDistance() throws Exception {
        TargetTracker tt = new TargetTracker(new Translation2d(0, 0)) ;
        Assert.assertEquals(70.7106781187, tt.getRelativeTargetDistance(new Pose2d(50, 50, new Rotation2d(2*Math.PI))), 0.0001) ;

        tt = new TargetTracker(new Translation2d(50, 50)) ;
        Assert.assertEquals(70.7106781187, tt.getRelativeTargetDistance(new Pose2d(0, 0, new Rotation2d(2*Math.PI))), 0.0001) ;

        tt = new TargetTracker(new Translation2d(0, 50)) ;
        Assert.assertEquals(70.7106781187, tt.getRelativeTargetDistance(new Pose2d(50, 0, new Rotation2d(2*Math.PI))), 0.0001) ;

        tt = new TargetTracker(new Translation2d(50, 0)) ;
        Assert.assertEquals(70.7106781187, tt.getRelativeTargetDistance(new Pose2d(0, 50, new Rotation2d(2*Math.PI))), 0.0001) ;
    }

    @Test
    public void testTargetTrackerAngleRight() throws Exception {
        TargetTracker tt = new TargetTracker(new Translation2d(324, 162)) ;
        Assert.assertEquals(90, tt.getRelativeTargetAngle(new Pose2d(324, 0, new Rotation2d(0))), 0.001) ;
        Assert.assertEquals(0, tt.getRelativeTargetAngle(new Pose2d(0, 162, new Rotation2d(0))), 0.001) ;
        Assert.assertEquals(180, tt.getRelativeTargetAngle(new Pose2d(648, 162, new Rotation2d(0))), 0.001) ;
        Assert.assertEquals(-90, tt.getRelativeTargetAngle(new Pose2d(324, 324, new Rotation2d(0))), 0.001) ; 
    }

    @Test
    public void testTargetTrackerAngleOther() throws Exception {
        TargetTracker tt = new TargetTracker(new Translation2d(324, 162)) ;
        Assert.assertEquals(26.5651, tt.getRelativeTargetAngle(new Pose2d(0, 0, new Rotation2d(0))), 0.0001) ;
        Assert.assertEquals(-153.4349, tt.getRelativeTargetAngle(new Pose2d(648, 324, new Rotation2d(0))), 0.0001) ;
        Assert.assertEquals(-26.5651, tt.getRelativeTargetAngle(new Pose2d(0, 324, new Rotation2d(0))), 0.0001) ;
        Assert.assertEquals(153.4349, tt.getRelativeTargetAngle(new Pose2d(648, 0, new Rotation2d(0))), 0.0001) ;
    }

    // @Test
    // public void testTargetTrackerAngleOtherComplex() throws Exception {
    //     TargetTracker tt = new TargetTracker(new Translation2d(324, 162)) ;
    //     Assert.assertEquals(-164.3485936, tt.getRelativeTargetAngle(new Pose2d(556, 277, new Rotation2d(0))), 0.0000001) ;
    // }

}
