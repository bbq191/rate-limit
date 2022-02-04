package com.imooc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/** @author afu */
public class Controller {
  @Autowired private AccessLimiter accessLimiter;

  @GetMapping("test")
  public String test() {
    accessLimiter.limitAccess("ratelimiter-test", 3);
    return "success";
  }

  /** 提醒！ 注意配置扫包路径（com.imooc 路径不同） */
  @GetMapping("test-annotation")
  @com.imooc.annotation.AccessLimiter(limit = 1)
  public String testAnnotation() {
    return "success";
  }
}
