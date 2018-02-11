package jdk.internal.agent.resources;

import java.util.ListResourceBundle;

public final class agent_pt_BR extends ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "agent.err.access.file.not.readable", "Arquivo de acesso ileg\u00EDvel" },
            { "agent.err.access.file.notfound", "Arquivo de acesso n\u00E3o encontrado" },
            { "agent.err.access.file.notset", "O arquivo de acesso n\u00E3o est\u00E1 especificado, mas com.sun.management.jmxremote.authenticate=true" },
            { "agent.err.access.file.read.failed", "Falha ao ler o arquivo de acesso" },
            { "agent.err.agentclass.access.denied", "Acesso negado a premain(String)" },
            { "agent.err.agentclass.failed", "Falha na classe do agente de gerenciamento " },
            { "agent.err.agentclass.notfound", "Classe do agente de gerenciamento n\u00E3o encontrada" },
            { "agent.err.configfile.access.denied", "Acesso negado ao arquivo de configura\u00E7\u00E3o" },
            { "agent.err.configfile.closed.failed", "Falha ao fechar o arquivo de configura\u00E7\u00E3o" },
            { "agent.err.configfile.failed", "Falha ao ler o arquivo de configura\u00E7\u00E3o" },
            { "agent.err.configfile.notfound", "Arquivo de configura\u00E7\u00E3o n\u00E3o encontrado" },
            { "agent.err.connector.server.io.error", "Erro de comunica\u00E7\u00E3o do servidor do conector JMX" },
            { "agent.err.error", "Erro" },
            { "agent.err.exception", "Exce\u00E7\u00E3o gerada pelo agente " },
            { "agent.err.exportaddress.failed", "Falha na exporta\u00E7\u00E3o do endere\u00E7o do conector JMX para o buffer de instrumenta\u00E7\u00E3o" },
            { "agent.err.file.access.not.restricted", "O acesso de leitura do arquivo deve ser limitado" },
            { "agent.err.file.not.found", "Arquivo n\u00E3o encontrado" },
            { "agent.err.file.not.readable", "Arquivo ileg\u00EDvel" },
            { "agent.err.file.not.set", "Arquivo n\u00E3o especificado" },
            { "agent.err.file.read.failed", "Falha ao ler o arquivo" },
            { "agent.err.invalid.agentclass", "Valor inv\u00E1lido da propriedade com.sun.management.agent.class" },
            { "agent.err.invalid.jmxremote.port", "N\u00FAmero inv\u00E1lido de com.sun.management.jmxremote.port" },
            { "agent.err.invalid.jmxremote.rmi.port", "N\u00FAmero inv\u00E1lido do com.sun.management.jmxremote.rmi.port" },
            { "agent.err.invalid.option", "Op\u00E7\u00E3o especificada inv\u00E1lida" },
            { "agent.err.invalid.state", "Estado inv\u00E1lido do agente: {0}" },
            { "agent.err.password.file.access.notrestricted", "O acesso de leitura do arquivo de senha deve ser limitado" },
            { "agent.err.password.file.not.readable", "Arquivo de senha ileg\u00EDvel" },
            { "agent.err.password.file.notfound", "Arquivo de senha n\u00E3o encontrado" },
            { "agent.err.password.file.notset", "O arquivo de senha n\u00E3o est\u00E1 especificado, mas com.sun.management.jmxremote.authenticate=true" },
            { "agent.err.password.file.read.failed", "Falha ao ler o arquivo de senha" },
            { "agent.err.premain.notfound", "premain(String) n\u00E3o existe na classe do agente" },
            { "agent.err.warning", "Advert\u00EAncia" },
            { "jmxremote.ConnectorBootstrap.file.readonly", "O acesso de leitura do arquivo deve ser limitado: {0}" },
            { "jmxremote.ConnectorBootstrap.noAuthentication", "Sem autentica\u00E7\u00E3o" },
            { "jmxremote.ConnectorBootstrap.password.readonly", "O acesso de leitura do arquivo de senha deve ser limitado: {0}" },
            { "jmxremote.ConnectorBootstrap.ready", "Conector JMX pronto em: {0}" },
            { "jmxremote.ConnectorBootstrap.starting", "Iniciando o Servidor do Conector JMX:" },
        };
    }
}
