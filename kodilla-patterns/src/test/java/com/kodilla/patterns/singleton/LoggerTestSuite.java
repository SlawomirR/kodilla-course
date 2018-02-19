package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLastLog() {
        // Given
        String logInfo = "Check this point.";
        // When
        Logger.getInstance().log(logInfo);
        // Then
        Assert.assertTrue(Logger.getInstance().getLastLog().length() > 0);
    }
}
