package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task makeTask(final String taskName) {
        switch (taskName) {
            case SHOPPING_TASK:
                return new ShoppingTask("Food", "Butter", 2);
            case PAINTING_TASK:
                return new PaintingTask("Paint", "blue", "living room");
            case DRIVING_TASK:
                return new DrivingTask("Morning", "School", "Bus");
            default:
                System.out.println("Bad name. No task created, NULL value returned!");
                return null;
        }
    }
}
