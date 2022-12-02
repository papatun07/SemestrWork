//package filter;
//
//import service.UserService;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = "/posts/add")
//public class AddPostFilter extends HttpFilter {
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        if (!UserService.isAuth()) {
//            res.sendRedirect("/auth");
//            return;
//        }
//
//        chain.doFilter(req, res);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
