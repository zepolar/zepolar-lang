package com.linbrox.common;

public class MathUtils {

    // Devuelve el factorial de un número
    public static int factorial(int number) {
        if (number < 0) throw new IllegalArgumentException("El número no puede ser negativo");
        return (number == 0) ? 1 : number * factorial(number - 1);
    }

    // Calcula la media de un array de números
    public static double average(int[] numbers) {
        if (numbers == null || numbers.length == 0) throw new IllegalArgumentException("El array no puede estar vacío");
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }

    // Verifica si un número es primo
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
