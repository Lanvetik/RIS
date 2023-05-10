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

@WebServlet("/getAll")
public class GetAllController extends HttpServlet {
    @WebServiceRef
    PhoneticsService phoneticsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Phonetics> phonetics = phoneticsService.getAll();
        if (phonetics == null) {
            resp.getWriter().write("Записей нет");
        } else {
            req.setAttribute("phonetics", phonetics);
            req.getRequestDispatcher("phonetics.jsp").forward(req, resp);
        }
    }
}