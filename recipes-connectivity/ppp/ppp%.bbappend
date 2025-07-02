
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://simcom-connect-chat"
SRC_URI += "file://simcom-disconnect-chat"
SRC_URI += "file://simcom-pppd"


do_install:append () {
	install -d ${D}{$sysconfdir}/ppp/peers
	install -m 0755 ${UNPACKDIR}/simcom-pppd ${D}${sysconfdir}/ppp/peers
	install -m 0755 ${UNPACKDIR}/simcom-connect-chat ${D}${sysconfdir}/ppp/peers
	install -m 0755 ${UNPACKDIR}/simcom-disconnect-chat ${D}${sysconfdir}/ppp/peers
}

FILES:${PN} += "${sysconfdir}/ppp/peers/simcom-pppd"
FILES:${PN} += "${sysconfdir}/ppp/peers/simcom-connect-chat"
FILES:${PN} += "${sysconfdir}/ppp/peers/simcom-disconnect-chat"
