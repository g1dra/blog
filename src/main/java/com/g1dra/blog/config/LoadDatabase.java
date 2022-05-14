package com.g1dra.blog.config;

import com.g1dra.blog.model.Post;
import com.g1dra.blog.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import static java.nio.charset.StandardCharsets.UTF_8;


@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Value("classpath:data/markdown-example.txt")
    Resource resourceFile;

    @Bean
    CommandLineRunner initDatabase(PostRepository postRepository) {
        return args -> {
            if (postRepository.count() == 0) {
                log.info("Preloading " + postRepository.save(
                        Post.builder()
                                .title("Hello World!")
                                .content(asString(resourceFile))
                                .build()));
            }
        };
    }

    public static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
