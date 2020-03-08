package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminSiteNoticeService;
import cc.ccocc.dao.ISiteNoticeDao;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.SiteNotice;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 22:36  15/02/2020
 * Description:
 *
 * @author Weleness
 */

@Service("adminSiteNoticeService")
public class AdminSiteNoticeServiceImpl implements IAdminSiteNoticeService {

    @Autowired
    private ISiteNoticeDao siteNoticeDao;

    private static final IdGenerator ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    @Override
    public AdminDTO<List<SiteNotice>> findAll(Integer pageNo, Integer pageSize) {
        return new AdminDTO<List<SiteNotice>>(ResultCode.OK_CODE.getCode(), null, siteNoticeDao.findAll(pageNo, pageSize), siteNoticeCount(), true);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO addSiteNotice(String siteNoticeContent) {
        SiteNotice siteNotice = SiteNotice.builder().
                siteNoticeId(ID_GENERATOR.generateId()).
                siteNoticeContent(siteNoticeContent).
                createTime(LocalDateTime.now(Clock.systemDefaultZone())).build();
        return siteNoticeDao.addSiteNotice(siteNotice) > 0 ? new AdminDTO<>(ResultCode.OK_CODE.getCode(), "操作成功", null, null, true) : new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", null, null, false);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO deleteSiteNotices(Long[] siteNoticeId) {
        AdminDTO result = null;
        try {
            for (Long siteNotice : siteNoticeId) {
                siteNoticeDao.deleteSiteNotice(siteNotice);
            }
            result  = new AdminDTO<>(ResultCode.OK_CODE.getCode(),"删除成功",null,null,true);
        } catch (Exception e) {
            e.printStackTrace();
            result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(),"服务器异常",null,null,false);
        }
        return result;
    }

    @Override
    public Integer siteNoticeCount() {
        return siteNoticeDao.siteNoticeCount();
    }
}
