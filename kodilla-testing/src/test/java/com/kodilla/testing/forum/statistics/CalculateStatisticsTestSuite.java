package com.kodilla.testing.forum.statistics;

import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculateStatisticsTestSuite {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("\t\tStarting tests for calculateAdvStatistics() method of the CalculateStatistics class ...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("\t\tAll tests for calculateAdvStatistics() method of the CalculateStatistics class finished.");
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void before() {
        System.out.println("\tBeginning: " + testName.getMethodName());
    }

    @After
    public void after() {
        System.out.println("\tFinished: " + testName.getMethodName());
    }

    @Test
    public void test_07_Users0_Posts0_Comments0() {
        // Given
        int userTestNumbers = 0;
        int postsTestCount=0;
        int commentsTestCount=0;
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>(Collections.nCopies(userTestNumbers, "Jan Kowalski"));
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsTestCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsTestCount);

        // When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        calculateStatistics.ShowStatistics();
        Assert.assertEquals("Average number of posts per user.", 0, calculateStatistics.getAveragePostsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per user.", 0, calculateStatistics.getAverageCommentsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per post.", 0, calculateStatistics.getAverageCommentsNumberPerPost(), 0);
        Assert.assertEquals("If not true then check this test calculation first!", calculateStatistics.getAverageCommentsNumberPerUser(), (calculateStatistics.getAveragePostsNumberPerUser() * calculateStatistics.getAverageCommentsNumberPerPost()), 0);
    }

    @Test
    public void test_06_Users0_Posts0_Comments100() {
        // Given
        int userTestNumbers = 0;
        int postsTestCount=0;
        int commentsTestCount=100;
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>(Collections.nCopies(userTestNumbers, "Jan Kowalski"));
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsTestCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsTestCount);

        // When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        calculateStatistics.ShowStatistics();
        Assert.assertEquals("Average number of posts per user.", 0, calculateStatistics.getAveragePostsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per user.", 0, calculateStatistics.getAverageCommentsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per post.", 0, calculateStatistics.getAverageCommentsNumberPerPost(), 0);
        Assert.assertEquals("If not true then check this test calculation first!", calculateStatistics.getAverageCommentsNumberPerUser(), (calculateStatistics.getAveragePostsNumberPerUser() * calculateStatistics.getAverageCommentsNumberPerPost()), 0);
    }

    @Test
    public void test_05_Users0_Posts1000_Comments100() {
        // Given
        int userTestNumbers = 0;
        int postsTestCount=1_000;
        int commentsTestCount=100;
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>(Collections.nCopies(userTestNumbers, "Jan Kowalski"));
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsTestCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsTestCount);

        // When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        calculateStatistics.ShowStatistics();
        Assert.assertEquals("Average number of posts per user.", 0, calculateStatistics.getAveragePostsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per user.", 0, calculateStatistics.getAverageCommentsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per post.", 0, calculateStatistics.getAverageCommentsNumberPerPost(), 0);
        Assert.assertEquals("If not true then check this test calculation first!", calculateStatistics.getAverageCommentsNumberPerUser(), (calculateStatistics.getAveragePostsNumberPerUser() * calculateStatistics.getAverageCommentsNumberPerPost()), 0);
    }

    @Test
    public void test_04_Users100_Posts0_Comments100() {
        // Given
        int userTestNumbers = 100;
        int postsTestCount=0;
        int commentsTestCount=100;
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>(Collections.nCopies(userTestNumbers, "Jan Kowalski"));
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsTestCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsTestCount);

        // When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        calculateStatistics.ShowStatistics();
        Assert.assertEquals("Average number of posts per user.", 0, calculateStatistics.getAveragePostsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per user.", 0, calculateStatistics.getAverageCommentsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per post.", 0, calculateStatistics.getAverageCommentsNumberPerPost(), 0);
        Assert.assertEquals("If not true then check this test calculation first!", calculateStatistics.getAverageCommentsNumberPerUser(), (calculateStatistics.getAveragePostsNumberPerUser() * calculateStatistics.getAverageCommentsNumberPerPost()), 0);
    }

    @Test
    public void test_03_Users100_Posts10_Comments0() {
        // Given
        int userTestNumbers = 100;
        int postsTestCount=10;
        int commentsTestCount=0;
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>(Collections.nCopies(userTestNumbers, "Jan Kowalski"));
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsTestCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsTestCount);

        // When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        calculateStatistics.ShowStatistics();
        Assert.assertEquals("Average number of posts per user.", 0.1, calculateStatistics.getAveragePostsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per user.", 0, calculateStatistics.getAverageCommentsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per post.", 0, calculateStatistics.getAverageCommentsNumberPerPost(), 0);
        Assert.assertEquals("If not true then check this test calculation first!", calculateStatistics.getAverageCommentsNumberPerUser(), (calculateStatistics.getAveragePostsNumberPerUser() * calculateStatistics.getAverageCommentsNumberPerPost()), 0);
    }

    @Test
    public void test_02_Users100_Posts1000_Comments100() {
        // Given
        int userTestNumbers = 100;
        int postsTestCount=1_000;
        int commentsTestCount=100;
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>(Collections.nCopies(userTestNumbers, "Jan Kowalski"));
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsTestCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsTestCount);

        // When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        calculateStatistics.ShowStatistics();
        Assert.assertEquals("Average number of posts per user.", 10, calculateStatistics.getAveragePostsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per user.", 1, calculateStatistics.getAverageCommentsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per post.", 0.1, calculateStatistics.getAverageCommentsNumberPerPost(), 0);
        Assert.assertEquals("If not true then check this test calculation first!", calculateStatistics.getAverageCommentsNumberPerUser(), (calculateStatistics.getAveragePostsNumberPerUser() * calculateStatistics.getAverageCommentsNumberPerPost()), 0);
    }

    @Test
    public void test_01_Users100_Posts1000_Comments10() {
        // Given
        int userTestNumbers = 100;
        int postsTestCount=1_000;
        int commentsTestCount=10;
        CalculateStatistics calculateStatistics = new CalculateStatistics();

        Statistics statisticsMock = mock(Statistics.class);
        List<String> usersNames = new ArrayList<>(Collections.nCopies(userTestNumbers, "Jan Kowalski"));
        when(statisticsMock.usersNames()).thenReturn(usersNames);
        when(statisticsMock.postsCount()).thenReturn(postsTestCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsTestCount);

        // When
        calculateStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        calculateStatistics.ShowStatistics();
        Assert.assertEquals("Average number of posts per user.", 10, calculateStatistics.getAveragePostsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per user.", 0.1, calculateStatistics.getAverageCommentsNumberPerUser(), 0);
        Assert.assertEquals("Average number of comments per post.", 0.01, calculateStatistics.getAverageCommentsNumberPerPost(), 0);
        Assert.assertEquals("If not true then check this test calculation first!", calculateStatistics.getAverageCommentsNumberPerUser(), (calculateStatistics.getAveragePostsNumberPerUser() * calculateStatistics.getAverageCommentsNumberPerPost()), 0);
    }
}
