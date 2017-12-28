package cn.visionliu.controller;

import cn.visionliu.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by VisionLiu on 2017/12/17.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${cupSize}")
    private String cupSize = null;

    @Value("${age}")
    private int age ;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"nihao", "hi"}, method = RequestMethod.GET)
    String hi() {
//        return cupSize + age;
//        return content;
        return girlProperties.sayHello();
    }

    //GET http://127.0.0.1:8082/visionliu/hello/say/100
    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)
    String pathVariable(@PathVariable("id") int id) {
        return "id:" + id;
    }

    //GET http://127.0.0.1:8082/visionliu/hello/say?id=100
    @RequestMapping(value = "/say", method = RequestMethod.GET)
    String requestParam(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        return "id:" + id;
    }

    //@RequestMapping(value = "/say", method = RequestMethod.POST)
    //POST http://127.0.0.1:8082/visionliu/hello/say?id=88
    @PostMapping(value = "/say")
    String postMapping(@RequestParam(value = "id", required = false, defaultValue = "0") int id) {
        return "id:" + id;
    }
}
