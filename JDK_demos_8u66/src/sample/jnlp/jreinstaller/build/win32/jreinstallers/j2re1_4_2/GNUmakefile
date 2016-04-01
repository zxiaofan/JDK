#
# J2RE 1.4.2 US Installer for Windows
#

# Include platform-specific definitions
include ../../share/Platform.gmk
include ../minclude/windows.defs

BINDIR=bin

# Include platform-neutral build instructions
include ../../share/jreinstallers/installer.gmk

# Source files for the J2RE 1.4.2
J2RE_BIN  = i:/jdk/1.4.2/archive/fcs/bundles/windows-i586/j2re-1_4_2-windows-i586.exe
J2RE_LICENSE =  i:/jdk/1.4.2/archive/fcs/binaries/windows-i586/LICENSE
J2RE_JNLP  = javaws-1_0_1-j2re-1_4_2-windows-i586.jnlp
VERSION_FILE = version.xml_windows-i586_1.4.2

# Target files for the J2RE 1.4.2
J2RE_INST_JAR=javaws-1_0_1-j2re-1_4_2-inst-windows-i586.jar
J2RE_DATA_JAR=javaws-1_0_1-j2re-1_4_2-data-windows-i586.jar
J2RE_NATIVE_JAR=javaws-1_0_1-j2re-1_4_2-native-windows-i586.jar
J2RE_BUNDLE=javaws-1_0_1-j2re-1_4_2-windows-i586.war

include ../../share/jreinstallers/components.gmk
include bundle.win.gmk

