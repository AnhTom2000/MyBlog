package cc.ccocc.service;

import cc.ccocc.dto.ResultDTO;

/**
 * Created on 05:25  25/01/2020
 * Description:
 *
 * @author Weleness
 */

public interface IArticle_UserService {

    Integer addInMiddle(Long articleId,Long userId);

    ResultDTO checkArticleIsLikeByUser(Long articleId , Long userId);

}
