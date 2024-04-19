#!/bin/bash

# Function to print colorful ASCII Art for Kernel Launcher
print_kernel_launcher() {
    echo -e "\033[1;35m   ____       __ __ __________  _   __________ \033[0m"
    echo -e "\033[1;35m  / __ \_  __/ //_// ____/ __ \/ | / / ____/ / \033[0m"
    echo -e "\033[1;35m / / / / |/_/ ,<  / __/ / /_/ /  |/ / __/ / /  \033[0m"
    echo -e "\033[1;35m/ /_/ />  </ /| |/ /___/ _, _/ /|  / /___/ /___\033[0m"
    echo -e "\033[1;35m\____/_/|_/_/ |_/_____/_/ |_/_/ |_/_____/_____/\033[0m"
    echo -e "\033[0;36m                                                \033[0m"
    echo -e "\033[0;36m                                                                                              \033[0m"
}

# Function to print colorful message
print_message() {
    local color="$1"
    local message="$2"
    echo -e "\033[1;32m[$(date +"%Y-%m-%d %T")] $color$message\033[0m"
}

# Define log file path
LOG_DIR="logs"
LOG_FILE="$LOG_DIR/bashsrc_logs.log"

# Function to log messages to both stdout and log file
log_message() {
    local message="$1"
    local timestamp=$(date +"%Y-%m-%d %T")
    echo "$timestamp - $message"
    echo "$timestamp - $message" >> "$LOG_FILE"
}

# Main script logic
main() {
    print_kernel_launcher
    print_message "" "Starting script execution..."

    ROOT_DIR=$(pwd)
    SRC_DIR="$ROOT_DIR/src"
    BIN_DIR="$ROOT_DIR/bin"
    VERSION_FILE="$ROOT_DIR/version.txt"

    print_message "" "Root directory: $ROOT_DIR"
    print_message "" "Source directory: $SRC_DIR"
    print_message "" "Binary directory: $BIN_DIR"
    print_message "" "Version file: $VERSION_FILE"

    print_message "" "Compiling Java source files..."
    mkdir -p "$BIN_DIR"
    javac -d "$BIN_DIR" "$SRC_DIR"/*.java

    if [ $? -eq 0 ]; then
        print_message "" "Compilation successful. Running program..."
        mkdir -p "$LOG_DIR"
        VERSION=$(<"$VERSION_FILE")
        java -cp "$BIN_DIR" src.Main
    else
        print_message "Error: " "Compilation failed. Exiting..."
    fi

    print_message "" "Script execution completed."
}

main
