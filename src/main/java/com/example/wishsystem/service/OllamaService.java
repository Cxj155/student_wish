package com.example.wishsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class OllamaService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String ollamaUrl = "http://127.0.0.1:11434/api/generate";
    private final String modelName = "llama3.2:latest";

    public String classifyWish(String wishText) {
        String prompt = """
你是学生意愿分类助手，只输出分类结果，不要多余文字。
可选分类标签：【升学深造、就业求职、考公、创业、暂未确定、其他】
学生意愿内容：
""" + wishText;
        Map<String,Object> req = new HashMap<>();
        req.put("model",modelName);
        req.put("prompt",prompt);
        req.put("stream",false);
        Map<String,Object> resp = restTemplate.postForObject(ollamaUrl,req,Map.class);
        return resp.get("response").toString().trim();
    }
}
