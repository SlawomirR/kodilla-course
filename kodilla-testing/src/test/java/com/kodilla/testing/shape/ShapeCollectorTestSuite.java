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
    }

    @After
    public void after() {
        System.out.println("\tWe finished test method: " + getTestName().getMethodName());
    }

    @Test
    public void test_1_shouldAddOneFigure() {
        // When
        shapeCollector.addFigure(testingShape);
        // Then
        Assert.assertEquals(1, shapeCollector.getShapeCollectorSize());
    }

    @Test
    public void test_5_shouldRemoveOneFigureAfterAddingItFirst() {
        // When
        shapeCollector.addFigure(testingShape);
        Assert.assertTrue(checkIfThereAreDataToProceed());
        shapeCollector.removeFigure(testingShape);
        // Then
        Assert.assertEquals(0, shapeCollector.getShapeCollectorSize());
    }

    @Test
    public void test_4_shouldReturnFalseForRemovingNonExistingFigure() {
        // When
        shapeCollector.removeFigure(testingShape); // it simulates wrong object
        // Then
        Assert.assertFalse("No such shape to delete!", shapeCollector.removeFigure(testingShape));
    }

    @Test
    public void test_2_shouldReturnProperFigure() {
        // When
        shapeCollector.addFigure(testingShape);
        // Then
        Assert.assertEquals(testingShape, shapeCollector.getFigure(0));
    }

    @Test
    public void test_3_shouldPrintSomeFigureDescription() {
        // When
        shapeCollector.removeFigure(testingShape);
        // Then
        Assert.assertFalse("Description should always give some information!", shapeCollector.showFigures().isEmpty());
    }

    private boolean checkIfThereAreDataToProceed() {
        if (shapeCollector.getShapeCollectorSize() != 0) {
            return true;
        } else {
            System.out.println("\tFirst, make sure that shapeCollector.addFigure() method is working properly to prepare to pass this test!");
            return false;
        }
    }
}
