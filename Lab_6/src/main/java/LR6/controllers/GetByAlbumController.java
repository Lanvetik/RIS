package LR6.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.ws.WebServiceRef;
import LR6.service.PhoneticsService;
import LR6.entity.Phonetics;

import java.io.IOException;
import java.util.List;

@WebServlet("/getByAlbun")
public class GetByAlbumController extends HttpServlet {
    @WebServiceRef
    PhoneticsService phoneticsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html; charset=UTF-8");
        String album = req.getParameter("album");
        List<Phonetics> phonetics = phoneticsService.getByAlbum(album);
        if (phonetics == null) {
            resp.getWriter().write("Записей с альбомом " + album + " не найдено");
        } else {
            req.setAttribute("phonetics", phonetics);
            req.getRequestDispatcher("phonetics.jsp").forward(req, resp);
        }
    }
}