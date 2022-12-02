//package filter;
//
//import dao.UserDao;
//import service.UserService;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class AuthFilter extends HttpFilter {
//    private static final String[] securedPaths = new String[]{"/car/create"};
//
//    private UserDao userDao;
//
//    private UserService userService;
//
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        boolean prot = false;
//        for (String path : securedPaths){
//            if (path.equals(req.getRequestURI().substring(req.getContextPath().length()))) {
//                prot = true;
//                break;
//            }
//        }
//        if (prot && !userService.isNoAnonymous(req, res)) {
//            res.sendRedirect(req.getContextPath() + "/signin");
//            return;
//        } else {
//            if (userService.isNoAnonymous(req, res)) {
//                req.setAttribute("user", userService.getUser(req, res));
//            }
//            chain.doFilter(req, res);
//        }
//    }
//
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        super.init();
//        userDao = (UserDao) getServletContext().getAttribute("userDao");
//        userService = (UserService) getServletContext().getAttribute("userService");
//    }
//
//    @Override
//    public void destroy() {
//    }
//}
