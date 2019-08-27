package cn.lianhy.demo.action;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorld {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping(value = "send.json")
    public String send(String userName){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("liming","13");
        rabbitTemplate.convertAndSend("exchange.direct","xiyangyang",jsonObject);
        return "Hello："+userName;
    }

    @GetMapping(value = "get.json")
    public String get(String userName){
        JSONObject jsonObject = (JSONObject)rabbitTemplate.receiveAndConvert("xiyangyang");
        log.info("消息："+jsonObject);
        return "Hello："+userName;
    }
}
