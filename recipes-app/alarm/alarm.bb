# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ffcb6baa391a4009ab1fe9cef517353c"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/PandaSB/AlarmPython.git;protocol=https;branch=main"
SRC_URI += "file://0001_pathpython.patch"
SRC_URI += "file://0002_simplepython.patch" 
SRC_URI += "file://0003_telegram.patch"
SRC_URI += "file://config.ini"
SRC_URI += "file://alarm.service"

DEPENDS += "opencv python3 python3-simplejson python3-requests python3-gpiod python3-pyserial python3-python-telegram-bot python3-smbus python3-paho-mqtt python3-luma-oled python3-cbor2"


# Modify these as desired
PV = "1.0+git"
SRCREV = "3d6bda3a56c77150383ff810b977a88d024c76de"

S = "${WORKDIR}/git"


SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "alarm.service"

# NOTE: no Makefile found, unable to determine what needs to be done

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	:
}

do_install () {
	# Specify install commands here
	install -d ${D}/opt/
	install -d ${D}/opt/alarm
	install -d ${D}/opt/alarm/html
	install -m 0755 ${S}/*.py ${D}/opt/alarm
	install -m 0666 ${WORKDIR}/sources-unpack/config.ini ${D}/opt/alarm
        install -m 0755 ${S}/html/*  ${D}/opt/alarm/html
	install -d 0755 ${D}${systemd_system_unitdir}
	install -m 0666 ${WORKDIR}/sources-unpack/alarm.service ${D}${systemd_system_unitdir}
}


FILES:${PN} += " opt/alarm/*.py"
FILES:${PN} += " opt/alarm/config.ini"
FILES:${PN} += " opt/alarm/html/*"
FILES:${PN} += " ${systemd_system_unitdir}/*.service"

#FILES:${PN}-dev += "opt/alarm/*.py"
#FILES:${PN}-dev += "opt/alarm/html/*"

RDEPENDS:${PN} += " python3-core"
RDEPENDS:${PN} += " python3"
RDEPENDS:${PN} += " python3-simplejson"
RDEPENDS:${PN} += " python3-requests"
RDEPENDS:${PN} += " python3-gpiod"
RDEPENDS:${PN} += " python3-pyserial"
RDEPENDS:${PN} += " python3-python-telegram-bot"
RDEPENDS:${PN} += " python3-smbus"
RDEPENDS:${PN} += " python3-paho-mqtt"
RDEPENDS:${PN} += " python3-luma-oled"
RDEPENDS:${PN} += " python3-cbor2"
RDEPENDS:${PN} += " opencv"

