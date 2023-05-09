package org.zerock.w2.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO todoDAO;
    private ModelMapper modelMapper;

    TodoService() {
        todoDAO = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(TodoDTO todoDTO) throws Exception {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoDAO.insert(todoVO);
    }

    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        log.info("voList................");

        List<TodoDTO> returnData = list.stream()
                .map(todoVO -> modelMapper.map(todoVO, TodoDTO.class))
                .collect(Collectors.toList());

        return returnData;
    }

    public TodoDTO get(Long tno) throws Exception {
        log.info("tno: " + tno);
        TodoVO todoVO = todoDAO.selectOne(tno);
        TodoDTO returnData = modelMapper.map(todoVO, TodoDTO.class);
        return returnData;

    }

    public void remove(Long tno) throws Exception {
        log.info("tno: " + tno);
        todoDAO.deleteOne(tno);
    }
    public void modify(TodoDTO todoDTO) throws Exception {
        log.info("todoDTO: " + todoDTO );
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoDAO.updateOne(todoVO);
    }



}
