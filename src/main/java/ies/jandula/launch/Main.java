package ies.jandula.launch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        File file = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "Historicos.csv");
        
        File carpetaAro = null;
        
        File carpetaMes = null;
        
        File carpetaDay = null;

        Set<Integer> arosList = new HashSet<>(); 
        
        Set<Integer> mesList = new HashSet<>(); 
        
        Set<Integer> diaList = new HashSet<>();
        

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
                        if (datos.length == 9) {
                            reintegro = Integer.parseInt(datos[8]);
                        }

                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = dateFormat.parse(fechaStr);

                    // Se suma 1900 porque getYear() comienza en 100
                    int year = fecha.getYear()+1900;
                    arosList.add(year); 
                    
                    // Se suma 1 porque getMonth porque comienza en 0
                    int month = fecha.getMonth()+1;                    
                    mesList.add(month);
                    
                    // Se suma 1 porque getMonth porque comienza en 0
                    int day = fecha.getDay()+1;
                    diaList.add(day);                                       
                }
            }
        } 
        catch (FileNotFoundException fileNotFoundException) 
        {
        	fileNotFoundException.printStackTrace();
        } 
        catch (ParseException parseException) 
        {
        	parseException.printStackTrace();
        }

        for (int year : arosList) 
        {
            carpetaAro = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + year);
            
            if (!carpetaAro.exists()) 
            {
            	carpetaAro.mkdirs(); 
            }
            
            for(int month : mesList)
            {
            	carpetaMes = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + year + File.separator + month);
            	
            	if (!carpetaMes.exists()) 
                {
            		carpetaMes.mkdirs(); 
                }
            	
            	for(int day : diaList)
                {
                	carpetaDay = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + year + File.separator + month +File.separator + day);
                	
                	if (!carpetaDay.exists()) 
                    {
                		carpetaDay.mkdirs(); 
                    }
                	
            		FileWriter fileWriter = new FileWriter("src" + File.separator + "main" + File.separator + "resources" + File.separator + year + File.separator + month +File.separator + day + File.separator + day+month+year+".tsv");              	
               
                
                }  
            }
        }
    }
}

