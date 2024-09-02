package com.akhmed.demo_advertising.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akhmed.demo_advertising.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
