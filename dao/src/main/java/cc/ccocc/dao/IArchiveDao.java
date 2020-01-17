package cc.ccocc.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 20:01  17/01/2020
 * Description:
 *
 * @author Weleness
 */
@Repository
public interface IArchiveDao {

    @Select("SELECT archive_name FROM tb_archive order by archive_id desc")
    List<String> findArchives();

}
