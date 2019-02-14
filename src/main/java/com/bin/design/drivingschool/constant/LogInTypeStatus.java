package com.bin.design.drivingschool.constant;

/**
 * @author ouyu
 * @version 2018/11/05
 * @since 2018/11/05
 * 登陆状态类型
 */
public enum LogInTypeStatus {
    /**
     * 同一台浏览器重复登录返回值-1
     */
    sameBrowserRepeatLogin("repeatLogin", -1),
    /**
     * 不同浏览器重复登录返回0
     */
    differentBrowserRepeatLogin("differentBrowserRepeatLogin", 0),
    /**
     * 正常登录返回1
     */
    normalLogin("normalLogin", 1);

    private String name;
    private Integer code;

    private LogInTypeStatus(String name, int code) {
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
        for (LogInTypeStatus state : LogInTypeStatus.values()) {
            if (state.getName().equals(name)) {
                return state.getCode();
            }
        }
        return sameBrowserRepeatLogin.getCode();
    }
}
