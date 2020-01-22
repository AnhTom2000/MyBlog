package cc.ccocc.service;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Oauth;
import cc.ccocc.pojo.User;

/**
 * Created on 21:56  21/01/2020
 * Description:
 *
 * @author Weleness
 */

public interface IUserService  {

    public UserDTO findUserByOauth(Oauth oauth);

    public ResultDTO doInformationComplete();

    public ResultDTO checkUserExsitByName(String username);

    public ResultDTO checkUserExsitByEmail(String email);

    public ResultDTO oauthInformationComplete(String email,String verificationCode);
 
    public ResultDTO login(String name ,String password);

    public ResultDTO register (String name,String email, String password,String verificationCode);

}
