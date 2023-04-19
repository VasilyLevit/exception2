package hw3;
/*
Приложение записи пользовательских данных в файл
 */
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * inputUserData получение данных от пользователя
 */
public class inputUserData {
   /**
    * Получение данных от пользователя
    * @return Пользовательские данные одной строкой
    */
   public static String getUserData() {
      Scanner sc = new Scanner(System.in);
      System.out.println("Введите Фамилию Имя Отчество датуРождения (dd.mm.yyyy) номерТелефона (10 знаков) пол (f или m) через пробелы: ");
      String data = sc.nextLine();      
      sc.close(); 
      // System.out.println(data);     
      return data;
      // String testData = "Коробочка Настасья Петровна 12.11.1917 9643586226 f"; // Тестова строка пользовательских данных
      // return testData;
   }   
   /**
    * Запись пользовательских данных в файл
    * @param data пользовательские данные
    * @param nameFile имя файла (по фамилии)
    */
   public static void saveFile(String data, String nameFile) {
      // String pathFile = "/Users/Addison/OneDrive/Projects/Exceptions/hw3/text.txt";
      try (FileWriter fw = new FileWriter(nameFile + ".txt",true)) {
         fw.append(data);
         fw.append('\n');
         System.out.println("Запись в файл выполнена.");
      }
      catch (IOException exception) {
         System.out.println(exception.getMessage());
      }
  }

   public static void main(String[] args) {
      String userData = getUserData();
      String[] splitUserData = userData.split(" ");
      int COUNTDATA = 6; // Количество требуемые полей для заполнения

      if (splitUserData.length != COUNTDATA) { 
         throw new RuntimeException("Число заполненных полей " + splitUserData.length + " не соответствует форме");
      }
      
      for (int index = 0; index < 3; index++) {
         if (!splitUserData[index].matches("^\\D*$")) {
         throw new RuntimeException("Поля ФИО не должны содержать цифр");
         }
      }      
      
      if (!splitUserData[3].matches("[0-3][0-9].[0-1][0-9].[0-2][0-9][0-9][0-9]")) {
         throw new RuntimeException("Недопустимый формат даты");
      }

      if (!splitUserData[4].matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")) {
         throw new RuntimeException("Недопустимый формат номера");
      }
      
      if (!splitUserData[5].matches("[f,m]")) {
         throw new RuntimeException("Пол должен быть указан в виде m или f");
      }
      
      // Тестовый вывод на печать пользовательских данных
      // for (String word: splitUserData) {
      //    System.out.println(word); 
      // }

      saveFile(userData, splitUserData[0]);
   }
}