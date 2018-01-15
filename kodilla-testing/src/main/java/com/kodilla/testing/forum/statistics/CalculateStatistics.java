package com.kodilla.testing.forum.statistics;

import java.util.List;
import java.util.Objects;

public class CalculateStatistics {
    private int usersNumber;
    private int postsNumber;
    private int commentsNumber;
    private double averagePostsNumberPerUser;
    private double averageCommentsNumberPerUser;
    private double averageCommentsNumberPerPost;

    private void setUsersNumber(List<String> usersNumber) {
        if (Objects.isNull(usersNumber)) throw new IllegalArgumentException("The List needs to be initialized!");
        this.usersNumber = usersNumber.size();
    }
    private void setPostsNumber(int postsNumber) {
        if (postsNumber < 0) throw new IllegalArgumentException("Positive value expected!");
        this.postsNumber = postsNumber;
    }

    private void setCommentsNumber(int commentsNumber) {
        if (postsNumber < 0) throw new IllegalArgumentException("Positive value expected!");
        this.commentsNumber = commentsNumber;
    }

    double getAveragePostsNumberPerUser() {
        return averagePostsNumberPerUser;
    }

    double getAverageCommentsNumberPerUser() {
        return averageCommentsNumberPerUser;
    }

    double getAverageCommentsNumberPerPost() {
        return averageCommentsNumberPerPost;
    }

    void calculateAdvStatistics(Statistics statistics) {
        setUsersNumber(statistics.usersNames());
        setPostsNumber(statistics.postsCount());
        setCommentsNumber(statistics.commentsCount());
        if(usersNumber == 0 || postsNumber == 0) {
            averagePostsNumberPerUser = 0;
            averageCommentsNumberPerUser = 0;
            averageCommentsNumberPerPost = 0;
        } else {
            averagePostsNumberPerUser = ((double) postsNumber) / usersNumber;
            averageCommentsNumberPerUser = ((double) commentsNumber) / usersNumber;
            averageCommentsNumberPerPost = ((double) commentsNumber) / postsNumber;
        }
    }

    void ShowStatistics() {
        System.out.println("Our statistics are:");
        System.out.println("Collected: (users: " + usersNumber + ", posts: " + postsNumber + ", comments: " + commentsNumber + ")");
        System.out.println("Average number of posts per user:    " + getAveragePostsNumberPerUser());
        System.out.println("Average number of comments per user: " + getAverageCommentsNumberPerUser());
        System.out.println("Average number of comments per post: " + getAverageCommentsNumberPerPost());
    }
}
