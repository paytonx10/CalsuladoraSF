package com.microservicio.calculadorasf.facades;

import com.microservicio.calculadorasf.models.Digitos;
import com.microservicio.calculadorasf.models.OperadoresDigitos;
import com.microservicio.calculadorasf.services.MicroserviciosServices;
import com.microservicio.calculadorasf.utils.IdentificacionCaracteresUtil;

import javax.rmi.CORBA.Util;
import java.util.Iterator;

public class GeneraCalculoFacade {

    private static final Character[] OPERATORS = {'/', '*', '+', '-'};
    private MicroserviciosServices services;

    public String GeneraCalculoFacade(String operacion) {
        IdentificacionCaracteresUtil util = new IdentificacionCaracteresUtil();

        OperadoresDigitos operadoresDigitos = new OperadoresDigitos();
        operadoresDigitos.setDigitosObj(util.obtenerDigitos(operacion));
        operadoresDigitos.setOperadoresObj(util.obtenerOperadores(operacion));

        obtenerPorOperadores(operadoresDigitos);

        String calculoFinal = "";
        Iterator<Integer> i = operadoresDigitos.getDigitosObj().getDigitos().iterator();
        while (i.hasNext()) {
            calculoFinal = String.valueOf(i.next());
        }

        Iterator<Character> z = operadoresDigitos.getOperadoresObj().getOperadores().iterator();
        while (z.hasNext()) {
            System.out.print("b:"+z.next());
        }

        return calculoFinal;
    }

    private void obtenerPorOperadores(OperadoresDigitos operadoresDigitos){
        for (Character op : OPERATORS) {
           //llamada servicio dividir
           services.obtenerDivision(operadoresDigitos);
           //llamada servicio multiplicar
           //llamada servicio restar
           //llamada servicio sumar
        }

    }

}
