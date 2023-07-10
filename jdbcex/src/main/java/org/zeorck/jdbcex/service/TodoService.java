package org.zeorck.jdbcex.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zeorck.jdbcex.dao.TodoDAO;
import org.zeorck.jdbcex.domain.TodoVO;
import org.zeorck.jdbcex.dto.TodoDTO;
import org.zeorck.jdbcex.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2
public enum TodoService {

    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();

        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

//        System.out.println("todoVO = " + todoVO);
        log.info(todoVO);
        dao.insert(todoVO);
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("volist---------------");

        List<TodoDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());

        return dtoList;

    }


    public TodoDTO get(Long tno) throws Exception{
        log.info("tno:" + tno);
        TodoVO todoVO = dao.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    public void remove(Long tno) throws Exception{

        log.info("tno : "+ tno);
        dao.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO) throws  Exception{
        log.info("todoDTo : " + todoDTO);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        dao.updateOne(todoVO);
    }

}
