#include "com_nju_bankSystem_bankJNI_BankJNI.h"
#include "BankSystem.h"
#include <iostream>

JNIEXPORT jboolean JNICALL Java_com_nju_bankSystem_bankJNI_BankJNI_transfer
	(JNIEnv *env, jclass clazz, jstring account, 
	jstring password, jstring target, jdouble amount) {
		
		using namespace std;

		cout << "jni start" <<endl; 

		const char* account_c = env->GetStringUTFChars(account, NULL);
		const char* password_c = env->GetStringUTFChars(password, NULL);
		const char* target_c = env->GetStringUTFChars(target, NULL);

		bool success = transfer(account_c, password_c, target_c, amount);

		cout << "success" << success <<endl;

		return success;

}

JNIEXPORT jobject JNICALL Java_com_nju_bankSystem_bankJNI_BankJNI_listHistory
	(JNIEnv *env, jclass clazz, jstring account, jstring password) {

	using namespace std;

	cout << "jni start" << endl; 

	const char* account_c = env->GetStringUTFChars(account, NULL);
	const char* password_c = env->GetStringUTFChars(password, NULL);

	list<record> list_c = listHistory(account_c, password_c);

	jclass class_array_list = env->FindClass("java/util/ArrayList");
	jmethodID construct_array_list = env->GetMethodID(class_array_list, "<init>", "()V");
	jobject object_array_list = env->NewObject(class_array_list, construct_array_list, NULL);
	jmethodID add_array_list = env->GetMethodID(class_array_list, "add", "(Ljava/lang/Object;)Z");

	for (list<record>::iterator itr = list_c.begin(); itr != list_c.end(); itr++) {
		const char* source = itr->source.c_str();
		const char* target = itr->target.c_str();
		double amount = itr->amount;
		jclass class_jrecord = env->FindClass("com/nju/bankSystem/info/Record");
		jmethodID construct_jrecord = env->GetMethodID(class_jrecord, "<init>", "(Ljava/lang/String;Ljava/lang/String;D)V");
		jobject object_jrecord = env->NewObject(class_jrecord, construct_jrecord, env->NewStringUTF(source), env->NewStringUTF(target), amount);
		env->CallBooleanMethod(object_array_list, add_array_list, object_jrecord);
		env->DeleteLocalRef(object_jrecord);
	}

	cout << "success" <<endl;

	return object_array_list;

}