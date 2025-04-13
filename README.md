This is my submission for the Final Sprint of the DSA course provided by Keyin College.

The program is a Spring Boot application capable of letting users create a binary search tree (BST) from a series of numbers, visualize the resulting tree, and be able to view any previous queries they place.

To run the program, do the following:

- Retrieve the repository above, and clone it into whichever program you're using. (In this case, I'm using IntelliJ so results may vary)
- Upon opening the app, do NOT run using DsaFinalApplication as it will cause an error.
- Instead, head to the terminal and use the command "mvn spring-boot:run".
- If ERROR happens, see below;
- Else, you should be able to make your way to http:localhost8080/enter-nums (must include the / to ensure proper routing)

That's it! If everything succeeds you should now have full access to the website, and can now do the following functions described above. Have fun!

------------------------------------------------------------------------------------------------------------
** if ERROR occurs during the running process, make sure that there is nothing already running on port 8080. 
   you can check this by running the following (on Windows):

   netstat -ano | findstr :8080 

   if there is something running on port 8080, use this to kill:

   taskkill /PID <12345> /F        (replace 12345 with correct PID found in terminal)

   then try running the application again! if that doesn't i have no clue
