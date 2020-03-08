package cc.ccocc.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.ResultDTO;

/**
 * Created on 19:55  22/01/2020
 * Description:
 *  邮箱验证码服务接口
 * @author Weleness
 */

public interface IVerifyCodeEmailService {

    public ResultDTO sendEmailWithVerifyCode(String email , Long timeOut);

    public ResultDTO checkEmailVerifyCode(String email,String verifyCode);
}
