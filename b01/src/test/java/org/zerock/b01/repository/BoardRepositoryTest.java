package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.zerock.b01.domain.Board;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Log4j2
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

//    @Test
//    public void testInsert(){
//        IntStream.rangeClosed(1, 100).forEach(i -> {
//            Board board = Board.builder().title("title...")
//                    .content("content...." + i)
//                    .writer("user" + (i % 10)).build();
//
//            Board result = boardRepository.save(board);
//            log.info("BNO: " + result.getBno());
//
//        });
//    }



    @Test
    public void testSelect(){
        Long bno = 100L;

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();
        log.info(board);
    }

    @Test // JUnit 테스트 어노테이션. 이 메서드가 단위 테스트임을 나타냅니다.
    public void testUpdate() {
        Long bno = 100L; // 테스트 할 게시글의 ID를 설정합니다.

        Optional<Board> result = boardRepository.findById(bno); // 해당 ID를 가진 게시글을 찾습니다.

        Board board = result.orElseThrow(); // 게시글이 존재하지 않을 경우, 예외를 발생시킵니다.

        board.change("update.. title 100", "update content 100"); // 게시글의 제목과 내용을 변경합니다.

        boardRepository.save(board); // 변경된 게시글을 저장합니다.
    }


//
//    @Test
//    public void testDelete(){
//        Long  bno = 1L;
//        boardRepository.deleteById(bno);
//    }

    @Test
    public void testPaging(){
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = boardRepository.findAll(pageable);


        log.info("total count: "+result.getTotalElements());


    }


    @Test
    public void testSearch1(){
        PageRequest pageable = PageRequest.of(1, 10, Sort.by("bno").descending());

        boardRepository.search1(pageable);
    }

    @Test
    public void testSearchAll(){
        String[] types = {"t","c","w"};

        String keyword = "1";


        PageRequest pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);



    }

    @Test
    public void testSearchAll2(){
        String[] types = {"t","c","w"};

        String keyword = "1";


        PageRequest pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = boardRepository.searchAll(types, keyword, pageable);



        //total page
        log.info(result.getTotalPages());

        //pag size
        log.info(result.getSize());

        //pagenumber
        log.info(result.getNumber());

        //prev next
        log.info(result.hasPrevious() +": "+ result.hasNext());

        result.getContent().forEach(board -> log.info(board));

    }
}