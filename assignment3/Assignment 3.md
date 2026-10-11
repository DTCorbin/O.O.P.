# Purpose

This program was required to take a text file as input then convert it to html. I chose to do this by
using a buffered reader and a buffered writer. I created a method to count the number of lines in the 
input file. I used as the max number in a for loop. within that loop I called two other methods that 
I made to parse the line of the input file and write the html to a file. The example output that was provided
was to generate a table.

---

The line parser used a custom class to classify the parts of the line into the proper html components. The
example used colons to separate the tags from the content. The thing that was difficult was to keep track of
where the tags went because it put attributes in the same place as actual tags.

---

The writer was where most of the complexity was. I had made a helper class to make the process a little
simpler. On the surface, it looks like a big switch statement, which it is, but in each case, it initializes
a buffer to the size of the html token in the switch statement, writes the token to the buffer, then converts
the buffer to a string. The reason for this is because I originally had it keeping track of the number of tabs
to add to the front of the buffer. This caused some problems so I omitted it for now.

# Things to improve

- Convert the parser to a tree. 
- reimplement tabs
