/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package sun.security.util;

/**
 * <p> This class represents the <code>ResourceBundle</code>
 * for the following packages:
 *
 * <ol>
 * <li> com.sun.security.auth
 * <li> com.sun.security.auth.login
 * </ol>
 *
 */
public class AuthResources_ja extends java.util.ListResourceBundle {

    private static final Object[][] contents = {

        // NT principals
        {"invalid.null.input.value", "\u7121\u52B9\u306Anull\u306E\u5165\u529B: {0}"},
        {"NTDomainPrincipal.name", "NTDomainPrincipal: {0}"},
        {"NTNumericCredential.name", "NTNumericCredential: {0}"},
        {"Invalid.NTSid.value", "\u7121\u52B9\u306ANTSid\u5024"},
        {"NTSid.name", "NTSid: {0}"},
        {"NTSidDomainPrincipal.name", "NTSidDomainPrincipal: {0}"},
        {"NTSidGroupPrincipal.name", "NTSidGroupPrincipal: {0}"},
        {"NTSidPrimaryGroupPrincipal.name", "NTSidPrimaryGroupPrincipal: {0}"},
        {"NTSidUserPrincipal.name", "NTSidUserPrincipal: {0}"},
        {"NTUserPrincipal.name", "NTUserPrincipal: {0}"},

        // UnixPrincipals
        {"UnixNumericGroupPrincipal.Primary.Group.name",
                "UnixNumericGroupPrincipal [\u4E3B\u30B0\u30EB\u30FC\u30D7]: {0}"},
        {"UnixNumericGroupPrincipal.Supplementary.Group.name",
                "UnixNumericGroupPrincipal [\u88DC\u52A9\u30B0\u30EB\u30FC\u30D7]: {0}"},
        {"UnixNumericUserPrincipal.name", "UnixNumericUserPrincipal: {0}"},
        {"UnixPrincipal.name", "UnixPrincipal: {0}"},

        // com.sun.security.auth.login.ConfigFile
        {"Unable.to.properly.expand.config", "{0}\u3092\u6B63\u3057\u304F\u5C55\u958B\u3067\u304D\u307E\u305B\u3093"},
        {"extra.config.No.such.file.or.directory.",
                "{0}(\u6307\u5B9A\u3055\u308C\u305F\u30D5\u30A1\u30A4\u30EB\u307E\u305F\u306F\u30C7\u30A3\u30EC\u30AF\u30C8\u30EA\u306F\u5B58\u5728\u3057\u307E\u305B\u3093)"},
        {"Configuration.Error.No.such.file.or.directory",
                "\u69CB\u6210\u30A8\u30E9\u30FC:\n\t\u6307\u5B9A\u3055\u308C\u305F\u30D5\u30A1\u30A4\u30EB\u307E\u305F\u306F\u30C7\u30A3\u30EC\u30AF\u30C8\u30EA\u306F\u5B58\u5728\u3057\u307E\u305B\u3093"},
        {"Configuration.Error.Invalid.control.flag.flag",
                "\u69CB\u6210\u30A8\u30E9\u30FC:\n\t\u7121\u52B9\u306A\u5236\u5FA1\u30D5\u30E9\u30B0: {0}"},
        {"Configuration.Error.Can.not.specify.multiple.entries.for.appName",
            "\u69CB\u6210\u30A8\u30E9\u30FC:\n\t{0}\u306B\u8907\u6570\u306E\u30A8\u30F3\u30C8\u30EA\u3092\u6307\u5B9A\u3067\u304D\u307E\u305B\u3093"},
        {"Configuration.Error.expected.expect.read.end.of.file.",
                "\u69CB\u6210\u30A8\u30E9\u30FC:\n\t[{0}]\u3067\u306F\u306A\u304F\u3001[\u30D5\u30A1\u30A4\u30EB\u306E\u7D42\u308F\u308A]\u304C\u8AAD\u307F\u8FBC\u307E\u308C\u307E\u3057\u305F"},
        {"Configuration.Error.Line.line.expected.expect.found.value.",
            "\u69CB\u6210\u30A8\u30E9\u30FC:\n\t\u884C{0}: [{1}]\u3067\u306F\u306A\u304F\u3001[{2}]\u304C\u691C\u51FA\u3055\u308C\u307E\u3057\u305F"},
        {"Configuration.Error.Line.line.expected.expect.",
            "\u69CB\u6210\u30A8\u30E9\u30FC:\n\t\u884C{0}: [{1}]\u304C\u8981\u6C42\u3055\u308C\u307E\u3057\u305F"},
        {"Configuration.Error.Line.line.system.property.value.expanded.to.empty.value",
            "\u69CB\u6210\u30A8\u30E9\u30FC:\n\t\u884C{0}: \u30B7\u30B9\u30C6\u30E0\u30FB\u30D7\u30ED\u30D1\u30C6\u30A3[{1}]\u304C\u7A7A\u306E\u5024\u306B\u5C55\u958B\u3055\u308C\u307E\u3057\u305F"},

        // com.sun.security.auth.module.JndiLoginModule
        {"username.","\u30E6\u30FC\u30B6\u30FC\u540D: "},
        {"password.","\u30D1\u30B9\u30EF\u30FC\u30C9: "},

        // com.sun.security.auth.module.KeyStoreLoginModule
        {"Please.enter.keystore.information",
                "\u30AD\u30FC\u30B9\u30C8\u30A2\u60C5\u5831\u3092\u5165\u529B\u3057\u3066\u304F\u3060\u3055\u3044"},
        {"Keystore.alias.","\u30AD\u30FC\u30B9\u30C8\u30A2\u306E\u5225\u540D: "},
        {"Keystore.password.","\u30AD\u30FC\u30B9\u30C8\u30A2\u306E\u30D1\u30B9\u30EF\u30FC\u30C9: "},
        {"Private.key.password.optional.",
            "\u79D8\u5BC6\u30AD\u30FC\u306E\u30D1\u30B9\u30EF\u30FC\u30C9(\u30AA\u30D7\u30B7\u30E7\u30F3): "},

        // com.sun.security.auth.module.Krb5LoginModule
        {"Kerberos.username.defUsername.",
                "Kerberos\u30E6\u30FC\u30B6\u30FC\u540D[{0}]: "},
        {"Kerberos.password.for.username.",
                "{0}\u306EKerberos\u30D1\u30B9\u30EF\u30FC\u30C9: "},
    };

    /**
     * Returns the contents of this <code>ResourceBundle</code>.
     *
     * <p>
     *
     * @return the contents of this <code>ResourceBundle</code>.
     */
    public Object[][] getContents() {
        return contents;
    }
}
