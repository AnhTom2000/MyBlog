package cc.ccocc.dao;

import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * Created on 21:47  21/01/2020
 * Description:
 *
 * @author Weleness
 */
@Repository("userDao")
public interface IUserDao {

    /**
     * @param openId 第三方平台GITHUB的openId
     * @Method Description:
     * 根据oauth的用户id，判断用户是否登陆过
     * @Author weleness
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT user_id,username,avatar_url,password,email,phone," +
            "gender,age,area,profession,description," +
            "login_count,last_login,last_update," +
            "create_time,locked,message_count FROM tb_user user INNER JOIN tb_oauth oauth " +
            "ON user.oauth_id = oauth.oauth_id WHERE github_open_id=#{openId}")
    public User findUserByGitHubOpenId(@Param("openId") String openId);

    /**
     * @param openId 第三方平台QQ的openId
     * @Method Description:
     * 根据oauth的用户id，判断用户是否登陆过
     * @Author weleness
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT user_id,username,avatar_url,password,email,phone," +
            "gender,age,area,profession,description," +
            "login_count,last_login,last_update," +
            "create_time,locked,message_count FROM tb_user user INNER JOIN tb_oauth oauth " +
            "ON user.oauth_id = oauth.oauth_id WHERE qq_open_id=#{openId}")
    public User findUserByQqOpenId(@Param("openId") String openId);


    /**
     * @param user 用户信息
     * @Method Description:
     * 如果用户是正常登陆的形式登陆的，添加用户信息
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_user(user_id,username,password,email," +
            "gender,last_login,last_update,create_time)" +
            " VALUES (#{user.userId},#{user.userName}," +
            "#{user.password},#{user.email},#{user.gender}," +
            "#{user.lastLogin},#{user.lastUpdate},#{user.createTime})")
    public Integer addDefaultUser(@Param("user") User user);


    /**
     * @param user    用户信息
     * @param oauthId 第三方平台的openId
     * @Method Description:
     * 如果用户是以第三方的形式登陆的，添加登陆信息
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_user(user_id,username,avatar_url,password,email," +
            "gender,last_login,last_update,create_time,oauth_id)" +
            " VALUES (${user.userId},'${user.userName}','${user.avatarUrl}'," +
            "'${user.password}','${user.email}',${user.gender}," +
            "'${user.lastLogin}','${user.lastUpdate}','${user.createTime}',${oauthId})")
    public Integer addOauthUser(@Param("user") User user, @Param("oauthId") Long oauthId);

    /**
     * @param username  用户名
     * @Method
     * Description:
     *  根据用户名查找用户
     * @Author weleness
     *
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT user_id,username,password,avatar_url,email,phone," +
            "gender,age,area,profession,description," +
            "login_count,last_login,last_update," +
            "create_time,locked,message_count FROM tb_user WHERE username = #{username}")
    public User findUserByName(@Param("username") String username);


    /**
     * @param userId 用户id
     * @Method Description:
     * 根据用户id查找用户
     * @Author weleness
     * @Return
     */
    @Results(id = "user_map", value = {
            @Result(id = true, column = "user_id", property = "userId", javaType = Long.class),
            @Result(column = "username", property = "userName",javaType = String.class),
            @Result(column = "password", property = "password"),
            @Result(column = "avatar_url", property = "avatarUrl"),
            @Result(column = "email", property = "email"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "gender", property = "gender", javaType = Boolean.class),
            @Result(column = "age", property = "age", javaType = Short.class),
            @Result(column = "area", property = "area"),
            @Result(column = "profession", property = "profession"),
            @Result(column = "description", property = "description"),
            @Result(column = "login_count", property = "loginCount"),
            @Result(column = "last_login", property = "lastLogin", javaType = LocalDateTime.class),
            @Result(column = "create_time", property = "createTime", javaType = LocalDateTime.class),
            @Result(column = "locked", property = "locked", javaType = Boolean.class),
            @Result(column = "message_count", property = "messageCount")
    })
    @Select("SELECT user_id,username,password,avatar_url,email,phone,gender,age,area,profession,description,login_count,last_login,last_update,create_time,locked,message_count FROM tb_user WHERE user_id = #{userId}")
    public User findUserById(@Param("userId") Long userId);


    /**
     * @param email  邮箱
     * @Method
     * Description:
     *  根据邮箱查找用户
     * @Author weleness
     *
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT user_id,username,password,avatar_url,email,phone,gender,age,area,profession,description,login_count,last_login,last_update,create_time,locked,message_count FROM tb_user WHERE email = #{email}")
    public User findUserByEmail(@Param("email") String email);

    /**
     * @param commentId 评论的主键
     * @Method
     * Description:
     *  根据评论id查找用户
     * @Author weleness
     *
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT u.user_id,u.username FROM tb_user u INNER JOIN tb_article_comment ac ON ac.user_id = u.user_id WHERE ac.comment_id = #{commentId} ")
    public User findUserByCommentId(@Param("commentId") Long commentId);

    /**
     * @param user 用户信息
     * @Method
     * Description:
     *  修改用户信息
     * @Author weleness
     *
     * @Return
     */
    @Update("UPDATE tb_user SET email=#{user.email},phone=#{user.phone},gender=#{user.gender},age=#{user.age},area=#{user.area},profession=#{user.profession},description=#{user.description},last_update=#{user.lastUpdate} WHERE user_id = #{user.userId}")
    public Integer personalUpdate(@Param("user") User user);

    /**
     * @param userId 用户主键
     * @param avatarUrl 头像地址
     * @param lastUpdate 最后一次修改时间
     * @Method
     * Description:
     *  用户修改头像
     * @Author weleness
     *
     * @Return
     */
    @Update("UPDATE tb_user SET avatar_url = '${avatarUrl}',last_update = #{lastUpdate} WHERE user_id = #{userId}")
    public Integer personalAvatarUrlUpdate(@Param("avatarUrl") String avatarUrl,@Param("lastUpdate") LocalDateTime lastUpdate,@Param("userId") Long userId);

    /**
     * @param userId 用户主键
     * @param password  修改的密码
     * @Method
     * Description:
     *  用户修改密码
     * @Author weleness
     *
     * @Return
     */
    @Update("UPDATE tb_user SET password = #{password} WHERE user_id = #{userId}")
    public Integer personalPaswwordUpdate(@Param("userId")Long userId , @Param("password") String password);


}
