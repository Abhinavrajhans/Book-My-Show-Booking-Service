package com.example.BMS.service.impl;

import com.example.BMS.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService implements CacheService {

    private final StringRedisTemplate redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, Object value) {
        this.redisTemplate.opsForValue().set(key, value.toString(), 2, TimeUnit.MINUTES);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public void getAllKeysAndValues() {
        var keys = stringRedisTemplate.keys("*");
        if (keys.isEmpty()) {
            System.out.println("No keys found in Redis");
            return;
        }

        keys.forEach(key -> {
            String type = stringRedisTemplate.type(key).code();  // check type
            System.out.print("Key: " + key + " (Type: " + type + ") -> ");

            try {
                switch (type) {
                    case "string":
                        System.out.println(stringRedisTemplate.opsForValue().get(key));
                        break;
                    case "hash":
                        System.out.println(stringRedisTemplate.opsForHash().entries(key));
                        break;
                    case "set":
                        System.out.println(stringRedisTemplate.opsForSet().members(key));
                        break;
                    case "zset":
                        System.out.println(stringRedisTemplate.opsForZSet().range(key, 0, -1));
                        break;
                    case "list":
                        System.out.println(stringRedisTemplate.opsForList().range(key, 0, -1));
                        break;
                    default:
                        System.out.println("[Unsupported Type]");
                }
            } catch (Exception e) {
                System.out.println("[Error fetching value: " + e.getMessage() + "]");
            }
        });
    }

    @Override
    public void deleteAll() {
        stringRedisTemplate.delete(stringRedisTemplate.keys("*"));
    }
}

