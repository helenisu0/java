package com.africa.semicolon.shortner.services;

import com.africa.semicolon.shortner.data.models.Url;
import com.africa.semicolon.shortner.dtos.requests.InputUrlRequest;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    public Url generateShortUrl(InputUrlRequest inputUrlRequest);
    public Url saveShortUrl(Url url);
    public Url getEncodedUrl(String url);
    public void deleteShortLink(Url url);
}
