package cc.ccocc.dao;

import cc.ccocc.pojo.Link;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 23:51  15/02/2020
 * Description:
 *
 * @author Weleness
 */
@Repository
public interface ILinkDao {

    @Results(id = "link_map",value = {
            @Result(id = true,column = "link_id",property = "linkId"),
            @Result(column = "link_name",property = "linkName"),
            @Result(column = "href",property = "href")
    })
    @Select("SELECT link_id,link_name,href FROM tb_link LIMIT #{pageNo} , #{pageSize}")
    public List<Link> findAll(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    @Update("UPDATE tb_link SET link_name = #{linkName}, href = '${href}' WHERE link_id = ${linkId}")
    public Integer updateLink(@Param("linkId") Integer linkId,@Param("linkName") String linkName,@Param("href") String href);

    @Delete("DELETE FROM tb_link WHERE link_id = #{linkId}")
    public Integer deleteLink(@Param("linkId") Integer linkId);

    @Insert("INSERT INTO tb_link(link_name,href) VALUES(#{link.linkName},#{link.href})")
    public Integer addLink(@Param("link") Link link);

    @Select("SELECT COUNT(*) FROM tb_link")
    public Integer linkCount();
}
