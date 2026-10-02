/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.assignment1.dylancorbin;

/**
 *
 * @author DTC
 */
public class Assignment1DylanCorbin {
    
    //find the lowest integer in the array
    
    public static int smallest(int data[], int size) {
        int lowest = data[0];
        for (int i = 0; i < size; i++){
            if (data[i]< lowest){
                lowest = data[i];
            }
        }
        return lowest;
    }
    
    //find the highest integer in the array
    
    public static int biggest(int data[], int size) {
        int highest = data[0];
        for (int i = 0; i < size; i++){
            if (data[i] > highest){
                highest = data[i];
            }
        }
        return highest;
    }
    
    //find the sum of all integers in the array
    
    public static int addition(int data[], int size){
        int sum = 0;
        for (int i = 0; i< size; i++){
            sum += data[i];
        }
        return sum;
    }
    
    //find the average of all integers in the array
    
    public static double average(int data[], int size){
        
        //had to typecast because averages aren't always perfect integers
        double total = (double) addition(data, size);
        double average = total/size;
        return average;
    }
    
    public static void main(String[] args) {
        int data[] = {5,6,12,15,87,23,78,7,56,23};
        int size = data.length;
        // small amount of input validation
        if (size < 10){
            System.out.println("Error: The array is not at least 10 integers");
            System.exit(0);
        }
        int low = smallest(data, size);
        int high = biggest(data, size);
        int total = addition(data, size);
        double avg = average(data, size);
        System.out.println("Lowest: \t" + low);
        System.out.println("Highest: \t" + high);
        System.out.println("Total: \t\t" + total);
        System.out.println("Average: \t"+ avg);
    }
}
