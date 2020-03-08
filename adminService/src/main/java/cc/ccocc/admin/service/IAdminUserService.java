package cc.ccocc.admin.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created on 19:50  10/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminUserService {

    public AdminDTO<List<User>> findAllUser(Integer pageNo, Integer pageSize);

    public AdminDTO<User> updateUser(Long userId, String email, String phone, Boolean gender);

    public AdminDTO<List<User>> addUser(String userName, String password, Short age, Boolean gender, String email);

    public Integer userCount();

    public AdminDTO<User> deleteUsers(Long[] userIds);

    public AdminDTO<List<User>> searchUser(Long userId,String userName,String email);

    public AdminDTO lockedUser(Long userId,String type);

    public User findUserByName(String userName);

    public User findUserByArticleId(Long articleId);
}
