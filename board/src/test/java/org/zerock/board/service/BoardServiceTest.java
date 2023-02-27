package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;

@SpringBootTest
class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Test
    void testRegister(){ // 게시글 등록
        BoardDTO dto = BoardDTO.builder()
                .title("Test.")
                .content("test")
                .writerEmail("user55@aaa.com")//현재 db에 존재하는 회원 이메일
                .build();
        long bno = boardService.register(dto);
    }

    @Test
    void testList(){
        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for(BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }
    }
    @Test
    void testGet(){ //특정 회원이 작성한 글 모두 가져오기
        Long bno = 100L;
        BoardDTO boardDTO = boardService.get(bno);
        System.out.println(boardDTO);
    }

    //삭제 테스트
    @Test
    void testRemove(){ //
        //삭제 테스트
        Long bno = 3L; // 1번 게시글의 모든 리플 삭제
        boardService.removeWithReplies(bno);
        System.out.println("seccess");
    }

    //수정 테스트
    @Test
    void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(2L)
                .title("수정합니다 제목")
                .content("내용도 수정합니다")
                .build();

        boardService.modify(boardDTO);
    }
}