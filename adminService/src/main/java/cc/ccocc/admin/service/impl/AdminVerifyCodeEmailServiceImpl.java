package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminEmailService;
import cc.ccocc.admin.service.IAdminSuperAdminService;
import cc.ccocc.admin.service.IAdminVerifyCodeEmailService;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.service.IEmailService;
import cc.ccocc.service.IVerifyCodeEmailService;
import cc.ccocc.utils.checkCode.CheckCodeGenerator;
import cc.ccocc.utils.checkCode.CodeGenerator;
import cc.ccocc.utils.result.ResultCode;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * Created on 19:56  22/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("adminVerifyCodeEmailService")
public class AdminVerifyCodeEmailServiceImpl implements IAdminVerifyCodeEmailService {

    @Autowired
    @Qualifier("adminEmailService")
    private IAdminEmailService emailService;


    // 生成一个全局唯一的验证码生成器
    private static final CodeGenerator CODE_GENERATOR = new CheckCodeGenerator();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @param timeOut 验证码失效时间
     * @Method Description:
     * @Author weleness
     * @Return
     */
    @Override
    public String sendEmailWithVerifyCode(String email, Long timeOut) throws MessagingException, IOException, TemplateException {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String verifyCode = generateVerifyCode();
        // 将验证码放进缓存
        redisTemplate.opsForValue().set(uuid, verifyCode, timeOut, TimeUnit.SECONDS);
        emailService.sendTemplateEmail(email, verifyCode);
        return uuid;
    }

    /**
     * @param verifyCode 验证码
     * @param uuid       管理员登陆令牌
     * @Method Description:
     * 检查验证码
     * @Author weleness
     * @Return
     */
    @Override
    public Boolean checkEmailVerifyCode(String uuid, String verifyCode) {
        String verifyCodeInCache = (String) redisTemplate.opsForValue().get(uuid);
        Boolean status = false;
        if (verifyCodeInCache != null) {
            if (verifyCode.equals(verifyCodeInCache)) {
                status = true;
            } else {
                status = false;
            }
        }
        return status;
    }

    @Override
    public Boolean removeEmailVerifyCode(String uuid) {
        try {
            redisTemplate.opsForValue().set(uuid, "");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * @Method Description:
     * 生成随机验证码
     * @Author weleness
     * @Return
     */
    private String generateVerifyCode() {
        return CODE_GENERATOR.generateCode();
    }

}
