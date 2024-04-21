#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool checkUsernameExists(const char *username) {
    FILE *file = fopen("C:\\Users\\petmk\\Desktop\\Library-Management\\data\\Users.txt", "r");
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

bool checkEmailExists(const char *email) {
    FILE *file = fopen("C:\\Users\\petmk\\Desktop\\Library-Management\\data\\Users.txt", "r");
    if (file == NULL) {
        printf("Error opening file.\n");
        return false;
    }

    char line[256];
    bool emailExists = false;

    while (fgets(line, sizeof(line), file)) {
        if (strstr(line, "Email:") == line) {
            char extractedEmail[256];
            sscanf(line, "Email: %[^\n]", extractedEmail);
            char *trimmedEmail = strtok(extractedEmail, " \t\n\r");
            if (strcmp(trimmedEmail, email) == 0) {
                emailExists = true;
                break;
            }
        }
    }
    fclose(file);
    return emailExists;
}

bool checkPhoneNumberExists(const char *phoneNumber) {
    FILE *file = fopen("C:\\Users\\petmk\\Desktop\\Library-Management\\data\\Users.txt", "r");
    if (file == NULL) {
        printf("Error opening file.\n");
        return false;
    }
    char line[256];
    bool phoneNumberExists = false;
    while (fgets(line, sizeof(line), file)) {
        if (strstr(line, "Phone Number:") == line) {
            char extractedPhoneNumber[256];
            sscanf(line, "Phone Number: %[^\n]", extractedPhoneNumber);
            char *trimmedPhoneNumber = strtok(extractedPhoneNumber, " \t\n\r");
            if (strcmp(trimmedPhoneNumber, phoneNumber) == 0) {
                phoneNumberExists = true;
                break;
            }
        }
    }
    fclose(file);

    return phoneNumberExists;
}

int main() {
    const char *usernameToCheck = "kernel";
    if (checkUsernameExists(usernameToCheck)) {
        printf("Username %s exists.\n", usernameToCheck);
    } else {
        printf("Username %s does not exist.\n", usernameToCheck);
    }

    const char *emailToCheck = "kernel@gmail.com";
    if (checkEmailExists(emailToCheck)) {
        printf("Email %s exists.\n", emailToCheck);
    } else {
        printf("Email %s does not exist.\n", emailToCheck);
    }

    const char *phoneNumberToCheck = "65456435";
    if (checkPhoneNumberExists(phoneNumberToCheck)) {
        printf("Phone number %s exists.\n", phoneNumberToCheck);
    } else {
        printf("Phone number %s does not exist.\n", phoneNumberToCheck);
    }

    return 0;
}
