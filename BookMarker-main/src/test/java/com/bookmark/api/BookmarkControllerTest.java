package com.bookmark.api;

import com.bookmark.models.Bookmark;
import com.bookmark.models.BookmarkRepository;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.util.ArrayList;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//Integration Test

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

 class BookmarkControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    BookmarkRepository bookmarkRepository;


    //Before each test delete all entities
    @BeforeEach
    void SetUp(){
        bookmarkRepository.deleteAllInBatch();

        ArrayList<Bookmark>bookmarks = new ArrayList<Bookmark>();
        bookmarks.add(new Bookmark(null,"Spring Initializer", "https://start.spring.io/", Instant.now()));
        bookmarks.add(new Bookmark(null,"Spring Initializer", "https://start.spring.io/", Instant.now()));
        bookmarks.add(new Bookmark(null,"Spring Initializer", "https://start.spring.io/", Instant.now()));
        bookmarks.add(new Bookmark(null,"Spring Initializer", "https://start.spring.io/", Instant.now()));
        bookmarks.add(new Bookmark(null,"Spring Initializer", "https://start.spring.io/", Instant.now()));

        bookmarkRepository.saveAll(bookmarks);
    }

    @Test
   public void shouldGetBootmarks() throws Exception{
        mvc.perform(get("/api/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(5)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(1)));
        ;
    }

    @ParameterizedTest
    @CsvSource({
            "1, false"
    })
    public void shouldGetBootmarksPage(int pageNo, boolean hasNext) throws Exception{
        mvc.perform(get("/api/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(5)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(pageNo)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)));
        ;
    }

    /**
     * Test for creation of the bookmark
     */

    @Test
    void shouldCreateBookmark() throws Exception{

        this.mvc.perform(
                MockMvcRequestBuilders.post("/api/bookmarks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                                "title":"Testing",
                                "url": "https://www.youtube.com"}                              
                        """)
        )
        .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()));
    }
}
