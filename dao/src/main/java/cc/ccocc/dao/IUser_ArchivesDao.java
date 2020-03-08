package cc.ccocc.dao;

import cc.ccocc.pojo.Archive;
import org.apache.ibatis.annotations.Delete;
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
    @Insert("INSERT INTO tb_user_archives_middle(archive_id,user_id) VALUES(#{archiveId},#{userId})")
    Integer addInUser_Archives(@Param("userId") Long userId, @Param("archiveId") Long archiveId );

    @Delete("DELETE FROM tb_user_archives_middle WHERE user_id = #{userId}")
    Integer deleteUser_ArchivesByUser(@Param("userId") Long userId);
}
