package com.akhmed.demo_advertising.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akhmed.demo_advertising.dto.CommentDto;
import com.akhmed.demo_advertising.impl.ICommentService;
import com.akhmed.demo_advertising.mapper.CommentMapper;
import com.akhmed.demo_advertising.model.Comment;
import com.akhmed.demo_advertising.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public List<CommentDto> findAll(Long userId) {
        return commentRepository.findAll().stream().map(commentMapper::toCommentDto).toList();
    }

    @Override
    public CommentDto saveComment(CommentDto commentDto) {
        Comment comment = commentMapper.toComment(commentDto);
        return commentMapper.toCommentDto(commentRepository.save(comment));
    }

}
