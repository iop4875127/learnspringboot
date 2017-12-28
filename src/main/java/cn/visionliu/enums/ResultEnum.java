package cn.visionliu.enums;

/**
 * Created by VisionLiu on 2017/12/24.
 */
public enum ResultEnum {
    SUCCESS(0, "success"),
    UNKNOW_ERROR(3, "系统异常"),
    PRIMARY_SCHOOL(100, "你在上小学"),
    MIDDLE_SCHOOL(101, "你在上中学"),
    ;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private Integer code;

    private String message;

}
