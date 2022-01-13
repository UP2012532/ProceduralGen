#Builds .java files into .class then creates a .jar with them all

#If build folder exists: delete files in build folder (there may be unwanted class files)
[ -d "bin" ] && rm -r bin/*

#Create .class files
cd src
javac -verbose Main.java -d ../bin

printf "\nClasses built now creating jar.\n\n"

#Create .jar file
cd ../bin
jar -cvfm ../App.jar ../manifest.txt *.class
