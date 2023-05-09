package org.zerock.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready(){
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception{
        TodoDTO todoDTO = TodoDTO.builder()
                .title("등록테스트중입니다. 사실 개같은 log test 중임")
                .dueDate(LocalDate.now())
                .build();
        log.info("------------------------------------ "); //테스트코드의 Log4j2설정확인
        log.info(todoDTO);

        todoService.register(todoDTO);
    }
}
