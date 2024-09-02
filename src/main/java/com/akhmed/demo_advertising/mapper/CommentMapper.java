package com.akhmed.demo_advertising.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.akhmed.demo_advertising.dto.CommentDto;
import com.akhmed.demo_advertising.model.Comment;

@Mapper
public interface CommentMapper {

    @Mapping(target = "id", ignore = true)
    CommentDto toCommentDto(Comment car);

    Comment toComment(CommentDto commentDto);
}
