package com.bookmark.models;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("select new com.bookmark.models.BookmarkDTO (b.id, b.title, b.url, b.createdAt) from Bookmark b")
    Page<BookmarkDTO> findBookmarks(Pageable pageable);

    /*
    @Query("select new com.bookmark.models.BookmarkDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b where lower(b.title) like lower(concat('%', :query, '%'))")
    Page<BookmarkDTO> searchBookmark(String query, Pageable pageable);

     */
    Page<BookmarkDTO> findByTitleContainsIgnoreCase(String query, Pageable pageable);

}
