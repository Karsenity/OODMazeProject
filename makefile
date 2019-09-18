#This is the make file for our OOD Maze Project
make:
	javac -d bin @sources

run:
	java Driver

doc:
	javadoc -d doc src/*.java

clean:
	rm *.class
	clear
