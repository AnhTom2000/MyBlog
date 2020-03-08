package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticleDao;
import cc.ccocc.dto.ArticleDTO;
import cc.ccocc.dto.PageHelpDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.*;
import cc.ccocc.service.*;
import cc.ccocc.utils.date.DateUtils;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @Qualifier("userService")
    @Lazy
    private IUserService userService;

    @Autowired
    @Lazy
    private IArticle_LikeNotificationService article_likeNotificationService;

    private BeanCopier beanCopier = BeanCopier.create(Article.class, ArticleDTO.class, false);

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
    public PageHelpDTO<List<Article>> findAll(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageSize == null) {
            pageNo = 1;
            pageSize = 5;
        }
        List<Article> articles = articleDao.findALL((pageNo-1)*pageSize, pageSize);
        //for (Article article : articles) {
        //    //将html转码再转回来
        //    article.setA_text(HtmlUtils.htmlUnescape(article.getA_text()));
        //}
        Integer count = article_Count();
        Integer totalPage = (count % pageSize) == 0 ? count / pageSize: (count / pageSize) + 1;
        return new PageHelpDTO<List<Article>>(pageNo,pageSize,count,totalPage,articles);
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

    @Override
    public Integer UserArticle_Count(Long userId) {
        return articleDao.UserArticle_Count(userId);
    }

    /**
     * @param tag_id 根据标签id查找文章
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
     * @Method Description:
     * 查找用户最新文章
     * @Author weleness
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
            if ((archive = archiveService.findArchiveByYear(DateUtils.getCurrentDay("yyyy年-MM月"))) == null) {
                //保存归档日期
                archive = Archive.builder()
                        .archive_id(SNOWFLAKE_ID_GENERATOR.generateId())
                        .archiveName(DateUtils.getCurrentDay("yyyy年-MM月"))
                        .archive_article_count(1)
                        .createTime(LocalDateTime.now(Clock.systemDefaultZone())).build();
                // 如果没有归档就创建归档
                archiveService.saveArchive(archive, userId);
            }
            // 这个月份归档的文章数+1
            archiveService.addArchiveArticleCount(DateUtils.getCurrentDay("yyyy年-MM月"));
            // 用户的文章数量+1
            Integer addUserArticleCount = userService.addUserArticleCount(userId);
            // 是否为markdown
            article.setMarkdown(true);
            //保存归档id
            article.setArchiveId(archive.getArchive_id());
            // 是否审核了
            article.setChecked(false);
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
            if (saveArticle > 0 && saveInMiddle > 0 && addUserArticleCount > 0)
                resultDTO = new ResultDTO(ResultCode.OK_CODE.getCode(), "发布成功", true);
            else resultDTO = new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "发布失败，服务器异常", false);
        } else {
            resultDTO = new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "对不起，服务器异常", false);
        }
        return resultDTO;
    }

    /**
     * @param userId      用户id
     * @param article     文章信息
     * @param category_id 类别id
     * @param newTag      新标签数组
     * @param tag         旧标签数组
     * @Method Description:
     * 文章编辑方法
     * @Author weleness
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
            beanCopier.copy(article, articleDTO, null);
            return articleDTO;
        }
        return null;
    }

    /**
     * @param articleId 文章id
     * @param userId    用户id
     * @Method Description:
     * 点赞
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO addArticleLike(Long articleId, Long authId, Long userId, String articleTitle) {
        ResultDTO result = null;
        //还没有点赞过这篇文章
        if ((result = article_userService.checkArticleIsLikeByUser(articleId, userId)).getMessage().equals("还没有点赞过")) {
            System.out.println(result);
            try {
                // 添加文章点赞
                articleDao.addArticleLike(articleId);
                // 添加中间表信息
                article_userService.addInMiddle(articleId, userId);
                // 添加点赞消息推送，点赞的用户id，被点赞的用户id，被点赞的文章主键
                article_likeNotificationService.addArticle_LikeNotification(userId, authId, articleId, articleTitle, "文章");
            } catch (Exception e) {
                e.printStackTrace();
                result = ResultDTO.builder().code(ResultCode.SERVER_ERROR_CODE.getCode()).message("服务器异常").status(false).build();
            }
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
     * @Method Description:
     * 获得用户的文章集合
     * @Author weleness
     * @Return
     */
    @Override
    public PageHelpDTO<List<ArticleDTO>> findArticleByUserId(Long userId,Integer pageNo,Integer pageSize) {
        if (pageNo == null || pageSize == null) {
            pageNo = 1;
            pageSize = 5;
        }
        if (userId == null) return null;
        List<Article> articleList = articleDao.findArticleByUserId(userId,(pageNo-1)*pageSize, pageSize);
        List<ArticleDTO> userArticles = null;
        if (articleList != null) {
            userArticles = new ArrayList<>();
            for (Article article : articleList) {
                ArticleDTO articleDTO = ArticleDTO.builder().build();
                beanCopier.copy(article, articleDTO, null);
                userArticles.add(articleDTO);
            }
        }
        Integer count = UserArticle_Count(userId);
        Integer totalPage = (count % pageSize) == 0 ? count / pageSize: (count / pageSize) + 1;
        return new PageHelpDTO<List<ArticleDTO>>(pageNo,pageSize,count,totalPage,userArticles);
    }


    /**
     * @param articleId 文章id
     * @Method Description:
     * 文章删除方法
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO deleteArticle(Long articleId, Long userId) {

        ResultDTO result = null;
        if (articleDao.deleteArticleById(articleId) > 0) {
            userService.devUserArticleCount(userId);
            result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("操作成功").status(true).build();
        } else {
            result = ResultDTO.builder().code(ResultCode.NOT_FOUND_CODE.getCode()).message("操作失败,文章不存在").status(false).build();
        }
        return result;
    }

    /**
     * @Method
     * Description:
     *  <P>首页模糊查询文章方法</P>
     * @Author weleness
     *
     * @Return
     */
    @Override
    public List<ArticleDTO> searchArticle(String articleName) {
        if (articleName != null) {
            articleName = "%".concat(articleName).concat("%");
        }
        List<Article> articles = articleDao.searchArticleByName(articleName);
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        if(articles != null){
            for (Article article : articles) {
                ArticleDTO articleDTO = new ArticleDTO();
                beanCopier.copy(article,articleDTO,null);
                articleDTOList.add(articleDTO);
            }
        }
        return articleDTOList;
    }

    @Override
    public List<ArticleDTO> searchArticleByTag(List<Tag> tags) {
        List<ArticleDTO> articleDTOList = new ArrayList<>();
        List<Article> articles = new ArrayList<>();
        if(tags!=null){
            for (Tag tag : tags) {
                articles.addAll(articleDao.findArticleByTagId(tag.getTag_id()));
            }
            if(!articles.contains(null)){
                for (Article article : articles) {
                    ArticleDTO articleDTO = new ArticleDTO();
                    beanCopier.copy(article,articleDTO,null);
                    articleDTOList.add(articleDTO);
                }
            }
        }

        return articleDTOList;
    }

}
