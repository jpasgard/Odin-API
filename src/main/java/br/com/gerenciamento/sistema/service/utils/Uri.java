package br.com.gerenciamento.sistema.service.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class Uri {
    public static List<Long> decodeIntList(String list){
        String[] aux = list.split(",");
        List<Long> listaAux = new ArrayList<Long>();
        for (int i = 0; i < aux.length; i++) {
            listaAux.add(Long.parseLong(aux[i]));
        }
        return listaAux;
    }
    public static String decodeParam(String param) {
        try {
            return URLDecoder.decode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            return "";
        }
    }
}