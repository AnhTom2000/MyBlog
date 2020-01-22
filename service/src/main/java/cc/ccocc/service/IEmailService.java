package cc.ccocc.service;

import cc.ccocc.dto.ResultDTO;

/**
 * Created on 18:52  22/01/2020
 * Description:
 *  邮箱服务接口
 * @author Weleness
 */

public interface IEmailService {

    public void sendSimpleEmail(String to, String verifyCode);

    public void  sendTemplateEmail(String to ,String verifyCode);
}
