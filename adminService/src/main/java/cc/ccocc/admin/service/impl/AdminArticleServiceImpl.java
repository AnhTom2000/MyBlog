package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.*;
import cc.ccocc.dao.IArticleDao;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.ArticleDTO;
import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Comment;
import cc.ccocc.pojo.User;
import cc.ccocc.service.ISystemNotificationService;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 14:51  11/02/2020
 * Description:
 *
 * @author Weleness
 */
@Service("adminArticleService")
public class AdminArticleServiceImpl implements IAdminArticleService {

    @Autowired
    private IArticleDao articleDao;

    @Autowired
    @Qualifier("adminUserService")
    private IAdminUserService adminUserService;

    @Autowired
    @Qualifier("adminSystemNotice")
    private IAdminSystemNotificationService adminSystemNotificationService;

    /**
     * @Method Description:
     * <p> 查询所有文章</p>
     * @Author weleness
     * @Return
     */
    @Override
    public AdminDTO<List<Article>> findAllArticle(Integer pageNo, Integer pageSize) {
        if (pageSize == null) pageSize = 10;
        List<Article> articles = articleDao.findALL(pageNo, pageSize);
        for (Article article : articles) {
            article.setA_text(HtmlUtils.htmlUnescape(article.getA_text()));
        }
        return new AdminDTO<List<Article>>(ResultCode.OK_CODE.getCode(), null, articles, articleCount(), true);
    }

    @Override
    public AdminDTO<List<Article>> findAllUnChecked(Integer pageNo, Integer pageSize) {
        List<Article> articleList = articleDao.findAllUnchecked(pageNo, pageSize);
        for (Article article : articleList) {
            article.setA_text(HtmlUtils.htmlUnescape(article.getA_text()));
        }
        return new AdminDTO<List<Article>>(ResultCode.OK_CODE.getCode(), null, articleList, uncheckedArticleCount(), true);
    }


    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO deleteArticles(Long[] articleId) {
        AdminDTO result = null;
        for (Long article : articleId) {
            User user = adminUserService.findUserByArticleId(article);
            Article article1 = articleDao.findArticleById(article);
            articleDao.deleteArticleById(article);
            adminSystemNotificationService.addSysteNoticeBad(user.getUserId(),"文章",article1.getA_Title(),"管理员删除了您的文章");
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "删除成功", null, articleCount(), true);
        }
        return result;

    }

    /**
     * @Method Description:
     * <p>文章数量</p>
     * @Author weleness
     * @Return
     */
    @Override
    public Integer articleCount() {
        return articleDao.article_Count();
    }

    @Override
    public Integer uncheckedArticleCount() {
        return articleDao.uncheckedArticle_count();
    }

    /**
     * @Method Description:
     * <p>审核文章</p>
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public AdminDTO checkArticle(Long articleId) {
        AdminDTO result = null;
        if (articleDao.checkArticle(articleId) > 0) {
            User user = adminUserService.findUserByArticleId(articleId);
            Article article = articleDao.findArticleById(articleId);
            adminSystemNotificationService.addSystemNotice(user.getUserId(),articleId,"文章",article.getA_Title(),"您的文章已审核通过,快去看看吧");
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "审核文章成功", null, articleCount(), true);
        } else
            result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(), "操作失败", null, articleCount(), false);
        return result;
    }

    /**
     * @Method Description:
     * 删除用户的所有文章
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public AdminDTO deleteByUser(Long userId) {
        articleDao.deleteArticleByUserId(userId);
        return new AdminDTO<>(ResultCode.OK_CODE.getCode(), "删除文章成功", null, articleCount(), true);
    }

    /**
     * @Method Description:
     * 模糊查询
     * @Author weleness
     * @Return
     */

    @Override
    public AdminDTO<List<Article>> searchArticle(String userName, String articleTitle, String categoryName) {
        String user_id = "";
        User user = adminUserService.findUserByName(userName);
        if (user != null) {
            user_id = "%".concat(String.valueOf(user.getUserId())).concat("%");
        }
        if (!articleTitle.equals("")) {
            articleTitle = "%".concat(articleTitle).concat("%");
        }
        if (!categoryName.equals("")) {
            categoryName = "%".concat(categoryName).concat("%");
        }
        List<Article> articleList = articleDao.searchArticle(user_id, articleTitle, categoryName);
        for (Article article : articleList) {
            article.setA_text(HtmlUtils.htmlUnescape(article.getA_text()));
        }
        return new AdminDTO<List<Article>>(ResultCode.OK_CODE.getCode(), null, articleList, articleList.size(), true);
    }
}
