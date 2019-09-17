#This is the make file for our OOD Maze Project
make:
	javac -d bin @sources

run:
	java Driver

run:
	javadoc

clean:
	rm *.class
	clear
