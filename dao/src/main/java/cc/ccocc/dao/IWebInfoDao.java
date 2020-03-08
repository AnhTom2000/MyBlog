package cc.ccocc.dao;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.WebInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Created on 17:02  16/02/2020
 * Description:
 *
 * @author Weleness
 */
@Repository
public interface IWebInfoDao {

    @Results(id = "webInfo_map",value = {
            @Result(id = true,column = "web_info_id" ,property = "webInfoId"),
            @Result(column = "description",property = "description"),
            @Result(column = "keywords" , property = "keywords"),
            @Result(column = "icp_info",property = "icpInfo"),
            @Result(column = "copyright",property = "copyright"),
            @Result(column = "logo_url",property = "logoUrl"),
    })
    @Select("SELECT web_info_id,description,keywords,icp_info,copyright,logo_url FROM tb_web_info")
    public WebInfo findAll();

    @Update("UPDATE tb_web_info SET description = #{description} WHERE web_info_id = #{webInfoId}")
    public Integer updateMetaDescription(@Param("webInfoId") Integer webInfoId,@Param("description") String description);

    @Update("UPDATE tb_web_info SET keywords = #{keywords} WHERE web_info_id = #{webInfoId}")
    public Integer updateMetaKeyWord(@Param("webInfoId") Integer webInfoId,@Param("keywords") String keywords);

    @Update("UPDATE tb_web_info SET copyright = #{copyRight} WHERE web_info_id = #{webInfoId}")
    public Integer updateCopyRight(@Param("webInfoId") Integer webInfoId, @Param("copyRight") String copyRight);

    @Update("UPDATE tb_web_info SET icp_info = #{icp} WHERE web_info_id = #{webInfoId} ")
    public Integer updateIcp(@Param("webInfoId") Integer webInfoId,@Param("icp")String icp);
}
