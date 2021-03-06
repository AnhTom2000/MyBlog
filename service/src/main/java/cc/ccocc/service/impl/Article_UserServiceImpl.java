package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticle_UserDao;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.service.IArticle_UserService;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 05:26  25/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("article_userService")
public class Article_UserServiceImpl implements IArticle_UserService {

    @Autowired
    private IArticle_UserDao article_userDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer addInMiddle(Long articleId, Long userId) {
        return article_userDao.addSourceInMiddle(userId, articleId);
    }

    @Override
    public ResultDTO checkArticleIsLikeByUser(Long articleId, Long userId) {
        Long articleIsLikeByOneUser = article_userDao.findArticleIsLikeByOneUser(userId, articleId);
        ResultDTO result = null;
        if (articleIsLikeByOneUser != null) {
            result = new ResultDTO(ResultCode.OK_CODE.getCode(), "已经点赞过这篇文章了", true);
        }else {
            result = new ResultDTO(ResultCode.OK_CODE.getCode(), "还没有点赞过", true);
        }
        return result;
    }


}
