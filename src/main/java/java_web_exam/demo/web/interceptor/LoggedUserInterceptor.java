package java_web_exam.demo.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static java_web_exam.demo.constants.GlobalConstants.INDEX;

@Component
public class LoggedUserInterceptor implements HandlerInterceptor {

    public static final String HOME = "/home";

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("id");

        if (user != null) {
            if (handler instanceof ResourceHttpRequestHandler) {
                ResourceHttpRequestHandler resourceHttpRequestHandler = (ResourceHttpRequestHandler) handler;
                resourceHttpRequestHandler.handleRequest(request, response);
            }

            response.setHeader("Location", HOME);
            response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
            return false;
        }
        return true;
    }
}
