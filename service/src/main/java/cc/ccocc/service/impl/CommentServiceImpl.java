package cc.ccocc.service.impl;

import cc.ccocc.dao.IArticle_CommentDao;
import cc.ccocc.dto.CommentDTO;
import cc.ccocc.dto.ReplyDTO;
import cc.ccocc.dto.ResultDTO;
import cc.ccocc.dto.UserDTO;
import cc.ccocc.pojo.Article;
import cc.ccocc.pojo.Comment;
import cc.ccocc.pojo.Reply;
import cc.ccocc.pojo.User;
import cc.ccocc.service.*;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created on 15:02  26/01/2020
 * Description:
 * 评论服务实现类
 *
 * @author Weleness
 */
@Service("commentService")
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private IArticle_CommentDao commentDao;

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @Autowired
    @Qualifier("comment_ReplyService")
    private IComment_ReplyService comment_replyService;



    @Autowired
    @Qualifier("user_commentService")
    private IUser_CommentService user_commentService;

    @Autowired
    @Qualifier("article_likeNotice")
    private IArticle_LikeNotificationService article_likeNotificationService;

    @Autowired
    @Qualifier("article_commentNotice")
    private IArticle_CommentNotificationService article_commentNotificationService;

    private static final IdGenerator COMMENT_ID_GENERATOR = SnowflakeIdGenerator.getInstance();

    /**
     * @param articleId 文章id
     * @Method Description:
     * 查询文章的所有评论以及回复
     * @Author weleness
     * @Return
     */
    @Override
    public List<CommentDTO> findAllCommentByArticleId(Long articleId) {
        List<Comment> comments = commentDao.findAllCommentByArticleId(articleId);
        if (!Objects.isNull(comments)) {
            List<CommentDTO> commentDTOList = new ArrayList<>();
            BeanCopier beanCopier = BeanCopier.create(Comment.class, CommentDTO.class, false);
            for (Comment comment : comments) {
                CommentDTO commentDTO = new CommentDTO();
                beanCopier.copy(comment, commentDTO, null);
                commentDTOList.add(commentDTO);
            }

            return commentDTOList;
        }
        return null;
    }

    /**
     * @param commentContent 评论内容
     * @param articleId      文章的id
     * @param userId         用户的id
     * @Method Description:
     * 保存用户发表的评论
     * @Author weleness
     * @Return 评论的信息，包含用户以及评论内容
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public List<CommentDTO> insertArticleComment(String commentContent, Long articleId, Long userId, Long authId) {
        try {
            LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());

            Comment comment = Comment.builder().commentId(COMMENT_ID_GENERATOR.generateId()).
                    comment_like_count(0).article(Article.builder().
                    a_id(articleId).build()).commentContent(commentContent).
                    user(User.builder().userId(userId).build()).
                    commentTime(now).build();

            if (commentDao.insertArticleComment(comment) > 0) {

                article_commentNotificationService.addArticle_CommentNotification(userId,authId,articleId,comment.getCommentId(),"评论",commentContent);
                System.out.println();
                return findAllCommentByArticleId(articleId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param articleId    文章id
     * @param replyContent 回复内容
     * @param parentId     回复的评论id
     * @Method Description:
     * 发表评论回复
     * @Author weleness
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ReplyDTO insertArticle_Comment_Reply(String replyContent, Long articleId, Long parentId, Long userId, Long authId) {
        if(userId!=null) {
            LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
            User user = new User();
            BeanCopier beanCopier1 = BeanCopier.create(UserDTO.class, User.class, false);
            beanCopier1.copy(userService.findUserById(userId), user, null);

            Reply reply = Reply.builder().articleId(articleId).commentId(parentId).replyContent(replyContent).user(user).replyTime(now).build();
            ReplyDTO replyDTO = new ReplyDTO();
            if (comment_replyService.insertCommentReply(reply) > 0) {
                article_commentNotificationService.addComment_ReplyNotification(userId, authId, articleId, reply.getReplyId(), "回复", replyContent);
                BeanCopier beanCopier = BeanCopier.create(Reply.class, ReplyDTO.class, false);
                beanCopier.copy(reply, replyDTO, null);
            }
            return replyDTO;
        }else return ReplyDTO.builder().build();
    }

    /**
     * @param commentId  评论id
     * @param userId  用户id
     * @Method
     * Description:
     *  评论点赞
     * @Author weleness
     *
     * @Return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    @Override
    public ResultDTO addCommentLike(Long commentId, Long userId,Long authId,Long articleId,String articleTitle,String commentContent) {
        //如果已经点赞过了
        if (user_commentService.checkCommentIsLikeByOneUser(commentId, userId).isStatus()) {
            return new ResultDTO(ResultCode.OK_CODE.getCode(), "已经点赞过了，不能在点赞了", true);
        }
        // 添加评论点赞信息
        commentDao.addCommentLike(commentId);
        // 添加到中间表
        user_commentService.addCommentLike(commentId, userId);
        // 添加评论点赞消息
        article_likeNotificationService.addCommentLikeNotificaton(userId,authId,articleId,articleTitle,commentContent,"评论");

        return new ResultDTO(ResultCode.OK_CODE.getCode(), "点赞成功", true);
    }

    @Override
    public Integer getAllCommentCount() {
        return commentDao.getAllCommentCount();
    }

    @Override
    public List<CommentDTO> getNewsComment(Long userId) {
        List<Comment> newComment = commentDao.getNewComment(0,userId);
        List<CommentDTO> newComments = null;
        if(newComment != null) {
            newComments = new ArrayList<>();
            BeanCopier beanCopier = BeanCopier.create(Comment.class, CommentDTO.class, false);
            for (Comment comment : newComment) {
                CommentDTO commentDTO = new CommentDTO();
                beanCopier.copy(comment, commentDTO, null);
                newComments.add(commentDTO);
            }
        }
        return newComments;
    }


}
