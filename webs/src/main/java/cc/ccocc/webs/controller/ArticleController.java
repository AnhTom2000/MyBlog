package cc.ccocc.webs.controller;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UploadImgDTO;
import cc.ccocc.pojo.Article;
import cc.ccocc.service.IArticleService;
import cc.ccocc.service.IUploadArticleImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * Created on 14:25  16/01/2020
 * Description:
 *
 * @author Weleness
 */
@RestController
public class ArticleController {

    @Autowired
    @Qualifier("articleService")
    private IArticleService articleService;
    @Autowired
    @Qualifier("uploadArticleImgService")
    private IUploadArticleImg uploadArticleImg;

    @RequestMapping(value = "/submit", produces = "application/json;charset=utf-8")
    public ResultDTO submit(Article article, @RequestParam(value = "tag[]",required = false) String[] tag, @RequestParam(value = "category_id",required = false) String category_id, @RequestParam(value = "newTag[]",required = false) String[] newTag) {
        return articleService.saveArticle(article, tag, category_id, newTag);
    }

    @RequestMapping(value = "/uploadimg", produces = "application/json;charset=utf-8")
    public UploadImgDTO uploadImg(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        return uploadArticleImg.uploadArticleImage(file, request);
    }

}
