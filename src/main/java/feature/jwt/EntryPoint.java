package feature.jwt;

import com.google.gson.Gson;
import feature.exception.InvalidLoginException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        InvalidLoginException loginResponse = new InvalidLoginException();
        String jsonLoginResponse = new Gson().toJson(loginResponse);

        response.setStatus(401);
        response.setContentType("application/json");
        response.getWriter().print(jsonLoginResponse);
    }
}
