package com.microservicio.calculadorasf.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicio.calculadorasf.models.OperadoresDigitos;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MicroserviciosServices {

    private static final String URL_DIVIDIR = "http://localhost:8080/divide"; //FALLÓ DOCKER
    private static final String URL_MULTIPLICAR = ""; //FALLÓ DOCKER
    private static final String URL_RESTAR = ""; //FALLÓ DOCKER
    private static final String URL_SUMAR = ""; //FALLÓ DOCKER

    public void obtenerDivision(OperadoresDigitos operadoresDigitos){
        String outputString = "";
        //JsonObject jsonObject = null;
        try {
            //System.setProperty("https.protocols", "TLSv1.2");
            ObjectMapper mapper = new ObjectMapper();
            String bodyJson = mapper.writeValueAsString(operadoresDigitos);

            URL url = new URL(URL_DIVIDIR);
            URLConnection connection = url.openConnection();
            HttpsURLConnection conn = (HttpsURLConnection) connection;

            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os = conn.getOutputStream();
            os.write(bodyJson.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                outputString = output;
            }
            System.out.println("outputString: .... :"+outputString);
            conn.disconnect();
            //jsonObject = new JsonParser().parse(outputString).getAsJsonObject();

        } catch (IOException io) {


        }
    }

    public void obtenerMultiplicacion(){

    }

    public void obtenerResta(){

    }

    public void obtenerSuma(){

    }
}
