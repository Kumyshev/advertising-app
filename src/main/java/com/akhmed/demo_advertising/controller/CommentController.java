package com.akhmed.demo_advertising.controller;

import org.springframework.web.bind.annotation.RestController;

import com.akhmed.demo_advertising.dto.CommentDto;
import com.akhmed.demo_advertising.impl.ICommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/comments")
@RequiredArgsConstructor
public class CommentController {

    private final ICommentService commentService;

    @PostMapping("/{userId}")
    public CommentDto saveComment(@Valid @RequestBody CommentDto commentDto,
            @RequestParam Long userId) {
        commentDto.setUserId(userId);
        return commentService.saveComment(commentDto);
    }

    @GetMapping("/{userId}")
    public List<CommentDto> findAll(@RequestParam Long userId) {
        return commentService.findAll(userId);
    }

    @GetMapping
    public String get(@RequestParam Map<String, String> allParams) {
        return "aaaa";
    }

}
