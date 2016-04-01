#
# Copyright (c) 2006, 2010, Oracle and/or its affiliates. All rights reserved.
# 
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
# 
# -Redistribution of source code must retain the above copyright notice, this
#  list of conditions and the following disclaimer.
# 
# -Redistribution in binary form must reproduce the above copyright notice, 
#  this list of conditions and the following disclaimer in the documentation
#  and/or other materials provided with the distribution.
# 
# Neither the name of Oracle nor the names of contributors may 
# be used to endorse or promote products derived from this software without 
# specific prior written permission.
# 
# This software is provided "AS IS," without a warranty of any kind. ALL 
# EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
# ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
# OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. ORACLE 
# AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
# AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
# DERIVATIVES. IN NO EVENT WILL ORACLE OR ITS LICENSORS BE LIABLE FOR ANY LOST 
# REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, 
# INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY 
# OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE, 
# EVEN IF ORACLE HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
# 
# You acknowledge that this software is not designed, licensed or intended
# for use in the design, construction, operation or maintenance of any
# nuclear facility.
#

## NOT TO BE CHANGED

JAVA=$(SDK_HOME)/bin/java
JAVAC=$(SDK_HOME)/bin/javac
JDB=$(SDK_HOME)/bin/jdb
JAR=$(SDK_HOME)/bin/jar

OUTPUT_DIR=lib

JNDI_PROPS=-Djava.naming.factory.initial=com.sun.jndi.cosnaming.CNCtxFactory -Djava.naming.provider.url=iiop://${ORB_INITIAL_HOST}:${ORB_INITIAL_PORT} 

ORB_INITIAL_PORT=10000
ORB_ACTIVATION_PORT=9999
ORB_INITIAL_HOST=capoon.sfbay.sun.com

MKDIR		= mkdir -p
RMDIR		= rm -rf
CLASSDESTDIR	= classes
SRC_STUBS_DIR	= src/stubs
SRC_CORE_DIR	= src/core
FILES_stubs_java = \
	HelloImpl.java \
	HelloInterface.java

FILES_stubs_class = $(FILES_stubs_java:%.java=$(CLASSDESTDIR)/%.class)

FILES_core_java = \
	HelloClient.java \
	HelloServer.java

FILES_core_class = $(FILES_core_java:%.java=$(CLASSDESTDIR)/%.class)


$(CLASSDESTDIR)/%.class: $(SRC_STUBS_DIR)/%.java	
	$(JAVAC) -classpath "$(SRC_STUBS_DIR)" -d $(CLASSDESTDIR) $?

$(CLASSDESTDIR)/%.class: $(SRC_CORE_DIR)/%.java	
	$(JAVAC) -classpath "$(SRC_CORE_DIR)$(FILE_SEPARATOR)$(CLASSDESTDIR)" -d $(CLASSDESTDIR) $?

ORBD=${SDK_HOME}/bin/orbd -ORBInitialPort ${ORB_INITIAL_PORT} -port ${ORB_ACTIVATION_PORT} -serverPollingTime 200 -serverStartupDelay 1000


ORB_PROPS=-Dorg.omg.CORBA.ORBInitialHost=${ORB_INITIAL_HOST} -Dorg.omg.CORBA.ORBInitialPort=${ORB_INITIAL_PORT}

JAVAFLAGS=$(ORB_PROPS) -classpath $(CLASSDESTDIR) 

all : clean build

compile-stubs: $(FILES_stubs_class)

stubs: 	compile-stubs
	$(SDK_HOME)/bin/rmic -classpath "$(CLASSDESTDIR)" -d "$(CLASSDESTDIR)" -iiop -keepgenerated HelloImpl

build: prepare stubs compile-core client-jar

client-jar:
	$(JAR) cvf $(OUTPUT_DIR)/HelloWorld.jar -C $(CLASSDESTDIR) .

compile-core: $(FILES_core_class)

prepare: clean
	$(MKDIR) $(OUTPUT_DIR)
	$(MKDIR) $(CLASSDESTDIR)

clean:
	$(RMDIR) $(OUTPUT_DIR)
	$(RMDIR) $(CLASSDESTDIR)
#
# Targets to run the client.
#
runclient:
	$(JAVA) $(JNDI_PROPS) $(JAVAFLAGS) HelloClient 

runserver:
	$(JAVA) $(JAVAFLAGS) $(JNDI_PROPS) HelloServer

runorbd:
	$(ORBD)	


