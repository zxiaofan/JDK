package jdk.internal.agent.resources;

import java.util.ListResourceBundle;

public final class agent_zh_TW extends ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "agent.err.access.file.not.readable", "\u5B58\u53D6\u6A94\u6848\u7121\u6CD5\u8B80\u53D6" },
            { "agent.err.access.file.notfound", "\u627E\u4E0D\u5230\u5B58\u53D6\u6A94\u6848" },
            { "agent.err.access.file.notset", "\u672A\u6307\u5B9A\u5B58\u53D6\u6A94\u6848\uFF0C\u4F46 com.sun.management.jmxremote.authenticate=true" },
            { "agent.err.access.file.read.failed", "\u7121\u6CD5\u8B80\u53D6\u5B58\u53D6\u6A94\u6848" },
            { "agent.err.agentclass.access.denied", "\u5B58\u53D6 premain(String) \u906D\u5230\u62D2\u7D55" },
            { "agent.err.agentclass.failed", "\u7BA1\u7406\u4EE3\u7406\u7A0B\u5F0F\u985E\u5225\u5931\u6557 " },
            { "agent.err.agentclass.notfound", "\u627E\u4E0D\u5230\u7BA1\u7406\u4EE3\u7406\u7A0B\u5F0F\u985E\u5225" },
            { "agent.err.configfile.access.denied", "\u5B58\u53D6\u8A2D\u5B9A\u6A94\u6848\u906D\u5230\u62D2\u7D55" },
            { "agent.err.configfile.closed.failed", "\u7121\u6CD5\u95DC\u9589\u8A2D\u5B9A\u6A94\u6848" },
            { "agent.err.configfile.failed", "\u7121\u6CD5\u8B80\u53D6\u8A2D\u5B9A\u6A94\u6848" },
            { "agent.err.configfile.notfound", "\u627E\u4E0D\u5230\u8A2D\u5B9A\u6A94\u6848" },
            { "agent.err.connector.server.io.error", "JMX \u9023\u63A5\u5668\u4F3A\u670D\u5668\u901A\u8A0A\u932F\u8AA4" },
            { "agent.err.error", "\u932F\u8AA4" },
            { "agent.err.exception", "\u4EE3\u7406\u7A0B\u5F0F\u767C\u751F\u7570\u5E38 " },
            { "agent.err.exportaddress.failed", "\u5C07 JMX \u9023\u63A5\u5668\u4F4D\u5740\u532F\u51FA\u81F3\u8A2D\u5099\u7DE9\u885D\u5340\u5931\u6557" },
            { "agent.err.file.access.not.restricted", "\u5FC5\u9808\u9650\u5236\u6A94\u6848\u8B80\u53D6\u5B58\u53D6\u6B0A" },
            { "agent.err.file.not.found", "\u627E\u4E0D\u5230\u6A94\u6848" },
            { "agent.err.file.not.readable", "\u6A94\u6848\u7121\u6CD5\u8B80\u53D6" },
            { "agent.err.file.not.set", "\u672A\u6307\u5B9A\u6A94\u6848" },
            { "agent.err.file.read.failed", "\u7121\u6CD5\u8B80\u53D6\u6A94\u6848" },
            { "agent.err.invalid.agentclass", "com.sun.management.agent.class \u5C6C\u6027\u503C\u7121\u6548" },
            { "agent.err.invalid.jmxremote.port", "com.sun.management.jmxremote.port \u865F\u78BC\u7121\u6548" },
            { "agent.err.invalid.jmxremote.rmi.port", "com.sun.management.jmxremote.rmi.port \u865F\u78BC\u7121\u6548" },
            { "agent.err.invalid.option", "\u6307\u5B9A\u7684\u9078\u9805\u7121\u6548" },
            { "agent.err.invalid.state", "\u7121\u6548\u7684\u4EE3\u7406\u7A0B\u5F0F\u72C0\u614B: {0}" },
            { "agent.err.password.file.access.notrestricted", "\u5FC5\u9808\u9650\u5236\u5BC6\u78BC\u6A94\u6848\u8B80\u53D6\u5B58\u53D6" },
            { "agent.err.password.file.not.readable", "\u5BC6\u78BC\u6A94\u6848\u7121\u6CD5\u8B80\u53D6" },
            { "agent.err.password.file.notfound", "\u627E\u4E0D\u5230\u5BC6\u78BC\u6A94\u6848" },
            { "agent.err.password.file.notset", "\u672A\u6307\u5B9A\u5BC6\u78BC\u6A94\u6848\uFF0C\u4F46 com.sun.management.jmxremote.authenticate=true" },
            { "agent.err.password.file.read.failed", "\u7121\u6CD5\u8B80\u53D6\u5BC6\u78BC\u6A94\u6848" },
            { "agent.err.premain.notfound", "\u4EE3\u7406\u7A0B\u5F0F\u985E\u5225\u4E2D\u4E0D\u5B58\u5728 premain(String)" },
            { "agent.err.warning", "\u8B66\u544A" },
            { "jmxremote.ConnectorBootstrap.file.readonly", "\u5FC5\u9808\u9650\u5236\u6A94\u6848\u8B80\u53D6\u5B58\u53D6\u6B0A: {0}" },
            { "jmxremote.ConnectorBootstrap.noAuthentication", "\u7121\u8A8D\u8B49" },
            { "jmxremote.ConnectorBootstrap.password.readonly", "\u5FC5\u9808\u9650\u5236\u5BC6\u78BC\u6A94\u6848\u8B80\u53D6\u5B58\u53D6: {0}" },
            { "jmxremote.ConnectorBootstrap.ready", "JMX \u9023\u63A5\u5668\u5C31\u7DD2\uFF0C\u4F4D\u65BC: {0}" },
            { "jmxremote.ConnectorBootstrap.starting", "\u6B63\u5728\u555F\u52D5 JMX \u9023\u63A5\u5668\u4F3A\u670D\u5668:" },
        };
    }
}
