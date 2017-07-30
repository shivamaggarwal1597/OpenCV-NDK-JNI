#include<com_example_shivam_opencvtest_NativeClass.h>

JNIEXPORT jstring JNICALL Java_com_example_shivam_opencvtest_NativeClass_getMessageFromJNI
  (JNIEnv *evn, jclass obj){
  return env->NewStringUTF("This is a message from JNI");

  }


