package mk.finki.ukim.lab.web.filters;
import mk.finki.ukim.lab.model.Balloon;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebFilter
public class BalloonFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException{

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        List<Balloon> balloonList = (List<Balloon>) request.getSession().getAttribute("balloons");
        String path=request.getServletPath();
        if (!"/balloons".equals(path) && balloonList.isEmpty()){
            response.sendRedirect("/balloons");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}