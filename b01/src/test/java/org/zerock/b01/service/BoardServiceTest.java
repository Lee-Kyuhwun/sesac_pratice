package org.zerock.b01.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.dto.BoardDTO;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Log4j2
class BoardServiceTest {

    @Autowired
    private BoardService boardService;



    @Test
    public void testRegister(){
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
                .title("sample title")
                .content("sample content")
                .writer("user00")
                .build();
        Long bno = boardService.register(boardDTO);

        log.info("bno : "+ bno);
    }

    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder().bno(101L).title("update 101").content("update content 101").build();

        boardService.modify(boardDTO);
    }
}