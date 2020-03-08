package cc.ccocc.admin.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.WebInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created on 17:48  16/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminWebInfoService {

    public AdminDTO<WebInfo> findAll();


    public AdminDTO updateMetaDescription(Integer webInfoId, String description);


    public AdminDTO updateMetaKeyWord(Integer webInfoId, String keyWord);


    public AdminDTO updateCopyRigtht(Integer webInfoId, String copyRight);


    public AdminDTO updateIcp(Integer webInfoId, String icp);

    public AdminDTO updateMeta(Integer webInfoId, String description, String keywords, String copyRight, String icp);
}
