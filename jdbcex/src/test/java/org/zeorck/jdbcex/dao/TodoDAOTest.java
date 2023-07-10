package org.zeorck.jdbcex.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.zeorck.jdbcex.domain.TodoVO;
import org.zeorck.jdbcex.dao.TodoDAO;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TodoDAOTest {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception{
        System.out.println("todoDAO.getTime() = " + todoDAO.getTime());
    }


    @Test
    public void testInsert() throws Exception{
        TodoVO todoVo =  TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021,12,31))
                .build();

        todoDAO.insert(todoVo);
    }
    
    @Test
    public void testList() throws Exception{
        List<TodoVO> list = todoDAO.selectAll();
        list.forEach( vo -> System.out.println("vo = " + vo));
    }

    @Test
    public void testSelectOne() throws Exception{
        long tno = 1L;
        TodoVO vo = todoDAO.selectOne(tno);
        System.out.println("vo = " + vo);
    }


    @Test
    @DisplayName("업데이트 테스트")
    public void testUpdateOne() throws Exception{
        TodoVO todoVo =  TodoVO.builder()
                .tno(1L)
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021,12,31))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVo);
    }
}