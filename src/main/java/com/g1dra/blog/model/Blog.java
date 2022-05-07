package com.g1dra.blog.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "blogs")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class Blog {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;

    public String title;

    @Length(min = 10)
    @NotNull(message = "Required")
    @Column(columnDefinition = "longtext")
    public String content;
}
