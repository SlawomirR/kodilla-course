package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {
    private final int userId;
    private final String userName;
    private final char sex; //‘M’/’F’
    private final LocalDate dateOfBirth;
    private final int postsQuantity;

    ForumUser(final int userId, final String userName, final char sex, LocalDate dateOfBirth, final int postsQuantity) {
        this.userId = userId;
        this.userName = userName;
        if (sex == 'M' || sex == 'F') {
            this.sex = sex;
        } else {
            System.err.println("Expected values are: M or F");
            this.sex = sex;

        }
        this.dateOfBirth = dateOfBirth;
        this.postsQuantity = postsQuantity;
    }

    public int getUserId() {
        return userId;
    }

   public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostsQuantity() {
        return postsQuantity;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", postsQuantity=" + postsQuantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return userId == forumUser.userId &&
                sex == forumUser.sex &&
                postsQuantity == forumUser.postsQuantity &&
                Objects.equals(userName, forumUser.userName) &&
                Objects.equals(dateOfBirth, forumUser.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, sex, dateOfBirth, postsQuantity);
    }
}
