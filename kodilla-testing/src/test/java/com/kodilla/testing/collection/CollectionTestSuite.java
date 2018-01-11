package com.kodilla.testing.collection;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class CollectionTestSuite {
    private OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
    private ArrayList<Integer> temporaryArrayList = new ArrayList<>();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void before() throws Exception {
        System.out.println(testName.getMethodName() + " ==> started ...");
    }

    @After
    public void after() {
        System.out.println("\tWe have " + temporaryArrayList.size() + " even numbers in new ArrayList.");
        System.out.println(testName.getMethodName() + " ... stopped <==\n");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        ArrayList<Integer> emptyArrayList = new ArrayList<>();
        temporaryArrayList = oddNumbersExterminator.exterminate(emptyArrayList);
        Assert.assertEquals(temporaryArrayList.size(), 0);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        temporaryArrayList = oddNumbersExterminator.exterminate(randomlyGeneratedArrayList(500_000, 10_000));
        Iterator<Integer> iterator = temporaryArrayList.iterator();
        boolean isOdd = false;
        while (iterator.hasNext()) {
            if ((iterator.next() % 2) != 0) {
                isOdd = true;
                break;
            }
        }
        Assert.assertFalse(isOdd);
    }

    private ArrayList<Integer> randomlyGeneratedArrayList(int maxOriginalArraySize, int randomBound) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < maxOriginalArraySize; i++) {
            arrayList.add(random.nextInt(randomBound));
        }
        System.out.println("\tRandomly generated ArrayList size: " + arrayList.size());
        return arrayList;
    }

}
