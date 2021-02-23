# Java_project

CS 310 Data Structures
Programming Assignment 0
Spring 2021

Due Wed., Feb 17 by midnight (i.e., end of this day) See Delivery section at end of this document for starred files due at this time. Note Mon., Feb.16 is a holiday.

This assignment aims to help you:

Learn about Maps (Symbol Tables), and get experience with their JDK classes
Think about performance and memory use
Reading

Read S&W Section 3.1 on symbol tables (maps), Section 3.5 on applications including text indexes. If you have Weiss, read Weiss Chap. 6 through Section 6.8 on Collection classes. Read the JDK API docs on at least Map, HashMap, and TreeMap. 

Project Description: also see Suggested Steps for more information.

A simple application using JDK collection classes.
The main server at your company maintains 500 terminal lines, numbered 1 through 500 inclusive. Every 10 minutes the system appends to a log file the terminal line numbers and user name of the person currently logged on, one terminal line number and username per line of text. (Not all lines are in use at every moment.) A fragment of the log file looks like this:
9 ALTEREGO
12 ALIMONY
433 HOTTIPS
433 USERMGR
12 BLONDIE
433 HOTTIPS
354 ALIMONY

This log file shows HOTTIPS was on line 433 twice but USERMGR was on that line at an intervening time. It also shows that ALIMONY was on line 12 at one time and line 354 later on. The log does not display the time at which each line was written. Your job is to write a program in Java that meets the following specifications.

The program first reads a log file into memory, storing the input data as it encounters it. Assume IO redirection when your program is invoked, so it can read from System.in rather than by actually opening a named textfile. User names are ASCII (plain text) strings with no embedded whitespace and a maximum length of 40 characters.

After all the data has been read your program should print data about terminal line usage: a header line and then one line of output for each terminal line showing the terminal line number, the most common user of that terminal line (in the event of a tie, choose one user), and a count of how many times that user was on that terminal line. Here is sample output:

Line Most Common User Count

1 OPERATOR 1749
2 HANNIBAL 432
3 NONE 0
4 HOTTIPS 945
...

Implementation. Since the lines are numbered consecutively, it is easy to use an array with one spot for each line, leaving spot 0 empty. Each line needs a container of user-count data, i.e. how many times each user has been seen on that line. Create a class named Usage to hold a single username and its count together. Note it is almost the same as WordUsage of homework 1. Create a class named LineUsage to hold all the data on one particular terminal line. In this LineUsage class, use a Map from the JDK (HashMap or TreeMap), mapping each username to its count, an Integer. See the provided program FrequencyCounter.java for an example of using a Map to hold a count for each of many strings. LineUsage should have methods addObservation(String username) and Usage findMaxUsage(), which returns the Usage object for the user with the highest count. Note that Usage is not used in the map, only in the delivery of results once the Map is full of data. TestLineUsage is a simple test of LineUsage: just create one LineUsage object, add data to it, and print it out. The top-level class LineReport has an array of LineUsage objects to hold all the data on all the lines. See page 72 of S&W for discussion of an array of objects. LineReport.java should have several methods (at least two object methods or static methods), including a main() to run the program. Each method should be commented (a comment above the method to describe what it does). 
