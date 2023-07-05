package org.zerock.todo.service;

import org.zerock.todo.dto.TodoDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum todoService {
    INSTANCE;

    public void register(TodoDTO todoDTO){
        System.out.println("DeBug_______________" + todoDTO);
    }

    public List<TodoDTO> getList(){
        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj( i->{
            /*
            * IntStream.range(0,10): 이 코드는 0부터 9까지의 연속된 정수 스트림을 생성합니다.
            * IntStream.range는 첫 번째 인수(포함)에서 두 번째 인수(미포함)까지의 연속된 정수를 생성하는 메서드입니다.
            * */
            TodoDTO dto = new TodoDTO();
            dto.setTno((long) i);
            dto.setTitle("TODo.."+i);
            dto.setDueDate(LocalDateTime.now());
            /*
            *
            * mapToObj(i -> {...}): mapToObj 메서드는 각 정수 i에 대해 중괄호 {...} 안에 있는 코드를 실행하고,
            * 결과로 생성된 객체를 새로운 스트림으로 변환합니다. 이 코드에서는 새로운 TodoDTO 객체를 생성하고 설정한 후 반환합니다.
            * */
            return dto;
        }).collect(Collectors.toList());
        /*
        * .collect(Collectors.toList()): collect 메서드는 스트림의 요소를 리스트로 모읍니다.
        * Collectors.toList() 메서드는 이 작업을 수행하기 위한 Collector 객체를 제공합니다.
        * */
        return todoDTOS;
    }

    public TodoDTO get(long tno){
        TodoDTO dto = new TodoDTO();

        dto.setTno(tno);
        dto.setTitle("sample");
        dto.setDueDate(LocalDateTime.now());
        dto.setFinished(true);
        return dto;
    }
}
