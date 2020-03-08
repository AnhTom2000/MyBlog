package cc.ccocc.service;

import cc.ccocc.dto.PageHelpDTO;
import cc.ccocc.dto.QuestionDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Question;

import java.util.List;

/**
 * Created on 15:43  14/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IQuestionService {

    public ResultDTO addQuestion(Long userId,String feedBackTitle,String feedBackContent);

    public PageHelpDTO<List<Question>> findAll(Integer pageNo, Integer pageSize);

    public Integer questionCount();

}
