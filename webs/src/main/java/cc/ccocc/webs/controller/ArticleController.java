package cc.ccocc.webs.controller;

import cc.ccocc.annotation.Action;
import cc.ccocc.annotation.BeforeSth;
import cc.ccocc.dto.*;
import cc.ccocc.exception.NoFundException;
import cc.ccocc.exception.NoPersonSelfException;
import cc.ccocc.pojo.Article;
import cc.ccocc.service.IArticleService;
import cc.ccocc.service.IArticle_CommentNotificationService;
import cc.ccocc.service.ICommentService;
import cc.ccocc.service.ICookieService;
import cc.ccocc.utils.result.ResultCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import static cc.ccocc.service.impl.AbstractOauthService.*;


/**
 * Created on 14:25  16/01/2020
 * Description:
 *
 * @author Weleness
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    @Qualifier("articleService")
    private IArticleService articleService;


    @Autowired
    @Qualifier("cookieService")
    private ICookieService cookieService;

    @Autowired
    @Qualifier("commentService")
    private ICommentService commentService;


    /**
     * @Method Description:
     * 文章发布接口
     * @Author weleness
     * @Return
     */
    @BeforeSth()
    @ResponseBody
    @RequestMapping(value = "/submit", produces = "application/json;charset=utf-8")
    public ResultDTO submit(Article article, @RequestParam(value = "tag[]", required = false) String[] tag,
                            @RequestParam(value = "category_id", required = false) String category_id,
                            @RequestParam(value = "newTag[]", required = false) String[] newTag,
                            HttpServletRequest request, HttpSession session) {

        return articleService.saveArticle(article, tag, category_id, newTag, (Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()));
    }

    /**
     * @Method Description:
     * 文章编辑接口
     * @Author weleness
     * @Return
     */
    @BeforeSth
    @ResponseBody
    @RequestMapping("/edit_markdown")
    public ResultDTO markdown_Edit(Article article, @RequestParam(value = "tag[]", required = false) String[] tag,
                                   @RequestParam(value = "category_id") String category_id,
                                   @RequestParam(value = "newTag[]", required = false) String[] newTag,
                                   HttpServletRequest request, HttpSession session) {
        Long userId = (Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue());
        return articleService.updateArticle(article, tag, category_id, newTag, userId);
    }

    /**
     * @Method Description:
     * 文章删除接口
     * @Author weleness
     * @Return
     */
    @BeforeSth()
    @ResponseBody
    @RequestMapping("/markdown_delete")
    public ResultDTO markdownDelete(@RequestParam("articleId") Long articleId, HttpServletRequest request) {
        ArticleDTO article = articleService.findArticleById(articleId);
        Long userId = (Long) request.getSession().getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue());
        if (article != null && article.getUser().getUserId().equals(userId)) {
            return articleService.deleteArticle(articleId, userId);
        }
        throw new NoFundException("404");
    }


    /**
     * @Method Description:
     * 文章点赞接口
     * @Author weleness
     * @Return
     */
    @BeforeSth
    @ResponseBody
    @RequestMapping("/addArticleLike")
    public ResultDTO addArticleLike(@RequestParam("articleId") Long articleId, @RequestParam("articleTitle") String articleTitle, @RequestParam("authId") Long authId, HttpServletRequest request, HttpSession session) {
        return articleService.addArticleLike(articleId, authId, (Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()), articleTitle);
    }

    /**
     * @Method Description:
     * 评论发布接口
     * @Author weleness
     * @Return
     */
    @BeforeSth
    @ResponseBody
    @RequestMapping("/comment/publishComment")
    public List<CommentDTO> publishComment(HttpServletRequest request, @RequestParam("commentContent") String commentContent, @RequestParam("articleId") Long articleId, @RequestParam("authId") Long authId, HttpSession session) {
        return commentService.insertArticleComment(commentContent, articleId, (Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()), authId);
    }

    /**
     * @Method Description:
     * 查询所有评论信息
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/comment/getAllComment")
    public List<CommentDTO> findAllComment(@RequestParam("articleId") Long articleId) {
        return commentService.findAllCommentByArticleId(articleId);
    }

    /**
     * @param articleId    文章的id（不需要）
     * @param replyContent 回复内容
     * @param parentId     回复的评论id
     * @param request      HttpServletRequest
     * @Method Description:
     * 发表评论回复
     * @Author weleness
     * @Return
     */
    @BeforeSth
    @ResponseBody
    @RequestMapping("/comment/publishReply")
    public ReplyDTO publishReply(@RequestParam("replyContent") String replyContent, @RequestParam("articleId") Long articleId, @RequestParam("parentId") Long parentId, @RequestParam(value = "authId") Long authId, HttpServletRequest request, HttpSession session) {
        return commentService.insertArticle_Comment_Reply(replyContent, articleId, parentId, (Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()), authId);
    }

    /**
     * @Method Description:
     * 评论点赞接口
     * @Author weleness
     * @Return
     */
    @BeforeSth()
    @RequestMapping("/comment/addCommentLike")
    @ResponseBody
    public ResultDTO addCommentLike(HttpServletRequest request,
                                    HttpSession session,
                                    @Param("commentId") Long commentId,
                                    @RequestParam("authId") Long authId,
                                    @RequestParam("articleId") Long articleId,
                                    @RequestParam("articleTitle") String articleTitle,
                                    @RequestParam("commentContent") String commentContent) {

        System.out.println((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()));
        return commentService.addCommentLike(commentId, (Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()), authId, articleId, articleTitle, commentContent);
    }


}
