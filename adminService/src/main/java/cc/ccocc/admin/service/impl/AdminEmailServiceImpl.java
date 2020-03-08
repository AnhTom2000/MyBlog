package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminEmailService;
import cc.ccocc.service.IEmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 18:52  22/01/2020
 * Description:
 * 邮箱服务实现类
 *
 * @author Weleness
 */
@Service("adminEmailService")
public class AdminEmailServiceImpl implements IAdminEmailService {

    // 自动装配的邮件发送工具
    @Autowired
    JavaMailSender mailSender;

    // freemarker模板引擎的配置类
    @Autowired
    private FreeMarkerConfigurer configurer;

    @Value("${mail.from}")
    private String mailFrom;

    @Value("${mail.subject}")
    private String subject;

    /**
     * @param to         发送地址
     * @param verifyCode 验证码
     * @Method Description:
     * 发送模板邮件
     * @Author weleness
     * @Return
     */
    public void sendTemplateEmail(String to, String verifyCode) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = null;
        Configuration configuration = configurer.getConfiguration();

            //获取模板对象
            Template template = configuration.getTemplate("/admin/Email.ftl");
            //模板对象的参数
            Map<String, Object> model = new HashMap<>();
            model.put("verifyCode", verifyCode);
            // 整合参数
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            //创建邮件
            mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(mailFrom);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(html, true);
            mailSender.send(mimeMessage);

    }
}
