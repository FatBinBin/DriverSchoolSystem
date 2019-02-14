package com.bin.design.drivingschool.constant;

/**
 * @author ouyu
 * @version 2018/11/05
 * @since 2018/11/05
 * 登陆状态类型
 */
public enum LogInStatus {
    /**
     * 管理员
     */
    manager("manager", 2),
    /**
     * 用户
     */
    user("user", 1),
    /**
     * 游客
     */
    visitor("visitor", 0);

    private String name;
    private Integer code;

    private LogInStatus(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public static Integer getCode(String name) {
        for (LogInStatus state : LogInStatus.values()) {
            if (state.getName().equals(name)) {
                return state.getCode();
            }
        }
        return visitor.getCode();
    }
}
