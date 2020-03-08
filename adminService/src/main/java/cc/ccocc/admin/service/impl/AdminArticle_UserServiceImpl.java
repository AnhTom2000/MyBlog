package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminArticle_UserService;
import cc.ccocc.dao.IArticle_UserDao;
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
@Service("adminArticle_userService")
public class AdminArticle_UserServiceImpl implements IAdminArticle_UserService {

    @Autowired
    private IArticle_UserDao article_userDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public void deleteByUser(Long userId) {
        article_userDao.deleteByUser(userId);
    }
}
