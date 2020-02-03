package cc.ccocc.service;

import org.apache.ibatis.annotations.Param;

/**
 * Created on 21:42  03/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IUser_ArchivesService {

    Integer addInUser_Archives( Long userId,  int archiveId );
}
