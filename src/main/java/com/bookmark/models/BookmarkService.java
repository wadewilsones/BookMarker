package com.bookmark.models;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final BookmarkMapper bookmarkMapper;

    @Transactional(readOnly = true)
    public BookmarksDTO  getBookmarks(Integer page){
        int pageNo = page < 1 ? 0 : page-1;
        Pageable pagable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDTO> bookmarkPage = bookmarkRepository.findBookmarks(pagable);
        return new BookmarksDTO(bookmarkPage);
    }


    @Transactional(readOnly = true)
    public BookmarksDTO searchBookmark(String query, Integer page) {
        int pageNo = page < 1 ? 0 : page-1;
        Pageable pagable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
        Page<BookmarkDTO> bookmarkPage = (Page<BookmarkDTO>)bookmarkRepository.findByTitleContainsIgnoreCase(query, pagable);
        return new BookmarksDTO(bookmarkPage);
    }

    public BookmarkDTO createBookmark(createdBookmark bookmark) {
        Bookmark newBookmark = new Bookmark(null, bookmark.getUrl(), bookmark.getTitle(), Instant.now());
        Bookmark createdBookmark = bookmarkRepository.save(newBookmark);
        return bookmarkMapper.toDTO(createdBookmark);
    }
}
