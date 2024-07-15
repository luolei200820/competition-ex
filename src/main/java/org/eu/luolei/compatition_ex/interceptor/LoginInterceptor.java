package org.eu.luolei.compatition_ex.interceptor;

import com.auth0.jwt.interfaces.Claim;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eu.luolei.compatition_ex.utils.JwtUtil;
import org.eu.luolei.compatition_ex.utils.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行OPTIONS
        if ("OPTIONS".equals(request.getMethod().toUpperCase())) {
            return true;
        }

        String token = request.getHeader("Authorization");
        // System.out.println(token);
        try {
            Integer userId = JwtUtil.parseToken(token);
            ThreadLocalUtil.set(userId);
            // 放行
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            // 不放行
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
