package com.ali.blogapp.service;

import com.ali.blogapp.Model.Post;
import com.ali.blogapp.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {


    Post getBlogPostById(long id);

    List<Post> getBlogPosts();

    Post saveBlogPost(Post post);

    void deleteBlogPost(long id);

}
