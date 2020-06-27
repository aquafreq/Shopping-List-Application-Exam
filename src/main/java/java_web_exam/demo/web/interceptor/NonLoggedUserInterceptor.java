package java_web_exam.demo.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static java_web_exam.demo.constants.GlobalConstants.USERS_LOGIN;

@Component
public class NonLoggedUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userId = session.getAttribute("id");

        if (userId == null) {
            if (handler instanceof ResourceHttpRequestHandler) {
                ResourceHttpRequestHandler resourceHttpRequestHandler = (ResourceHttpRequestHandler) handler;
                resourceHttpRequestHandler.handleRequest(request, response);
            }
            response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
            response.setHeader("Location", USERS_LOGIN);
            return false;
        }

        return true;
    }
}
