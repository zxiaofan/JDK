#
# J2RE 1.4.2 Installers for Linux
#

# Include platform-specific definitions
include ../../share/Platform.gmk
include ../minclude/linux.defs

BINDIR=bin

# Include platform-neutral build instructions
include ../../share/jreinstallers/installer.gmk

# Source files for the J2RE 1.4.2
J2RE_BIN  = /java/re/jdk/1.4.2/archive/fcs/bundles/linux-i586/j2re-1_4_2-linux-i586.bin
J2RE_LICENSE = /java/re/jdk/1.4.2/archive/fcs/binaries/linux-i586/LICENSE
J2RE_JNLP  = javaws-1_0_1-j2re-1_4_2-linux-i586.jnlp
VERSION_FILE = version.xml_linux-i586_1.4.2

# Target files for the J2RE 1.4.2
J2RE_INST_JAR=javaws-1_0_1-j2re-1_4_2-inst-linux-i586.jar
J2RE_DATA_JAR=javaws-1_0_1-j2re-1_4_2-data-linux-i586.jar
J2RE_BUNDLE=javaws-1_0_1-j2re-1_4_2-linux-i586.war

include ../../share/jreinstallers/components.gmk
include ../../share/jreinstallers/bundle.unix.gmk


