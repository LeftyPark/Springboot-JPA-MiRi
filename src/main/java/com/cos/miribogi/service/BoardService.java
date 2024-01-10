package com.cos.miribogi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.miribogi.model.Board;
import com.cos.miribogi.model.Reply;
import com.cos.miribogi.model.User;
import com.cos.miribogi.repository.BoardRepository;
import com.cos.miribogi.repository.ReplyRepository;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    public void 글쓰기(Board board, User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);        
    }

   @Transactional(readOnly = true)
    public Page<Board> 글목록(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board 글상세보기(int id) {
        return boardRepository.findById(id).orElseThrow(()-> {
            return new IllegalArgumentException("상세보기 실패 : 해당 아이디를 찾을 수 없음");
        });
    }

    
    @Transactional
    public void 글삭제(int id){
        boardRepository.deleteById(id);
    }
    

    @Transactional
    public void 글수정(int id, Board requestBoard) {
        Board board = boardRepository.findById(id).orElseThrow(()-> {
            return new IllegalArgumentException("수정하기 실패 : 해당 아이디를 찾을 수 없음");
        });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());        

    }


    @Transactional
    public void 댓글쓰기(User user, int boardId, Reply requsetReply){
        
        Board board = boardRepository.findById(boardId).orElseThrow(()->{
            return new IllegalArgumentException("댓글 쓰기 실패 : 게시글 id를 찾을 수 없다");
        });

        requsetReply.setUser(user);
        requsetReply.setBoard(board);

        replyRepository.save(requsetReply);
    }


    @Transactional
    public void 댓글삭제(int replyId) {
        replyRepository.deleteById(replyId);
    }



}
