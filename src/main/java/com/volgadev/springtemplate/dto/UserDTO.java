package com.volgadev.springtemplate.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

	private Integer userId;

	private String telegramUserName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTelegramUserName() {
        return telegramUserName;
    }

    public void setTelegramUserName(String telegramUserName) {
        this.telegramUserName = telegramUserName;
    }
}
