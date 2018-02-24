package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        // Given
        User mF = new Millenials("Millenials Facebook");
        User yT = new YGeneration("YGeneration Twitter");
        User zS = new ZGeneration("ZGeneration Snapchat");
        // When
        String mFSentThrough = mF.sharePost();
        System.out.println("Millenials  Facebook: " + mFSentThrough);
        String yTSentThrough = yT.sharePost();
        System.out.println("YGeneration  Twitter: " + yTSentThrough);
        String zSSentThrough = zS.sharePost();
        System.out.println("ZGeneration Snapchat: " + zSSentThrough);
        // Then
        Assert.assertEquals(">>Facebook<< connecting ... and sending post.", mFSentThrough);
        Assert.assertEquals(">>Twitter<<< connecting ... and sending post.", yTSentThrough);
        Assert.assertEquals(">>Snapchat<< connecting ... and sending post.", zSSentThrough);
    }

    @Test
    public void testIndividualSharingStrategy() {
        // Given
        User mF = new Millenials("Millenials Facebook");
        // When
        String mFSentThrough = mF.sharePost();
        System.out.println("Millenials  Facebook: " + mFSentThrough);
        mF.setPrefferedMedia(new SnapchatPublisher());
        mFSentThrough = mF.sharePost();
        System.out.println("Millenials Facebook?: " + mFSentThrough);
        // Then
        Assert.assertEquals(">>Snapchat<< connecting ... and sending post.", mFSentThrough);
    }
}
