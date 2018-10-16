#include "com_wangchuncheng_HelloWorldJNI.h"
 #include <stdio.h>
 JNIEXPORT void JNICALL  Java_com_wangchuncheng_HelloWorldJNI_sayHello(JNIEnv * env, jobject obj){
     printf("Hello World");
 }