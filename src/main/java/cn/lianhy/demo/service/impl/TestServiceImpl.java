package cn.lianhy.demo.service.impl;

import cn.lianhy.demo.service.TestService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RabbitListener(queues = "xiyangyang")
public class TestServiceImpl implements TestService {

    @Override
    @RabbitHandler
    public void receive(JSONObject jsonObject) {
        log.info("收到消息："+jsonObject);
    }
}
