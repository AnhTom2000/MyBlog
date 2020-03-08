package cc.ccocc.service;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Oauth;
import cc.ccocc.pojo.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 21:56  21/01/2020
 * Description:
 *
 * @author Weleness
 */

public interface IUserService  {

    public UserDTO findUserByOauth(Oauth oauth);

    public ResultDTO checkUserExsitByName(String username);

    public ResultDTO checkUserExsitByEmail(String email);

    public ResultDTO oauthInformationComplete(String username,String email, String verificationCode, HttpServletRequest request, HttpServletResponse response);

    public ResultDTO  addOauthUser(String email , String username ,Oauth oauth );
 
    public ResultDTO login(String name ,String password,HttpServletRequest request,HttpServletResponse response);

    public ResultDTO register (String name,String email, String password,String verificationCode ,HttpServletRequest request,HttpServletResponse response);

    public UserDTO findUserById(Long userID);

    public User findUserByName(String userName);

    public void findUserInfo(Model model,User user);

    public ResultDTO savePersonalUpdate(Long userId ,String email,Short age,Boolean gender,String area,String phone,String description,String profession);

    public Integer updateUserImage(String avatarUrl,Long userId);

    public ResultDTO updateUserPassword(Long userId,String email,String verifyCode,String modifyPassword,HttpServletRequest request,HttpServletResponse response);

    public Integer addUserArticleCount(Long userId);

    public Integer devUserArticleCount(Long userId);

    public User findUserByArticleId(Long articleId);

    public User findUserByCommentId(Long commentId);


}
