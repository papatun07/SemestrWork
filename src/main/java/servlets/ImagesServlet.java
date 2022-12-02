package servlets;

import entity.Post;
import service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/images/*")
public class ImagesServlet extends HttpServlet {
    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String imgName = req.getPathInfo().substring(1);
        List<Post> posts = postService.getAllPosts();

        for (Post post : posts) {
            if (post.getImgName().equals(imgName)) {
                byte[] img = post.getImg();
                resp.setContentType(getServletContext().getMimeType(imgName));
                resp.setContentLength(img.length);
                resp.getOutputStream().write(img);
                return;
            }
        }
    }
}
