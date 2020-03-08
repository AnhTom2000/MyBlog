package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminQuestionService;
import cc.ccocc.admin.service.IAdminSystemNotificationService;
import cc.ccocc.dao.IQuestionDao;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.Question;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 16:00  14/02/2020
 * Description:
 *
 * @author Weleness
 */
@Service("adminQuestionService")
public class AdminQuestionServiceImpl implements IAdminQuestionService {

    @Autowired
    private IQuestionDao questionDao;

    @Autowired
    @Qualifier("adminSystemNotice")
    private IAdminSystemNotificationService adminSystemNotificationService;

    /**
     * @Method
     * Description:
     *  <p>查询所有</p>
     * @Author weleness
     *
     * @Return
     */
    @Override
    public AdminDTO<List<Question>> findAll(Integer pageNo, Integer pageSize) {
        return new AdminDTO<>(ResultCode.OK_CODE.getCode(),null,questionDao.findAllUnchecked(pageNo, pageSize),questionCount(),true);
    }

    /**
     * @Method
     * Description:
     *  <P>回复反馈</P>
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO addReply(Long questionId, String replyContent,Long userId,String questionTitle) {
        AdminDTO result = null;
        if(questionDao.addReply(replyContent,questionId, LocalDateTime.now(Clock.systemDefaultZone())) > 0){
            adminSystemNotificationService.addSystemNotice(userId,questionId,"反馈",replyContent,questionTitle);
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(),"回复成功",null,null,true);
        }else result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(),"服务器异常",null,null,false);
        return result;
    }

    /**
     * @Method
     * Description:
     *  <P>删除反馈</P>
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO deleteQuestion(Long[] questionIds) {
        for (Long questionId : questionIds) {
            questionDao.deleteQuestionByQuestion(questionId);
        }
        return new AdminDTO<>(ResultCode.OK_CODE.getCode(),"删除成功",null,null,true);
    }

    /**
     * @Method
     * Description:
     *  <P>获得全部反馈数量</P>
     * @Author weleness
     *
     * @Return
     */
    @Override
    public Integer questionCount() {
        return questionDao.questionCount();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO checkQuestion(Long questionId) {
        AdminDTO result = null;
        if(questionDao.checkedQuestion(questionId)==null &&questionDao.checkedQuestion(questionId) > 0){
            result  = new AdminDTO<>(ResultCode.OK_CODE.getCode(),"审核成功",null,null,true);
        }else result = new AdminDTO<>(ResultCode.UNAUTHORIZED_CODE.getCode(),"该反馈已审核",null,null,false);
        return result;
    }
}
