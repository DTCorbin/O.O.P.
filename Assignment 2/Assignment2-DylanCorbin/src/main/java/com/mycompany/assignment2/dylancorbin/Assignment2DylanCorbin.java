/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.assignment2.dylancorbin;

/**
 *
 * @author DTC
 */

import java.util.Arrays;
import java.util.Scanner;
        
public class Assignment2DylanCorbin {
        
    //##########################
    //####  HELPER METHODS  ####
    //##########################
    
    //helper method to fill the 2d array
    public static float[][] fillArr(float[][] emptyArr){
        Scanner in = new Scanner(System.in);
        float val;
        for (int i = 0; i < emptyArr.length; i++){
            for (int j = 0; j < emptyArr[i].length; j++){
                System.out.printf("Please enter the floating point value for [%d][%d]: ", i, j);
                val = in.nextFloat();
                emptyArr[i][j] = val;
            }
        }
        //consumes the newline character just in case
        in.nextLine();
        return emptyArr;
    }
    
    //float version of my sort array
    public static void floatSort(float[] array){
        for (int i=0; i < array.length; i++) {
            int mindex = i;
            for (int j = i; j < array.length; j++){
                if (array[j] < array[mindex]){
                    mindex = j;
                }
            }
            float temp = array[i];
            array[i] = array[mindex];
            array[mindex] = temp;
        }
    }
    
    //helper method to help print the rock array in ascending
    //order on axis 0
    public static void col(float[][] arr) {
        
        //for each column
        
        for (int i = 0; i < arr[0].length; i++){
            
            //create a temporary 1d array
            
            float[] temp = new float[arr.length];
            
            //fill the temp array with the values of each
            //column then sort the temporary array
            
            for (int j = 0; j < arr.length; j++){
              temp[j] = arr[j][i];
            }
            floatSort(temp);
            
            //map the temp array values to the corresponding
            //position on the 2d array
            
             for (int k = 0; k < arr.length; k++){
               arr[k][i] = temp[k];
             }
        }
    }
    
    //#############################################
    //####  SUBMETHOD 1: SORT THE WORDS ARRAY  ####
    //#############################################
    
    public static void sortArray(String[] array){
        for (int i = 0; i < array.length; i++){
            int mindex = i;
            for (int j = i+1; j < array.length; j++){
                
                //compares all characters in the strings
                //and if it finds a smaller value, it reassigns
                //the minimum index variable
                
                if (array[mindex].compareToIgnoreCase(array[j]) > 0) {
                    mindex = j;
                }
            }
            //Then swaps values
            String temp = array[i];
            array[i] = array[mindex];
            array[mindex] = temp;
        }
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
    
    //###############################################
    //####  SUBMETHOD 2: Linear Search function  ####
    //###############################################
    
    public static void linearSearch(String[] sortedArr, String val) {
        for (int i = 0; i < sortedArr.length; i++){
            if (sortedArr[i].equals(val)) {
                
    // to handle the special cases in positional labels
    
                switch (i) {
                    case 0:
                        System.out.println(val + " is at the 1st position");
                        break;
                    case 1:
                        System.out.println(val + " is at the 2nd position");
                        break;
                    case 2:
                        System.out.println(val+"is at the 3rd position");
                        break;
                    default:
                        System.out.println(val + " is at the " + (i + 1) + "th position");
                }
                break;
            } else if (i == (sortedArr.length - 1))
                System.out.println(val + " could not be found");
        }
    }
    
    //#########################################################
    //####  SUBMETHOD 3: Print 2d array in a table format  ####
    //#########################################################
    
    public static void printTable(float[][] arr){
        System.out.println();
        
    //  Table Head
    
        System.out.print("       ");
        for (int g = 0; g < arr[0].length; g++){
          System.out.print("     col " + g + "  ");
        }
        System.out.println();
        System.out.print("       ");
        for (int h = 0; h < arr[0].length; h++) {
          System.out.print("+-----------");
        }
        System.out.println("+");
        
    //  Table body
    
        for (int i = 0; i < arr.length; i++) {
          System.out.printf("row%3d ", i);
          for (int j = 0; j < arr[i].length; j++){
            System.out.printf("| %8.2f  ", arr[i][j]);
          }
          
    //    handles the end of the row
    
          System.out.println("|");
          System.out.print("       ");
          
    //    handles the lines between rows
    
          for (int k = 0; k < arr[0].length; k++) {
            System.out.print("+-----------");
          }
          System.out.println("+");
        }
        System.out.println();
    }
    
    //#############################################################################
    //####  SUBMETHOD 4: Deep Copy a 2d array and print it in ascending order  ####
    //#############################################################################
    
    public static void copyArray(float [][] original){
        float[][] rock = new float[original.length][original[0].length];
        for (int i = 0; i < original.length; i++){
            System.arraycopy(original[i], 0, rock[i], 0, original[i].length);
        }
        int opt = 2;
        System.out.print("0 for column-wise sorting\n1 for row-wise sorting\nPlease choose a sorting method: ");
        Scanner select = new Scanner(System.in);
        while (opt != 0 || opt != 1){
            opt = select.nextInt();
            if (opt == 1) {
                
    //          Axis[1] sort of the rock array
    
                System.out.println("\nRock array sorted on axis 1:");
                for (int i = 0; i < rock.length; i++){
                    floatSort(rock[i]);
                }
                break;
            } else if (opt == 0) {
                
    //          Axis[0] sort of the rock array
    
                System.out.println("\nRock array sorted on axis 0:");
                col(rock);
                break;
            } else{
                System.out.println("Please either choose 1 for row-wise or 0 for column-wise: ");
            }
        }
        printTable(rock);
    }

    
    public static void main(String[] args) {
        String[] words = {"DC", "SRU", "Rock", "SWC", "ARC", "VSC", "Grove"};
        float[][] sru = new float[5][5];        
        System.out.println("Original Array: " + Arrays.toString(words));
        sortArray(words);
        linearSearch(words, "SRU");
        fillArr(sru);
        System.out.println("\nSRU array:");
        printTable(sru);
        copyArray(sru);
    }
}
