package mk.finki.ukim.lab.web.servlet;

import mk.finki.ukim.lab.service.BalloonService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "balloonorder", urlPatterns = "/servlet/BalloonOrder.do")
public class BalloonOrderServlet  extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BalloonService balloonService;

    public BalloonOrderServlet (SpringTemplateEngine springTemplateEngine, BalloonService balloonService) {
        this.springTemplateEngine = springTemplateEngine;
        this.balloonService = balloonService;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        this.springTemplateEngine.process("deliveryInfo.html",context,resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        req.getSession().setAttribute("clientIp",req.getRemoteAddr());
        req.getSession().setAttribute("clientBrowser",req.getHeader("User-Agent"));
        req.getSession().setAttribute("username", username);
        resp.sendRedirect("/servlet/ConfirmationInfo");

    }
}