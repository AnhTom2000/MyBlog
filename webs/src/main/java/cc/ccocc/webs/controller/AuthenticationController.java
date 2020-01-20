package cc.ccocc.webs.controller;

import cc.ccocc.dto.ResultDTO;
import cc.ccocc.service.IOauthService;
import cc.ccocc.utils.result.ResultCode;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 23:34  20/01/2020
 * Description:
 *
 * @author Weleness
 */
@Controller
@RequestMapping("/user")
public class AuthenticationController {

    @Autowired
    @Qualifier("githubOauthService")
    private IOauthService githubOauthService;

    @RequestMapping("/oauth")
    @ResponseBody
    public ResultDTO oauth() {

        return new ResultDTO(ResultCode.OK_CODE.getCode(), "", true);

    }

}
