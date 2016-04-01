# environment variable CLASS_PATH should contain path to javaws.jar and servlet.jar
# environment variable FILE_SEPARATOR variable for file separator (; on win32 and : on unix)
# environment variable SDK_HOME should point to SDK directory
JAVAC		= $(SDK_HOME)/bin/javac
JAR		= $(SDK_HOME)/bin/jar
CLASSDESTDIR	= classes
CLASSDESTDIR_SERVLET	= $(CLASSDESTDIR)/servlet
CLASSDESTDIR_WEBPAD	= $(CLASSDESTDIR)/webpad
MKDIR		= mkdir -p
RMDIR		= rm -rf
SRC_SERVLET_DIR	= src/servlet
SRC_WEBPAD_DIR	= src/version1
COPY		= cp -fr
OUTPUT_DIR	= lib
CD		= cd
ECHO		= echo

FILES_servlet_java = \
	TxtServlet.java

FILES_servlet_class = $(FILES_servlet_java:%.java=$(CLASSDESTDIR_SERVLET)/%.class)

FILES_webpad_java = \
        WebPad.java \
        AboutAction.java

FILES_webpad_class = $(FILES_webpad_java:%.java=$(CLASSDESTDIR_WEBPAD)/%.class)

$(CLASSDESTDIR_SERVLET)/%.class: $(SRC_SERVLET_DIR)/%.java	
	$(JAVAC) -classpath "$(CLASS_PATH)$(FILE_SEPARATOR)$(SRC_SERVLET_DIR)" -d $(CLASSDESTDIR_SERVLET) $?

$(CLASSDESTDIR_WEBPAD)/%.class: $(SRC_WEBPAD_DIR)/%.java	
	$(JAVAC) -classpath "$(CLASS_PATH)$(FILE_SEPARATOR)$(SRC_WEBPAD_DIR)" -d $(CLASSDESTDIR_WEBPAD) $?

all: prepare compile-servlet servlet-jar compile-webpad webpad-jar 

clean:
	$(RMDIR) $(CLASSDESTDIR_SERVLET)
	$(RMDIR) $(CLASSDESTDIR_WEBPAD)
	$(RMDIR) $(CLASSDESTDIR)
	$(RMDIR) $(OUTPUT_DIR)	

prepare: clean
	$(MKDIR) $(CLASSDESTDIR)
	$(MKDIR) $(CLASSDESTDIR_SERVLET)
	$(MKDIR) $(CLASSDESTDIR_WEBPAD)
	$(MKDIR) $(OUTPUT_DIR)

compile-webpad: $(FILES_webpad_class)

compile-servlet: $(FILES_servlet_class)

webpad-jar:
	$(COPY) README $(CLASSDESTDIR_WEBPAD)/readme.txt
	$(JAR) cvf $(OUTPUT_DIR)/webpad.jar -C $(CLASSDESTDIR_WEBPAD) .

servlet-jar:
	$(JAR) cvf $(OUTPUT_DIR)/txtservlet.jar -C $(CLASSDESTDIR_SERVLET) .
