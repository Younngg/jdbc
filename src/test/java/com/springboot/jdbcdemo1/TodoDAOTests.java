package com.springboot.jdbcdemo1;

import com.springboot.jdbcdemo1.dao.TodoDAO;
import com.springboot.jdbcdemo1.domain.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception{
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021,12,21))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testSelectOne() throws Exception{
        Long tno = 1L;
        TodoVO todoVO = todoDAO.selectOne(tno);
        System.out.println(todoVO);

    }

    @Test
    public void testUpdateOne() throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Sample title....")
                .dueDate(LocalDate.of(2021, 12, 31))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }

    @Test
    public void testList() throws Exception{
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }
}
