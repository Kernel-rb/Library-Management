#!/bin/bash

# ASCII Art for Kernel Launcher
echo "

   ____       __ __ __________  _   __________ 
  / __ \_  __/ //_// ____/ __ \/ | / / ____/ / 
 / / / / |/_/ ,<  / __/ / /_/ /  |/ / __/ / /  
/ /_/ />  </ /| |/ /___/ _, _/ /|  / /___/ /___
\____/_/|_/_/ |_/_____/_/ |_/_/ |_/_____/_____/
                                               
                                                                                              
"

ROOT_DIR=$(pwd)
SRC_DIR="$ROOT_DIR/src"
BIN_DIR="$ROOT_DIR/bin"
LOG_DIR="$ROOT_DIR/logs"
VERSION_FILE="$ROOT_DIR/version.txt"
LOG_FILE="$LOG_DIR/logfile.log"

echo "Compiling Java source files..."
mkdir -p "$BIN_DIR"
javac -d "$BIN_DIR" "$SRC_DIR"/*.java



if [ $? -eq 0 ]; then
    echo "Compilation successful. Running program..."
    mkdir -p "$LOG_DIR"
    VERSION=$(<"$VERSION_FILE")
    java -cp "$BIN_DIR" src.Main

else
    echo "Compilation failed. Exiting..."
fi
