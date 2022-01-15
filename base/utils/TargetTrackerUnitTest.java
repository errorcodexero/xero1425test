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
        TargetTracker tt = new TargetTracker(new Translation2d()) ;
        Assert.assertEquals(70.7106781187, tt.getRelativeTargetDistance(new Pose2d(50, 50, new Rotation2d(2*Math.PI))), 0.0001) ;

        // tt = new TargetTracker() ;
        // Assert.assertEquals(12.7279220613, tt.getRelativeTargetAngle(), 0.00001);
    }

    @Test
    public void testTargetTrackerAngle() {

    }

}
