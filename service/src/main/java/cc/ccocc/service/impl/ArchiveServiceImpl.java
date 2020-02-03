package cc.ccocc.service.impl;

import cc.ccocc.dao.IArchiveDao;
import cc.ccocc.dto.ArchiveDTO;
import cc.ccocc.pojo.Archive;
import cc.ccocc.service.IArchiveService;
import cc.ccocc.service.IUser_ArchivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 20:18  17/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("archiveService")
public class ArchiveServiceImpl implements IArchiveService {
    @Autowired
    private IArchiveDao archiveDao;

    @Autowired
    @Qualifier("user_archivesService")
    private IUser_ArchivesService user_archivesService;

    /**
     * @param userId  用户主键  根据用户主键查询用户的归档信息
     * @Method
     * Description:
     *  查找用户的归档
     * @Author weleness
     *
     * @Return
     */
    @Override
    public List<ArchiveDTO> findArchives(Long userId) {
        List<Archive> archives = archiveDao.findArchives(userId);
        List<ArchiveDTO> user_archives = null;
        if(archives != null){
            user_archives = new ArrayList<>();
            BeanCopier beanCopier = BeanCopier.create(Archive.class,ArchiveDTO.class,false);
            for (Archive archive : archives) {
                ArchiveDTO archiveDTO = ArchiveDTO.builder().build();
                beanCopier.copy(archive,archiveDTO,null);
                user_archives.add(archiveDTO);
            }
        }
        return user_archives;
    }

    /**
     * @param userId 用户id
     * @param archive 归档信息
     * @Method
     * Description:
     *  保存归档信息到归档表和中间表
     * @Author weleness
     *
     * @Return
     */
    @Override
    public void saveArchive(Archive archive,Long userId) {
        // 保存到归档表后返回一个插入的主键
        archiveDao.saveArchive(archive);
        // 将归档主键和用户主键存到中间表
        user_archivesService.addInUser_Archives(userId,archive.getId());
    }

    /**
     * @param year 归档日期
     * @Method
     * Description:
     *  查询归档日期
     * @Author weleness
     *
     * @Return
     */
    @Override
    public Archive findArchiveByYear(String year) {
        return archiveDao.findArchiveByYear(year);
    }


}
