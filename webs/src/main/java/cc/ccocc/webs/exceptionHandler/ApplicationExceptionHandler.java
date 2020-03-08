package cc.ccocc.webs.exceptionHandler;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.exception.*;
import cc.ccocc.utils.result.ResultCode;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created on 16:52  18/02/2020
 * Description: TODO 全局的异常处理器
 *
 * @author Weleness
 */

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler({LoginException.class})
    public ModelAndView handlerUnLoginException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/login");
        return mv;
    }

    @ExceptionHandler({NoPersonSelfException.class, NoFundException.class})
    public ModelAndView handlerNoPersonSelfException(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/error/404");
        return mv;
    }

    @ExceptionHandler({AuthenticationException.class})
    public ModelAndView handlerAuthenticationException(Exception e) {
        ModelAndView mv = new ModelAndView();
        ResultDTO resultDTO = new ResultDTO(ResultCode.CLIENT_ERROR_CODE.getCode(), null, false);

        if (e instanceof AuthenticationException) {
            resultDTO.setMessage(e.getMessage());
        }
        mv.addObject("errorMessage", resultDTO);
        mv.setViewName("redirect:/login");
        return mv;
    }

    @ExceptionHandler({Throwable.class, Error.class})
    public String handlerUnResultError(Throwable t) {
        return "/error/500";
    }
}
