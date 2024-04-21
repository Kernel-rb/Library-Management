#include <stdbool.h>
#include <stdio.h>
#include <string.h>


JNIEXPORT jboolean JNICALL Java_UserCheckerJNI_checkUsernameExists(JNIEnv *env, jobject obj, jstring username) {
    const char *usernameStr = (*env)->GetStringUTFChars(env, username, NULL);
    if (usernameStr == NULL) {
        return JNI_FALSE;
    }

    bool exists = (strcmp(usernameStr, "kernel") == 0);

    (*env)->ReleaseStringUTFChars(env, username, usernameStr);

    return (exists ? JNI_TRUE : JNI_FALSE);
}
