package com.ali.blogapp.service;

import com.ali.blogapp.Model.Comment;
import com.ali.blogapp.Model.Post;

import java.util.List;
public interface CommentService {

    List<Comment> getAllPostComments(Post postId);

    Comment getBlogPostCommentById(long id);

    Comment createComment(Comment comment);

    void deleteComment(long id);




}
