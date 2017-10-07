package jdk.internal.agent.resources;

import java.util.ListResourceBundle;

public final class agent_it extends ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "agent.err.access.file.not.readable", "File di accesso non leggibile" },
            { "agent.err.access.file.notfound", "File di accesso non trovato" },
            { "agent.err.access.file.notset", "Il file di accesso non \u00E8 specificato ma com.sun.management.jmxremote.authenticate=true" },
            { "agent.err.access.file.read.failed", "Errore di lettura file di accesso" },
            { "agent.err.agentclass.access.denied", "Accesso negato a premain(String)" },
            { "agent.err.agentclass.failed", "Errore classe agente gestione " },
            { "agent.err.agentclass.notfound", "Classe agente gestione non trovata" },
            { "agent.err.configfile.access.denied", "Accesso negato al file di configurazione" },
            { "agent.err.configfile.closed.failed", "Errore di chiusura file di configurazione" },
            { "agent.err.configfile.failed", "Errore di lettura file di configurazione" },
            { "agent.err.configfile.notfound", "File di configurazione non trovato" },
            { "agent.err.connector.server.io.error", "Errore di comunicazione server del connettore JMX" },
            { "agent.err.error", "Errore" },
            { "agent.err.exception", "Eccezione dell'agente " },
            { "agent.err.exportaddress.failed", "Errore di esportazione dell'indirizzo connettore JMX nel buffer strumenti" },
            { "agent.err.file.access.not.restricted", "Limitare l'accesso in lettura al file" },
            { "agent.err.file.not.found", "File non trovato" },
            { "agent.err.file.not.readable", "File non leggibile" },
            { "agent.err.file.not.set", "File non specificato" },
            { "agent.err.file.read.failed", "Errore di lettura file" },
            { "agent.err.invalid.agentclass", "Valore propriet\u00E0 com.sun.management.agent.class non valido" },
            { "agent.err.invalid.jmxremote.port", "Numero com.sun.management.jmxremote.port non valido" },
            { "agent.err.invalid.jmxremote.rmi.port", "Numero com.sun.management.jmxremote.rmi.port non valido" },
            { "agent.err.invalid.option", "Specificata opzione non valida" },
            { "agent.err.invalid.state", "Stato agente non valido: {0}" },
            { "agent.err.password.file.access.notrestricted", "Limitare l'accesso in lettura al password file" },
            { "agent.err.password.file.not.readable", "Password file non leggibile" },
            { "agent.err.password.file.notfound", "Password file non trovato" },
            { "agent.err.password.file.notset", "Il password file non \u00E8 specificato ma com.sun.management.jmxremote.authenticate=true" },
            { "agent.err.password.file.read.failed", "Errore di lettura password file" },
            { "agent.err.premain.notfound", "premain(String) non esiste nella classe agente" },
            { "agent.err.warning", "Avvertenza" },
            { "jmxremote.ConnectorBootstrap.file.readonly", "Limitare l''accesso in lettura al file: {0}" },
            { "jmxremote.ConnectorBootstrap.noAuthentication", "Nessuna autenticazione" },
            { "jmxremote.ConnectorBootstrap.password.readonly", "Limitare l''accesso in lettura al password file: {0}" },
            { "jmxremote.ConnectorBootstrap.ready", "Connettore JMX pronto in: {0}" },
            { "jmxremote.ConnectorBootstrap.starting", "Avvio del server connettore JMX:" },
        };
    }
}
