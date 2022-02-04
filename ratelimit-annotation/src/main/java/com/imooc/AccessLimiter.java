package com.imooc;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

/** @author afu */
@Service
@Slf4j
@Deprecated
public class AccessLimiter {
  @Autowired private StringRedisTemplate stringRedisTemplate;

  @Autowired private RedisScript<Boolean> rateLimitLua;

  public void limitAccess(String key, Integer limit) {
    // step 1 : request Lua script
    // Lua script的真身
    // Lua脚本中的Key列表
    // Lua脚本Value列表
    boolean acquired =
        Boolean.TRUE.equals(
            stringRedisTemplate.execute(
                // Lua script的真身
                rateLimitLua,
                // Lua脚本中的Key列表
                Lists.newArrayList(key),
                // Lua脚本Value列表
                limit.toString()));

    if (!acquired) {
      log.error("your access is blocked, key={}", key);
      throw new RuntimeException("Your access is blocked");
    }
  }
}
