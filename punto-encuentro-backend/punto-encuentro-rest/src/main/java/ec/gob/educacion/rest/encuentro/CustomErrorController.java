package ec.gob.educacion.rest.encuentro;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
 
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        if (HttpStatus.NOT_FOUND
                .value() == (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)) {
            return "/index.html";
        }
        return "error";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
 
}