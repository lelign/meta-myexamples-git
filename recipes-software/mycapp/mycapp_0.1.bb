SUMMARY = "summary ign this is a test c program"
DESCRIPTION = "description ign this is a test c program"
SECTION = "examples"
LICENSE = "CLOSED"

SRC_URI = "file://myCApp.c"
 
# S = "${WORKDIR}"
# S set to be WORKDIR no longer supported
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

# ERROR: mycapp-0.1-r0 do_package_qa: QA Issue: 
# File /usr/bin/myCApp in package mycapp doesn't have GNU_HASH 
# (didn't pass LDFLAGS?) [ldflags]
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile () {
	${CC} myCApp.c -o myCApp
}

# ${D} << root /
# ${bindir} << usr/bin

do_install () {
	install -d ${D}${bindir}
	install -m 0755 myCApp ${D}${bindir}/

}

python do_display_banner() {
    bb.plain("******************************************************");
    bb.plain("*          hello from mycapp                         *");
    bb.plain("******************************************************");
}

addtask display_banner before do_package_qa
