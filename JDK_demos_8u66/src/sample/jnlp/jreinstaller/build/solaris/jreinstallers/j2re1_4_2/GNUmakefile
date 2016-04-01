#
# J2RE 1.4.2 Installers for Solaris/SPARC
#

# Include platform-specific definitions
include ../../share/Platform.gmk
include ../minclude/solaris.defs

BINDIR=bin

# Include platform-neutral build instructions
include ../../share/jreinstallers/installer.gmk

# Source files for the J2RE 1.4.2
J2RE_BIN  = /java/re/jdk/1.4.2/archive/fcs/bundles/solaris-sparc/j2re-1_4_2-solaris-sparc.sh
J2RE_LICENSE = /java/re/jdk/1.4.2/archive/fcs/binaries/solaris-sparc/LICENSE
J2RE_JNLP  = javaws-1_0_1-j2re-1_4_2-solaris-sparc.jnlp
VERSION_FILE = version.xml_solaris-sparc_1.4.2

# Target files for the J2RE 1.4.2
J2RE_INST_JAR=javaws-1_0_1-j2re-1_4_2-inst-solaris-sparc.jar
J2RE_DATA_JAR=javaws-1_0_1-j2re-1_4_2-data-solaris-sparc.jar
J2RE_BUNDLE=javaws-1_0_1-j2re-1_4_2-solaris-sparc.war

ifeq ($(ARCH),i386)
  J2RE_BIN = /java/re/jdk/1.4.2/archive/fcs/bundles/solaris-i586/j2re-1_4_2-rc-solaris-i586.sh
  J2RE_LICENSE = /java/re/jdk/1.4.2/archive/fcs/binaries/solaris-i586/LICENSE 
  J2RE_JNLP  = javaws-1_0_1-j2re-1_4_2-solaris-i586.jnlp
  VERSION_FILE = version.xml_solaris-i586_1.4.2

  # Target files for the J2RE 1.4.2
  J2RE_INST_JAR=javaws-1_0_1-j2re-1_4_2-inst-solaris-i586.jar
  J2RE_DATA_JAR=javaws-1_0_1-j2re-1_4_2-data-solaris-i586.jar
  J2RE_BUNDLE=javaws-1_0_1-j2re-1_4_2-solaris-i586.war
endif

include ../../share/jreinstallers/components.gmk
include ../../share/jreinstallers/bundle.unix.gmk

