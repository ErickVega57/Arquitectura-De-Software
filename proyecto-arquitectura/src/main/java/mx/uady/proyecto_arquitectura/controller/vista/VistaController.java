package mx.uady.proyecto_arquitectura.controller.vista;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class VistaController {

    @GetMapping("/")
    public String mostrarIndex(){
        return "index.html";
    }
}
