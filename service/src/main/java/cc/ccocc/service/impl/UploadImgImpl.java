package cc.ccocc.service.impl;

import cc.ccocc.dto.UploadImgDTO;
import cc.ccocc.service.IUserService;
import cc.ccocc.utils.upload.CosUtils;
import cc.ccocc.utils.upload.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;


/**
 * Created on 12:02  20/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("uploadArticleImgService")
public class UploadImgImpl extends AbstractUploadImageService {

    @Autowired
    @Lazy
    IUserService userService;

    @Override
    public UploadImgDTO uploadArticleImage(MultipartFile file, HttpServletRequest request) {
        return UploadImgDTO.builder().success(1).message("上传成功").url(UploadUtils.comcatURL(CosUtils.uploadCos(file, FILEPATH_ARTICLE, ARTICLE_TYPE), ARTICLE_TYPE)).build();
    }

    @Override
    public UploadImgDTO uploadUserImage(MultipartFile file, HttpServletRequest request,Long userId) {
        String url =UploadUtils.comcatURL(CosUtils.uploadCos(file, FILEPATH_USER, USER_TYPE), USER_TYPE) ;
        UploadImgDTO result = null;
        if(userService.updateUserImage(url,userId)> 0){
            result = UploadImgDTO.builder().success(1).message("上传成功").url(url).build();
        }else result = UploadImgDTO.builder().success(0).message("上传失败").url("").build();
        return result;
    }


}
