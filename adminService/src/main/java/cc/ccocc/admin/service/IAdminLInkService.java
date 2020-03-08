package cc.ccocc.admin.service;

import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.Link;

import java.util.List;

/**
 * Created on 00:03  16/02/2020
 * Description:
 *
 * @author Weleness
 */
public interface IAdminLInkService {

    public AdminDTO<List<Link>> findAll(Integer pageNo, Integer pageSize);

    public AdminDTO addLink(String linkName, String href);

    public Integer linkCount();

    public AdminDTO updateLink(Integer linkId,String linkName,String href);

    public AdminDTO deleteLinks(Integer[] linkIds);
}
