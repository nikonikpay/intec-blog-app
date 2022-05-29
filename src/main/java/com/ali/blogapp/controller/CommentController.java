package com.ali.blogapp.controller;

import com.ali.blogapp.Model.Comment;
import com.ali.blogapp.Model.Post;
import com.ali.blogapp.repository.CommentsRepository;
import com.ali.blogapp.service.CommentService;
import com.ali.blogapp.service.PostService;
import com.ali.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;


//    @GetMapping("/allCommentsOf")
//    public ModelAndView listOfComments(@RequestParam Long postId) {
//        ModelAndView modelAndView = new ModelAndView("post-list");
//        List<Comment> commentList = commentService.getBlogPostCommentById(postId);
//        modelAndView.addObject("postList", commentList);
//        return modelAndView;
//
//
//    }

    @GetMapping("/showCommentForm")
    public ModelAndView showPostForm(@RequestParam Long postId) {
        ModelAndView mav = new ModelAndView("create-comment-form");

        Post post = postService.getBlogPostById(postId);

        Comment newComment = new Comment();
        newComment.setToUser(post.getUser());
        newComment.setCommentedToPost(post);
        System.out.println(newComment);
        mav.addObject("myComment", newComment);
        return mav;
    }


    @PostMapping("/saveComment")
    public String saveEmployee(@ModelAttribute Comment comment) {

        commentService.createComment(comment);
        System.out.println(comment);
        return "redirect:/list";
    }

}
