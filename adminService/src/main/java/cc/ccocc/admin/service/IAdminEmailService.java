package cc.ccocc.admin.service;

import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created on 18:52  22/01/2020
 * Description:
 *  邮箱服务接口
 * @author Weleness
 */

public interface IAdminEmailService {


    public void  sendTemplateEmail(String to, String verifyCode) throws MessagingException, IOException, TemplateException;
}
