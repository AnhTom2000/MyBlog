package cc.ccocc.dao;

import cc.ccocc.pojo.SiteNotice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 22:24  15/02/2020
 * Description:
 *
 * @author Weleness
 */
@Repository
public interface ISiteNoticeDao {


    @Results(id = "siteNotice_map",value = {
            @Result(id = true,column = "siteNotice_id",property = "siteNoticeId"),
            @Result(column = "siteNotice_content",property = "siteNoticeContent"),
            @Result(column = "create_time",property = "createTime",javaType = LocalDateTime.class)
    })
    @Select("SELECT siteNotice_id,siteNotice_content,create_time FROM tb_siteNotice LIMIT #{pageNo},#{pageSize} ")
    public List<SiteNotice> findAll(@Param("pageNo") Integer pageNo , @Param("pageSize") Integer pageSize);

    @Insert("INSERT INTO tb_siteNotice(siteNotice_id,siteNotice_content,create_time) VALUES(#{siteNotice.siteNoticeId},#{siteNotice.siteNoticeContent},#{siteNotice.createTime})")
    public Integer addSiteNotice(@Param("siteNotice") SiteNotice siteNotice);

    @Delete("DELETE FROM tb_siteNotice WHERE siteNotice_id = #{siteNoticeId}")
    public Integer deleteSiteNotice(@Param("siteNoticeId") Long siteNoticeId);

    @Select("SELECT COUNT(*) FROM tb_siteNotice")
    public Integer siteNoticeCount();
}
