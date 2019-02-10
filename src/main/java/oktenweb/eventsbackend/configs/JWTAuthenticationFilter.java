package oktenweb.eventsbackend.configs;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


// check jwt presence with help of TokenAuthenticationService
public class JWTAuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        System.out.println(((HttpServletRequest) request).getMethod());
        System.out.println("dofilter - " + url);
        Authentication authentication = TokenAuthenticationService
                .getAuthentication((HttpServletRequest) request);
        System.out.println(authentication == null ? "" : authentication.getPrincipal());
        System.out.println(authentication == null ? "" : authentication.isAuthenticated());

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        chain.doFilter(request, response);
    }
}
