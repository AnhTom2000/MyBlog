package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminCookieService;
import cc.ccocc.admin.service.IAdminSuperAdminService;
import cc.ccocc.admin.service.IAdminSystemNotificationService;
import cc.ccocc.admin.service.IAdminVerifyCodeEmailService;
import cc.ccocc.dao.ISuperAdminDao;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.SuperAdminDTO;
import cc.ccocc.pojo.SupperAdmin;
import cc.ccocc.pojo.User;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.passwordEncoder.MD5Utils;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created on 20:23  12/02/2020
 * Description:
 *
 * @author Weleness
 */

@Service("adminSuperAdminService")
public class AdminSuperAdminServiceImpl implements IAdminSuperAdminService {

    @Autowired
    private ISuperAdminDao superAdminDao;

    @Autowired
    @Qualifier("adminVerifyCodeEmailService")
    private IAdminVerifyCodeEmailService adminVerifyCodeEmailService;

    @Autowired
    @Qualifier("adminCookieService")
    private IAdminCookieService adminCookieService;

    @Autowired
    @Qualifier("adminSystemNotice")
    private IAdminSystemNotificationService adminSystemNotificationService;

    private static final IdGenerator ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    @Override
    public AdminDTO<List<SupperAdmin>> findAll(Integer pageNo, Integer pageSize) {
        return new AdminDTO<List<SupperAdmin>>(ResultCode.OK_CODE.getCode(), null, superAdminDao.findAll(pageNo, pageSize), adminCount(), true);
    }

    @Override
    public AdminDTO<List<SupperAdmin>> searchAdmin(Long adminId, String adminName, String email) {
        return new AdminDTO<List<SupperAdmin>>(ResultCode.OK_CODE.getCode(), null, superAdminDao.searchUser(adminId, adminName, email), adminCount(), true);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO<SupperAdmin> updateAdmin(Long adminId, String email, String phone, Boolean gender, String avatarUrl) {
        superAdminDao.updateAdminUser(adminId, email, phone, gender, avatarUrl);
        return new AdminDTO<SupperAdmin>(ResultCode.OK_CODE.getCode(), "修改成功", superAdminDao.findAdminById(adminId), adminCount(), true);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO<List<SupperAdmin>> addAdmin(String adminName, String password, Short age, Boolean gender, String email) {
        if (superAdminDao.findAdminByName(adminName) == null) {
            LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
            SupperAdmin supperAdmin = SupperAdmin.builder().adminId(ID_GENERATOR.generateId()).
                    adminName(adminName).password(MD5Utils.generate(password)).
                    age(age).gender(gender).email(email).createTime(now).
                    lastLogin(now).build();
            if (superAdminDao.addDefaultUser(supperAdmin) > 0) {
                return findAll(0, 5);
            }
        }
        return new AdminDTO<>(ResultCode.CLIENT_ERROR_CODE.getCode(), "该用户已注册", null, adminCount(), false);
    }

    @Override
    public SupperAdmin findAdminById(Long adminId) {
        return superAdminDao.findAdminById(adminId);
    }


    @Override
    public Integer adminCount() {
        return superAdminDao.getCount();
    }


    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO deleteAdmins(Long[] adminIds) {
        for (Long adminId : adminIds) {
            superAdminDao.deleteAdminUser(adminId);
        }
        return new AdminDTO<>(ResultCode.OK_CODE.getCode(), "删除成功", null, null, true);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO sendToUser(Long userId, String content) {
        AdminDTO result = null;
        if (adminSystemNotificationService.addSystemNotice(userId, userId, "管理员", content, "管理员给你发了条信息") > 0) {
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "发送成功", null, null, true);
        } else {
            result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", null, null, false);
        }
        return result;
    }

    /**
     * @Method Description:
     * <P>管理员登陆</P>
     * @Author weleness
     * @Return
     */
    @Override
    public AdminDTO SuperAdminLogin(String superAdminName, String password) {
        SupperAdmin supperAdmin = null;
        AdminDTO result = null;
        if ((supperAdmin = superAdminDao.adminLogin(superAdminName)) != null) {
            if(MD5Utils.verify(password,supperAdmin.getPassword())) {
                SuperAdminDTO superAdminDTO = null;
                try {
                    String token = adminVerifyCodeEmailService.sendEmailWithVerifyCode(supperAdmin.getEmail(), 120L);
                    superAdminDTO = SuperAdminDTO.builder().adminId(supperAdmin.getAdminId()).adminName(superAdminName).uuid(token).build();
                    result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "请在邮箱中查看验证码", superAdminDTO, null, true);
                } catch (Throwable e) {
                    result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", null, null, false);
                    e.printStackTrace();
                }
            }else result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "用户名或密码错误", null, null, false);
        } else result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "用户名或密码错误", null, null, false);
        return result;
    }


    @Override
    public AdminDTO check(String uuid, String verifyCode,Long adminId, HttpServletRequest request, HttpServletResponse response) {
        AdminDTO result = null;
        if (adminVerifyCodeEmailService.checkEmailVerifyCode(uuid, verifyCode)) {
            Cookie cookie = adminCookieService.generateCookie("superAdmin");
            request.getSession().setAttribute(cookie.getValue(), adminId);
            request.getSession().setMaxInactiveInterval(172800000);
            response.addCookie(cookie);
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(),"登陆成功",null,null,true);
        }else result = new AdminDTO<>(ResultCode.OK_CODE.getCode(),"验证码不存在或者验证码错误",null,null,false);
        return result;
    }

    @Override
    public AdminDTO loginCancel(String uuid) {
        AdminDTO  result = null;
        try {
            adminVerifyCodeEmailService.removeEmailVerifyCode(uuid);
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(),"取消登录成功",null,null,false);
        } catch (Exception e) {
            e.printStackTrace();
            result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(),"错误",null,null,false);
        }
        return result;
    }
}
