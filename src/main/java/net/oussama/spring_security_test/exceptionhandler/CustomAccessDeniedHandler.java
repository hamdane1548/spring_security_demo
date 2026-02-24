package net.oussama.spring_security_test.exceptionhandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.time.LocalDateTime;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
      response.setContentType("application/json;charset=UTF-8");
      response.setContentType("APPLICATION/JSON");
      LocalDateTime  now = LocalDateTime.now();
      String message = accessDeniedException.getMessage();
      String path = request.getRequestURI();
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      String jsonCustomRespone = String.format("{\"timestamp\":\"%s\",\"status\":%d,\"error\":\"%s\",\"message\":\"%s\",\"path\":\"%s\"}"
      now, HttpStatus.UNAUTHORIZED.value(),HttpStatus.UNAUTHORIZED.getReasonPhrase(),message,path
      );
     response.getWriter().write(jsonCustomRespone);
    }
}
