package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminUploadImgService;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.UploadImgDTO;
import cc.ccocc.utils.result.ResultCode;
import cc.ccocc.utils.upload.CosUtils;
import cc.ccocc.utils.upload.UploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 21:48  12/02/2020
 * Description:
 *
 * @author Weleness
 */

@Service("adminUploadImgService")
public class AdminUploadImgServiceImpl implements IAdminUploadImgService {

    private static final String ADMIN_TYPE = "admin";

    private static final String Admin_path = "src/main/resources/static/upload/user";
    @Override
    public AdminDTO uploadAdminImage(MultipartFile file, HttpServletRequest request) {

        return new AdminDTO<>(ResultCode.OK_CODE.getCode(),null,UploadUtils.comcatURL(CosUtils.uploadCos(file, Admin_path, ADMIN_TYPE), ADMIN_TYPE),null,true );
    }
}
