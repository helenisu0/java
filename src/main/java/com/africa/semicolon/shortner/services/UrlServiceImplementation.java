package com.africa.semicolon.shortner.services;

import com.africa.semicolon.shortner.data.models.Url;
import com.africa.semicolon.shortner.data.repositories.UrlRepository;
import com.africa.semicolon.shortner.dtos.requests.InputUrlRequest;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class UrlServiceImplementation implements UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public Url generateShortUrl(InputUrlRequest inputUrlRequest) {

        if(ObjectUtils.isEmpty(inputUrlRequest.getInitialUrl())){

            String encodedUrl = encodeInitialUrl(inputUrlRequest.getInitialUrl());

            Url urlToSave = new Url();
            urlToSave.setInitialUrl(inputUrlRequest.getInitialUrl());
            urlToSave.setShortUrl(encodedUrl);
            Url generatedShortUrl = saveShortUrl(urlToSave);

            if (generatedShortUrl != null)
                return generatedShortUrl;

            return null;
        }

        return null;
    }


    private String encodeInitialUrl(String initialUrl) {

        String encodedUrl  ;
        LocalDateTime time  = LocalDateTime.now();
        encodedUrl = Hashing.sha256()
                .hashString(initialUrl.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        return encodedUrl;

    }

    @Override
    public Url saveShortUrl(Url url) {
        Url savedUrl = urlRepository.save(url);
        return savedUrl;
    }

    @Override
    public Url getEncodedUrl(String url) {
        Url encodedUrl = urlRepository.findByShortUrl(url);
        return encodedUrl;
    }

    @Override
    public void deleteShortLink(Url url) {
        urlRepository.delete(url);
    }
}
