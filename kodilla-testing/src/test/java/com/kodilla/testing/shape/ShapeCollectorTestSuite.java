package com.kodilla.testing.shape;

import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShapeCollectorTestSuite {
    private TestName testName = new TestName();
    // Given
    private ShapeCollector shapeCollector = new ShapeCollector();
    private Shape testingShape = new Square(3,4);

    @Rule
    public TestName getTestName() {
        return testName;
    }

    @Before
    public void before() {
        System.out.println("We are proceeding test method: " + getTestName().getMethodName());
        showCurrentWorkingValues();
        // When
        if ( ! filledOrEmptyCheck()) { shapeCollector.addFigure(testingShape); }
    }

    @After
    public void after() {
        showCurrentWorkingValues();
        System.out.println("We finished test method: " + getTestName().getMethodName());
    }

    @Test
    public void test_1_AddFigure() {
        // Then
        Assert.assertTrue(shapeCollector.getShapeCollectorSize() > 0);
    }

    @Test
    public void test_6_RemoveFigure() {
        // When
        shapeCollector.removeFigure(testingShape);
        // Then
        Assert.assertEquals(0, shapeCollector.getShapeCollectorSize());
    }

    @Test
    public void test_7_RemoveFigureException() {
        // When
        shapeCollector.removeFigure(testingShape);
        shapeCollector.removeFigure(testingShape); // it simulates wrong object
        // Then
        System.out.println();
        Assert.assertFalse("No such shape to delete!", shapeCollector.removeFigure(testingShape));
    }

    // Then
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_2_GetFigure() {
        // When
        shapeCollector.getFigure(-1);
    }

    @Test
    public void test_3_GetFigure() {
        // When
        Shape whatIsTheFirstAddedShape = shapeCollector.getFigure(0);
        // Then
        Assert.assertEquals(testingShape, whatIsTheFirstAddedShape);
    }

    @Test
    public void test_5_ShowFigures() {
        // When
        shapeCollector.removeFigure(testingShape);
        // Then
        Assert.assertNotEquals("Unexpected empty string!", "", shapeCollector.showFigures());
    }

    @Test
    public void test_4_ShowFigures() {
        // Then
        Assert.assertNotEquals("Unexpected null value!", null, shapeCollector.showFigures());
    }

    private void showCurrentWorkingValues() {
        System.out.println("\t" + getTestName().getMethodName() + " value: " + shapeCollector.getShapeCollectorSize());
    }

    private boolean filledOrEmptyCheck() {
        if (shapeCollector.getShapeCollectorSize() != 0) {
            return true;
        } else {
            System.out.println("First, make sure that shapeCollector.addFigure() method is working properly to pass this test!");
            return false;
        }
    }
}
