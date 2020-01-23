package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticleDao;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Archive;
import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Category;
import cc.ccocc.pojo.Tag;
import cc.ccocc.service.*;
import cc.ccocc.utils.date.DateUtils;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.sql.Date;
import java.time.Clock;
import java.time.LocalDateTime;
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


    /**
     * @Method Description:
     * 获得一个全局唯一的雪花id生成器对象
     * @Author weleness
     * @Return
     */
    private static final SnowflakeIdGenerator SNOWFLAKE_ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    /**
     * @Method
     * Description:
     *  查找所有文章
     * @Author weleness
     *
     * @Return
     */
    @Override
    public List<Article> findAll() {
        List<Article> all = articleDao.findALL();
        for (Article article : all) {
            // 把html特殊字符转换为html
            article.setA_text(HtmlUtils.htmlUnescape(article.getA_text()));
        }
        return all;
    }

    /**
     * @Method
     * Description:
     *  统计文章总数
     * @Author weleness
     *
     * @Return
     */
    @Override
    public Integer article_Count() {
        return articleDao.article_Count();
    }

    /**
     * @Method
     * Description:
     *  根据文章id查找文章
     * @Author weleness
     *
     * @Return
     */
    @Override
    public List<Article> findArticleByTagId(Long tag_id) {
        return articleDao.findArticleByTagId(tag_id);
    }

    /**
     * @Method
     * Description:
     *  查找最新文章
     * @Author weleness
     *
     * @Return
     */
    @Override
    public List<Article> findArticleNew() {
        return articleDao.findArticleNew();
    }

    /**
     * @param article     文章类
     * @param tag         等待解析的文章标签
     * @param category_id 文章的分类
     * @Method Description:
     * 保存文章方法
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO saveArticle(Article article, String[] tag, String category_id, String[] newTag) {
        ResultDTO resultDTO = null;
        if (!Objects.isNull(article)) {
            List<Tag> tagList = tagService.findByTagName(tag);
            if (tagList.contains(null)) {
                tagList = tagService.saveTags(tag);
            }
            if (!Objects.isNull(newTag)) {
                tagList.addAll(tagService.saveTags(newTag));
            }

            //转移html字符串
            article.setA_text(HtmlUtils.htmlEscapeHex(article.getA_text()));
            // 这里localDateTime.now（）要加上系统时钟，不然可能会造成精度不准
            article.setA_createTime((LocalDateTime.now(Clock.systemDefaultZone())));
            //保存归档日期
            Archive archive = Archive.builder().archiveName(DateUtils.format(DateUtils.localDateTime2Date(article.getA_createTime()), "yyyy")).build();
            //初始化最后一次的修改时间
            article.setA_last_update(article.getA_createTime());
            //生成文章雪花id
            article.setA_id(SNOWFLAKE_ID_GENERATOR.generateId());
            // 添加用户id
            article.setU_id(1L);
            // 初始化点赞和观看值为0
            article.setA_likeNums(0);
            article.setA_viewNums(0);
            // 查找对应的分类
            Category category = categoryService.findById(Integer.parseInt(category_id) + 2);
            //保存文章
            articleDao.saveArticle(article, category);
            // 将文章信息和标签信息存入中间表
            iArticle_tagService.saveInMiddle(article, tagList);

            resultDTO = new ResultDTO(ResultCode.OK_CODE.getCode(), "发布成功", true);
        } else {
            resultDTO = new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(), "对不起，服务器异常", false);
        }
        return resultDTO;
    }

}
