package cc.ccocc.webs.controller;

import cc.ccocc.dto.ArticleDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UploadImgDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Article;
import cc.ccocc.service.IArticleService;
import cc.ccocc.service.ICookieService;
import cc.ccocc.service.IUploadArticleImg;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static cc.ccocc.service.impl.AbstructOauthService.*;


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
    @Qualifier("uploadArticleImgService")
    private IUploadArticleImg uploadArticleImg;

    @Autowired
    @Qualifier("cookieService")
    private ICookieService cookieService;

    @RequestMapping(value = "/submit", produces = "application/json;charset=utf-8")
    public ResultDTO submit(Article article, @RequestParam(value = "tag[]", required = false) String[] tag, @RequestParam(value = "category_id", required = false) String category_id, @RequestParam(value = "newTag[]", required = false) String[] newTag) {
        return articleService.saveArticle(article, tag, category_id, newTag);
    }

    @RequestMapping(value = "/uploadimg", produces = "application/json;charset=utf-8")
    public UploadImgDTO uploadImg(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        return uploadArticleImg.uploadArticleImage(file, request);
    }


    @ResponseBody
    @RequestMapping("/addArticleLike")
    public ResultDTO addArticleLike(@RequestParam("articleId") String articleId, HttpServletRequest request) {
        System.out.println("点赞");
        ResultDTO result = null;
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY,request)) != null) {
            Long userId = (Long) request.getSession().getAttribute(userCookie.getValue());
            if ( userId != null) {
                result = articleService.addArticleLike(Long.parseLong(articleId),userId);
            }else {
                result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("请先登陆").status(false).build();
            }
        } else {
            result = ResultDTO.builder().code(ResultCode.CLIENT_ERROR_CODE.getCode()).message("请先登陆").status(false).build();
        }

        return result;
    }

    @RequestMapping("/publishComment")
    public ResultDTO publisComment(@RequestParam("commentContent") String commentContent , @RequestParam("articleId") String articleId){
            return  null;
    }


}
