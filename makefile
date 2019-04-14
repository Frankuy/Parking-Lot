#Make class from java file
SOURCE = src/*.java
target:
	javac -d bin $(SOURCE)

