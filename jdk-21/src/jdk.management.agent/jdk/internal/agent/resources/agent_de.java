package jdk.internal.agent.resources;

import java.util.ListResourceBundle;

public final class agent_de extends ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "agent.err.access.file.not.readable", "Zugriffsdatei kann nicht gelesen werden" },
            { "agent.err.access.file.notfound", "Zugriffsdatei nicht gefunden" },
            { "agent.err.access.file.notset", "Es wurde keine Zugriffsdatei angegeben, obwohl com.sun.management.jmxremote.authenticate auf \"true\" gesetzt ist" },
            { "agent.err.access.file.read.failed", "Zugriffsdatei konnte nicht gelesen werden" },
            { "agent.err.agentclass.access.denied", "Zugriff auf premain(String) wurde abgelehnt" },
            { "agent.err.agentclass.failed", "Management Agent-Klasse nicht erfolgreich" },
            { "agent.err.agentclass.notfound", "Management Agent-Klasse nicht gefunden" },
            { "agent.err.configfile.access.denied", "Zugriff auf Konfigurationsdatei wurde abgelehnt" },
            { "agent.err.configfile.closed.failed", "Konfigurationsdatei konnte nicht geschlossen werden" },
            { "agent.err.configfile.failed", "Konfigurationsdatei konnte nicht gelesen werden" },
            { "agent.err.configfile.notfound", "Konfigurationsdatei wurde nicht gefunden" },
            { "agent.err.connector.server.io.error", "Fehler bei JMX-Connector-Serverkommunikation" },
            { "agent.err.error", "Fehler" },
            { "agent.err.exception", "Ausnahme von Agent ausgel\u00F6st " },
            { "agent.err.exportaddress.failed", "Export der JMX-Connector-Adresse in Instrumentierungspuffer nicht erfolgreich" },
            { "agent.err.file.access.not.restricted", "Lesezugriff auf Datei muss eingeschr\u00E4nkt werden" },
            { "agent.err.file.not.found", "Datei wurde nicht gefunden" },
            { "agent.err.file.not.readable", "Datei nicht lesbar" },
            { "agent.err.file.not.set", "Datei nicht angegeben" },
            { "agent.err.file.read.failed", "Datei konnte nicht gelesen werden" },
            { "agent.err.invalid.agentclass", "Ung\u00FCltiger Eigenschaftswert f\u00FCr com.sun.management.agent.class" },
            { "agent.err.invalid.jmxremote.port", "Ung\u00FCltige Nummer f\u00FCr com.sun.management.jmxremote.port" },
            { "agent.err.invalid.jmxremote.rmi.port", "Ung\u00FCltige Nummer f\u00FCr com.sun.management.jmxremote.rmi.port" },
            { "agent.err.invalid.option", "Ung\u00FCltige Option angegeben" },
            { "agent.err.invalid.state", "Ung\u00FCltiger Agent-Zustand: {0}" },
            { "agent.err.password.file.access.notrestricted", "Lesezugriff auf Kennwortdatei muss eingeschr\u00E4nkt werden" },
            { "agent.err.password.file.not.readable", "Kennwortdatei nicht lesbar" },
            { "agent.err.password.file.notfound", "Kennwortdatei nicht gefunden" },
            { "agent.err.password.file.notset", "Es wurde keine Kennwortdatei angegeben, obwohl com.sun.management.jmxremote.authenticate auf \"true\" gesetzt ist" },
            { "agent.err.password.file.read.failed", "Kennwortdatei konnte nicht gelesen werden" },
            { "agent.err.premain.notfound", "premain(String) ist in Agent-Klasse nicht vorhanden" },
            { "agent.err.warning", "Warnung" },
            { "jmxremote.ConnectorBootstrap.file.readonly", "Lesezugriff auf Datei muss eingeschr\u00E4nkt werden: {0}" },
            { "jmxremote.ConnectorBootstrap.noAuthentication", "Keine Authentifizierung" },
            { "jmxremote.ConnectorBootstrap.password.readonly", "Lesezugriff auf Kennwortdatei muss eingeschr\u00E4nkt werden: {0}" },
            { "jmxremote.ConnectorBootstrap.ready", "JMX-Connector bereit unter: {0}" },
            { "jmxremote.ConnectorBootstrap.starting", "JMX-Connector-Server starten:" },
        };
    }
}
