package com.cos.miribogi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.cos.miribogi.service.BoardService;


//1
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping({ "", "/" })
    public String index(Model model,
            @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("boards", boardService.글목록(pageable));
        return "index";
    }

    //글 작성
    @GetMapping("/board/saveForm")
    public String save() {
        return "board/saveForm";
    }

    //글 상세
    @GetMapping("/board/{id}")
    public String findById(Model model, @PathVariable int id) {
        model.addAttribute("board", boardService.글상세보기(id));
        return "board/detail";
    }

    //글 수정
    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.글상세보기(id));
        return "board/updateForm";
    }
}
