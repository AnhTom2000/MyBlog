package cc.ccocc.dao;

import cc.ccocc.pojo.Oauth;
import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
    @Select("SELECT user_id,username,avatar_url,email,phone," +
            "gender,age,area,profession,description,article_count," +
            "follower_count,login_count,last_login,last_update," +
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
    @Select("SELECT user_id,username,avatar_url,email,phone," +
            "gender,age,area,profession,description,article_count," +
            "follower_count,login_count,last_login,last_update," +
            "create_time,locked FROM tb_user user INNER JOIN tb_oauth oauth " +
            "ON user.oauth_id = oauth.oauth_id WHERE qq_open_id=#{openId}")
    public User findUserByQqOpenId(@Param("openId") String openId);


    /**
     * @param user 用户信息
     * @Method Description:
     * 如果用户是正常登陆的形式登陆的，添加用户信息
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_user(user_id,username,avatar_url,password,salt,email," +
            "gender,last_login,last_update,create_time)" +
            " VALUES (${user.userId},${user.userName},${user.avatarUrl}," +
            "${user.password},${user.salt},${user.email},${user.gender}," +
            "${user.lastLogin},${user.lastUpdate},${user.createTime})")
    public Integer addDefaultUser(@Param("user") User user);

    /**
     * @param user    用户信息
     * @param oauthId 第三方平台的openId
     * @Method Description:
     * 如果用户是以第三方的形式登陆的，添加登陆信息
     * @Author weleness
     * @Return
     */
    @Insert("INSERT INTO tb_user(user_id,username,avatar_url,password,salt,email," +
            "gender,last_login,last_update,create_time,oauth_id)" +
            " VALUES (${user.userId},${user.userName},${user.avatarUrl}," +
            "${user.password},${user.salt},${user.email},${user.gender}," +
            "${user.lastLogin},${user.lastUpdate},${user.createTime},${oauthId})")
    public Integer addOauthUser(@Param("user") User user, @Param("oauthId") String oauthId);


    @Select("SELECT user_id,username,avatar_url,email,phone," +
            "            gender,age,area,profession,description,article_count," +
            "           follower_count,login_count,last_login,last_update," +
            "           create_time,locked FROM tb_user WHERE username = #{username}")
    public User findUserByName(@Param("username") String username);


}
