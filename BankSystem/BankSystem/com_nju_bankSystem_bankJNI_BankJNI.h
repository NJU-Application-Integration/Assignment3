/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_nju_bankSystem_bankJNI_BankJNI */

#ifndef _Included_com_nju_bankSystem_bankJNI_BankJNI
#define _Included_com_nju_bankSystem_bankJNI_BankJNI
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_nju_bankSystem_bankJNI_BankJNI
 * Method:    transfer
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;D)Z
 */
JNIEXPORT jboolean JNICALL Java_com_nju_bankSystem_bankJNI_BankJNI_transfer
  (JNIEnv *, jclass, jstring, jstring, jstring, jdouble);

/*
 * Class:     com_nju_bankSystem_bankJNI_BankJNI
 * Method:    listHistory
 * Signature: (Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
 */
JNIEXPORT jobject JNICALL Java_com_nju_bankSystem_bankJNI_BankJNI_listHistory
  (JNIEnv *, jclass, jstring, jstring);

#ifdef __cplusplus
}
#endif
#endif