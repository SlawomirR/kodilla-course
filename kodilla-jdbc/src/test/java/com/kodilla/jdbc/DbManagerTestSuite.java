package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        // Given
        // When
        DbManager dbManager = DbManager.getInstance();
        // Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        // When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        // Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(5, counter);
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        // Given
/*
        Manually added to database to satisfy test:
        insert into POSTS (USER_ID, BODY) values
            (1, 'Post nr 3'),
            (1, 'Post nr 4'),
            (4, 'Second post'),
            (4, 'Third post'); commit;
*/
        DbManager dbManager = DbManager.getInstance();
        // When
        String sqlQuery = "select USERS.FIRSTNAME, USERS.LASTNAME, count(POSTS.BODY) as POSTS_NUMBER\n" +
                "    from USERS, POSTS where USERS.ID = POSTS.USER_ID\n" +
                "    group by USERS.LASTNAME, USERS.FIRSTNAME having count(POSTS.BODY) > 2;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        // Then
        int counter = 0;
        while (resultSet.next()) {
            counter++;
            System.out.println(counter + ". " +
                    resultSet.getString("FIRSTNAME") + ", " +
                    resultSet.getString("LASTNAME") + ", " +
                    resultSet.getInt("POSTS_NUMBER")
            );
        }
        resultSet.close();
        statement.close();
        Assert.assertEquals(2, counter);
    }
}
