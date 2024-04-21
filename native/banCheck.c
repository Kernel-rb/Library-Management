#inlude <stdio.h>
#include <stdbool.h>
#include <string.h>
// #include <jni.h>


int main(){
    FILE *file = fopen("C:\\Users\\petmk\\Desktop\\Library-Management\\data\\BannedUsers.txt", "r");
    if (file == NULL) {
        printf("Error opening file.\n");
        return false;
    }

    char line[256];
    bool usernameExists = false;
    while (fgets(line, sizeof(line), file)) {
        if (strstr(line, "Username:") == line) {
            char extractedUsername[256];
            sscanf(line, "Username: %[^\n]", extractedUsername);
            char *trimmedUsername = strtok(extractedUsername, " \t\n\r");
            if (strcmp(trimmedUsername, username) == 0) {
                usernameExists = true;
                break;
            }
        }
    }

    fclose(file);

    return usernameExists;
}