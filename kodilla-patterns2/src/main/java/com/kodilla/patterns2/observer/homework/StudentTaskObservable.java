package com.kodilla.patterns2.observer.homework;

public interface StudentTaskObservable {
    void registerMentor(MentorsObserver mentorsObserver);
    void notifyMentors();
    void removeMentor(MentorsObserver mentorsObserver);
}
