package cc.ccocc.admin.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.ResultDTO;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created on 19:55  22/01/2020
 * Description:
 *  邮箱验证码服务接口
 * @author Weleness
 */

public interface IAdminVerifyCodeEmailService {

    public String sendEmailWithVerifyCode(String email,Long timeOut) throws MessagingException, IOException, TemplateException;

    public Boolean checkEmailVerifyCode(String uuid, String verifyCode);

    public Boolean removeEmailVerifyCode(String uuid);
}
