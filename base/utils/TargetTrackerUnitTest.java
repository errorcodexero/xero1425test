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

    //add 64 tests - for 8 cardinal positions around field * the 4 cardinal directions possible at each position.

    //field orientation reference
    /* 
        |-----------------------|
        |                       |
        |          (())         |
        |                       |
        |-----------------------|
    */

    @Test
    public void testTargetTrackerMainCardinalFour() throws Exception {
        // NOTE 
        // this seems like it's doing abs value of the rotation instead of converting it to -90 to +180
        // that's a change we still need to make...

        TargetTracker tt = new TargetTracker(new Translation2d(324, 162)) ;

        // over halfway, up 0
        Assert.assertEquals(90, tt.getRelativeTargetAngle(new Pose2d(324, 0, new Rotation2d(0))), 0.001) ;
        Assert.assertEquals(0, tt.getRelativeTargetAngle(new Pose2d(324, 0, new Rotation2d(Math.PI/2))), 0.001) ;
        Assert.assertEquals(-90, tt.getRelativeTargetAngle(new Pose2d(324, 0, new Rotation2d(Math.PI))), 0.001) ;
        Assert.assertEquals(-180, tt.getRelativeTargetAngle(new Pose2d(324, 0, new Rotation2d(3*Math.PI/2))), 0.001) ;

        // over 0, up halfway
        Assert.assertEquals(0, tt.getRelativeTargetAngle(new Pose2d(0, 162, new Rotation2d(0))), 0.001) ;
        Assert.assertEquals(-90, tt.getRelativeTargetAngle(new Pose2d(0, 162, new Rotation2d(Math.PI/2))), 0.001) ;
        Assert.assertEquals(-180, tt.getRelativeTargetAngle(new Pose2d(0, 162, new Rotation2d(Math.PI))), 0.001) ;
        Assert.assertEquals(-270, tt.getRelativeTargetAngle(new Pose2d(0, 162, new Rotation2d(3*Math.PI/2))), 0.001) ;

        // over to end of field, up halfway
        Assert.assertEquals(180, tt.getRelativeTargetAngle(new Pose2d(648, 162, new Rotation2d(0))), 0.001) ;
        Assert.assertEquals(90, tt.getRelativeTargetAngle(new Pose2d(648, 162, new Rotation2d(Math.PI/2))), 0.001) ;
        Assert.assertEquals(0, tt.getRelativeTargetAngle(new Pose2d(648, 162, new Rotation2d(Math.PI))), 0.001) ;
        Assert.assertEquals(-90, tt.getRelativeTargetAngle(new Pose2d(648, 162, new Rotation2d(3*Math.PI/2))), 0.001) ;

        // over halfway, up to "top" of field
        Assert.assertEquals(-90, tt.getRelativeTargetAngle(new Pose2d(324, 324, new Rotation2d(0))), 0.001) ; 
        Assert.assertEquals(-180, tt.getRelativeTargetAngle(new Pose2d(324, 324, new Rotation2d(Math.PI/2))), 0.001) ; 
        Assert.assertEquals(-270, tt.getRelativeTargetAngle(new Pose2d(324, 324, new Rotation2d(Math.PI))), 0.001) ; 
        Assert.assertEquals(-360, tt.getRelativeTargetAngle(new Pose2d(324, 324, new Rotation2d(3*Math.PI/2))), 0.001) ; 

    }

    @Test
    public void testTargetTrackerDiagonalFour() throws Exception {
        TargetTracker tt = new TargetTracker(new Translation2d(324, 162)) ;
      
        // bottom left
        Assert.assertEquals(26.5651, tt.getRelativeTargetAngle(new Pose2d(0, 0, new Rotation2d(0))), 0.0001) ;
        // Assert.assertEquals(-63.7349, tt.getRelativeTargetAngle(new Pose2d(0, 0, new Rotation2d(Math.PI/2))), 0.0001) ;
        // Assert.assertEquals(26.5651, tt.getRelativeTargetAngle(new Pose2d(0, 0, new Rotation2d(Math.PI))), 0.0001) ;
        // Assert.assertEquals(26.5651, tt.getRelativeTargetAngle(new Pose2d(0, 0, new Rotation2d(3*Math.PI/2))), 0.0001) ;
      
        // top right 
        Assert.assertEquals(-153.4349, tt.getRelativeTargetAngle(new Pose2d(648, 324, new Rotation2d(0))), 0.0001) ;
        // Assert.assertEquals(-153.4349, tt.getRelativeTargetAngle(new Pose2d(648, 324, new Rotation2d(0))), 0.0001) ;
        // Assert.assertEquals(-153.4349, tt.getRelativeTargetAngle(new Pose2d(648, 324, new Rotation2d(0))), 0.0001) ;
        // Assert.assertEquals(-153.4349, tt.getRelativeTargetAngle(new Pose2d(648, 324, new Rotation2d(0))), 0.0001) ;
      
        // top left
        Assert.assertEquals(-26.5651, tt.getRelativeTargetAngle(new Pose2d(0, 324, new Rotation2d(0))), 0.0001) ;
        // Assert.assertEquals(-26.5651, tt.getRelativeTargetAngle(new Pose2d(0, 324, new Rotation2d(0))), 0.0001) ;
        // Assert.assertEquals(-26.5651, tt.getRelativeTargetAngle(new Pose2d(0, 324, new Rotation2d(0))), 0.0001) ;
        // Assert.assertEquals(-26.5651, tt.getRelativeTargetAngle(new Pose2d(0, 324, new Rotation2d(0))), 0.0001) ;
      
        // bottom right
        Assert.assertEquals(153.4349, tt.getRelativeTargetAngle(new Pose2d(648, 0, new Rotation2d(0))), 0.0001) ;
        // Assert.assertEquals(153.4349, tt.getRelativeTargetAngle(new Pose2d(648, 0, new Rotation2d(0))), 0.0001) ;
        // Assert.assertEquals(153.4349, tt.getRelativeTargetAngle(new Pose2d(648, 0, new Rotation2d(0))), 0.0001) ;
        // Assert.assertEquals(153.4349, tt.getRelativeTargetAngle(new Pose2d(648, 0, new Rotation2d(0))), 0.0001) ;
    
    }

}
