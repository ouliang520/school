//package ouliang.com.school.Configuration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.lang.Nullable;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@Configuration
//public class SpringMvcConfig implements WebMvcConfigurer {
//    //    registry是整个拦截器的注册中心
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new firstInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/index");
//    }
//
//
//
//    public class firstInterceptor implements HandlerInterceptor {
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//            System.out.println("拦截器拦截了");
//            HttpSession session= request.getSession();
//            if(session.getAttribute("user")==null)
//            { System.out.println("拦截器跳转了");
//                response.sendRedirect("index");
//            }
//            return true;
//        }
//        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//            System.out.println("posthandel执行了");
//        }
//        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//            System.out.println("afterhandle执行了");
//        }
//    }
//
//}
//
