package com.africa.semicolon.shortner.data.repositories;

import com.africa.semicolon.shortner.data.models.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {
    public Url findByShortUrl(String shortUrl);

}
