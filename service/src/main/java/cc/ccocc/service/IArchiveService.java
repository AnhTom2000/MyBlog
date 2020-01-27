package cc.ccocc.service;

import cc.ccocc.pojo.Archive;

import java.util.List;

/**
 * Created on 20:17  17/01/2020
 * Description:
 *
 * @author Weleness
 */

public interface IArchiveService {

    List<String>  findArchives();

    void saveArchive(Archive archive);

    Archive findArchiveByYear(String year);
}
