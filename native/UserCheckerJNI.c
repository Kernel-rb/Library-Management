#include "src/src_UserCheckerJNI.h"


#include <stdbool.h>
#include <stdio.h>
#include <string.h>

// Implementation of the native method to check if a username exists
JNIEXPORT jboolean JNICALL Java_UserCheckerJNI_checkUsernameExists(JNIEnv *env, jobject obj, jstring username) {
    // Convert Java string to C string
    const char *usernameStr = (*env)->GetStringUTFChars(env, username, NULL);
    if (usernameStr == NULL) {
        return JNI_FALSE; // Failed to get the username string
    }

    // Your C code to check if the username exists in the database goes here
    // Replace this with your actual logic

    // Example: Assume username exists if it is "kernel"
    bool exists = (strcmp(usernameStr, "kernel") == 0);

    // Release the C string
    (*env)->ReleaseStringUTFChars(env, username, usernameStr);

    // Convert the boolean result to JNI boolean type
    return (exists ? JNI_TRUE : JNI_FALSE);
}

// Implementations of other native methods (checkEmailExists, checkPhoneNumberExists) go here...
