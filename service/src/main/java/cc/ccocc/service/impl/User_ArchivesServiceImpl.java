package cc.ccocc.service.impl;

import cc.ccocc.dao.IUser_ArchivesDao;
import cc.ccocc.service.IUser_ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 21:43  03/02/2020
 * Description:
 *
 * @author Weleness
 */

@Service("user_archivesService")
public class User_ArchivesServiceImpl implements IUser_ArchivesService {

    @Autowired
    private IUser_ArchivesDao user_archivesDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public Integer addInUser_Archives(Long userId, Long archiveId) {
        return user_archivesDao.addInUser_Archives(userId, archiveId);
    }
}
