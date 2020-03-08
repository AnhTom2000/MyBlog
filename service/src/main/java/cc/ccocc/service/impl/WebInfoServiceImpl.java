package cc.ccocc.service.impl;

import cc.ccocc.dao.IWebInfoDao;
import cc.ccocc.dto.WebInfoDTO;
import cc.ccocc.pojo.WebInfo;
import cc.ccocc.service.ILinkService;
import cc.ccocc.service.IWebInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 21:45  19/02/2020
 * Description:
 *
 * @author Weleness
 */
@Service("webInfoService")
public class WebInfoServiceImpl implements IWebInfoService {

    @Autowired
    private IWebInfoDao webInfoDao;

    @Autowired
    @Qualifier("linkService")
    private ILinkService linkService;

    /**
     * @Method
     * Description:
     *  获取网站信息
     * @Author weleness
     *
     * @Return
     */
    @Override
    public WebInfoDTO WebInfo() {
        WebInfo webInfo = webInfoDao.findAll();
        BeanCopier beanCopier = BeanCopier.create(WebInfo.class,WebInfoDTO.class,false);
        WebInfoDTO webInfoDTO = null;
        if(webInfo!=null){
             webInfoDTO = new WebInfoDTO();
            beanCopier.copy(webInfo,webInfoDTO,null);
            webInfoDTO.setLinks(linkService.findAll());
        }
        return webInfoDTO;
    }
}
