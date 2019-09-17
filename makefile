#This is the make file for our OOD Maze Project
make:
	javac @sources

run:
	java Driver

clean:
	rm *.class
	clear

