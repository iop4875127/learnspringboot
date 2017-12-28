package cn.visionliu.service;

import cn.visionliu.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by VisionLiu on 2017/12/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    GirlService girlService;

    @Test
    public void getAgeTest() throws Exception {
        Girl girl = girlService.getAge(2);

        Assert.assertEquals(new Integer(33), girl.getAge());
    }

}