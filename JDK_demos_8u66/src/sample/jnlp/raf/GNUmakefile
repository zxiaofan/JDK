# environment variable CLASS_PATH should contain path to javaws.jar
# environment variable SDK_HOME should point to SDK directory
JAVAC		= $(SDK_HOME)/bin/javac
JAR		= $(SDK_HOME)/bin/jar
CLASSDESTDIR	= classes
MKDIR		= mkdir -p
RMDIR		= rm -rf
SRCDIR		= src
COPY		= cp -fr
OUTPUT_DIR	= lib
CD		= cd
ECHO		= echo



FILES_raf_java = \
        randomFile.java

FILES_raf_class = $(FILES_raf_java:%.java=$(CLASSDESTDIR)/%.class)

$(CLASSDESTDIR)/%.class: $(SRCDIR)/%.java	
	$(JAVAC) -classpath "$(CLASS_PATH)" -d $(CLASSDESTDIR) $?

all: prepare compile-raf raf-jar

clean:
	$(RMDIR) $(CLASSDESTDIR)
	$(RMDIR) $(OUTPUT_DIR)	

prepare: clean
	$(MKDIR) $(CLASSDESTDIR)
	$(MKDIR) $(OUTPUT_DIR)

compile-raf: $(FILES_raf_class)

raf-jar:
	$(JAR) cvf $(OUTPUT_DIR)/randomFile.jar -C $(CLASSDESTDIR) .
