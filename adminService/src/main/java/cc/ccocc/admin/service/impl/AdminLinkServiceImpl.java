package cc.ccocc.admin.service.impl;

import cc.ccocc.admin.service.IAdminLInkService;
import cc.ccocc.dao.ILinkDao;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.Link;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 00:06  16/02/2020
 * Description:
 *
 * @author Weleness
 */
@Service("adminLinkService")
public class AdminLinkServiceImpl implements IAdminLInkService {

    @Autowired
    private ILinkDao linkDao;

    @Override
    public AdminDTO<List<Link>> findAll(Integer pageNo, Integer pageSize) {
        return new AdminDTO<List<Link>>(ResultCode.OK_CODE.getCode(), null, linkDao.findAll(pageNo, pageSize), linkCount(), true);
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO addLink(String linkName, String href) {
        AdminDTO result = null;
        if (linkDao.addLink(Link.builder().linkName(linkName).href(href).build()) > 0) {
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "添加成功", null, null, true);
        } else result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", null, null, false);
        return result;
    }

    @Override
    public Integer linkCount() {
        return linkDao.linkCount();
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO updateLink(Integer linkId, String linkName, String href) {
        AdminDTO result = null;
        if (linkDao.updateLink(linkId, linkName, href) > 0) {
            result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "修改成功", null, null, true);
        } else result = new AdminDTO<>(ResultCode.SERVER_ERROR_CODE.getCode(), "服务器异常", null, null, false);
        return result;
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public AdminDTO deleteLinks(Integer[] linkIds) {
        AdminDTO result = new AdminDTO<>(ResultCode.OK_CODE.getCode(), "修改成功", null, null, true);;
        for (Integer linkId : linkIds) {
            if(linkDao.deleteLink(linkId) == 0){
                result.setCode(ResultCode.SERVER_ERROR_CODE.getCode());
                result.setMessage("服务器异常");
                result.setStatus(false);
                break;
            }
        }
        return result;
    }
}
