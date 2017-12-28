package cn.visionliu.exception;

import cn.visionliu.enums.ResultEnum;

/**
 * Created by VisionLiu on 2017/12/24.
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
