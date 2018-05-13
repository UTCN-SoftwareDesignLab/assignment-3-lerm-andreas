package bookstore.config;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class AuthSuccessHandler  extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        // Get the role of logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();

        String targetUrl = "";
        if(role.contains("administrator")) {
            targetUrl = "/administrator";
        }// else if(role.contains("user")) {
        //    targetUrl = "/user";
        //}
        else if(role.contains("secretary")) {
            targetUrl = "/secretary";
        }
        else if(role.contains("doctor")) {
            targetUrl = "/doctor";
        }
        return targetUrl;
    }
}
