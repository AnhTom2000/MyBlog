package cc.ccocc.service;

import cc.ccocc.dto.SiteNoticeDTO;

import java.util.List;

/**
 * Created on 21:13  19/02/2020
 * Description:
 *
 * @author Weleness
 */

public interface ISiteNoticeService {

    public List<SiteNoticeDTO> findAll();
}
