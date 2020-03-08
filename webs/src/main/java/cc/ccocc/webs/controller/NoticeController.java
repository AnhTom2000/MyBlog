package cc.ccocc.webs.controller;

import cc.ccocc.annotation.Action;
import cc.ccocc.annotation.BeforeSth;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.service.*;
import cc.ccocc.utils.result.ResultCode;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static cc.ccocc.service.impl.AbstractOauthService.*;

/**
 * Created on 15:26  08/02/2020
 * Description:
 *
 * @author Weleness
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    @Qualifier("article_likeNotice")
    private IArticle_LikeNotificationService article_likeNotificationService;

    @Autowired
    @Qualifier("cookieService")
    private ICookieService cookieService;

    @Autowired
    @Qualifier("article_commentNotice")
    private IArticle_CommentNotificationService article_commentNotificationService;

    @Autowired
    @Qualifier("systemNotice")
    private ISystemNotificationService systemNotificationService;

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @ModelAttribute
    public void beforeToPage(Model model, HttpServletRequest request) {
        Cookie userCookie = null;
        if ((userCookie = cookieService.getCookie(SIMPLE_COOKIE_KEY, request)) != null) {
            Long userId = null;
            if ((userId = (Long) request.getSession().getAttribute(userCookie.getValue())) != null) {
                UserDTO userDTO = userService.findUserById(userId);
                if (userDTO != null) {
                    model.addAttribute("user", userDTO);
                }
                model.addAttribute("unMarkRead_Comment", article_commentNotificationService.UnMarkReadCount(userId));
                model.addAttribute("unMarkRead_Like", article_likeNotificationService.UnMarkReadCount(userId));
                model.addAttribute("unMarkRead_System", systemNotificationService.UnMarkReadCount(userId));
            }
        }
    }

    /**
     * @param model model
     * @Method Description:
     * 标记点赞消息已读
     * @Author weleness
     * @Return
     */
    @Action("markReadAll")
    @ResponseBody
    @RequestMapping("/like/markReadAll")
    public ResultDTO markReadAllLikeNotice(Model model, HttpServletRequest request, HttpSession session) {
        return article_likeNotificationService.updateMarkReadStatus((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()));
    }

    /**
     * @Method Description:
     * 删除全部的点赞消息推送
     * @Author weleness
     * @Return
     */
    @Action("clearAll")
    @ResponseBody
    @RequestMapping("/like/clear")
    public ResultDTO clearAllLikeNotice(Model model, HttpServletRequest request, HttpSession session) {
        return article_likeNotificationService.deleteLikeAllNotice((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()));
    }

    /**
     * @Method Description:
     * 删除单条点赞消息推送
     * @Author weleness
     * @Return
     */
    @Action("clearOne")
    @ResponseBody
    @RequestMapping("/like/clearOne")
    public ResultDTO clearLikeNotice(Model model, @RequestParam("NoticeId") Long likeNotificationId) {
        return article_likeNotificationService.deleteLikeNotice(likeNotificationId);
    }

    /**
     * @Method Description:
     * 标记全部的评论消息为已读
     * @Author weleness
     * @Return
     */
    @Action("markReadAll")
    @ResponseBody
    @RequestMapping("/comment/markReadAll")
    public ResultDTO markReadAllCommentNotice(Model model, HttpSession session, HttpServletRequest request) {
        return article_commentNotificationService.updateMarkReadStatus((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()));
    }

    @Action("clearOne")
    @ResponseBody
    @RequestMapping("/comment/clearOne")
    public ResultDTO clearCommentNotice(Model model, @RequestParam("NoticeId") Long commentNotificationId) {
        return article_commentNotificationService.deleteComment_ReplyNotice(commentNotificationId);
    }

    @Around("clear")
    @ResponseBody
    @RequestMapping("/comment/clear")
    public ResultDTO clearCommentAllNotice(Model model, HttpServletRequest request, HttpSession session) {
        return article_commentNotificationService.deleteComment_ReplyAllNotice((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()));
    }

    @Action("likeNotice")
    @RequestMapping("/like")
    public String likeNotification(Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("likeNotice", article_likeNotificationService
                .findLikeNotificationByUserId((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue())));
        return "user/Like";
    }

    @Action("commentReply")
    @RequestMapping("/commentReply")
    public String commentReplyNotification(Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("comment_replyNotice", article_commentNotificationService
                .findComment_ReplyNotificationByUserId((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue())));
        return "user/messageSystem";
    }

    @Action("system")
    @RequestMapping("/system")
    public String systemNotification(Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("systemNotice", systemNotificationService
                .findSystemNoticeByUserId((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue())));
        return "user/systemMsg";
    }

    @BeforeSth
    @ResponseBody
    @RequestMapping("/system/clear")
    public ResultDTO clearAllSystemNotice(Model model, HttpSession session, HttpServletRequest request) {
        return systemNotificationService.deleteAllSystemNotice((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY, request).getValue()));
    }

    @BeforeSth
    @ResponseBody
    @RequestMapping("/system/clearOne")
    public ResultDTO clearOneSystemNotice(Model model, @RequestParam("NoticeId") Long systemNoticeId) {
        return systemNotificationService.deleteSystemNotice(systemNoticeId);
    }

    @BeforeSth
    @ResponseBody
    @RequestMapping("/system/markReadAll")
    public ResultDTO markAll(Model model,HttpSession session,HttpServletRequest request) {
           return systemNotificationService.updateMarkReadStatus((Long) session.getAttribute(cookieService.getCookie(SIMPLE_COOKIE_KEY,request).getValue()));
    }
}

