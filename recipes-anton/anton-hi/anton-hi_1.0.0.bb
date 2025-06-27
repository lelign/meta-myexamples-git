# 
# Package summary
SUMMARY = "Hello World"
# License, for example MIT
LICENSE = "MIT"
# License checksum file is always required
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# anton-hi.c from local file
SRC_URI = "file://anton-hi.cpp"

# Set LDFLAGS options provided by the build system
TARGET_CC_ARCH += "${LDFLAGS}"

# Change source directory to workdirectory where anton-hi.cpp is
#S = "${WORKDIR}"
S = "${WORKDIR}/sources"
UNPACKDIR = "${S}"

# Compile anton-hi from sources, no Makefile
do_compile() {
    ${CXX} -Wall anton-hi.cpp -o anton-hi
}

# Install binary to final directory /usr/bin
do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/anton-hi ${D}${bindir}
}

python do_display_banner() {
    bb.plain("***********************************************************");
    bb.plain("*        hello from anton-hi                              *");
    bb.plain("***********************************************************");
}

addtask display_banner before do_build