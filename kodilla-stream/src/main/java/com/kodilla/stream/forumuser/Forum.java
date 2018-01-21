package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUsersList = new ArrayList<>();

    public Forum() {
        forumUsersList.add(new ForumUser(16, "Aichał", 'M', LocalDate.of(1978, 4, 11), 1));
        forumUsersList.add(new ForumUser(15, "Bichał", 'M', LocalDate.of(1989, 5, 10), 2));
        forumUsersList.add(new ForumUser(14, "Cichał", 'M', LocalDate.of(1990, 6, 19), 3));
        forumUsersList.add(new ForumUser(13, "Dichał", 'M', LocalDate.of(1991, 7, 16), 4));
        forumUsersList.add(new ForumUser(12, "Eichał", 'M', LocalDate.of(1992, 8, 12), 5));
        forumUsersList.add(new ForumUser(11, "Fichał", 'M', LocalDate.of(1993, 1, 3), 6));
        forumUsersList.add(new ForumUser(10, "Richał", 'M', LocalDate.of(1994, 2, 21), 7));
        forumUsersList.add(new ForumUser(1, "Gichał", 'M', LocalDate.of(1995, 3, 22), 9));
        forumUsersList.add(new ForumUser(2, "Hichał", 'F', LocalDate.of(1996, 9, 24), 19));
        forumUsersList.add(new ForumUser(3, "Jichał", 'M', LocalDate.of(1997, 9, 25), 0));
        forumUsersList.add(new ForumUser(4, "Kichał", 'F', LocalDate.of(1998, 9, 26), 3));
        forumUsersList.add(new ForumUser(5, "Lichał", 'M', LocalDate.of(1999, 9, 27), 33));
        forumUsersList.add(new ForumUser(6, "Michał", 'F', LocalDate.of(2000, 9, 28), 6));
        forumUsersList.add(new ForumUser(7, "Nichał", 'M', LocalDate.of(2001, 9, 29), 9));
        forumUsersList.add(new ForumUser(8, "Oichał", 'F', LocalDate.of(2002, 9, 20), 4));
        forumUsersList.add(new ForumUser(9, "Pichał", 'M', LocalDate.of(2003, 9, 23), 12));
     }

    public List<ForumUser> getForumUsersList() {
        return new ArrayList<>(forumUsersList);
    }
}
