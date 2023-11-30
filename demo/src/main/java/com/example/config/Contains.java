package com.example.config;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public class Contains {

    public enum RoleType {
        ADMIN(0, "管理员"),
        USER(1, "用户");

        @EnumValue
        private int value;
        @JsonValue
        private String typeName;

        RoleType(int value, String typeName) {
            this.value = value;
            this.typeName = typeName;
        }
    }
}
