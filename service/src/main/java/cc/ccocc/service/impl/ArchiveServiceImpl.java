package cc.ccocc.service.impl;

import cc.ccocc.dao.IArchiveDao;
import cc.ccocc.service.IArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 20:18  17/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service
public class ArchiveServiceImpl implements IArchiveService {
    @Autowired
    private IArchiveDao archiveDao;

    @Override
    public List<String> findArchives() {
        return archiveDao.findArchives();
    }
}
