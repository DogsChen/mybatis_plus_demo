package com.example.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.example.config.Contains;

import java.time.LocalDateTime;

public class Role {

    //    AUTO(0), 数据库自动增加
//    NONE(1),
//    INPUT(2),
//    ASSIGN_ID(3),
//    ASSIGN_UUID(4);
//    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("roleName")
    private String roleName;
    @TableField("roleType")
    @EnumValue
    private Contains.RoleType roleType;
    private String description;
    private String status;
    @TableField("parentRole")

    private String parentRole;
    @TableField("departmentId")
    private Integer departmentId;
    @TableField("createById")
    private Integer createById;
    @TableField("updateById")
    private Integer updateById;
    @TableField("createBy")
    private String createBy;

    @TableField("updateBy")
    private String updateBy;
    @TableField("createTime")
    private LocalDateTime createTime;
    @TableField("updateTime")
    private LocalDateTime updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Contains.RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(Contains.RoleType roleType) {
        this.roleType = roleType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParentRole() {
        return parentRole;
    }

    public void setParentRole(String parentRole) {
        this.parentRole = parentRole;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getCreateById() {
        return createById;
    }

    public void setCreateById(Integer createById) {
        this.createById = createById;
    }

    public Integer getUpdateById() {
        return updateById;
    }

    public void setUpdateById(Integer updateById) {
        this.updateById = updateById;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleType='" + roleType + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", parentRole='" + parentRole + '\'' +
                ", departmentId=" + departmentId +
                ", createById=" + createById +
                ", updateById=" + updateById +
                ", createBy='" + createBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
