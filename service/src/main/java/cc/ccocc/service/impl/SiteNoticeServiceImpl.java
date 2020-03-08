package cc.ccocc.service.impl;

import cc.ccocc.dao.ISiteNoticeDao;
import cc.ccocc.dto.SiteNoticeDTO;
import cc.ccocc.pojo.SiteNotice;
import cc.ccocc.service.ISiteNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 21:17  19/02/2020
 * Description:
 *
 * @author Weleness
 */

@Service("siteNoticeService")
public class SiteNoticeServiceImpl implements ISiteNoticeService {

    @Autowired
    private ISiteNoticeDao siteNoticeDao;

    /**
     * @Method
     * Description:
     *  查询网站公告
     * @Author weleness
     *
     * @Return
     */
    @Override
    public List<SiteNoticeDTO> findAll() {
        List<SiteNotice> siteNotices = siteNoticeDao.findAll(0, siteNoticeDao.siteNoticeCount());
        List<SiteNoticeDTO> siteNoticeDTOList = null;
        if (siteNotices != null) {
            BeanCopier beanCopier = BeanCopier.create(SiteNotice.class, SiteNoticeDTO.class, false);
            siteNoticeDTOList = new ArrayList<>();
            for (SiteNotice siteNotice : siteNotices) {
                SiteNoticeDTO siteNoticeDTO = new SiteNoticeDTO();
                beanCopier.copy(siteNotice, siteNoticeDTO, null);
                siteNoticeDTOList.add(siteNoticeDTO);
            }
        }
        return siteNoticeDTOList;
    }
}
