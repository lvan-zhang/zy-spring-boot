package com.zhangyu.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 用户对象 sys_user
 * 
 * @author ruoyi
 */
@Setter
@Getter
@ToString
public class SysUser extends BaseEntity
{
    /** 用户ID */
    private Long userId;

    /** 用户账号 */
    private String username;

    /** 部门ID */
    private Long deptId;

    /** 用户昵称 */
    private String nickName;

    /** 用户邮箱 */
    private String email;

    /** 手机号码 */
    private String phoneNumber;

    /** 用户性别 */
    private String sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 帐号状态（0正常 1停用） */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 最后登录IP */
    private String loginIp;

    /** 最后登录时间yyyy-MM-dd HH:mm:ss */
    private Date loginDate;

    /** 角色组 */
    private Long[] roleIds;

    /** 岗位组 */
    private Long[] postIds;

    /** 角色ID */
    private Long roleId;
}
