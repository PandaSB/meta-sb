FILESEXTRAPATHS:append := "${THISDIR}/files"

SRC_URI += "file://99-usb-serial.rules"
do_install:prepend () {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/*/rules ${D}${sysconfdir}/udev/rules.d
} 

PACKAGE_ARCH = "${MACHINE_ARCH}"
