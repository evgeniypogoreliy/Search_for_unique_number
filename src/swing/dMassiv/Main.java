package swing.dMassiv;

import java.util.Random;
import java.util.Scanner;


public class Main {
    static Random rnd = new Random(); // Объявление имени для функции рандомного заполнения числами
    static int row = 0;               // Объявление перменной для количества строк
    static int colum = 0;             // Объявление перменной для количества столбцов
    static int rndMin = 1;            // Минимальное число для заполнения массива
    static int rndMax = 9;            // Максимальное число для заполнения массива

    public static void main(String[] args) {
        Scanner sacnner = new Scanner(System.in); // Объявление сканера для отслеживания вводимых значений в консоль
        System.out.println("Введите количество строк: ");
        row = sacnner.nextInt();              // Задание количества строк
        System.out.println("Введите количество столбцов: ");
        colum = sacnner.nextInt();            // Задание количества столбцов
        int[][] arr = new int[row][colum];    // Объявление двумерного массива

        FillArray(arr);                       // Заполнение двумерного массива
        PrintArray(arr);                      // Вывод заполниного двумерного масива
        System.out.println(countUnique(arr)); // Вывод количества уникальных чисел

        int[][] arrayDic = new int[countUnique(arr)][2]; // Объявление двумерного массива для записи результатов поиска уникальных чисел
        int indexArrayDic = 0; // Индекс массива для перебора при заполнении

        // Перебор массива на предмет уникальных чесел и их количесвта
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]+" ");                               //Вывод всех чисел массива
                if(countNumArray(arrayDic,arr[i][j]) == 0){                    //Условие записи числа в массив с результатами поиска уникальных чисел
                    arrayDic[indexArrayDic][0] = arr[i][j];                    //Присваивоние соответсвующуму индексу массива с результатами, числа из начального массива
                    arrayDic[indexArrayDic][1] = countNumArray(arr, arr[i][j]);//Присваивоние соответсвующуму индексу массива с результатами, количества повторений уникального числа
                    indexArrayDic++;                                           //Прибовление единицы к индексу массива с результатами
                }
            }
        }
        System.out.println(); // Переход на новую строку в консоле

        PrintArray(arrayDic); // Вывод двумерного массива с результатом поиска уникальных чисел и количеством повторений

    }

    private static void FillArray(int[][] a) {  // Метод для заполнение двумерного массива
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rnd.nextInt(rndMin, rndMax) + rndMin;
            }
        }
    }
    private static int countUnique(int[][] a) { // Метод-Счетчик количества уникальных чисел в двумерном массиве
        int res = 0;
        for(int i = rndMin; i <= rndMax; i++){
            if(numberUnique(a, i) == 1){
                res++;
            }
        }
        return res;
    }
    private static int numberUnique( int[][] a, int value) { // Метод-проверка наличия заданного числа в двумерном массиве
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                    if (a[i][j] == value) {
                        num = 1;
                    }
            }
        }
        return num;
    }

//    private static void PrintArrayDic(int[][] a){
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }

    private static void PrintArray(int[][] a){ // Метод для вывода в кансоль двумерного массива
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int countNumArray(int[][] a, int value){ //Метод для посика количества повторений числа
        int countNum = 0;
        for(int i =0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                if(a[i][j] == value){
                    countNum++;;
                }
            }
        }
        return countNum;
    }
}


