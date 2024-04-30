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
        File carpetaDia = null;

        Set<Integer> arosList = new HashSet<>(); 
        Set<Integer> mesList = new HashSet<>(); 
        Set<Integer> diaList = new HashSet<>();
        
        try (Scanner scanner = new Scanner(file)) 
        {
            scanner.nextLine(); // Leer la primera línea y descartarla

            while (scanner.hasNextLine()) 
            {
                String linea = scanner.nextLine();

                if (!linea.isEmpty()) 
                {
                    String[] datos = linea.split(",");
                    String fechaStr = datos[0];

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha = dateFormat.parse(fechaStr);

                    int year = fecha.getYear() + 1900;
                    arosList.add(year);

                    int month = fecha.getMonth() + 1;
                    mesList.add(month);

                    int day = fecha.getDate();
                    diaList.add(day);
                }
            }

            for (int year : arosList) 
            {
                for (int month : mesList) 
                {
                    for (int day : diaList) 
                    {
                        carpetaDia = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + year + File.separator + month + File.separator + day);

                        if (!carpetaDia.exists()) 
                        {
                            carpetaDia.mkdirs();
                        }

                        String fileName = carpetaDia.getPath() + File.separator + String.format("%02d%02d%04d.csv", day, month, year);
                        FileWriter fileWriter = new FileWriter(fileName);

                        try (Scanner scanner2 = new Scanner(file)) 
                        {
                            scanner2.nextLine(); // Ignorar la primera línea

                            while (scanner2.hasNextLine()) 
                            {
                                String linea = scanner2.nextLine();

                                if (!linea.isEmpty()) 
                                {
                                    String[] datos = linea.split(",");
                                    String fechaStr = datos[0];

                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    Date fecha = dateFormat.parse(fechaStr);

                                    int csvYear = fecha.getYear() + 1900;
                                    int csvMonth = fecha.getMonth() + 1;
                                    int csvDay = fecha.getDate();

                                    if (csvYear == year && csvMonth == month && csvDay == day) 
                                    {
                                        int numero1 = Integer.parseInt(datos[1]);
                                        int numero2 = Integer.parseInt(datos[2]);
                                        int numero3 = Integer.parseInt(datos[3]);
                                        int numero4 = Integer.parseInt(datos[4]);
                                        int numero5 = Integer.parseInt(datos[5]);
                                        int numero6 = Integer.parseInt(datos[6]);
                                        int complementario = Integer.parseInt(datos[7]);
                                        int reintegro = datos.length == 9 ? Integer.parseInt(datos[8]) : -1;

                                        String dataLine = fechaStr + "," + numero1 + "," + numero2 + "," + numero3 + "," +
                                                numero4 + "," + numero5 + "," + numero6 + "," + complementario + "," + reintegro + "\n";

                                        fileWriter.write(dataLine);
                                    }
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

                        fileWriter.close();
                    }
                }
            }
        } 
        catch (FileNotFoundException fileNotFoundException) 
        {
            fileNotFoundException.printStackTrace();
        } 
        catch (IOException ioException) 
        {
            ioException.printStackTrace();
        } 
        catch (ParseException e)
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
