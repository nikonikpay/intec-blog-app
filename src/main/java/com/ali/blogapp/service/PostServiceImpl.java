package com.ali.blogapp.service;

import com.ali.blogapp.Model.Post;
import com.ali.blogapp.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class PostServiceImpl implements PostService{


    private PostRepository blogPostRepository;

    @Autowired
    public void setBlogPostRepository(PostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public Post getBlogPostById(long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getBlogPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public Post saveBlogPost(Post post) {
        return blogPostRepository.save(post);
    }

    @Override
    public void deleteBlogPost(long id) {

        blogPostRepository.deleteById(id);
        log.info("Blog post deleted with id: " + id);

    }
}
