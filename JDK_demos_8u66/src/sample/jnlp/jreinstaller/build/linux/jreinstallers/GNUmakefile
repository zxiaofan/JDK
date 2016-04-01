#
# @(#)GNUmakefile	1.14 03/09/11
#
# J2RE Installers for Linux
#

# Include platform-specific definitions
include ../../share/Platform.gmk
include ../minclude/linux.defs

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



