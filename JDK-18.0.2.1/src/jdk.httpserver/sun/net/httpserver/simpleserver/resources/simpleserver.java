package sun.net.httpserver.simpleserver.resources;

import java.util.ListResourceBundle;

public final class simpleserver extends ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "err.invalid.arg", "invalid value given for {0}: {1}" },
            { "err.missing.arg", "no value given for {0}" },
            { "err.server.config.failed", "server config failed: {0}" },
            { "err.server.handle.failed", "server exchange handling failed: {0}" },
            { "err.unknown.option", "unknown option: {0}" },
            { "error.prefix", "Error:" },
            { "html.dir.list", "Directory listing for" },
            { "html.not.found", "File not found" },
            { "loopback.info", "Binding to loopback by default. For all interfaces use \"-b 0.0.0.0\" or \"-b ::\"." },
            { "msg.start.anylocal", "Serving {0} and subdirectories on 0.0.0.0 (all interfaces) port {2}\nURL http://{1}:{2}/" },
            { "msg.start.other", "Serving {0} and subdirectories on {1} port {2}\nURL http://{1}:{2}/" },
            { "opt.bindaddress", "-b, --bind-address    - Address to bind to. Default: {0} (loopback).\n                        For all interfaces use \"-b 0.0.0.0\" or \"-b ::\"." },
            { "opt.directory", "-d, --directory       - Directory to serve. Default: current directory." },
            { "opt.output", "-o, --output          - Output format. none|info|verbose. Default: info." },
            { "opt.port", "-p, --port            - Port to listen on. Default: 8000." },
            { "options", "Options:\n-b, --bind-address    - Address to bind to. Default: {0} (loopback).\n                        For all interfaces use \"-b 0.0.0.0\" or \"-b ::\".\n-d, --directory       - Directory to serve. Default: current directory.\n-o, --output          - Output format. none|info|verbose. Default: info.\n-p, --port            - Port to listen on. Default: 8000.\n-h, -?, --help        - Prints this help message and exits.\n-version, --version   - Prints version information and exits.\nTo stop the server, press Ctrl + C." },
            { "usage.java", "Usage: java -m jdk.httpserver [-b bind address] [-p port] [-d directory]\n                              [-o none|info|verbose] [-h to show options]\n                              [-version to show version information]" },
            { "usage.jwebserver", "Usage: jwebserver [-b bind address] [-p port] [-d directory]\n                  [-o none|info|verbose] [-h to show options]\n                  [-version to show version information]" },
            { "version", "{0} {1}" },
        };
    }
}
