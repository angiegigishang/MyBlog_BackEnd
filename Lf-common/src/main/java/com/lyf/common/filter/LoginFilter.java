package com.lyf.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyf.common.dto.RestHttpReply;
import com.lyf.common.entity.LfyUsrDo;
import com.lyf.common.enums.ErrorCode;
import com.lyf.common.properties.LfSettings;
import com.lyf.common.service.LoginService;
import com.lyf.common.service.UserService;
import com.lyf.common.utils.ThreadUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(httpServletRequest.getServletContext());
        RestHttpReply reply = new RestHttpReply();
        ObjectMapper mapper = new ObjectMapper();

        LfSettings s = (LfSettings) ctx.getBean("lfSettings");
        if(s.getAddr().contains(httpServletRequest.getServletPath())) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String token = httpServletRequest.getHeader("Auth");
        if(StringUtils.isEmpty(token)) {
            reply.setHead(ErrorCode.ERR0005);
            String output = mapper.writeValueAsString(reply);

            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("text/html;charset=UTF-8");
            PrintWriter w = httpServletResponse.getWriter();
            w.append(output);
            w.flush();
            w.close();
            return;
        } else {

            LoginService l = (LoginService) ctx.getBean("loginService");

            String uid = l.getUserNbrByToken(token);
            if(StringUtils.isEmpty(uid)) {
                reply.setHead(ErrorCode.ERR0006);
                String output = mapper.writeValueAsString(reply);

                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setContentType("text/html;charset=UTF-8");
                PrintWriter w = httpServletResponse.getWriter();
                w.append(output);
                w.flush();
                w.close();

                return;
            } else {
                UserService u = (UserService) ctx.getBean("userService");
                LfyUsrDo user = u.getUser(uid);

                ThreadUtil.set(user);

                filterChain.doFilter(httpServletRequest, httpServletResponse);
                return;
            }
        }

    }

}
