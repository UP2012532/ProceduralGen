# Getting started guide

## Prerequisites

### JDK

Make sure that JDK is installed, and the bin folder path is on the home enviorment variable path. To check type in a console:

```shell
javac --version
```

Should output something like this:

```shell
javac 15.0.1
```

### Git shell

Make sure that the Git bin folder is on the home enviorment variable path. To check type in a console:

```shell
sh --version
```

Should output something like this:

```shell
GNU bash, version 4.4.23(1)-release (x86_64-pc-msys)
Copyright (C) 2016 Free Software Foundation, Inc.
License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>

This is free software; you are free to change and redistribute it.
There is NO WARRANTY, to the extent permitted by law.
```

## Build

To build the application in vscode simply press
```ctrl + shift + B```, or type in a console:

```shell
sh build.sh
```

## Run

To run the application either open it through a file browser, or type in the console:

```shell
java -jar App.jar
```
