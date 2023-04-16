//Задание 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.
// package Excep2;

import java.util.Scanner;
import java.lang.Exception;

public class Exep1 {
    public static void main(String[] args) {
        //System.out.println(getFloat());
        getSrting();
    }

    public static float getFloat() {
        float num = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите число:");
            num = sc.nextFloat();
            } catch (Exception e) {      //NumberFormatException???
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            getFloat();
            }
        return num;
    }


// Задание 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public static void getSrting() {
        String text = new String();
        while (text.isEmpty()) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Введите строку:");
                text = sc.nextLine();
            } catch (NullPointerException ex) {
                System.out.println(ex + "Повторите ввод");
            }
        }
    }


}

// Задание 2. Если необходимо, исправьте данный код ,
// try {
//     int d = 0;
//     double catchedRes1 = intArray[8] / d;
//     System.out.println("catchedRes1 = " + catchedRes1);
//     } catch (ArithmeticException e) {
//     System.out.println("Catching exception: " + e);
//     }


// Задание 3. Дан следующий код, исправьте его там, где требуется
//     public static void main(String[] args) throws Exception {
//         try {
//             int a = 90;
//             int b = 3;
//             System.out.println(a / b);
//             printSum(23, 234);
//             int[] abc = { 1, 2 };
//             abc[3] = 9;
//         } catch (ArithmeticException ex) {
//             System.out.println("На ноль делить нельзя!");
// //        } catch (NullPointerException ex) {
// //            System.out.println("Указатель не может указывать на null!");
//         } catch (IndexOutOfBoundsException ex) {
//             System.out.println("Массив выходит за пределы своего размера!");
//         } catch (Throwable ex) {
//             System.out.println("Что-то пошло не так...");
//         }
//     }
//     public static void printSum(Integer a, Integer b) {
//         System.out.println(a + b);
//     }
