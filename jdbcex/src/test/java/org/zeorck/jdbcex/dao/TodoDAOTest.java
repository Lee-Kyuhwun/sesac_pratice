package org.zeorck.jdbcex.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoDAOTest {


    @Test
    public void testInsert() throws Exception{
        TodoVO todoVo =  TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021,12,31))
                .build();

        todoDAO.insert(todoVo)
    }
}