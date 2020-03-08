package cc.ccocc.dao;

import cc.ccocc.pojo.SupperAdmin;
import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 19:41  12/02/2020
 * Description:
 *
 * @author Weleness
 */
@Repository
public interface ISuperAdminDao {

    @ResultMap("admin_map")
    @Select("SELECT admin_id,adminname,avatar_url,password,email,phone," +
            "gender,age,area," +
            "create_time,message_count FROM tb_superAdmin WHERE admin_id= #{adminId}")
    public SupperAdmin findAdminById(@Param("adminId") Long adminId);

    @Select("SELECT COUNT(*) FROM tb_superAdmin")
    public Integer getCount();

    /**
     * @Method Description:
     * 查询管理员是否存在
     * @Author weleness
     * @Return
     */
    @ResultMap("admin_map")
    @Select("SELECT admin_id,adminname,avatar_url,password,email,phone," +
            "gender,age,area," +
            "create_time,message_count FROM tb_superAdmin WHERE adminname= #{adminName}")
    public SupperAdmin findAdminByName(@Param("adminName") String adminName);

    @ResultMap("admin_map")
    @Select("SELECT admin_id,adminname,password,email FROM tb_superAdmin WHERE adminname=#{adminName} ")
    public SupperAdmin adminLogin(@Param("adminName") String adminName);

    /**
     * @Method Description:
     * 模糊查询
     * @Author weleness
     * @Return
     */
    @ResultMap("admin_map")
    @Select("SELECT admin_id,adminname,avatar_url,password,email,phone," +
            "gender,age,area,last_login,login_count," +
            "create_time,message_count FROM tb_superAdmin WHERE admin_id LIKE '%${adminId}%' OR adminname LIKE '%${adminName}%' OR email LIKE '%${email}%'")
    public List<SupperAdmin> searchUser(@Param("adminId") Long adminId, @Param("adminName") String adminName, @Param("email") String email);

    /**
     * @Method Description:
     * 查询所有管理员
     * @Author weleness
     * @Return
     */

    @Results(id = "admin_map", value = {
            @Result(id = true, column = "admin_id", property = "adminId", javaType = Long.class),
            @Result(column = "adminname", property = "adminName"),
            @Result(column = "avatar_url", property = "avatarUrl"),
            @Result(column = "password", property = "password"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "email", property = "email"),
            @Result(column = "gender", property = "gender", javaType = Boolean.class),
            @Result(column = "area", property = "area"),
            @Result(column = "login_count", property = "loginCount"),
            @Result(column = "create_time", property = "createTime", javaType = LocalDateTime.class),
            @Result(column = "last_login", property = "lastLogin", javaType = LocalDateTime.class),
            @Result(column = "message_count", property = "messageCount")
    })
    @Select("SELECT admin_id,adminname,avatar_url,password,email,phone," +
            "gender,age,area,login_count," +
            "last_login," +
            "create_time,message_count FROM tb_superAdmin LIMIT #{pageNo},#{pageSize}")
    public List<SupperAdmin> findAll(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    /**
     * @param adminId 用户id
     * @Method Description:
     * 删除用户
     * @Author weleness
     * @Return
     */
    @Delete("DELETE FROM tb_superAdmin WHERE admin_id = #{adminId}")
    public Integer deleteAdminUser(@Param("adminId") Long adminId);

    /**
     * @param adminId 用户id
     * @param email   邮箱
     * @param phone   手机
     * @param gender  性别
     * @Method Description:
     * <p>管理员修改信息</p>
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_superAdmin SET email = #{email},phone = #{phone},gender=#{gender},avatar_url = #{avatarUrl} WHERE admin_id = #{adminId}")
    public Integer updateAdminUser(@Param("adminId") Long adminId, @Param("email") String email, @Param("phone") String phone, @Param("gender") Boolean gender, @Param("avatarUrl") String avatarUrl);

    /**
     * @Method Description:
     * 用户反馈加一
     * @Author weleness
     * <P>用户反馈</P>
     * @Return
     */
    @Update("UPDATE tb_superAdmin SET message_count = message_count+1 WHERE adminId = #{adminId}")
    public Integer addAdminMessageCount(@Param("adminId") Long adminId);


    /**
     * @param admin 管理员
     * @Method Description:
     * 如果用户是正常登陆的形式登陆的，添加用户信息
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_superAdmin(admin_id,adminname,password,email," +
            "gender,last_login,create_time)" +
            " VALUES (#{admin.adminId},#{admin.adminName}," +
            "#{admin.password},#{admin.email},#{admin.gender},#{admin.lastLogin}," +
            "#{admin.createTime})")
    public Integer addDefaultUser(@Param("admin") SupperAdmin admin);


}
