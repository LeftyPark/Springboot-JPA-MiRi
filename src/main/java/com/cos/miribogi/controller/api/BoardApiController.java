package com.cos.miribogi.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.miribogi.config.auth.PrincipalDetail;
import com.cos.miribogi.dto.ResponseDto;
import com.cos.miribogi.model.Board;
import com.cos.miribogi.model.Reply;
import com.cos.miribogi.service.BoardService;

@RestController
public class BoardApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) { // fffffffffffffffffff
        boardService.글쓰기(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // /auth/loginProc를 안만드는 이유 >> 스프링시큐리티가 가로챌 것이기 때문.

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> delete(@PathVariable int id) {
        boardService.글삭제(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board) {
        boardService.글수정(id, board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


    // 컨트롤러에서 데이터를 받을 때 dto를 만들어서 받는게 좋다  >> 이유는?
    // dto를 사용하지 않는 이유는 프로젝트 규모가 작기때문이다 >> 규모가 클수록 dto를 쓰는게 좋다
    @PostMapping("/board/{boardId}/reply")
    public ResponseDto<Integer> replySave(@PathVariable int boardId, @RequestBody Reply reply, @AuthenticationPrincipal PrincipalDetail principal){
        boardService.댓글쓰기(principal.getUser(), boardId, reply);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    
    @DeleteMapping("/board/{boardId}/reply/{id}")
    public ResponseDto<Integer> responseDto(@PathVariable int id){
        System.out.println("댓글삭제------------------------------------------------------------");
        boardService.댓글삭제(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
