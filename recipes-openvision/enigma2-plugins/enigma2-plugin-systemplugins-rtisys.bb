DESCRIPTION = "Azbox RTi-SYS plugin"
DEPENDS = "python-native"
require conf/license/openvision-gplv2.inc

inherit gitpkgv pkgconfig

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

SRC_URI = "git://github.com/OpenAZBox/RTi-SYS.git;protocol=git"

S = "${WORKDIR}/git"

do_compile() {
	python -O -m compileall ${S}
}

python populate_packages_prepend () {
    enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/[a-zA-Z0-9_]+.*$', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.py$', 'enigma2-plugin-%s-src', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/(.*/)?\.debug/.*$', 'enigma2-plugin-%s-dbg', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.la$', 'enigma2-plugin-%s-dev', '%s (development)', recursive=True, match_path=True, prepend=True)
    do_split_packages(d, enigma2_plugindir, '^(\w+/\w+)/.*\.a$', 'enigma2-plugin-%s-staticdev', '%s (static development)', recursive=True, match_path=True, prepend=True)
}

do_install() {
	install -d  ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/RtiSYS
	
	install -m 0644 ${S}/*.pyo ${D}${libdir}/enigma2/python/Plugins/SystemPlugins/RtiSYS
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/SystemPlugins/RtiSYS"

PACKAGES = "enigma2-plugin-systemplugins-rtisys"

PROVIDES="${PACKAGES}"
