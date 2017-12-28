package cn.visionliu.controller;

import cn.visionliu.domain.Girl;
import cn.visionliu.domain.Result;
import cn.visionliu.repository.GirlRepository;
import cn.visionliu.service.GirlService;
import cn.visionliu.uitls.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by VisionLiu on 2017/12/17.
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    GirlRepository girlRepository;

    @Autowired
    GirlService girlService;

    /**
     * GET  http://127.0.0.1:8082/visionliu/girls
     */
    @GetMapping(value = "/girls")
    public List<Girl> findAllGirls() {
        logger.info("get /girls");
        return girlRepository.findAll();
    }

    /**
     * POST http://127.0.0.1:8082/visionliu/girls?age=19&cupSize=d
     */
/*
    @PostMapping(value = "/girls")
    public Girl addGirls(@RequestParam(value = "age") Integer age,
                         @RequestParam(value = "cupSize") String cupSize) {

        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }
*/

    /**
     * POST http://127.0.0.1:8082/visionliu/girls?age=19&cupSize=d
     */
    @PostMapping(value = "/girls")
    public Result<Girl> addGirls(@Valid Girl girl, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        return ResultUtil.success(girlRepository.save(girl));
    }


    /**
     * GET http://127.0.0.1:8082/visionliu/girls/3
     */
    @GetMapping(value = "/girls/{id}")
    public Girl findOneGirl(@PathVariable Integer id) {

        return girlRepository.findOne(id);
    }

    /**
     * PUT http://127.0.0.1:8082/visionliu/girls/3?age=20&cupSize=b
     */
    @PutMapping(value = "/girls/{id}")
    public Girl putOneGirl(@PathVariable Integer id,
                           @RequestParam(value = "age") Integer age,
                           @RequestParam(value = "cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * DELETE http://127.0.0.1:8082/visionliu/girls/3
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable Integer id) {
        girlRepository.delete(id);
    }

    /**
     * GET http://127.0.0.1:8082/visionliu/girls/age/19
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findByAge(@PathVariable Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * POST http://127.0.0.1:8082/visionliu/girls/two
     */
    @PostMapping(value = "/girls/two")
    public void addTwoGirls() {
        girlService.addTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public Result getAge(@PathVariable Integer id) {

        return ResultUtil.success(girlService.getAge(id));
    }
}
