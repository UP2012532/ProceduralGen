cd src
javac -verbose Main.java -d ../bin

printf "\nClasses built now creating jar.\n\n"

cd ..
jar -cvfm App.jar META-INF/MANIFEST.MF -C bin .
