# environment variable CLASS_PATH should contain path to javaws.jar and servlet.jar
# environment variable FILE_SEPARATOR variable for file separator (; on win32 and : on unix)
# environment variable TMPDIR should point to tmp directory 
# environment variable SDK_HOME should point to SDK directory
JAVAC		= $(SDK_HOME)/bin/javac
JAR		= $(SDK_HOME)/bin/jar
CLASSDESTDIR	= classes
MKDIR		= mkdir -p
RMDIR		= rm -rf
SRCDIR		= src/classes
COPY		= cp -fr
OUTPUT_DIR	= lib
CD		= cd
ECHO		= echo



FILES_servlet_java = \
	jnlp/sample/servlet/JnlpDownloadServlet.java \
        jnlp/sample/servlet/JnlpFileHandler.java \
        jnlp/sample/servlet/DownloadRequest.java \
        jnlp/sample/servlet/DownloadResponse.java \
        jnlp/sample/servlet/ErrorResponseException.java \
        jnlp/sample/servlet/JnlpResource.java \
        jnlp/sample/servlet/ResourceCatalog.java \
        jnlp/sample/servlet/JarDiffHandler.java \
        jnlp/sample/servlet/XMLParsing.java \
        jnlp/sample/servlet/XMLNode.java \
        jnlp/sample/servlet/XMLAttribute.java \
        jnlp/sample/servlet/Logger.java \
        jnlp/sample/util/VersionID.java \
        jnlp/sample/util/VersionString.java

FILES_servlet_class = $(FILES_servlet_java:%.java=$(CLASSDESTDIR)/%.class)

FILES_jardiff_java = \
        jnlp/sample/jardiff/JarDiff.java \
        jnlp/sample/jardiff/JarDiffConstants.java \
	jnlp/sample/jardiff/Patcher.java \
	jnlp/sample/jardiff/JarDiffPatcher.java

FILES_jardiff_class = $(FILES_jardiff_java:%.java=$(CLASSDESTDIR)/%.class)

$(CLASSDESTDIR)/%.class: $(SRCDIR)/%.java	
	$(JAVAC) -classpath "$(CLASS_PATH)$(FILE_SEPARATOR)$(SRCDIR)" -d $(CLASSDESTDIR) $?

all: prepare compile-jardiff jardiff-resource jardiff-jar compile-servlet servlet-resource servlet-jar

clean:
	$(RMDIR) $(CLASSDESTDIR)
	$(RMDIR) $(OUTPUT_DIR)	

prepare: clean
	$(MKDIR) $(CLASSDESTDIR)
	$(MKDIR) $(OUTPUT_DIR)

compile-jardiff: $(FILES_jardiff_class)

compile-servlet: $(FILES_servlet_class)

jardiff-resource:
	$(MKDIR) $(CLASSDESTDIR)/jnlp/sample/jardiff/resources/
	$(COPY) $(SRCDIR)/jnlp/sample/jardiff/resources/strings.properties $(CLASSDESTDIR)/jnlp/sample/jardiff/resources/strings.properties

servlet-resource:
	$(MKDIR) $(CLASSDESTDIR)/jnlp/sample/servlet/resources/
	$(COPY) $(SRCDIR)/jnlp/sample/servlet/resources/strings.properties $(CLASSDESTDIR)/jnlp/sample/servlet/resources/strings.properties

jardiff-jar:
	$(ECHO) 'Main-Class:' jnlp.sample.jardiff.JarDiff > $(TMPDIR)/jardiff.manifest
	$(JAR) cvfm $(OUTPUT_DIR)/jardiff.jar $(TMPDIR)/jardiff.manifest -C $(CLASSDESTDIR) .
	$(RM) $(TMPDIR)/jardiff.manifest

servlet-jar:
	$(JAR) cvf $(OUTPUT_DIR)/jnlp-servlet.jar -C $(CLASSDESTDIR) .
