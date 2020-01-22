package cc.ccocc.dao;

import cc.ccocc.pojo.Oauth;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created on 23:13  20/01/2020
 * Description:
 *
 * @author Weleness
 */
@Repository("oauthDao")
public interface IOauthDao {

    /**
     * @Method
     * Description:
     *  添加第三方登陆信息
     * @Author weleness
     *
     * @Return  是否成功插入
     * @param oauth 第三方登陆信息
     */
    @Insert("INSERT INTO tb_oauth(oauth_id,oauth_type,github_open_id,qq_open_id,wechat_open_id) " +
            "VALUES(${oauth.oauthId},${oauth.oauthType},${oauth.githubOpenId},${oauth.qqOpenId},${oauth.weChatOpenId})")
    public Integer addOauth(@Param("oauth") Oauth oauth);

}
