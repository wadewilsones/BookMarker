package com.bookmark;

import com.bookmark.models.Bookmark;
import com.bookmark.models.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;


//Fill db with data when the app is running
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookmarkRepository repository;

    @Override
    public void run(String...args) throws Exception{
        repository.save(new Bookmark(null, "Spring Initializer", "https://start.spring.io/", Instant.now()));
        repository.save(new Bookmark(null, "ChatGPT", "https://chat.openai.com/", Instant.now()));
        repository.save(new Bookmark(null, "Youtube", "https://www.youtube.com/watch?v=UhEMh-HZIMY&t=711s&ab_channel=SivaLabs", Instant.now()));
        repository.save(new Bookmark(null, "Project Repo", "https://github.com/sivaprasadreddy/springboot-kubernetes-youtube-series/tree/main/bookmarker-api/src/main/java/com/sivalabs/bookmarker/domain", Instant.now()));
        repository.save(new Bookmark(null, "Translater", "https://translate.google.com/?hl=ru&sl=en&tl=ru&text=Round%20Robin&op=translate", Instant.now()));
        repository.save(new Bookmark(null, "ChatGPT", "https://chat.openai.com/", Instant.now()));
        repository.save(new Bookmark(null, "Spring Initializer", "https://start.spring.io/", Instant.now()));
        repository.save(new Bookmark(null, "Spring Initializer", "https://start.spring.io/", Instant.now()));
        repository.save(new Bookmark(null, "ChatGPT", "https://chat.openai.com/", Instant.now()));
        repository.save(new Bookmark(null, "Youtube", "https://www.youtube.com/watch?v=UhEMh-HZIMY&t=711s&ab_channel=SivaLabs", Instant.now()));
        repository.save(new Bookmark(null, "Project Repo", "https://github.com/sivaprasadreddy/springboot-kubernetes-youtube-series/tree/main/bookmarker-api/src/main/java/com/sivalabs/bookmarker/domain", Instant.now()));
        repository.save(new Bookmark(null, "Translater", "https://translate.google.com/?hl=ru&sl=en&tl=ru&text=Round%20Robin&op=translate", Instant.now()));
        repository.save(new Bookmark(null, "ChatGPT", "https://chat.openai.com/", Instant.now()));
        repository.save(new Bookmark(null, "Spring Initializer", "https://start.spring.io/", Instant.now()));

    }
}
