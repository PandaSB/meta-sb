include recipes-core/images/core-image-base.bb

DESCRIPTION = "Small image capable of booting a device with support for the \
Minimal MTD Utilities, which let the user interact with the MTD subsystem in \
the kernel to perform operations on flash devices."

COMPATIBLE_MACHINE = "^rpi$"

INHERIT += "cve-check"


IMAGE_INSTALL:append = " packagegroup-rpi-test"

IMAGE_INSTALL += " mtd-utils"
IMAGE_INSTALL += " kernel-modules"
IMAGE_INSTALL += " net-tools"
IMAGE_INSTALL += " alarm"
IMAGE_INSTALL += " ppp"
IMAGE_INSTALL += " psplash"
IMAGE_INSTALL += " lxc"

IMAGE_FEATURES += " ssh-server-openssh"

