#Builds .java files into .class then creates a .jar with them all

#If build folder exists: delete files in build folder (there may be unwanted class files)
[ -d "build" ] && rm -r build/*

#Create .class files
cd src
javac -verbose Main.java -d ../build

printf "\nClasses built now creating jar.\n\n"

#Create .jar file
cd ../build
jar -cvfm ../App.jar ../manifest.txt *.class
