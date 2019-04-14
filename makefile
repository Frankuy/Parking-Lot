#Make class from java file
SOURCE = src/*.java
TEST = test/*.java
target:
	javac -d bin $(SOURCE)
	javac -d bin -cp bin $(TEST)

