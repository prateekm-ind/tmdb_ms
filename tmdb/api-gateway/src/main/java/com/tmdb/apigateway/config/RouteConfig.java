package com.tmdb.apigateway.config;

public class RouteConfig {
    //java based configuration for routes
    //optional
    //we can leverage application.properties based configuration

    /*
    @Bean
    public RouteLocator modifiedRouteLocation(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("movie_catalog", route-> route.path("/movie-catalog/**")
                .and()
                .method(HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT)
                .uri("http://localhost:8090"))
                .build();
    }*/
}
