package cc.ccocc.admin.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.UploadImgDTO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 11:59  20/01/2020
 * Description:
 *
 * @author Weleness
 */

public interface IAdminUploadImgService {


    AdminDTO uploadAdminImage(MultipartFile file, HttpServletRequest request);

}
