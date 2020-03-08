package cc.ccocc.service.impl;

import cc.ccocc.dao.IQuestionDao;
import cc.ccocc.dto.PageHelpDTO;
import cc.ccocc.dto.QuestionDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Link;
import cc.ccocc.pojo.Question;
import cc.ccocc.service.IQuestionService;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 23:51  19/02/2020
 * Description:
 *
 * @author Weleness
 */

@Service("questionService")
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private IQuestionDao questionDao;

    private static final IdGenerator ID_GENERATOR = SnowflakeIdGenerator.getInstance();
    /**
     * @param userId 反馈的用户
     * @param feedBackContent 反馈内容
     * @param feedBackTitle 反馈标题
     * @Method
     * Description:
     *  <P>添加反馈</P>
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO addQuestion(Long userId,String feedBackTitle, String feedBackContent) {
        Question question = Question.builder().questionId(ID_GENERATOR.generateId()).userId(userId).locked(false).createTime(LocalDateTime.now(Clock.systemDefaultZone())).questionTitle(feedBackTitle).questionContent(feedBackContent).build();
        questionDao.addQuestion(question);
        return ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("操作成功").status(true).build();
    }

    /**
     * @param pageNo 第几页
     * @param pageSIze 一页多少个
     * @Method
     * Description:
     *  <P>查询所有</P>
     * @Author weleness
     *
     * @Return
     */
    @Override
    public PageHelpDTO<List<Question>> findAll(Integer pageNo, Integer pageSIze) {
        if(pageNo == null){
            pageNo = 0;
        }
        if(pageSIze == null){
            pageSIze = 5;
        }
        PageHelpDTO<List<Question>> pageHelpDTO = new PageHelpDTO<>();
        pageHelpDTO.setPageNo(pageNo);
        pageHelpDTO.setTotal(questionCount());
        pageHelpDTO.setPageSize(pageSIze);
        pageHelpDTO.setData(questionDao.findAll(pageNo, pageSIze));
        return pageHelpDTO;
    }

    @Override
    public Integer questionCount() {
        return questionDao.questionCount();
    }
}
