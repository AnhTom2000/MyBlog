package cc.ccocc.dao;

import cc.ccocc.pojo.Archive;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
    @Select("SELECT a.archive_id,a.archive_name,a.archive_article_count,a.createTime FROM tb_archive a INNER JOIN tb_user_archives_middle m ON m.archive_id = a.archive_id WHERE m.user_id = #{userId}  ORDER BY a.archive_id DESC")
    List<Archive> findArchives(@Param("userId") Long userId);

    @Results(id = "archive_list",value = {
            @Result(id = true, column = "archive_id", property = "archive_id",javaType = Long.class),
            @Result(column = "archive_name", property = "archiveName"),
            @Result(column = "archive_article_count",property = "archive_article_count"),
            @Result(column = "createTime",property = "createTime",javaType = LocalDateTime.class),
            @Result(column = "YEAR(createTime)",property = "archiveYear",javaType = String.class),
            @Result(column = "archive_id",property = "articles",jdbcType = JdbcType.BIGINT,javaType = List.class,many = @Many(select = "cc.ccocc.dao.IArticleDao.findArticleByArchiveId",fetchType = FetchType.LAZY))
    })
    @Select("SELECT archive_id,archive_name,archive_article_count,createTime,YEAR(createTime) FROM tb_archive")
    public List<Archive> findAllArchives();

    /**
     * @param archive 归档信息
     * @Method Description:
     * 添加归档
     * @Author weleness
     * @Return
     */

    @Insert("INSERT INTO tb_archive(archive_id,archive_name,archive_article_count,createTime) VALUES(#{archive.archive_id},#{archive.archiveName},#{archive.archive_article_count},#{archive.createTime})")
    @Options(useGeneratedKeys=true, keyProperty="archive_id", keyColumn="archive_id")
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
            @Result(id = true, column = "archive_id", property = "archive_id"),
            @Result(column = "archive_name", property = "archiveName"),
            @Result(column = "archive_article_count",property = "archive_article_count"),
            @Result(column = "createTime",property = "createTime",javaType = LocalDateTime.class),
    })
    @Select("SELECT ar.archive_id,ar.archive_name,ar.archive_article_count,ar.createTime FROM tb_archive ar WHERE ar.archive_name = #{archiveName} LIMIT 0,1 ")
    Archive findArchiveByYear(@Param("archiveName") String archiveName);


    @Update("UPDATE tb_archive SET archive_article_count = archive_article_count+1 WHERE archive_name = #{archiveName}")
    void addArchiveArticleCount(@Param("archiveName") String archiveName);





}
