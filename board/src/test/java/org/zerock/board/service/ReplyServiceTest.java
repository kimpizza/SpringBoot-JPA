package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.ReplyDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReplyServiceTest {
    @Autowired
    private ReplyService service;

    @Test
    void testGetList(){ //특정 게시글의 리스트를 가져오기
        Long bno = 100L;
        List<ReplyDTO> replyDTOList = service.getList(bno);
        replyDTOList.forEach(replyDTO -> System.out.println(replyDTO));
    }

}