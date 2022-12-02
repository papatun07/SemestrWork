package servlets;

import entity.Post;
import service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/posts/update")
@MultipartConfig
public class UpdateServlet extends HttpServlet {

        private final PostService postService = new PostService();
        private Long postID;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Long postID = Long.parseLong(request.getParameter("postID"));
            this.postID = postID;
            Post post = postService.findPost(postID);

            request.setAttribute("post", post);
            request.getRequestDispatcher("/WEB-INF/update_post.jsp").forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String title = request.getParameter("title");
            String text = request.getParameter("text");
            Part part = request.getPart("img");

            Post post = postService.findPost(postID);
            post.setTitle(title);
            post.setText(text);

            if (!part.getSubmittedFileName().equals("")) {
                String imgName = UUID.randomUUID() + "_" + part.getSubmittedFileName();
                post.setImgName(imgName);
                post.setImg(part.getInputStream().readAllBytes());
            }

            postService.updatePost(post);
            response.sendRedirect("/posts");
        }
}
