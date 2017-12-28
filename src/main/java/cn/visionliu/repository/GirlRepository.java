package cn.visionliu.repository;

import cn.visionliu.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by VisionLiu on 2017/12/17.
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    public List<Girl> findByAge(Integer age);
}
