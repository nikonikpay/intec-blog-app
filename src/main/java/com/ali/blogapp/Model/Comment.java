package com.ali.blogapp.Model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Instant;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty(message = "Post can not be empty")
    @Size(min = 10, message = "Comment must be at least 10 characters long")
    @NotBlank(message = "Comment is required")
    private String commentBody;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post commentedToPost;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User toUser;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
