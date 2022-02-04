package com.imooc;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

/** @author afu */
public class RatelimiterApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(RatelimiterApplication.class)
        .web(WebApplicationType.SERVLET)
        .run(args);
  }
}
