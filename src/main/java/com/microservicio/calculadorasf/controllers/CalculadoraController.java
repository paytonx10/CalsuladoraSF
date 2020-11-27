package com.microservicio.calculadorasf.controllers;

import com.microservicio.calculadorasf.facades.GeneraCalculoFacade;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
public class CalculadoraController {

    @GetMapping("/calcular")
    public String calcular(@RequestParam(value = "operacion", defaultValue = "0") String operacion) {
        GeneraCalculoFacade generaCalculo = new GeneraCalculoFacade();
        String valor = generaCalculo.GeneraCalculoFacade(operacion);

        //System.out.println(operators.size());
        return String.format("Cálculo operación: "+valor);
    }

}
