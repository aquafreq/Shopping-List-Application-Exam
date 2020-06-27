package java_web_exam.demo.config;

import java_web_exam.demo.web.interceptor.LoggedUserInterceptor;
import java_web_exam.demo.web.interceptor.NonLoggedUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static java_web_exam.demo.constants.GlobalConstants.*;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    private final LoggedUserInterceptor loggedUserInterceptor;
    private final NonLoggedUserInterceptor nonLoggedUserInterceptor;

    @Autowired
    public InterceptorConfiguration(LoggedUserInterceptor loggedUserInterceptor, NonLoggedUserInterceptor nonLoggedUserInterceptor) {
        this.loggedUserInterceptor = loggedUserInterceptor;
        this.nonLoggedUserInterceptor = nonLoggedUserInterceptor;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(STATIC);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggedUserInterceptor)
                .addPathPatterns(USERS_REGISTER, USERS_LOGIN, INDEX);

        registry.addInterceptor(nonLoggedUserInterceptor)
                .excludePathPatterns(USERS_REGISTER, USERS_LOGIN, INDEX);
    }
}
