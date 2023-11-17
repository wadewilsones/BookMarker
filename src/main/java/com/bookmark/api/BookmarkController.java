package com.bookmark.api;

import com.bookmark.models.Bookmark;
import com.bookmark.models.BookmarkDTO;
import com.bookmark.models.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService; // Dependency Injection

    @GetMapping
    public BookmarkDTO getBookmarks(@RequestParam(name="page", defaultValue = "1") Integer page){
        return bookmarkService.getBookmarks(page);
    }

}
