package com.bookmark.models;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class createdBookmark {

    @NotEmpty(message="Title can't be empty")
    private String title;
    @NotEmpty(message="URL can't be empty")
    private String url;
}
