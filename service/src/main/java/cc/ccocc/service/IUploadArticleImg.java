package cc.ccocc.service;

import cc.ccocc.dto.UploadImgDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 11:59  20/01/2020
 * Description:
 *
 * @author Weleness
 */

public interface IUploadArticleImg {

    UploadImgDTO uploadArticleImage(MultipartFile file, HttpServletRequest request);
}
