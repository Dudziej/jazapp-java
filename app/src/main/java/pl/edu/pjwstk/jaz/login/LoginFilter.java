package pl.edu.pjwstk.jaz.login;

import pl.edu.pjwstk.jaz.auth.UserContext;

import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("*")
public class LoginFilter extends HttpFilter {
    @Inject
    private UserContext uc;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (isResourceReq(req) || isSiteAllowed(req) || isUserLogged(req)) {
            if (isAdminReq(req)) {
                if (uc.isAdmin()) {
                    chain.doFilter(req, res);
                } else {
                    res.sendRedirect(getServletContext().getContextPath() + "/index.xhtml");
                }
            } else {
                if (isOwnerReq(req)) {
                    var resq = req.getPart("id");
                    Long auctionId = Long.parseLong("3");
                    if (uc.hasAccessToAuction(auctionId)) {
                        chain.doFilter(req, res);
                    } else {
                        res.sendRedirect(getServletContext().getContextPath() + "/index.xhtml");
                    }
                } else {
                    chain.doFilter(req, res);
                }
            }
        } else {
            res.sendRedirect(getServletContext().getContextPath() + "/login.xhtml");
        }
    }

    private boolean isUserLogged(HttpServletRequest req) {
        var session = req.getSession(false);
        return session != null && session.getAttribute("username") != null;
    }

    private boolean isSiteAllowed(HttpServletRequest req) {
        return req.getRequestURI().equals(req.getContextPath() + "/login.xhtml") ||
                req.getRequestURI().equals(req.getContextPath() + "/register.xhtml") ||
                req.getRequestURI().contains("samples");
    }

    private boolean isResourceReq(HttpServletRequest req) {
        return req.getRequestURI().startsWith(
                req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
    }

    private boolean isAdminReq(HttpServletRequest req) {
        return isOwnerReq(req);
    }

    private boolean isOwnerReq(HttpServletRequest req) {
        return req.getRequestURI().equals(req.getContextPath() + "/auctions/editauction.xhtml");
    }
}
