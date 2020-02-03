package cc.ccocc.dao;

import cc.ccocc.pojo.Archive;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 20:01  17/01/2020
 * Description:
 * 归档dao
 *
 * @author Weleness
 */
@Repository
public interface IArchiveDao {
    /**
     * @Method Description:
     * 查询用户所有的归档
     * @Author weleness
     * @Return
     */
    @ResultMap("archive_map")
    @Select("SELECT a.archive_id,a.archive_name FROM tb_archive a INNER JOIN tb_user_archives_middle m ON m.archive_id = a.archive_id WHERE m.user_id = #{userId}  ORDER BY a.archive_id DESC")
    List<Archive> findArchives(@Param("userId") Long userId);

    /**
     * @param archive 归档信息
     * @Method Description:
     * 添加归档
     * @Author weleness
     * @Return
     */

    @Insert("INSERT INTO tb_archive(archive_name) VALUES(#{archive.archiveName})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="archive_id")
    void saveArchive(@Param("archive") Archive archive);

    /**
     * @Method
     * Description:
     *  查询归档年份
     * @Author weleness
     *
     * @Return
     */
    @Results(id = "archive_map", value = {
            @Result(id = true, column = "archive_id", property = "id"),
            @Result(column = "archive_name", property = "archiveName")
    })
    @Select("SELECT archive_id,archive_name FROM tb_archive WHERE archive_name = #{year}")
    Archive findArchiveByYear(@Param("year") String year);

}
