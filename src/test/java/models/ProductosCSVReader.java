package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProductosCSVReader {

    public static List<String[]> leerProductos() {

        List<String[]> productos = new ArrayList<>();

        String ruta = "src/test/resources/data/productos.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;
            br.readLine(); // saltar encabezado

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                productos.add(datos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productos;
    }
}