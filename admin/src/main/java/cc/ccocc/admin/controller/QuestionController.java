package cc.ccocc.admin.controller;

import cc.ccocc.admin.service.IAdminCookieService;
import cc.ccocc.admin.service.IAdminQuestionService;
import cc.ccocc.dto.AdminDTO;
import cc.ccocc.pojo.Question;
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
 * Created on 22:13  13/02/2020
 * Description:
 *
 * @author Weleness
 */
@Controller
@RequestMapping("/admin/question")
public class QuestionController {

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

    @Autowired
    @Qualifier("adminQuestionService")
    private IAdminQuestionService adminQuestionService;

    @ResponseBody
    @RequestMapping("/findAll")
    public AdminDTO<List<Question>> findAllQuestion(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
        return adminQuestionService.findAll((pageNo-1)*pageSize, pageSize);
    }

    @ResponseBody
    @RequestMapping("/replyQuestion")
    public AdminDTO replyQuestion(@RequestParam("questionId") Long questionId ,@RequestParam("userId") Long userId, @RequestParam("replyContent") String replyContent,@RequestParam("questionTitle") String questionTitle,Model model){
        AdminDTO result = null;
        if(model.getAttribute("superAdmin") != null){
            result =  adminQuestionService.addReply(questionId,replyContent,userId,questionTitle);
        }else result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(),"请先登陆",null,null,false);
        return result;
    }

    @ResponseBody
    @RequestMapping("/deleteQuestion")
    public AdminDTO deleteQuestion(@RequestParam("questionId[]") Long[] questionId,Model model){
        AdminDTO result = null;
        if(model.getAttribute("superAdmin")!=null){
            result = adminQuestionService.deleteQuestion(questionId);
        }else result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(),"请先登陆",null,null,false);
        return result;
    }

    @ResponseBody
    @RequestMapping("/checkedQuestion")
    public AdminDTO checkQuestion(@RequestParam("questionId") Long questionId , Model model){
        AdminDTO result = null;
        if(model.getAttribute("superAdmin")!=null){
            result = adminQuestionService.checkQuestion(questionId);
        }else result = new AdminDTO<>(ResultCode.NOT_FOUND_CODE.getCode(),"请先登陆",null,null,false);
        return result;
    }

}
