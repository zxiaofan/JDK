package jdk.internal.agent.resources;

import java.util.ListResourceBundle;

public final class agent_fr extends ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "agent.err.access.file.not.readable", "Fichier d'acc\u00E8s illisible" },
            { "agent.err.access.file.notfound", "Fichier d'acc\u00E8s introuvable" },
            { "agent.err.access.file.notset", "Le fichier d'acc\u00E8s n'est pas sp\u00E9cifi\u00E9 mais com.sun.management.jmxremote.authenticate=true" },
            { "agent.err.access.file.read.failed", "Impossible de lire le fichier d'acc\u00E8s" },
            { "agent.err.agentclass.access.denied", "Acc\u00E8s \u00E0 premain(String) refus\u00E9" },
            { "agent.err.agentclass.failed", "Echec de la classe d'agents de gestion " },
            { "agent.err.agentclass.notfound", "Classe d'agents de gestion introuvable" },
            { "agent.err.configfile.access.denied", "Acc\u00E8s refus\u00E9 au fichier de configuration" },
            { "agent.err.configfile.closed.failed", "Impossible de fermer le fichier de configuration" },
            { "agent.err.configfile.failed", "Impossible de lire le fichier de configuration" },
            { "agent.err.configfile.notfound", "Fichier de configuration introuvable" },
            { "agent.err.connector.server.io.error", "Erreur de communication avec le serveur du connecteur JMX" },
            { "agent.err.error", "Erreur" },
            { "agent.err.exception", "Exception envoy\u00E9e par l'agent " },
            { "agent.err.exportaddress.failed", "Impossible d'exporter l'adresse du connecteur JMX dans le tampon d'instrumentation" },
            { "agent.err.file.access.not.restricted", "L'acc\u00E8s en lecture au fichier doit \u00EAtre limit\u00E9" },
            { "agent.err.file.not.found", "Fichier introuvable" },
            { "agent.err.file.not.readable", "Fichier illisible" },
            { "agent.err.file.not.set", "Fichier non sp\u00E9cifi\u00E9" },
            { "agent.err.file.read.failed", "Impossible de lire le fichier" },
            { "agent.err.invalid.agentclass", "Valeur de propri\u00E9t\u00E9 com.sun.management.agent.class incorrecte" },
            { "agent.err.invalid.jmxremote.port", "Num\u00E9ro com.sun.management.jmxremote.port incorrect" },
            { "agent.err.invalid.jmxremote.rmi.port", "Num\u00E9ro com.sun.management.jmxremote.rmi.port non valide" },
            { "agent.err.invalid.option", "Option sp\u00E9cifi\u00E9e non valide" },
            { "agent.err.invalid.state", "Etat de l''agent non valide : {0}" },
            { "agent.err.password.file.access.notrestricted", "L'acc\u00E8s en lecture au fichier de mots de passe doit \u00EAtre limit\u00E9" },
            { "agent.err.password.file.not.readable", "Fichier de mots de passe illisible" },
            { "agent.err.password.file.notfound", "Fichier de mots de passe introuvable" },
            { "agent.err.password.file.notset", "Le fichier de mots de passe n'est pas sp\u00E9cifi\u00E9 mais com.sun.management.jmxremote.authenticate=true" },
            { "agent.err.password.file.read.failed", "Impossible de lire le fichier de mots de passe" },
            { "agent.err.premain.notfound", "premain(String) n'existe pas dans la classe d'agents" },
            { "agent.err.warning", "Avertissement" },
            { "jmxremote.ConnectorBootstrap.file.readonly", "L''acc\u00E8s en lecture au fichier doit \u00EAtre limit\u00E9 : {0}" },
            { "jmxremote.ConnectorBootstrap.noAuthentication", "Pas d'authentification" },
            { "jmxremote.ConnectorBootstrap.password.readonly", "L''acc\u00E8s en lecture au fichier de mots de passe doit \u00EAtre limit\u00E9 : {0}" },
            { "jmxremote.ConnectorBootstrap.ready", "Connecteur JMX pr\u00EAt \u00E0 : {0}" },
            { "jmxremote.ConnectorBootstrap.starting", "D\u00E9marrage du serveur du connecteur JMX :" },
        };
    }
}
