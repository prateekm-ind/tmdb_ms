package com.tmdb.moviecatalog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-catalog")
public class MovieCatalogController {
    @GetMapping("/status")
    public ResponseEntity<String> check(){
        return ResponseEntity.ok("Movie-Catalog Working");
    }
}
