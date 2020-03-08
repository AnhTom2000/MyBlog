package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminWebInfoService;
import cc.ccocc.dao.IWebInfoDao;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.WebInfo;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 17:49  16/02/2020
 * Description:
 *
 * @author Weleness
 */

@Service("webInfoService")
public class AdminWebInfoServiceImpl implements IAdminWebInfoService {

    @Autowired
    private IWebInfoDao webInfoDao;

    @Override
    public AdminDTO<WebInfo> findAll() {
        return new AdminDTO<WebInfo>(ResultCode.OK_CODE.getCode(), null, webInfoDao.findAll(), null, true);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO updateMetaDescription(Integer webInfoId,String description) {
        AdminDTO result = null;
        if (webInfoDao.updateMetaDescription(webInfoId,description) > 0) {
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "修改成功", null, null, true);
        } else result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", null, null, false);
        return result;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO updateMetaKeyWord(Integer webInfoId,String keyWord) {
        AdminDTO result = null;
        if (webInfoDao.updateMetaKeyWord(webInfoId,keyWord) > 0) {
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "修改成功", null, null, true);
        } else result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", null, null, false);
        return result;
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO updateCopyRigtht(Integer webInfoId,String copyRight) {
        AdminDTO result = null;
        if (webInfoDao.updateCopyRight(webInfoId,copyRight) > 0) {
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "修改成功", null, null, true);
        } else result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", null, null, false);
        return result;
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO updateIcp(Integer webInfoId,String icp) {
        AdminDTO result = null;
        if (webInfoDao.updateIcp(webInfoId,icp) > 0) {
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "修改成功", null, null, true);
        } else result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", null, null, false);
        return result;
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO updateMeta(Integer webInfoId, String description, String keywords, String copyRight, String icp) {
        AdminDTO result = null;
        if(description!=null) result = updateMetaDescription(webInfoId, description);
        else if(keywords!=null) result = updateMetaKeyWord(webInfoId,keywords);
        else if(copyRight!=null) result = updateCopyRigtht(webInfoId, copyRight);
        else if(icp!=null) result = updateIcp(webInfoId, icp);
        return result;
    }
}
