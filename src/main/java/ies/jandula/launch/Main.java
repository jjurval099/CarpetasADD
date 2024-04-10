package ies.jandula.launch;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        File file = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator+"Historicos.csv");

        try (Scanner scanner = new Scanner(file)) 
        {
               	
            scanner.nextLine();            

            while (scanner.hasNextLine()) 
            {
                String linea = scanner.nextLine();

                if (!linea.isEmpty()) 
                {
                    String[] datos = linea.split(","); 
                    String fechaStr = datos[0];
                    int numero1 = Integer.parseInt(datos[1]);
                    int numero2 = Integer.parseInt(datos[2]);
                    int numero3 = Integer.parseInt(datos[3]);
                    int numero4 = Integer.parseInt(datos[4]);
                    int numero5 = Integer.parseInt(datos[5]);
                    int numero6 = Integer.parseInt(datos[6]);
                    int complementario = Integer.parseInt(datos[7]);
                    int reintegro = -1;
                    if(datos.length==9)
                    {
                    	reintegro = Integer.parseInt(datos[8]);
                    }

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = dateFormat.parse(fechaStr);

                    if(fecha.getYear())
                    {
                    	
                    }
                    
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
    }
}
