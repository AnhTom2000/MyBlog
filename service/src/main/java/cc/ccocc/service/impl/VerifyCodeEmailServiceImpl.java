package cc.ccocc.service.impl;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.service.IEmailService;
import cc.ccocc.service.IVerifyCodeEmailService;
import cc.ccocc.utils.checkCode.CheckCodeGenerator;
import cc.ccocc.utils.checkCode.CodeGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created on 19:56  22/01/2020
 * Description:
 *
 * @author Weleness
 */
@Service("verifyCodeEmailService")
public class VerifyCodeEmailServiceImpl implements IVerifyCodeEmailService {

    @Autowired
    @Qualifier("emailService")
    private IEmailService emailService;

    // 生成一个全局唯一的验证码生成器
    private static final CodeGenerator CODE_GENERATOR = new CheckCodeGenerator();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * @param email  注册的邮箱
     * @param timeOut  验证码失效时间
     * @Method
     * Description:
     *
     * @Author weleness
     *
     * @Return
     */
    @Override
    public ResultDTO sendEmailWithVerifyCode(String email, Long timeOut) {
        try {
            String verifyCode = generateVerifyCode();
            // 将验证码放进缓存
            redisTemplate.opsForValue().set(email, verifyCode, timeOut, TimeUnit.SECONDS);
            emailService.sendTemplateEmail(email, verifyCode);
            System.out.println("发送成功");
            return ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("验证码发送成功，请在邮箱查看").status(true).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("发送验证码失败").status(false).build();
        }
    }

    /**
     * @param verifyCode 验证码
     * @param email  注册的邮箱
     * @Method
     * Description:
     *  检查验证码
     * @Author weleness
     *
     * @Return
     */
    @Override
    public ResultDTO checkEmailVerifyCode(String email, String verifyCode) {
        String verifyCodeInCache = (String) redisTemplate.opsForValue().get(email);
        ResultDTO result = null;
        if (verifyCodeInCache != null) {
            if (verifyCode.equals(verifyCodeInCache)) {
                result = ResultDTO.builder().code(ResultCode.OK_CODE.getCode()).message("验证成功").status(true).build();
            } else {
                result = ResultDTO.builder().code(ResultCode.SERVER_ERROR_CODE.getCode()).message("验证失败，可能是验证码不正确").status(false).build();
            }
        } else {
            result = ResultDTO.builder().code(ResultCode.NOT_FOUND_CODE.getCode()).message("验证码不存在，请重新获取").status(false).build();
        }
        return result;
    }

    /**
     * @Method
     * Description:
     *  生成随机验证码
     * @Author weleness
     *
     * @Return
     */
    private String generateVerifyCode() {
        return CODE_GENERATOR.generateCode();
    }

}
