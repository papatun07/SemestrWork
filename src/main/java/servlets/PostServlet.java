package servlets;

import entity.Post;
import entity.User;
import service.PostService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/posts/*")
public class PostServlet extends HttpServlet {

    private final PostService postService = new PostService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long postID = Long.valueOf(request.getPathInfo().substring(1));
            Post post = postService.findPost(postID);

            request.setAttribute("post", post);
            request.getRequestDispatcher("/WEB-INF/post.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long postID = Long.valueOf(request.getPathInfo().substring(1));
        User user = UserService.getAuthUser();
        String text = request.getParameter("text");
        response.sendRedirect("/posts/" + postID);
    }
}
