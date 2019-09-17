#This is the make file for our OOD Maze Project
make:
	javac -d bin @sources

run:
	java Driver

clean:
	rm *.class
	clear
