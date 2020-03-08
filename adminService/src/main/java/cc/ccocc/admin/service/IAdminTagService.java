package cc.ccocc.admin.service;

import cc.ccocc.dto.ArticleDTO;
import cc.ccocc.pojo.Tag;

import java.util.List;

/**
 * Created on 15:04  11/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminTagService {

    public void deleteByUser(Long userId);

    public Integer TagCount();

}
