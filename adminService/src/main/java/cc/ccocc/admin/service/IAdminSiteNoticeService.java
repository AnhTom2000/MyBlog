package cc.ccocc.admin.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.SiteNotice;

import java.util.List;

/**
 * Created on 22:34  15/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminSiteNoticeService {

    public AdminDTO<List<SiteNotice>> findAll(Integer pageNo,Integer pageSize);

    public AdminDTO addSiteNotice (String siteNoticeContent);

    public AdminDTO deleteSiteNotices(Long[] siteNoticeId);

    public Integer siteNoticeCount();
}
