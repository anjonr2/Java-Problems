Concurrent File Reader Program

Develop a generic concurrent file reader program that can read data from multiple 
text files concurrently using java's thread pool and executor framework

Program should meet the following criteria
1.Program should be able to read from multiple text files simultaneously 
2.Program should process and print each data entry
3.Each data entry that gets printed should be prefixed with the name of the thread
that processed it
4.Utilize the executor service for managing threads
5.Provide a mechanism to gracefully shut down all threads when all files 
have been read