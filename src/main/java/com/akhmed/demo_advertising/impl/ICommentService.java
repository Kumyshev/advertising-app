package com.akhmed.demo_advertising.impl;

import java.util.List;

import com.akhmed.demo_advertising.dto.CommentDto;

public interface ICommentService {

    public List<CommentDto> findAll(Long userId);

    public CommentDto saveComment(CommentDto commentDto);
}
