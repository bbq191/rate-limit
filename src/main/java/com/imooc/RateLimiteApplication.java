package com.imooc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/** @author afu */
@SpringBootApplication
public class RateLimiteApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(RateLimiteApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }
}
