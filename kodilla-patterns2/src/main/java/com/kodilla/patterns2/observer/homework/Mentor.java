package com.kodilla.patterns2.observer.homework;

public class Mentor implements MentorsObserver {
    private String firstName;
    private String lastName;
    private int mentorTaskNumber = 0;

    Mentor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    int getMentorTaskNumber() {
        return mentorTaskNumber;
    }

    @Override
    public void changeTaskStatus(StudentTasksQueue studentTasksQueue) {
        mentorTaskNumber++;
        System.out.println(firstName + " " + lastName + ": New tasks to check. Total: "
                + mentorTaskNumber + "; Sent email notification.");
    }
}
