package cn.haohaoli.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    /**
     * redisTemplate.opsForValue(); //操作字符串
     * redisTemplate.opsForHash();  //操作hash
     * redisTemplate.opsForList();  //操作list
     * redisTemplate.opsForSet();   //操作set
     * redisTemplate.opsForZSet();  //操作有序set
     */

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void connectTest (){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("str1","这是一个str",10L, TimeUnit.SECONDS);
        ops.set("str2","这又是一个str");
        String test = ops.get("str1");
        System.out.println(test);
    }

    @Test
    public void getTest () {
        String test = stringRedisTemplate.opsForValue().get("str2");
        System.out.println(test);

    }


}
