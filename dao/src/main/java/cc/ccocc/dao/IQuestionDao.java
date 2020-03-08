package cc.ccocc.dao;

import cc.ccocc.pojo.Question;
import cc.ccocc.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 23:03  13/02/2020
 * Description:
 *
 * @author Weleness
 */
@Repository
public interface IQuestionDao {

    /**
     * @Method
     * Description:
     *  <P>查询所有反馈</P>
     * @Author weleness
     *
     * @Return
     */
    @Results(id = "question_map",value = {
            @Result(id = true,column = "question_id",property = "questionId"),
            @Result(column = "user_id",property = "user",javaType = User.class,one = @One(select = "cc.ccocc.dao.IUserDao.findUserById",fetchType = FetchType.LAZY)),
            @Result(column = "question_title",property = "questionTitle"),
            @Result(column = "question_content",property = "questionContent"),
            @Result(column = "reply_content",property = "replyContent"),
            @Result(column = "create_time",property = "createTime",javaType = LocalDateTime.class),
            @Result(column = "reply_time",property = "replyTime",javaType = LocalDateTime.class),
            @Result(column = "locked",property = "locked",javaType = Boolean.class)
    })
    @Select("SELECT question_id,user_id,question_title,question_content,reply_content,create_time,reply_time,locked FROM tb_question WHERE locked = true LIMIT #{pageNo} , #{pageSize} ")
    public List<Question> findAll(@Param("pageNo") Integer pageNo , @Param("pageSize") Integer pageSize);

    @ResultMap("question_map")
    @Select("SELECT question_id,user_id,question_title,question_content,reply_content,create_time,reply_time,locked FROM tb_question  LIMIT #{pageNo} , #{pageSize} ")
    public List<Question> findAllUnchecked(@Param("pageNo") Integer pageNo , @Param("pageSize") Integer pageSize);
    /**
     * @Method
     * Description:
     *  <P>添加反馈</P>
     * @Author weleness
     *
     * @Return
     */
    @Insert("INSERT INTO tb_question(question_id,user_id,question_title,question_content,create_time,locked) VALUES(#{question.questionId},#{question.userId},#{question.questionTitle},#{question.questionContent},#{question.createTime},#{question.locked})")
    public Integer addQuestion(@Param("question")Question question);

    /**
     * @Method
     * Description:
     *  <P>管理员回复反馈</P>
     * @Author weleness
     *
     * @Return
     */
    @Update("UPDATE tb_question SET reply_content = #{replyContent} , locked = true,reply_time=#{replyTime} WHERE question_id = #{questionId}")
    public Integer addReply(@Param("replyContent") String replyContent, @Param("questionId") Long questionId, @Param("replyTime")LocalDateTime replyTime);

    /**
     * @Method
     * Description:
     *  <P>删除对应用户的反馈</P>
     * @Author weleness
     *
     * @Return
     */
    @Delete("DELETE FROM tb_question WHERE user_id = #{userId}")
    public Integer deleteQuestionByUser(@Param("userId") Long userId);

    /**
     * @Method
     * Description:
     *  <P>删除反馈</P>
     *  @Author weleness
     *
     * @Return
     */
    @Delete("DELETE FROM tb_question WHERE question_id = #{questionId}")
    public Integer deleteQuestionByQuestion(@Param("questionId") Long questionId);

    @Select("SELECT COUNT(*) FROM tb_question")
    public  Integer questionCount();

    @Update("UPDATE tb_question SET locked = true WHERE question_id = #{questionId}")
    public Integer checkedQuestion(Long questionId);

    @Select("SELECT question_id FROM tb_question WHERE question_id = #{questionId} AND locked=true")
    public Integer IsChecked(Long questionId);
}
