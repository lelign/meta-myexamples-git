SUMMARY = "summary ign this is a test QT program"
DESCRIPTION = "description ign this is a test QT program"
SECTION = "examples" 
LICENSE = "CLOSED"

DEPENDS += " qtbase wayland "

SRC_URI = "file://added-myQTApp.cpp \
	   file://added-myQTApp.pro \
           "
 
# S = "${WORKDIR}"
# S set to be WORKDIR no longer supported
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

# ERROR: mycapp-0.1-r0 do_package_qa: QA Issue: 
# File /usr/bin/myCApp in package mycapp doesn't have GNU_HASH 
# (didn't pass LDFLAGS?) [ldflags]
TARGET_CC_ARCH += "${LDFLAGS}"

#do_compile () {
#	${CC} myCApp.c -o myCApp
#}

# ${D} << root /
# ${bindir} << usr/bin

do_install:append () {
	install -d ${D}${bindir}
	install -m 0775 added-myQTApp ${D}${bindir}/
}

FILES_${PN} +="${bindir}/qadded-myQTApp"

inherit qmake5

python do_display_banner() {
    bb.plain("*******************************************************");
    bb.plain("*          hello from qmyqtapp                         *");
    bb.plain("*******************************************************");
}

addtask display_banner before do_build
