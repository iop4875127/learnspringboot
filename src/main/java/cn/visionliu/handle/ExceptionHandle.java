package cn.visionliu.handle;

import cn.visionliu.domain.Result;
import cn.visionliu.exception.GirlException;
import cn.visionliu.uitls.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by VisionLiu on 2017/12/24.
 */
@RestControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        if (e instanceof GirlException) {
            return ResultUtil.error(((GirlException) e).getCode(), e.getMessage());
        } else {
            logger.error("系统异常 {}", e);
            return ResultUtil.error(3, "系统异常");
        }
    }
}
