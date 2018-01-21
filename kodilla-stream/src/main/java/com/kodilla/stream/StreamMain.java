package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> mapWithUsersList =
                forum.getForumUsersList().stream()
                .filter(f -> f.getSex() == 'M')
                .filter(f -> 2018 - f.getDateOfBirth().getYear() > 19)
                .filter(f -> f.getPostsQuantity() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, f -> f));

        mapWithUsersList.entrySet().stream().forEach(System.out::println);
    }
}
