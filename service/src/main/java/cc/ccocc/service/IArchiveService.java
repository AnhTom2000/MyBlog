package cc.ccocc.service;

import cc.ccocc.dto.ArchiveDTO;
import cc.ccocc.pojo.Archive;

import java.util.List;

/**
 * Created on 20:17  17/01/2020
 * Description:
 *
 * @author Weleness
 */

public interface IArchiveService {

    List<ArchiveDTO>  findArchives(Long userId);

    void saveArchive(Archive archive,Long userId);

    Archive findArchiveByYear(String year);

    void  addArchiveArticleCount(String year);

    List<ArchiveDTO> findAllArchives();
}
