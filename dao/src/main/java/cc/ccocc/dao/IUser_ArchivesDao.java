package cc.ccocc.dao;

import cc.ccocc.pojo.Archive;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * Created on 21:15  03/02/2020
 * Description:
 *  用户归档的dao
 * @author Weleness
 */
@Repository
public interface IUser_ArchivesDao {

    /**
     * @Method
     * Description:
     *  往中间表插入数据
     * @Author weleness
     *
     * @Return
     */
    @Insert("INSERT INTO tb_user_archives_middle(archive_id,user_id) VALUES(#{archiveId},#{archiveId})")
    Integer addInUser_Archives(@Param("userId") Long userId, @Param("archiveId") int archiveId );
}
