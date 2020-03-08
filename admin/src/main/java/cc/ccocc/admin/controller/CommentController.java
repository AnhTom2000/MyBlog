package cc.ccocc.admin.controller;

import cc.ccocc.admin.service.IAdminCommentService;
import cc.ccocc.admin.service.IAdminCookieService;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.Comment;
import cc.ccocc.utils.result.ResultCode;
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
 * Created on 18:31  14/02/2020
 * Description:
 *
 * @author Weleness
 */
@Controller
@RequestMapping("/admin/comment")
public class CommentController {

    @Autowired
    @Qualifier("adminCommentService")
    private IAdminCommentService adminCommentService;

    @Autowired
    @Qualifier("adminCookieService")
    @Lazy
    private IAdminCookieService cookieService;

    @ModelAttribute
    public void beforeToPage(Model model, HttpServletRequest request) {
        Cookie cookie = null;
        if((cookie = cookieService.getCookie("superAdmin",request))!=null){
            Object superAdmin = null;
            if((superAdmin = request.getSession().getAttribute(cookie.getValue()))!=null){
                model.addAttribute("superAdmin",superAdmin);
            }
        }
    }



    @ResponseBody
    @RequestMapping("/findAll")
    public AdminDTO<List<Comment>> findAll(@RequestParam("pageNo") Integer pageNo , @RequestParam("pageSize") Integer pageSize){
        return adminCommentService.findAll((pageNo-1)*pageSize,pageSize);
    }

    @ResponseBody
    @RequestMapping("/deleteComment")
    public AdminDTO deleteComment(@RequestParam("commentId[]") Long[] commentId,Model model){
        AdminDTO result = null;
        if(model.getAttribute("superAdmin") != null){
            result = adminCommentService.deleteComments(commentId);
        }else result = new AdminDTO<>(ResultCode.OK_CODE.getCode(),"请先登陆",null,null,false);
        return result;
    }
}
