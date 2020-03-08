package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminUser_ArchivesService;
import cc.ccocc.dao.IUser_ArchivesDao;
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

@Service("adminUser_archivesService")
public class AdminUser_ArchivesServiceImpl implements IAdminUser_ArchivesService {

    @Autowired
    private IUser_ArchivesDao user_archivesDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public Integer addInUser_Archives(Long userId, Long archiveId) {
        return user_archivesDao.addInUser_Archives(userId, archiveId);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void deleteByUser(Long userId) {
        user_archivesDao.deleteUser_ArchivesByUser(userId);
    }
}
