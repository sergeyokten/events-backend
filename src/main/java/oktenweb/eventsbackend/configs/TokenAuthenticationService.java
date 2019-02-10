package oktenweb.eventsbackend.configs;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;

public class TokenAuthenticationService {

    //    static final long EXPIRATIONTIME = 864_000_000; // 10 days
//    static final long EXPIRATIONTIME = 30000;
    static final String SECRET = "yes";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse res, String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        System.out.println(token);
        if (token != null) {
            System.out.println(token);
            String replaceToken = token.replace(TOKEN_PREFIX, "");
            System.out.println(replaceToken);
            String username = Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(replaceToken)
                    .getBody()
                    .getSubject();
            //userservice.findByUsername(username)
            System.out.println(username);
            return username != null ?
                    new UsernamePasswordAuthenticationToken(username, "user") :
                    null;
        }
        return null;
    }
}
