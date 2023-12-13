package com.bookmark.models;

/**
 * Provides a way to map bookmark entity to data transfer object (DTO)
 */

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookmarkMapper {
    public BookmarkDTO toDTO(Bookmark bookmark){
        BookmarkDTO dto = new BookmarkDTO(bookmark.getId(), bookmark.getUrl(), bookmark.getTitle(), bookmark.getCreatedAt());
        return dto;
    }
}
