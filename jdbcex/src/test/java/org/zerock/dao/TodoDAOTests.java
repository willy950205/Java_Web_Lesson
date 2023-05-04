package org.zerock.dao;

import lombok.Cleanup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.TodoDAO;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime2());
    }
    @Test
    public void testInsert() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .title("test Title")
                .dueDate(LocalDate.now())
                .build();

        todoDAO.insert(todoVO);
    }
    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach(todoVO -> System.out.println(todoVO));
    }

    @Test
    public void testOne() throws Exception {
        TodoVO todoVO = todoDAO.selectOne(14L);
        System.out.println(todoVO);
    }

    @Test
    public void testUpdateOne() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .finished(true)
                .tno(1L)
                .title("수정된 타이틀")
                .dueDate(LocalDate.of(2021,12,31))
                .finished(true)
                .build();
        todoDAO.updateOne(todoVO);
    }
}
