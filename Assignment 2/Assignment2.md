# Purpose:
This program is designed to demonstrate basic array actions and operations. It has four sub methods that are supposed
to perform various operations. The first one accepts an array of strings, sorts it and prints the sorted array in
ascending order. Next, there is a method to perform a simple linear search to find the string that is passed to the sub
method. Linear search iterates over the array with a for loop to sequentially check each value in the array to find the
first instance of the string. I created a small helper method to fill a 2d array to fulfill the third sub method which
is required to be filled with floating-point numbers, supplied by the user, then prints them in a table format.

The fourth sub method is supposed to create a deep copy the 2d array from the third sub method then print it in ascending
order. The problem I had was that it was ambiguous which way I was supposed to sort it. With a table, ascending order can
mean two things, row wise or column wise, so I implemented both, allowing the user to select which axis they wanted to
sort the 2d array.
