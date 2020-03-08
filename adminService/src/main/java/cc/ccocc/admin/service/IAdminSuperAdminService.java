package cc.ccocc.admin.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.dto.SuperAdminDTO;
import cc.ccocc.pojo.SupperAdmin;
import cc.ccocc.pojo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created on 20:11  12/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminSuperAdminService {

    public AdminDTO<List<SupperAdmin>> findAll(Integer pageNo, Integer pageSize);

    public AdminDTO<List<SupperAdmin>> searchAdmin(Long adminId,String adminName,String email);

    public AdminDTO<SupperAdmin> updateAdmin(Long adminId, String email, String phone, Boolean gender,String avatarUrl);

    public AdminDTO<List<SupperAdmin>> addAdmin(String adminName, String password, Short age, Boolean gender, String email);

    public SupperAdmin findAdminById(Long adminId);
    public Integer adminCount();

    public AdminDTO deleteAdmins(Long[] adminIds);

    public AdminDTO sendToUser(Long userId,String content);

    public AdminDTO SuperAdminLogin(String superAdminName,String password);

    public AdminDTO check(String uuid,String verifyCode,Long adminId, HttpServletRequest request, HttpServletResponse response);

    public AdminDTO loginCancel(String uuid);

}
