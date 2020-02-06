package cc.ccocc.webs.controller;

import cc.ccocc.dto.*;
import cc.ccocc.pojo.Article;
import cc.ccocc.service.IArticleService;
import cc.ccocc.service.ICommentService;
import cc.ccocc.service.ICookieService;
import cc.ccocc.utils.result.ResultCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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

    @ResponseBody
    @RequestMapping(value = "/submit", produces = "application/json;charset=utf-8")
    public ResultDTO submit(Article article, @RequestParam(value = "tag[]", required = false) String[] tag,
                            @RequestParam(value = "category_id", required = false) String category_id,
                            @RequestParam(value = "newTag[]", required = false) String[] newTag,
                            HttpServletRequest request) {
        ResultDTO result = null;
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = null;
            if ((userId = (Long) request.getSession().getAttribute(userCookie.getValue())) != null) {
                result = articleService.saveArticle(article, tag, category_id, newTag, userId);
            }
        } else result = new ResultDTO(ResultCode.CLIENT_ERROR_CODE.getCode(), "请先登陆", false);
        return result;
    }

    @ResponseBody
    @RequestMapping("/edit_markdown")
    public ResultDTO markdown_Edit(Article article, @RequestParam(value = "tag[]", required = false) String[] tag,
                          @RequestParam(value = "category_id") String category_id,
                          @RequestParam(value = "newTag[]", required = false) String[] newTag,
                          HttpServletRequest request) {
        ResultDTO result = null;
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = null;
            if ((userId = (Long) request.getSession().getAttribute(userCookie.getValue())) != null) {
                result = articleService.updateArticle(article, tag, category_id, newTag, userId);
            }
        } else result = new ResultDTO(ResultCode.CLIENT_ERROR_CODE.getCode(), "请先登陆", false);
        return result;
    }

    @ResponseBody
    @RequestMapping("/markdown_delete")
    public ResultDTO markdownDelete(@RequestParam("articleId")Long articleId , @RequestParam("authId") Long authId ,HttpServletRequest request){
        ResultDTO result = null;
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = null;
            if ((userId = (Long) request.getSession().getAttribute(userCookie.getValue())) != null) {
                if(userId.equals(authId)){
                    result = articleService.deleteArticle(articleId);
                }
            }
        } else result = new ResultDTO(ResultCode.CLIENT_ERROR_CODE.getCode(), "请先登陆", false);
        return result;
    }


    @ResponseBody
    @RequestMapping("/addArticleLike")
    public ResultDTO addArticleLike(@RequestParam("articleId") String articleId, HttpServletRequest request) {
        System.out.println("点赞");
        ResultDTO result = null;
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            if (userId != null) {
                result = articleService.addArticleLike(Long.parseLong(articleId), userId);
            } else {
                result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("请先登陆").status(false).build();
            }
        } else {
            result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("请先登陆").status(false).build();
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/comment/publishComment")
    public List<CommentDTO> publishComment(HttpServletRequest request, @RequestParam("commentContent") String commentContent, @RequestParam("articleId") String articleId) {
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            if (userId != null) {
                return commentService.insertArticleComment(commentContent, articleId, userId);
            }
        }
        return null;
    }

    /**
     * @Method Description:
     * 查询所有评论信息
     * @Author weleness
     * @Return
     */
    @ResponseBody
    @RequestMapping("/comment/getAllComment")
    public List<CommentDTO> findAllComment(@RequestParam("articleId") String articleId) {
        return commentService.findAllCommentByArticleId(Long.parseLong(articleId));
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
    @ResponseBody
    @RequestMapping("/comment/publishReply")
    public ReplyDTO publishReply(@RequestParam("replyContent") String replyContent, @RequestParam("articleId") String articleId, @RequestParam("parentId") String parentId, HttpServletRequest request) {
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            if (userId != null) {
                return commentService.insertArticle_Comment_Reply(replyContent, articleId, parentId, userId);
            } else return null;
        }
        return null;

    }

    @RequestMapping("/comment/addCommentLike")
    @ResponseBody
    public ResultDTO addCommentLike(HttpServletRequest request, @Param("commentId") String commentId) {
        Cookie userCookie = null;
        ResultDTO result = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            if (userId != null) {
                result = commentService.addCommentLike(commentId, userId);
            }
        } else {
            result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("请先登陆").status(false).build();
        }
        return result;
    }


}
