package cc.ccocc.dao;

import cc.ccocc.pojo.Archive;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 20:01  17/01/2020
 * Description:
 *  归档dao
 * @author Weleness
 */
@Repository
public interface IArchiveDao {
    /**
     * @Method
     * Description:
     *  查询所有归档
     * @Author weleness
     *
     * @Return
     */
    @Select("SELECT archive_name FROM tb_archive order by archive_id desc")
    List<String> findArchives();

    /**
     * @Method
     * Description:
     *  添加归档
     * @Author weleness
     *
     * @Return
     * @param archive  归档信息
     */
    @Insert("INSERT INTO tb_archive(archive_name) VALUES(#{archive.archiveName})")
    void saveArchive(@Param("archive") Archive archive);



    @Results(id = "archive_map",value = {
            @Result(id = true ,column = "archive_id",property = "id"),
            @Result(column = "archive_name",property = "archiveName")
    })
    @Select("SELECT archive_id,archive_name FROM tb_archive WHERE archive_name = #{year}")
    Archive findArchiveByYear(@Param("year") String year);

}
