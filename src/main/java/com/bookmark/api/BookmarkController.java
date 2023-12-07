package com.bookmark.api;

import com.bookmark.models.BookmarksDTO;
import com.bookmark.models.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService; // Dependency Injection

    @GetMapping
    public BookmarksDTO getBookmarks(@RequestParam(name="page", defaultValue = "1") Integer page,
                                     @RequestParam(name="query", defaultValue = "") String query){

        if(query == null || query.trim().isEmpty()){
            return bookmarkService.getBookmarks(page);
        }
        else{
            return bookmarkService.searchBookmark(query, page);
        }


    }


}
