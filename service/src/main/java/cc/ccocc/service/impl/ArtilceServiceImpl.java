package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticleDao;
import cc.ccocc.dao.ITagDao;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.pojo.Article;
import cc.ccocc.service.IArticleService;
import cc.ccocc.service.IArticle_TagService;
import cc.ccocc.service.ITagService;
import cc.ccocc.utils.date.DateUtils;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Random;

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
    @Qualifier("tagdao")
    private ITagDao tagDao;
    @Autowired
    @Qualifier("tagService")
    private ITagService tagService;
    @Autowired
    @Qualifier("IArticle_TagService")
    private IArticle_TagService iArticle_tagService;


    /**
     * @Method
     * Description:
     *  获得一个全局唯一的雪花id生成器对象
     *  @Author weleness
     *
     * @Return
     */
    private static final SnowflakeIdGenerator SNOWFLAKE_ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    @Override
    public List<Article> findAll() {
        return articleDao.findALL();
    }

    @Override
    public Integer article_Count() {
        return articleDao.article_Count();
    }

    @Override
    public List<Article> findArticleByTagId(Integer tag_id) {
        return articleDao.findArticleByTagId(tag_id);
    }

    @Override
    public List<Article> findArticleNew() {
        return articleDao.findArticleNew();
    }
/**
 * @Method
 * Description:
 *  保存文章方法
 * @Author weleness
 *
 * @Return
 * @param  article 文章类
 */
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Throwable.class)
    @Override
    public ResultDTO saveArticle(Article article) {
        ResultDTO resultDTO = null;
        if (!Objects.isNull(article)) {
            article.setA_createTime(DateUtils.localDateTime2Date(LocalDateTime.now()));
            article.setA_id(SNOWFLAKE_ID_GENERATOR.generateId());
            if(!Objects.isNull(article.getTag())) {
                articleDao.saveArticle(article); // 存入文章表
                tagService.save(article.getTag()); // 存入标签表
                iArticle_tagService.saveInMiddle(article); // 存入中间表
                resultDTO = new ResultDTO(ResultCode.OK_CODE.getCode(), "发布成功", true);
            }else {
                resultDTO = new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(),"对不起，服务器异常",false);
            }
        }else {
            resultDTO = new ResultDTO(ResultCode.SERVER_ERROR_CODE.getCode(),"对不起，服务器异常",false);
        }
        return resultDTO;
    }

}
