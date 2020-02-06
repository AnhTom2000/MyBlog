package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticleDao;
import cc.ccocc.dto.ArticleDTO;
import cc.ccocc.dto.CommentDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.*;
import cc.ccocc.service.*;
import cc.ccocc.utils.date.DateUtils;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 22:14  15/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("articleService")
public class ArtilceServiceImpl implements IArticleService {

    @Autowired
    @Qualifier("articledao")
    private IArticleDao articleDao;
    @Autowired
    @Qualifier("tagService")
    private ITagService tagService;
    @Autowired
    @Qualifier("IArticle_TagService")
    private IArticle_TagService iArticle_tagService;
    @Autowired
    @Qualifier("categoryService")
    private ICategoryService categoryService;
    @Autowired
    @Qualifier("archiveService")
    private IArchiveService archiveService;
    @Autowired
    @Qualifier("article_userService")
    private IArticle_UserService article_userService;
    @Autowired
    @Qualifier("user_archivesService")
    private  IUser_ArchivesService user_archivesService;


    /**
     * @Method Description:
     * 获得一个全局唯一的雪花id生成器对象
     * @Author weleness
     * @Return
     */
    private static final SnowflakeIdGenerator SNOWFLAKE_ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    /**
     * @Method Description:
     * 查找所有文章
     * @Author weleness
     * @Return
     */
    @Override
    public List<Article> findAll() {
        List<Article> articles = articleDao.findALL();
        for (Article article : articles) {
            //将html转码再转回来
            article.setA_text(HtmlUtils.htmlUnescape(article.getA_text()));
        }
        return articles;
    }

    /**
     * @Method Description:
     * 统计文章总数
     * @Author weleness
     * @Return
     */
    @Override
    public Integer article_Count() {
        return articleDao.article_Count();
    }

    /**
     * @param tag_id  根据标签id查找文章
     * @Method Description:
     * 根据标签id查找文章
     * @Author weleness
     * @Return
     */
    @Override
    public List<Article> findArticleByTagId(Long tag_id) {
        return articleDao.findArticleByTagId(tag_id);
    }

    /**
     * @Method Description:
     * 查找所有的最新文章
     * @Author weleness
     * @Return
     */
    @Override
    public List<Article> findAllArticleNew() {

        return articleDao.findArticleNew();
    }

    /**
     * @param userId 用户id
     * @Method
     * Description:
     *  查找用户最新文章
     * @Author weleness
     *
     * @Return
     */
    @Override
    public List<Article> findArticleNewByUserId(Long userId) {
        return articleDao.findArticleNewByUserId(userId);
    }

    /**
     * @param article     文章信息
     * @param tag         旧标签数组
     * @param category_id 文章的分类id
     * @param newTag      新标签数组
     * @param userId      用户主键
     * @Method Description:
     * 保存文章
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO saveArticle(Article article, String[] tag, String category_id, String[] newTag, Long userId) {
        ResultDTO resultDTO = null;
        Archive archive = null;
        if (!Objects.isNull(article)) {
            // 获得标签信息
            List<Tag> tagList = tagService.getTagList(newTag, tag, userId);
            // 进行html字符转码，过滤特殊字符
            article.setA_text(HtmlUtils.htmlEscapeHex(article.getA_text()));
            // 这里localDateTime.now（）要加上系统时钟，不然可能会造成精度不准
            article.setA_createTime((LocalDateTime.now(Clock.systemDefaultZone())));
            if ((archive = archiveService.findArchiveByYear(DateUtils.format(DateUtils.localDateTime2Date(article.getA_createTime()), "yyyy"))) == null) {
                //保存归档日期
                 archive = Archive.builder().archiveName(DateUtils.format(DateUtils.localDateTime2Date(article.getA_createTime()), "yyyy")).build();
                archiveService.saveArchive(archive, userId);
            }
            user_archivesService.addInUser_Archives(userId,archive.getId());
            article.setMarkdown(true);
            //初始化最后一次的修改时间
            article.setA_last_update(article.getA_createTime());
            //生成文章雪花id
            article.setA_id(SNOWFLAKE_ID_GENERATOR.generateId());
            // 添加用户id
            article.setUser(User.builder().userId(userId).build());
            // 初始化点赞和观看值为0
            article.setA_likeNums(0);
            article.setA_viewNums(0);
            // 查找对应的分类
            Category category = categoryService.findById(Integer.parseInt(category_id));
            //保存文章
            Integer saveArticle = articleDao.saveArticle(article, category);
            // 将文章信息和标签信息存入中间表
            Integer saveInMiddle = iArticle_tagService.saveInMiddle(article, tagList);

            if (saveArticle > 0 && saveInMiddle > 0)
                resultDTO = new ResultDTO(ResultCode.OK_CODE.getCode(), "发布成功", true);
            else resultDTO = new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "发布失败，服务器异常", false);
        } else {
            resultDTO = new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "对不起，服务器异常", false);
        }
        return resultDTO;
    }

    /**
     * @param userId 用户id
     * @param article 文章信息
     * @param category_id  类别id
     * @param newTag  新标签数组
     * @param tag  旧标签数组
     * @Method
     * Description:
     *  文章编辑方法
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO updateArticle(Article article, String[] tag, String category_id, String[] newTag, Long userId) {
        ResultDTO resultDTO = null;
        if (!Objects.isNull(article)) {
            //获得标签信息
            List<Tag> tagList = tagService.getTagList(newTag, tag, userId);
            // 进行html字符转码，过滤特殊字符
            article.setA_text(HtmlUtils.htmlEscapeHex(article.getA_text()));
            //修改最后一次的修改时间
            article.setA_last_update(LocalDateTime.now(Clock.systemDefaultZone()));
            // 查找对应的分类
            Category category = categoryService.findById(Integer.parseInt(category_id));
            //保存文章
            Integer updateArticle = articleDao.updateArticle(article, category);
            // 将文章信息和标签信息存入中间表
            Integer updateInMiddle = iArticle_tagService.updateInMiddle(article, tagList);
            if (updateArticle > 0 && updateInMiddle > 0)
                resultDTO = new ResultDTO(ResultCode.OK_CODE.getCode(), "发布成功", true);
            else resultDTO = new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "发布失败，服务器异常", false);
        } else {
            resultDTO = new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "对不起，服务器异常", false);
        }
        return resultDTO;
    }

    /**
     * @param articleId 文章id
     * @Method Description:
     * 查看文章
     * @Author weleness
     * @Return
     */
    @Override
    public ArticleDTO findArticleById(Long articleId) {
        ArticleDTO articleDTO = new ArticleDTO();
        Article article = articleDao.findArticleById(articleId);
        if (article != null) {
            BeanCopier beanCopier = BeanCopier.create(Article.class, ArticleDTO.class, false);
            beanCopier.copy(article, articleDTO, null);
            return articleDTO;
        }
        return null;
    }

    /**
     * @param articleId  文章id
     * @param userId  用户id
     * @Method Description:
     * 点赞
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO addArticleLike(Long articleId, Long userId) {
        ResultDTO result = null;
        //还没有点赞过这篇文章
        if (!article_userService.checkArticleIsLikeByUser(articleId, userId).isStatus()) {
            try {
                articleDao.addArticleLike(articleId);
                article_userService.addInMiddle(articleId, userId);
                result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("操作成功").status(true).build();
            } catch (Exception e) {
                result = ResultDTO.builder().code(ResultCode.SERVER_ERROR_CODE.getCode()).message("服务器异常").status(false).build();
                e.printStackTrace();
            }
        } else {
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("已经点赞过了，不可以再点赞了").status(false).build();
        }

        return result;
    }

    /**
     * @param articleId 文章id
     * @Method Description:
     * 观看人数+1
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO addArticleViewStatistics(Long articleId) {
        ResultDTO result = null;
        if (articleDao.addArticleViewStatistics(articleId) > 0) {
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("观看人数+1").status(true).build();
        } else {
            result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("服务器异常").status(false).build();
        }
        return result;
    }

    /**
     * @param userId 用户id
     * @Method
     * Description:
     *  获得用户的文章集合
     * @Author weleness
     *
     * @Return
     */
    @Override
    public List<ArticleDTO> findArticleByUserId(Long userId) {
        if (userId == null) return null;
        List<Article> articleList = articleDao.findArticleByUserId(userId);
        List<ArticleDTO> userArticles = null;
        if (articleList != null) {
            userArticles = new ArrayList<>();
            BeanCopier beanCopier = BeanCopier.create(Article.class, ArticleDTO.class, false);
            for (Article article : articleList) {
                ArticleDTO articleDTO = ArticleDTO.builder().build();
                beanCopier.copy(article, articleDTO, null);
                userArticles.add(articleDTO);
            }
        }
        return userArticles;
    }

    /**
     * @param articleId 文章id
     * @Method
     * Description:
     *  文章删除方法
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO deleteArticle(Long articleId) {
        ResultDTO result = null;
        if(articleDao.deleteArticleById(articleId)> 0){
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("操作成功").status(true).build();
        }else {
            result = ResultDTO.builder().code(ResultCode.NOT_FOUND_CODE.getCode()).message("操作失败,文章不存在").status(false).build();
        }
        return result;
    }

}
