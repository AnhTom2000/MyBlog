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
import cc.ccocc.service.ICommentService;
import cc.ccocc.service.IComment_ReplyService;
import cc.ccocc.service.IUserService;
import cc.ccocc.service.IUser_CommentService;
import cc.ccocc.utils.idgenerater.IdGenerator;
import cc.ccocc.utils.idgenerater.SnowflakeIdGenerator;
import cc.ccocc.utils.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
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
    @Override
    public List<CommentDTO> insertArticleComment(String commentContent, String articleId, Long userId) {
        LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
        Comment comment = Comment.builder().commentId(COMMENT_ID_GENERATOR.generateId()).comment_like_count(0).article(Article.builder().a_id(Long.parseLong(articleId)).build()).commentContent(commentContent).user(User.builder().userId(userId).build()).commentTime(now).build();
        if (commentDao.insertArticleComment(comment) > 0) {
            return findAllCommentByArticleId(Long.parseLong(articleId));
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
    @Transactional
    @Override
    public ReplyDTO insertArticle_Comment_Reply(String replyContent, String articleId, String parentId, Long userId) {
        LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
        User user = new User();
        BeanCopier beanCopier1 = BeanCopier.create(UserDTO.class, User.class, false);
        beanCopier1.copy(userService.findUserById(userId), user, null);
        Reply reply = Reply.builder().articleId(Long.parseLong(articleId)).commentId(Long.parseLong(parentId)).replyContent(replyContent).user(user).replyTime(now).build();
        ReplyDTO replyDTO = new ReplyDTO();
        if (comment_replyService.insertCommentReply(reply)) {
            BeanCopier beanCopier = BeanCopier.create(Reply.class, ReplyDTO.class, false);
            beanCopier.copy(reply, replyDTO, null);
        }
        return replyDTO;
    }

    @Override
    public ResultDTO addCommentLike(String commentId, Long userId) {
        //如果已经点赞过了
        if (user_commentService.checkCommentIsLikeByOneUser(Long.parseLong(commentId), userId).isStatus()) {
            return new ResultDTO(ResultCode.OK_CODE.getCode(), "已经点赞过了，不能在点赞了", true);
        }
        commentDao.addCommentLike(Long.parseLong(commentId));
        user_commentService.addCommentLike(Long.parseLong(commentId), userId);
        return new ResultDTO(ResultCode.OK_CODE.getCode(), "点赞成功", false);
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
