#
# @(#)GNUmakefile	1.20 03/09/11
#
# J2RE Installers for Windows
#

# Include platform-specific definitions
include ../../share/Platform.gmk
include ../minclude/windows.defs

FILES = j2re1_4_2/GNUmakefile

all::
	for i in $(FILES) ; do \
	    echo ">>>Recursively making "$$i" "$@"..."; \
	    $(MAKE) -f $$i bundle || exit 1; \
	    echo "<<<Finished Recursively making "$$i" "$@"." ; \
	done

clean::
	for i in $(FILES) ; do \
	    echo ">>>Recursively making "$$i" "$@"..."; \
	    $(MAKE) -f $$i clean || exit 1; \
	    echo "<<<Finished Recursively making "$$i" "$@"." ; \
	done




