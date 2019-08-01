package com.epam.file;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrey_Vaganov on 12/5/2016.
 */
public class MainReader {

    /**
     * Формат даты
     */
    private static final String DATE_FORMAT_PATTERN = "dd.MM.yyyy";

    /**
     * Форматтер, используется для преобразования строк в даты и обратно
     */
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT_PATTERN);


    /**
     * Точка входа в программу
     * @param args
     */
    public static void main(String[] args) {
        readFile();
    }

    /**
     * Метод для чтения дат из файла
     */
    public static void readFile() {
        //Открываем потоки на чтение из файла
        try (FileReader reader = new FileReader("ExceptionTask\\src\\file");
             BufferedReader byfReader = new BufferedReader(reader)) {
            String strDate = byfReader.readLine();
            while(strDate != null) {
                try {
                    //Преобразуем строку в дату
                    Date date = parseDate(strDate);

                    //Выводим дату в консоль в формате dd-mm-yy
                    System.out.printf("%1$td-%1$tm-%1$ty \n", date);
                } catch (ParseException e) {
                    System.out.println("Caught ParseException" + e.getMessage());
                } finally {
                    //Читаем следующую строку из файла
                    strDate = byfReader.readLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException" + e.getMessage());
        }
    }

    /**
     * Метод преобразует строковое представление даты в класс Date
     * @param strDate строковое представление даты
     * @return
     */
    public static Date parseDate(String strDate) throws ParseException {
        return dateFormatter.parse(strDate);
    }
}

