package cc.ccocc.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created on 14:43  26/01/2020
 * Description:
 *  用户评论点赞dao
 * @author Weleness
 */
@Repository
public interface IUser_CommentDao {

    /**
     * @Method
     * Description:
     *  查询用户是否点赞过这条评论
     * @Author weleness
     *
     * @Return
     */
    @Select("SELECT user_id FROM tb_user_comment_like_middle WHERE article_comment_id = #{commentId}")
    public Long checkCommentIsLikeByOneUser(@Param("commentId") Long commentId);

    /**
     * @Method
     * Description:
     *  用户点赞评论
     * @Author weleness
     *
     * @Return
     */
    @Insert("INSERT INTO tb_user_comment_like_middle(article_comment_id,user_id) VALUES(#{commentId},#{userId})")
    public Integer addCommentLike(@Param("commentId") Long commentId , @Param("userId") Long userId);
}
