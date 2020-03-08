package cc.ccocc.dao;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 21:47  21/01/2020
 * Description:
 *
 * @author Weleness
 */
@Repository("userDao")
public interface IUserDao {


    /**
     * @Method
     * Description:
     *  锁定用户
     * @Author weleness
     *
     * @Return
     */
    @Update("UPDATE tb_user SET locked = !locked WHERE user_id = #{userId}")
    public Integer lockedUser(@Param("userId") Long userId);

    /**
     * @Method Description:
     * 模糊查询
     * @Author weleness
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT user_id,username,avatar_url,password,email,phone," +
            "gender,age,area,profession,description,article_count," +
            "login_count,last_login,last_update," +
            "create_time,locked,message_count FROM tb_user WHERE user_id LIKE '%${userId}%' OR username LIKE '%${userName}%' OR email LIKE '%${email}%'")
    public List<User> searchUser(@Param("userId") Long userId, @Param("userName") String userName, @Param("email") String email);

    /**
     * @Method Description:
     * 统计用户数量
     * @Author weleness
     * @Return
     */
    @Select("SELECT COUNT(*) FROM tb_user")
    public Integer userCount();

    /**
     * @Method Description:
     * 管理员查找所有用户
     * @Author weleness
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT user_id,username,avatar_url,password,email,phone," +
            "gender,age,area,profession,description,article_count," +
            "login_count,last_login,last_update," +
            "create_time,locked,message_count FROM tb_user LIMIT #{pageNo},#{pageSize}")
    public List<User> findAll(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    /**
     * @param userId 用户id
     * @Method Description:
     * 删除用户
     * @Author weleness
     * @Return
     */
    @Delete("DELETE FROM tb_user WHERE user_id = #{userId}")
    public Integer deleteUser(@Param("userId") Long userId);

    /**
     * @param userId 用户id
     * @param email  邮箱
     * @param phone  手机
     * @param gender 性别
     * @Method Description:
     * <p>管理员修改用户信息</p>
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_user SET email = #{email},phone = #{phone},gender=#{gender} WHERE user_id = #{userId}")
    public Integer updateUser(@Param("userId") Long userId, @Param("email") String email, @Param("phone") String phone, @Param("gender") Boolean gender);

    /**
     * @param openId 第三方平台GITHUB的openId
     * @Method Description:
     * 根据oauth的用户id，判断用户是否登陆过
     * @Author weleness
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT user_id,username,avatar_url,password,email,phone," +
            "gender,age,area,profession,description,article_count," +
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
            "gender,age,area,profession,description,article_count," +
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
     * @param username 用户名
     * @Method Description:
     * 根据用户名查找用户
     * @Author weleness
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT user_id,username,password,avatar_url,email,phone," +
            "gender,age,area,profession,description,article_count," +
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
            @Result(column = "username", property = "userName", javaType = String.class),
            @Result(column = "password", property = "password"),
            @Result(column = "avatar_url", property = "avatarUrl"),
            @Result(column = "email", property = "email"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "gender", property = "gender", javaType = Boolean.class),
            @Result(column = "age", property = "age", javaType = Short.class),
            @Result(column = "area", property = "area"),
            @Result(column = "profession", property = "profession"),
            @Result(column = "description", property = "description"),
            @Result(column = "article_count", property = "articleCount"),
            @Result(column = "user_id", property = "tagCount", one = @One(select = "cc.ccocc.dao.ITagDao.findTagCountByUserId", fetchType = FetchType.LAZY)),
            @Result(column = "login_count", property = "loginCount"),
            @Result(column = "last_login", property = "lastLogin", javaType = LocalDateTime.class),
            @Result(column = "last_update", property = "lastUpdate", javaType = LocalDateTime.class),
            @Result(column = "create_time", property = "createTime", javaType = LocalDateTime.class),
            @Result(column = "locked", property = "locked", javaType = Boolean.class),
            @Result(column = "message_count", property = "messageCount"),
            @Result(column = "oauth_id",property = "oauthId",javaType = Long.class)
    })
    @Select("SELECT user_id,username,password,avatar_url,email,phone,gender,age,area,profession,article_count,description,login_count,last_login,last_update,create_time,locked,message_count,oauth_id FROM tb_user WHERE user_id = #{userId}")
    public User findUserById(@Param("userId") Long userId);


    /**
     * @param email 邮箱
     * @Method Description:
     * 根据邮箱查找用户
     * @Author weleness
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT user_id,username,password,avatar_url,email,phone,gender,age,area,profession,article_count,description,login_count,last_login,last_update,create_time,locked,message_count FROM tb_user WHERE email = #{email}")
    public User findUserByEmail(@Param("email") String email);

    /**
     * @param commentId 评论的主键
     * @Method Description:
     * 根据评论id查找用户
     * @Author weleness
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT u.user_id,u.username FROM tb_user u INNER JOIN tb_article_comment ac ON ac.user_id = u.user_id WHERE ac.comment_id = #{commentId} ")
    public User findUserByCommentId(@Param("commentId") Long commentId);

    /**
     * @param articleId 文章id
     * @Method Description:
     * 根据文章id查找用户
     * @Author weleness
     * @Return
     */
    @ResultMap("user_map")
    @Select("SELECT u.user_id,u.username FROM tb_user u INNER JOIN tb_article a ON a.u_id = u.user_id WHERE a.article_id = #{articleId}")
    public User findUserByArticleId(@Param("articleId") Long articleId);

    /**
     * @param user 用户信息
     * @Method Description:
     * 修改用户信息
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_user SET email=#{user.email},phone=#{user.phone},gender=#{user.gender},age=#{user.age},area=#{user.area},profession=#{user.profession},description=#{user.description},last_update=#{user.lastUpdate} WHERE user_id = #{user.userId}")
    public Integer personalUpdate(@Param("user") User user);

    /**
     * @param userId     用户主键
     * @param avatarUrl  头像地址
     * @param lastUpdate 最后一次修改时间
     * @Method Description:
     * 用户修改头像
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_user SET avatar_url = '${avatarUrl}',last_update = #{lastUpdate} WHERE user_id = #{userId}")
    public Integer personalAvatarUrlUpdate(@Param("avatarUrl") String avatarUrl, @Param("lastUpdate") LocalDateTime lastUpdate, @Param("userId") Long userId);

    /**
     * @param userId   用户主键
     * @param password 修改的密码
     * @Method Description:
     * 用户修改密码
     * @Author weleness
     * @Return
     */
    @Update("UPDATE tb_user SET password = #{password} WHERE user_id = #{userId}")
    public Integer personalPasswordUpdate(@Param("userId") Long userId, @Param("password") String password);

    @Update("UPDATE tb_user SET article_count = article_count+1 WHERE user_id = #{userId}")
    Integer addUserArticleCount(@Param("userId") Long userId);

    @Update("UPDATE tb_user SET article_count = article_count-1 WHERE user_id = #{userId}")
    Integer devUserArticleCount(@Param("userId") Long userId);

    @Update("UPDATE tb_user SET login_count = login_count+1 WHERE user_id = #{userId}")
    void updateUserLoginCount(@Param("userId") Long userId);

    @Update("UPDATE tb_user SET last_login = #{lastLogin} WHERE user_id = #{userId}")
    void updateUserLastLogin(@Param("userId") Long userId, @Param("lastLogin") LocalDateTime now);


}
