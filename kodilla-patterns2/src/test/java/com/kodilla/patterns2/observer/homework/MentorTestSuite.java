package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class MentorTestSuite {
    @Test
    public void testStudentTaskUpdate() {
        // Given
        Mentor mentorAdPo = new Mentor("Adam", "Polny");
        Mentor mentorPiKo = new Mentor("Piotr", "Koronny");
        StudentTasksQueue michlBlady = new StudentTasksQueue("Michal Blady");
        StudentTasksQueue tomaszGniady = new StudentTasksQueue("Tomasz Gniady");
        StudentTasksQueue grzegorzSniady = new StudentTasksQueue("Grzegorz Sniady");

        michlBlady.registerMentor(mentorAdPo);
        tomaszGniady.registerMentor(mentorAdPo);
        grzegorzSniady.registerMentor(mentorPiKo);
        // When
        michlBlady.sendTask(TaskList.INTRO, "http://example.com/michalBlady/course");
        grzegorzSniady.sendTask(TaskList.STEP2, "http://example.com/grzegorzSniady/course");
        tomaszGniady.sendTask(TaskList.INTRO, "http://example.com/tomaszGniady/course");
        michlBlady.sendTask(TaskList.STEP1, "http://example.com/michalBlady/course");
        grzegorzSniady.sendTask(TaskList.STEP1, "http://example.com/grzegorzSniady/course");
        // Then
        Assert.assertEquals(3, mentorAdPo.getMentorTaskNumber());
        Assert.assertEquals(2, mentorPiKo.getMentorTaskNumber());
    }
}
