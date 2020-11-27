package com.microservicio.calculadorasf.utils;

import com.microservicio.calculadorasf.models.Digitos;
import com.microservicio.calculadorasf.models.Operadores;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentificacionCaracteresUtil {

    private static final String REGEXOPERATORS = "[/+,-,/*,//,-]";
    private static final String REGEXDIGITS = "(\\d+)";

    //Obtener digitos
    public Digitos obtenerDigitos(String operacion){
        Digitos digitos = new Digitos();
        ArrayList<Integer> digitosArray = new ArrayList<Integer>();
        Pattern r = Pattern.compile(REGEXDIGITS);
        Matcher m = r.matcher(operacion);
        while (m.find()) {
            int t = Integer.parseInt(operacion.substring(m.start(), m.end()));
            digitosArray.add(t);
        }
        digitos.setDigitos(digitosArray);
        return digitos;
    }

    //obtener operadores
    public Operadores obtenerOperadores(String operacion) {
        Operadores operadores = new Operadores();
        ArrayList<Character> operadoresArray = new ArrayList<Character>();
        Pattern r2 = Pattern.compile(REGEXOPERATORS);
        Matcher m2 = r2.matcher(operacion);
        while (m2.find()) {
            operadoresArray.add(operacion.charAt(m2.start()));
        }
        operadores.setOperadores(operadoresArray);
        return operadores;
    }
}
