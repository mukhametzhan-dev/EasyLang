// package com.easylang.demo;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class WebMvcConfiger {

//     @Bean
//     public WebMvcConfigurer corsConfigurer() {
//         return new WebMvcConfigurer() {
//             @Override
//             public void addCorsMappings(CorsRegistry registry) {
//                 // registry.addMapping("/**")
//                 //         .allowedOrigins("http://localhost:5173")
//                 //         .allowedMethods("*")
//                 //         .allowedHeaders("*")
//                 //         .allowCredentials(true);

//                 registry.addMapping("/**")
//                         .allowedOrigins("http://localhost:5173")
//                         .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                         .allowedHeaders("*")
//                         .allowCredentials(true);
                        
//             }
//         };
//     }
// }