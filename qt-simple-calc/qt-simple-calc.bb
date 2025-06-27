SUMMARY = "Qt Simple Calculator Application Recipe"
DESCRIPTION = "This recipe builds a Qt project for a simple calculator application."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "qtbase"

SRC_URI = "git://github.com/vpapadopou/qt-simple-calculator;protocol=https;branch=master"
#SRC_URI = "https://github.com/vpapadopou/qt-simple-calculator;branch=master"
#SRC_URI[sha256sum] = "fd2d327b957e9474de5fcb1297abaa711af0c2ff9aa6af39259dc79f2ef18436"

#https://github.com/vpapadopou/qt-simple-calculator
SRCREV = "1af09d43f9a41ad3136a4fac9db63b9542692f91"

S = "${WORKDIR}/git"

#do_install:append() {
#    install -d ${D}/opt/qt-simple-calc/
#    install -m 0755 simpleCalculator ${D}/opt/qt-simple-calc/
#}


do_install:append() {
    install -d ${D}${bindir}
    install -m 0755 simpleCalculator ${D}/${bindir}
}

#FILES_${PN} += "/opt/qt-simple-calc/simpleCalculator"
FILES_${PN} += "/usr/bin/simpleCalculator"

# Install binary to final directory /usr/bin
#do_install() {
#    install -d ${D}${bindir}
#    install -m 0755 ${S}/hello-ignat ${D}${bindir}
#}



inherit qmake5

#PACKAGECONFIG += "fontconfig"
