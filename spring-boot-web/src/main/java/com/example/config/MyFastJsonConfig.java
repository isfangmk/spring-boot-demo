package com.example.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
public class MyFastJsonConfig {
    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd");
        config.setCharset (StandardCharsets.UTF_8);
        config.setSerializerFeatures(
                SerializerFeature.WriteClassName, // 在生成的JSON中输出类名
                SerializerFeature.WriteMapNullValue, // 输出 value 为 null 的数据
                SerializerFeature.PrettyFormat, // JSON 格式化
                SerializerFeature.WriteNullListAsEmpty, // 空集合输出口而非null
                SerializerFeature.WriteNullStringAsEmpty // 空字符串输出’”’而非 null
        );
        converter.setFastJsonConfig(config);
        return converter;
    }
}
