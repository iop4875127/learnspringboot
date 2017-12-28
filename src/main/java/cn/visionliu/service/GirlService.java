package cn.visionliu.service;

import cn.visionliu.domain.Result;
import cn.visionliu.enums.ResultEnum;
import cn.visionliu.exception.GirlException;
import cn.visionliu.repository.GirlRepository;
import cn.visionliu.domain.Girl;
import cn.visionliu.uitls.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by VisionLiu on 2017/12/17.
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void addTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(19);
        girlRepository.save(girlB);

    }


    public Girl getAge(Integer id){
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();

        if(age < 14){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age < 16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        return girl;

    }
}
