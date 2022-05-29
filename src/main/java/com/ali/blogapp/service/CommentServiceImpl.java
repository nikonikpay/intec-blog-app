package com.ali.blogapp.service;

import com.ali.blogapp.Model.Comment;
import com.ali.blogapp.Model.Post;
import com.ali.blogapp.repository.CommentsRepository;
import com.ali.blogapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentsRepository blogCommentRepository;


    @Autowired
    public void setBlogPostRepository(CommentsRepository blogCommentRepository ) {
        this.blogCommentRepository = blogCommentRepository;

    }


    @Override
    public List<Comment> getAllPostComments(Post postId) {
        return null;
    }

    public Comment getBlogPostCommentById(long id) {
        return blogCommentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findByCommentedToPost(Post post) {
        return blogCommentRepository.findByCommentedToPost(post);
    }

    @Override
    public Comment createComment(Comment comment) {
        return blogCommentRepository.save(comment);
    }

    @Override
    public void deleteComment(long id) {

    }
}
