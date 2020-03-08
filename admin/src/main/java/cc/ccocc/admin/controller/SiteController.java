package cc.ccocc.admin.controller;

import cc.ccocc.admin.service.IAdminCookieService;
import cc.ccocc.admin.service.IAdminLInkService;
import cc.ccocc.admin.service.IAdminSiteNoticeService;
import cc.ccocc.admin.service.IAdminWebInfoService;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.Link;
import cc.ccocc.pojo.SiteNotice;
import cc.ccocc.pojo.WebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created on 22:09  15/02/2020
 * Description:
 *
 * @author Weleness
 */

@Controller
@RequestMapping("/admin/site")
public class SiteController {

    @Autowired
    @Qualifier("adminSiteNoticeService")
    private IAdminSiteNoticeService adminSiteNoticeService;

    @Autowired
    @Qualifier("adminLinkService")
    private IAdminLInkService lInkService;

    @Autowired
    @Qualifier("webInfoService")
    private IAdminWebInfoService webInfoService;

    @Autowired
    @Qualifier("adminCookieService")
    @Lazy
    private IAdminCookieService cookieService;

    @ModelAttribute
    public void beforeToPage(Model model, HttpServletRequest request) {
        Cookie cookie = null;
        if ((cookie = cookieService.getCookie("superAdmin", request)) != null) {
            Object superAdmin = null;
            if ((superAdmin = request.getSession().getAttribute(cookie.getValue())) != null) {
                model.addAttribute("superAdmin", superAdmin);
            }
        }
    }
    @ResponseBody
    @RequestMapping("/findAll")
    public AdminDTO<List<SiteNotice>> findAll(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return adminSiteNoticeService.findAll((pageNo - 1) * pageSize, pageSize);
    }

    @ResponseBody
    @RequestMapping("/addSiteNotice")
    public AdminDTO addSiteNotice(@RequestParam("siteNoticeContent") String siteNoticeContent) {
        return adminSiteNoticeService.addSiteNotice(siteNoticeContent);
    }


    @ResponseBody
    @RequestMapping("/deleteSiteNotices")
    public AdminDTO deleteSiteNotices(@RequestParam("siteNotice[]") Long[] siteNoticeIds) {
        return adminSiteNoticeService.deleteSiteNotices(siteNoticeIds);
    }

    @ResponseBody
    @RequestMapping("/findAllLink")
    public AdminDTO<List<Link>> findAllLink(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return lInkService.findAll((pageNo - 1) * pageSize, pageSize);
    }

    @ResponseBody
    @RequestMapping("/addLink")
    public AdminDTO addLink(@RequestParam("linkName") String linkName, @RequestParam("href") String href) {
        return lInkService.addLink(linkName, href);
    }

    @ResponseBody
    @RequestMapping("/updateLink")
    public AdminDTO updateLink(@RequestParam("linkId") Integer linkId, @RequestParam("linkName") String linkName, @RequestParam("href") String href) {
        System.out.println(linkId);
        return lInkService.updateLink(linkId, linkName, href);
    }

    @ResponseBody
    @RequestMapping("/deleteLink")
    public AdminDTO deleteLink(@RequestParam("linkId[]") Integer[] linkId) {
        return lInkService.deleteLinks(linkId);
    }

    @ResponseBody
    @RequestMapping("/updateMeta")
    public AdminDTO updateMeta(@RequestParam("webInfoId") Integer webInfoId, @RequestParam(value = "description", required = false) String description, @RequestParam(value = "keywords", required = false
    ) String keywords, @RequestParam(value = "copyRight", required = false) String copyRight, @RequestParam(value = "icp",required = false) String icp){
        return webInfoService.updateMeta(webInfoId, description, keywords, copyRight, icp);
    }

    @ResponseBody
    @RequestMapping("/findAllMeta")
    public AdminDTO<WebInfo> findAllMeta(){
        return webInfoService.findAll();
    }
}
