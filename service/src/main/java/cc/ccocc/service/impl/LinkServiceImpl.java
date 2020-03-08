package cc.ccocc.service.impl;

import cc.ccocc.dao.ILinkDao;
import cc.ccocc.pojo.Link;
import cc.ccocc.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 21:56  19/02/2020
 * Description:
 *
 * @author Weleness
 */

@Service("linkService")
public class LinkServiceImpl implements ILinkService {

    @Autowired
    private ILinkDao linkDao;

    @Override
    public List<Link> findAll() {
        return linkDao.findAll(0,linkDao.linkCount());
    }
}
