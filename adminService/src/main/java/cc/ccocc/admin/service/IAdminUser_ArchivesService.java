package cc.ccocc.admin.service;

/**
 * Created on 21:42  03/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminUser_ArchivesService {

    Integer addInUser_Archives(Long userId, Long archiveId);

    void  deleteByUser(Long userId);
}
