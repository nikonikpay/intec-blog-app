package com.ali.blogapp.controller;


import com.ali.blogapp.Model.Post;
import com.ali.blogapp.Model.User;
import com.ali.blogapp.service.PostService;
import com.ali.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/allPosts")
    public ModelAndView listOfUsers() {
        ModelAndView modelAndView = new ModelAndView("post-list");
        List<Post> postList = postService.getBlogPosts();
        modelAndView.addObject("postList", postList);
        return modelAndView;


    }


    @GetMapping("/showPostForm")
    public ModelAndView showPostForm(@RequestParam Long userId) {
        ModelAndView mav = new ModelAndView("create-post-form");
        User user = userService.findById(userId);
        Post newPost = new Post();
        newPost.setUser(user);
        System.out.println(newPost);

        mav.addObject("myPost", newPost);
        return mav;
    }

    @PostMapping("/savePost")
    public String saveEmployee(@ModelAttribute Post post) {
//        User user = userService.findById(userId);
//        post.setUser(user);
        postService.saveBlogPost(post);
        System.out.println(post);
        return "redirect:/list";
    }

    //create blog post
//    @PostMapping("/create")
//    public String createBlogPost(@Valid Post post, BindingResult result, Model model) {
//        //        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
//        //        User currentUser = blogUserService.getBlogUserByUsername(currentUserName);
//        model.addAttribute("currentUser", currentUser);
//        model.addAttribute("blogpost", post);
//        if(result.hasErrors()) {
//            return "blogpost-create";
//        }
//        post.setUser(currentUser);
//
//        blogPostService.saveBlogPost(post);
//        return "redirect:/blogpost";
//    }


}
