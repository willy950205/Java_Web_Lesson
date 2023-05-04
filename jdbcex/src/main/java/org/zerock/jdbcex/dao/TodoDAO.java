package org.zerock.jdbcex.dao;

import lombok.Cleanup;
import org.zerock.jdbcex.domain.TodoVO;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    public String getTime() {
        String now = null;


        // https://codechacha.com/ko/java-try-with-resources/
        // try-with-reason 문법설명
        try (
                Connection connection = ConnectionUtil.INSTANCE.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT NOW()"
                );

                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            resultSet.next();
            now = resultSet.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public String getTime2() throws Exception {
        @Cleanup
        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT NOW()"
        );
        @Cleanup
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }


    public void insert(TodoVO todoVO) throws Exception {
        String sql =
                "INSERT INTO TBL_TODO (title, dueDate, finished)" +
                        "VALUES(?,?,?)";
        @Cleanup
        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, todoVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVO.getDueDate()));
        preparedStatement.setBoolean(3, todoVO.isFinished());

        preparedStatement.executeUpdate();
    }

    public List<TodoVO> selectAll() throws Exception {
        String sql =
                "SELECT * FROM TBL_TODO";
        @Cleanup
        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup
        ResultSet resultSet = preparedStatement.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        while (resultSet.next()) {
            TodoVO todoVO = TodoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .title(resultSet.getString("title"))
                    .finished(resultSet.getBoolean("finished"))
                    .build();

            list.add(todoVO);
        }
        return list;
    }

    public TodoVO selectOne(Long tno) throws Exception {

        String sql =
                "SELECT * FROM TBL_TODO WHERE tno = ?";
        @Cleanup
        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);

        @Cleanup
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        TodoVO todoVO = TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .title(resultSet.getString("title"))
                .build();

        return todoVO;
    }

    public void deleteOne(Long tno) throws Exception {

        String sql =
                "DELETE FROM TBL_TODO WHERE tno = ?";
        @Cleanup
        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        preparedStatement.executeUpdate();
    }

    public void updateOne(TodoVO todoVO) throws Exception {
        String sql =
                "UPDATE TBL_TODO " +
                        "SET title = ?, " +
                        "dueDate = ?, " +
                        "finished = ? " +
                        "WHERE tno = ?";
        @Cleanup
        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, todoVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVO.getDueDate()));
        preparedStatement.setBoolean(3, todoVO.isFinished());
        preparedStatement.setLong(4, todoVO.getTno());

        preparedStatement.executeUpdate();
    }

}
