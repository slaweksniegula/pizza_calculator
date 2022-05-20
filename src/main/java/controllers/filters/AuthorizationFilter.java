package controllers.filters;

import utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AuthorizationFilter", urlPatterns =
        {"/calculate"})
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(req, resp);

        String currentUser = ServletUtils.getCurrentUserEmailFromSession((HttpServletRequest)req);
        if (currentUser==null){
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
