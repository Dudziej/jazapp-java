package pl.edu.pjwstk.jaz.login;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.edu.pjwstk.jaz.auth.UserContext;

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
					var resq = req.getParameter("id");
					if (resq == null || resq.length() == 0) {
						chain.doFilter(req, res);
					} else {
					Long auctionId = Long.parseLong(resq);
                    if (uc.hasAccessToAuction(auctionId)) {
                        chain.doFilter(req, res);
                    } else {
                        res.sendRedirect(getServletContext().getContextPath() + "/index.xhtml");
					}
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
                req.getRequestURI().contains("samples") ||
                // ONLY FOR TESTING
				req.getRequestURI().contains("api");
                // ONLY FOR TESTING
    }

    private boolean isResourceReq(HttpServletRequest req) {
        return req.getRequestURI().startsWith(
                req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
    }

    private boolean isAdminReq(HttpServletRequest req) {
		if (!isOwnerReq(req)) {
			return req.getRequestURI().contains("admin");
		}
		return false;
    }

    private boolean isOwnerReq(HttpServletRequest req) {
        return req.getRequestURI().equals(req.getContextPath() + "/auctions/editauction.xhtml");
    }
}
