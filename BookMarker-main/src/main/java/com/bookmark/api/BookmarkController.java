package com.bookmark.api;

import com.bookmark.models.BookmarkDTO;
import com.bookmark.models.BookmarksDTO;
import com.bookmark.models.BookmarkService;
import com.bookmark.models.createdBookmark;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDTO createBookmark(@RequestBody @Valid createdBookmark bookmark){
        return bookmarkService.createBookmark(bookmark);
    }


}
