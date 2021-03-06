## 第一个JNI程序

### 步骤

#### 1、java类中编写native方法

```java
public class HelloWorldJNI {
    static {
        System.loadLibrary("HelloWorld");
    }

    public HelloWorldJNI() {
    }

    public native void sayHello();
}

```
#### 2、生成对应的头文件

①{项目根目录}/src 下运行 `javac com/wangchuncheng/HelloWorldJNI.java`

②{项目根目录}/src 下运行`javah com.wangchuncheng.HelloWorldJNI`

头文件：com_wangchuncheng_HelloWorldJNI.h
```c
/* DO NOT EDIT THIS FILE - it is machine generated */
#include "jni.h"
/* Header for class com_wangchuncheng_HelloWorldJNI */

#ifndef _Included_com_wangchuncheng_HelloWorldJNI
#define _Included_com_wangchuncheng_HelloWorldJNI
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_wangchuncheng_HelloWorldJNI
 * Method:    sayHello
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_wangchuncheng_HelloWorldJNI_sayHello
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif

```

#### 3、编写对应的C方法

实现头文件中的方法
```c
#include "com_wangchuncheng_HelloWorldJNI.h"
#include <stdio.h>
JNIEXPORT void JNICALL  Java_com_wangchuncheng_HelloWorldJNI_sayHello(JNIEnv * env, jobject obj){
    printf("Hello World");
}
```
#### 4、生成对应的动态链接库文件

note:编译时需要将{JAVA_HOME}/include/jni.h 和 {JAVA_HOME}/include/win32/jni_md.h移动到这个这个目录下。或者使用–I {头文件路径}参数。

```shell
 gcc HelloWorld.c -shared -o HelloWorld.dll 
```
#### 5、运行

```shell
# java -Djava.library.path={dll文件的路径}  主类
java -Djava.library.path=./lib src/com.wangchuncheng.Main 
```