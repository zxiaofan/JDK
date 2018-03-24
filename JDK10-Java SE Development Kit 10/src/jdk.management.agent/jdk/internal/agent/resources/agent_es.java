package jdk.internal.agent.resources;

import java.util.ListResourceBundle;

public final class agent_es extends ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "agent.err.access.file.not.readable", "No se puede leer el archivo de acceso" },
            { "agent.err.access.file.notfound", "Archivo de acceso no encontrado" },
            { "agent.err.access.file.notset", "El archivo de acceso no se ha especificado, pero com.sun.management.jmxremote.authenticate=true" },
            { "agent.err.access.file.read.failed", "Fallo al leer el archivo de acceso" },
            { "agent.err.agentclass.access.denied", "Acceso denegado a premain(String)" },
            { "agent.err.agentclass.failed", "Fallo de clase de agente de gesti\u00F3n " },
            { "agent.err.agentclass.notfound", "Clase de agente de gesti\u00F3n no encontrada" },
            { "agent.err.configfile.access.denied", "Acceso denegado al archivo de configuraci\u00F3n" },
            { "agent.err.configfile.closed.failed", "Fallo al cerrar el archivo de configuraci\u00F3n" },
            { "agent.err.configfile.failed", "Fallo al leer el archivo de configuraci\u00F3n" },
            { "agent.err.configfile.notfound", "No se ha encontrado el archivo de configuraci\u00F3n" },
            { "agent.err.connector.server.io.error", "Error de comunicaci\u00F3n con el servidor de conector JMX" },
            { "agent.err.error", "Error" },
            { "agent.err.exception", "Excepci\u00F3n devuelta por el agente " },
            { "agent.err.exportaddress.failed", "Fallo al exportar la direcci\u00F3n del conector JMX al buffer de instrumentaci\u00F3n" },
            { "agent.err.file.access.not.restricted", "El acceso de lectura al archivo debe ser restringido" },
            { "agent.err.file.not.found", "Archivo no encontrado" },
            { "agent.err.file.not.readable", "Archivo ilegible" },
            { "agent.err.file.not.set", "Archivo no especificado" },
            { "agent.err.file.read.failed", "Fallo al leer el archivo" },
            { "agent.err.invalid.agentclass", "Valor de propiedad com.sun.management.agent.class no v\u00E1lido" },
            { "agent.err.invalid.jmxremote.port", "N\u00FAmero com.sun.management.jmxremote.port no v\u00E1lido" },
            { "agent.err.invalid.jmxremote.rmi.port", "N\u00FAmero com.sun.management.jmxremote.rmi.port no v\u00E1lido" },
            { "agent.err.invalid.option", "Opci\u00F3n especificada no v\u00E1lida" },
            { "agent.err.invalid.state", "Estado de agente no v\u00E1lido: {0}" },
            { "agent.err.password.file.access.notrestricted", "Se debe restringir el acceso de lectura al archivo de contrase\u00F1as" },
            { "agent.err.password.file.not.readable", "No se puede leer el archivo de contrase\u00F1as" },
            { "agent.err.password.file.notfound", "Archivo de contrase\u00F1as no encontrado" },
            { "agent.err.password.file.notset", "El archivo de contrase\u00F1as no se ha especificado, pero com.sun.management.jmxremote.authenticate=true" },
            { "agent.err.password.file.read.failed", "Fallo al leer el archivo de contrase\u00F1as" },
            { "agent.err.premain.notfound", "premain(String) no existe en la clase del agente" },
            { "agent.err.warning", "Advertencia" },
            { "jmxremote.ConnectorBootstrap.file.readonly", "El acceso de lectura al archivo debe ser restringido: {0}" },
            { "jmxremote.ConnectorBootstrap.noAuthentication", "Sin autenticaci\u00F3n" },
            { "jmxremote.ConnectorBootstrap.password.readonly", "Se debe restringir el acceso de lectura al archivo de contrase\u00F1as: {0}" },
            { "jmxremote.ConnectorBootstrap.ready", "Conector JMX listo en: {0}" },
            { "jmxremote.ConnectorBootstrap.starting", "Iniciando servidor de conector JMX:" },
        };
    }
}
