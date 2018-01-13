package com.kodilla.testing.shape;

import junit.extensions.PA;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShapeCollectorTestSuite {
    private TestName testName = new TestName();
    private ShapeCollector shapeCollector = new ShapeCollector();
    private Shape testingShape = new Square(3,4);
    private ArrayList<Shape> reflectedShapeCollector = new ArrayList<>();

    @Rule
    public TestName getTestName() {
        return testName;
    }

    @Before
    public void before() {
        System.out.println("We are proceeding test method: " + getTestName().getMethodName());
        showCurrentWorkingValues();
        if ( ! filledOrEmptyCheck()) { shapeCollector.addFigure(testingShape); }
    }

    @After
    public void after() {
        showCurrentWorkingValues();
        System.out.println("We finished test method: " + getTestName().getMethodName());
    }

    @Test
    public void testT1AddFigure() {
        reflectedShapeCollector = (ArrayList<Shape>) PA.getValue(shapeCollector, "shapeCollector");
        Assert.assertTrue(reflectedShapeCollector.size() > 0);
    }

    @Test
    public void testT6RemoveFigure() {
        shapeCollector.removeFigure(testingShape);
        reflectedShapeCollector = (ArrayList<Shape>) PA.getValue(shapeCollector, "shapeCollector");
        Assert.assertEquals(0, reflectedShapeCollector.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testT7RemoveFigureException() {
        shapeCollector.removeFigure(testingShape);
        shapeCollector.removeFigure(testingShape); // it simulates wrong object
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testT2GetFigure() {
        shapeCollector.getFigure(-1);
    }

    @Test
    public void testT3GetFigure() {
        Shape whatIsTheFirstAddedShape = shapeCollector.getFigure(0);
        Assert.assertEquals(testingShape, whatIsTheFirstAddedShape);
    }

    @Test
    public void testT5ShowFigures() {
        shapeCollector.removeFigure(testingShape);
        Assert.assertNotEquals("Unexpected empty string!", "", shapeCollector.showFigures());
    }

    @Test
    public void testT4ShowFigures() {
        Assert.assertNotEquals("Unexpected null value!", null, shapeCollector.showFigures());
    }

    private void showCurrentWorkingValues() {
        System.out.println("\t" + getTestName().getMethodName() + " value: " + ((ArrayList<Shape>) PA.getValue(shapeCollector, "shapeCollector")));
    }

    private boolean filledOrEmptyCheck() {
        if (((ArrayList<Shape>) PA.getValue(shapeCollector, "shapeCollector")).size() != 0) {
            return true;
        } else {
            System.out.println("First, make sure that shapeCollector.addFigure() method is working properly to pass this test!");
            return false;
        }
    }
}
