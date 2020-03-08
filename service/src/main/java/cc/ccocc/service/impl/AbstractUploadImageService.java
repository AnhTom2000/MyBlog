package cc.ccocc.service.impl;

import cc.ccocc.dto.UploadImgDTO;
import cc.ccocc.service.IUploadImg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 20:27  04/02/2020
 * Description:
 * 上传图片的操作基类
 *
 * @author Weleness
 */

public abstract class AbstractUploadImageService implements IUploadImg {

    @Value("${uploadPath_article}")
    protected String FILEPATH_ARTICLE;

    @Value("${uploadPath_user}")
    protected String FILEPATH_USER;

    static final String ARTICLE_TYPE = "article";

    static final String USER_TYPE = "user";

    @Override
    public UploadImgDTO uploadArticleImage(MultipartFile file, HttpServletRequest request) {
        return null;
    }

    @Override
    public UploadImgDTO uploadUserImage(MultipartFile file, HttpServletRequest request, Long userId) {
        return null;
    }

}
