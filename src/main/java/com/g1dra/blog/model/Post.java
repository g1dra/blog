package com.g1dra.blog.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
@RedisHash("Posts")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;

    public String title;

    @Length(min = 10)
    @NotNull(message = "Required")
    @Column(columnDefinition = "longtext")
    public String content;
}
