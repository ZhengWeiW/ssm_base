package com.lixiang.ssm.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.lixiang.ssm.entity.Role;
import com.lixiang.ssm.entity.Ugroup;
import com.lixiang.ssm.entity.User;

public interface UgroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ugroup
     *
     * @mbg.generated Thu May 03 17:07:31 CST 2018
     */
    int insert(Ugroup record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ugroup
     *
     * @mbg.generated Thu May 03 17:07:31 CST 2018
     */
    int insertSelective(Ugroup record);
    
    
    /**
     * 查询多个用户组
     *
     */
    List<Ugroup> selectList(@Param("ugroup")Ugroup ugroup);
    /**
     * 删除用户组
     * @param id
     * @return
     */
    int deleteUgroup(Integer id);
    /**
     * 删除用户组和用户的关系
     * @param id
     * @return
     */
    int deleteUgAndUser(Integer id);
    
    /**
     * 修改用户组
     * @param ugroup
     * @return
     */
    public boolean ugroupModify(@Param("ugroup")Ugroup ugroup,@Param("user")User user);
    
    /**
     * 删除用户组和角色的关系
     * @param id
     * @return
     */
    int deleteUgAndRole(Integer id);
    
    /**
     * 用户组添加用户
     * @param ugroup
     * @param list
     * @return
     */
    public boolean ugroupAddUsers(@Param("groupid")int groupid,@Param("list")List<Integer> list);
    
    /**
     * 用户组删除用户
     * @param ugroup
     * @param list
     * @return
     */
    public boolean ugroupDelUsers(@Param("groupid")int groupid,@Param("list")List<User> list);
    
    
    /**
     * 查看用户组用户
     */
    public List<User> ugroupUsers(@Param("ugroup")Ugroup ugroup);
    
    /**
     * 用户组添加角色
     * @param ugroup
     * @param list
     * @return
     */
    public boolean ugroupAddRoles(@Param("groupid")int groupid,@Param("list")List<Integer> list);
    
    /**
     * 用户组删除角色
     * @param ugroup
     * @param list
     * @return
     */
    public boolean ugroupDelRoles(@Param("groupid")int groupid,@Param("list")List<Role> list);
    
    /**
     * 查看用户组角色
     */
    public List<Role> ugroupRoles(@Param("ugroup")Ugroup ugroup);
    
}