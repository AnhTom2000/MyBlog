package cc.ccocc.admin.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.Question;

import java.util.List;

/**
 * Created on 15:57  14/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminQuestionService {

    public AdminDTO<List<Question>> findAll(Integer pageNo , Integer pageSize);

    public AdminDTO addReply (Long questionId,String replyContent,Long userId,String quetsionTitle);

    public AdminDTO deleteQuestion(Long[] questionId);

    public Integer questionCount();

    public AdminDTO checkQuestion(Long questionId);

}
