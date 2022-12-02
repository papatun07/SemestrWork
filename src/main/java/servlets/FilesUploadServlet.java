//package servlets;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//import java.io.IOException;
//
//@WebServlet("/files-upload")
//public class FilesUploadServlet extends HttpServlet {
//    private FilesService filesService;
//
//    @Override
//    public void init(ServletConfig config) {
//        this.filesService = (FilesService) config.getServletContext().getAttribute("filesService");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("html/fileUpload.html").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Part part = request.getPart("file");
//        FileInfo fileInfo;
//        try {
//            fileInfo = filesService.saveFileToStorage(part.getInputStream(),
//                    part.getSubmittedFileName(),
//                    part.getContentType(),
//                    part.getSize());
//        } catch (FileSizeException e) {
//            response.setStatus(400);
//            response.getWriter().println(e.getMessage());
//            return;
//        }
//        response.sendRedirect("/files/" + fileInfo.getId());
//    }
//}
