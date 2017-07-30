LOCAL_PATH := $(Call my-dir)
include$(CLEAR_VARS)

LOCAL_SRC_FILES := com_example_shivam_opencvtest_NativeClass.cpp

LOCAL_LDLIBS += -llog
LOCAL_MODULES := MyLibs

include $(BUILD_SHARED_LIBRARY)