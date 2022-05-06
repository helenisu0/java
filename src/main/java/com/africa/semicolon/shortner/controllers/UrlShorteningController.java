package com.africa.semicolon.shortner.controllers;


import com.africa.semicolon.shortner.data.models.Url;
import com.africa.semicolon.shortner.dtos.requests.InputUrlRequest;
import com.africa.semicolon.shortner.dtos.responses.UrlErrorResponse;
import com.africa.semicolon.shortner.dtos.responses.UrlResponse;
import com.africa.semicolon.shortner.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShorteningController {

     @Autowired
     private UrlService urlService;

     @PostMapping("/generate")
     public ResponseEntity<?> generateShortUrl(@RequestBody InputUrlRequest inputUrlRequest){

          Url urlGenerated = urlService.generateShortUrl(inputUrlRequest);

          if(urlGenerated != null){
               UrlResponse urlResponse = new UrlResponse();
               urlResponse.setInitialUrl(urlGenerated.getInitialUrl());
               urlResponse.setShortUrl(urlGenerated.getShortUrl());

               return new ResponseEntity<UrlResponse>(urlResponse, HttpStatus.OK);
          }

          UrlErrorResponse urlErrorResponse = new UrlErrorResponse();
          urlErrorResponse.setStatus("404");
          urlErrorResponse.setErrorMessage("there was an error processing your Request, please try again");
          return new ResponseEntity<UrlErrorResponse>(urlErrorResponse, HttpStatus.NOT_FOUND);
     }


}
