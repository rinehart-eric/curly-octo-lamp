To run the database:
1. Start a mysql server on localhost
2. Log in to mysql as root and run:
	CREATE DATABASE VideoGames;
	GRANT ALL PRIVILEGES ON VideoGames.* To 'username'@'localhost' IDENTIFIED BY 'password';
3. Go back to terminal/command line and navigate to the base project directory
3. ant populate //Creates database and populates it.
	3a. Only need to run once to create database
	3b. If there is already existing database of the same name that is not ours, you will need to drop it first. 
4. ant run     //runs the code