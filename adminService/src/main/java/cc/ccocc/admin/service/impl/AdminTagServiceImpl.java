package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminTagService;
import cc.ccocc.dao.ITagDao;
import cc.ccocc.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 15:06  11/02/2020
 * Description:
 *
 * @author Weleness
 */

@Service("adminTagService")
public class AdminTagServiceImpl implements IAdminTagService {

    @Autowired
    private ITagDao tagDao;


    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public void deleteByUser(Long userId) {
        tagDao.deleteTagByUser(userId);
    }

    /**
     *
     * @Method
     * Description:
     *  <p>查询标签数量</p>
     * @Author weleness
     *
     * @Return
     */
    @Override
    public Integer TagCount() {
        return tagDao.tag_Count();
    }
}
