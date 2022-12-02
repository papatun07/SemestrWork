package servlets;

import dao.CarDao;
import entity.Post;
import entity.User;
import service.PostService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@MultipartConfig
@WebServlet("/posts/add")
public class AddPostServlet extends HttpServlet {


    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        Part part = request.getPart("img");
        User user = UserService.getAuthUser();
        String fileName = UUID.randomUUID() + "_" + part.getSubmittedFileName();


        Post post = Post.builder()
                .title(title)
                .text(text)
                .img(part.getInputStream().readAllBytes())
                .imgName(fileName)
                .userID(Long.valueOf(user.getId()))
                .build();

        postService.savePost(post);
        response.sendRedirect("/posts");

    }
}
