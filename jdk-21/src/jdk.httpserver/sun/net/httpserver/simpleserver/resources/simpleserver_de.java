package sun.net.httpserver.simpleserver.resources;

import java.util.ListResourceBundle;

public final class simpleserver_de extends ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "err.invalid.arg", "ung\u00FCltiger Wert angegeben f\u00FCr {0}: {1}" },
            { "err.missing.arg", "kein Wert angegeben f\u00FCr {0}" },
            { "err.server.config.failed", "Serverkonfiguration nicht erfolgreich: {0}" },
            { "err.server.handle.failed", "Handling des Serveraustauschs nicht erfolgreich: {0}" },
            { "err.unknown.option", "unbekannte Option: {0}" },
            { "error.prefix", "Fehler:" },
            { "html.dir.list", "Verzeichnisliste f\u00FCr" },
            { "html.not.found", "Datei wurde nicht gefunden" },
            { "loopback.info", "Binding an Loopback als Standard. Verwenden Sie f\u00FCr alle Schnittstellen \"-b 0.0.0.0\" oder \"-b ::\"." },
            { "msg.start.anylocal", "Bedient {0} und Unterverzeichnisse auf 0.0.0.0 (alle Schnittstellen) Port {2}\nURL http://{1}:{2}/" },
            { "msg.start.other", "Bedient {0} und Unterverzeichnisse auf {1} Port {2}\nURL http://{1}:{2}/" },
            { "opt.bindaddress", "-b, --bind-address    - Adresse, an die das Binding erfolgt. Standard: {0} (Loopback).\n                        Verwenden Sie f\u00FCr alle Schnittstellen \"-b 0.0.0.0\" oder \"-b ::\"." },
            { "opt.directory", "-d, --directory       - Zu bedienendes Verzeichnis. Standard: Aktuelles Verzeichnis." },
            { "opt.output", "-o, --output          - Ausgabeformat. none|info|verbose. Standard: info." },
            { "opt.port", "-p, --port            - Port, auf dem gehorcht wird. Standard: 8000." },
            { "options", "Optionen:\n-b, --bind-address    - Adresse, an die das Binding erfolgt. Standard: {0} (Loopback).\n                        Verwenden Sie f\u00FCr alle Schnittstellen \"-b 0.0.0.0\" oder \"-b ::\".\n-d, --directory       - Zu bedienendes Verzeichnis. Standard: Aktuelles Verzeichnis.\n-o, --output          - Ausgabeformat. none|info|verbose. Standard: info.\n-p, --port            - Port, auf dem gehorcht wird. Standard: 8000.\n-h, -?, --help        - Gibt diese Hilfemeldung aus und beendet.\n-version, --version   - Gibt Versionsinformationen aus und beendet.\nDr\u00FCcken Sie zum Stoppen des Servers Strg+C." },
            { "usage.java", "Verwendung: java -m jdk.httpserver [-b bind address] [-p port] [-d directory]\n                              [-o none|info|verbose] [-h zum Anzeigen von Optionen]\n                              [-version zum Anzeigen der Versionsinformationen]" },
            { "usage.jwebserver", "Verwendung: jwebserver [-b bind address] [-p port] [-d directory]\n                  [-o none|info|verbose] [-h zum Anzeigen von Optionen]\n                  [-version zum Anzeigen von Versionsinformationen]" },
            { "version", "{0} {1}" },
        };
    }
}
