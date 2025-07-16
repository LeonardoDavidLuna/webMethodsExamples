#                   Generated C-Service Makefile
#
#  cService.mak:  DO NOT USE THIS FILE DIRECTLY.
#		This file has been generated for cService; please 
#		create and/or augment C.mak with the contents
#  		of this file. 
#
#  cService.c:  DO NOT EXTEND THIS FILE.
#		Copy this file to cServiceImpl.c and customize in
#		order to prevent overwriting by subsequent code gens.
#
#  C.mak:  CONSTRUCT AND MAKE THIS FILE.
#		Use this file to make the shared library for your interface
#		which will be loaded by the B2B server.
#
#  Environment Settings:  make sure you set JDKDIR and SERVDIR for 
#               your deployment.                         
#



#  Set these:
JDKDIR = C:\java\jdk1.1.7
SERVDIR = C:\SoftwareAG\WM10.5\IntegrationServer\instances\IS_DEV
#  Copy SRC value to C.mak:
SRC = cServiceImpl.c

PKGDIR = $(SERVDIR)\packages\EXAMPLES
LIBSDIR = $(PKGDIR)\code\libs

all: install

install:  C.dll
	if exist $(LIBSDIR)\EXAMPLES_C.dlx \
		del $(LIBSDIR)\EXAMPLES_C.dlx
	if exist $(LIBSDIR)\EXAMPLES_C.dll \
		rename $(LIBSDIR)\EXAMPLES_C.dll EXAMPLES_C.dlx
	copy C.dll $(LIBSDIR)\EXAMPLES_C.dll

C.dll: $(SRC)
	cl -DWIN32 -I$(JDKDIR)\include -I$(JDKDIR)\include\win32 \
		-I$(SERVDIR)\lib -I$(LIBSDIR) -LD $(SRC) \
		$(SERVDIR)\lib\wmJNI.lib -MT -FeC.dll

clean:
	del *.obj
	del *.exp
	del *.lib
	del C.dll


