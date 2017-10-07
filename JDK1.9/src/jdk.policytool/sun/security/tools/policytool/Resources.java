/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.tools.policytool;

/**
 * <p> This class represents the <code>ResourceBundle</code>
 * for the policytool.
 *
 */
public class Resources extends java.util.ListResourceBundle {

    private static final Object[][] contents = {
        {"NEWLINE", "\n"},
        {"Warning.A.public.key.for.alias.signers.i.does.not.exist.Make.sure.a.KeyStore.is.properly.configured.",
                "Warning: A public key for alias {0} does not exist.  Make sure a KeyStore is properly configured."},
        {"Warning.Class.not.found.class", "Warning: Class not found: {0}"},
        {"Warning.Invalid.argument.s.for.constructor.arg",
                "Warning: Invalid argument(s) for constructor: {0}"},
        {"Illegal.Principal.Type.type", "Illegal Principal Type: {0}"},
        {"Illegal.option.option", "Illegal option: {0}"},
        {"Usage.policytool.options.", "Usage: policytool [options]"},
        {".file.file.policy.file.location",
                "  [-file <file>]    policy file location"},
        {"New", "&New"},
        {"Open", "&Open..."},
        {"Save", "&Save"},
        {"Save.As", "Save &As..."},
        {"View.Warning.Log", "View &Warning Log"},
        {"Exit", "E&xit"},
        {"Add.Policy.Entry", "&Add Policy Entry"},
        {"Edit.Policy.Entry", "&Edit Policy Entry"},
        {"Remove.Policy.Entry", "&Remove Policy Entry"},
        {"Edit", "&Edit"},
        {"Retain", "Retain"},

        {"Warning.File.name.may.include.escaped.backslash.characters.It.is.not.necessary.to.escape.backslash.characters.the.tool.escapes",
            "Warning: File name may include escaped backslash characters. " +
                        "It is not necessary to escape backslash characters " +
                        "(the tool escapes characters as necessary when writing " +
                        "the policy contents to the persistent store).\n\n" +
                        "Click on Retain to retain the entered name, or click on " +
                        "Edit to edit the name."},

        {"Add.Public.Key.Alias", "Add Public Key Alias"},
        {"Remove.Public.Key.Alias", "Remove Public Key Alias"},
        {"File", "&File"},
        {"KeyStore", "&KeyStore"},
        {"Policy.File.", "Policy File:"},
        {"Could.not.open.policy.file.policyFile.e.toString.",
                "Could not open policy file: {0}: {1}"},
        {"Policy.Tool", "Policy Tool"},
        {"Errors.have.occurred.while.opening.the.policy.configuration.View.the.Warning.Log.for.more.information.",
                "Errors have occurred while opening the policy configuration.  View the Warning Log for more information."},
        {"Error", "Error"},
        {"OK", "OK"},
        {"Status", "Status"},
        {"Warning", "Warning"},
        {"Permission.",
                "Permission:                                                       "},
        {"Principal.Type.", "Principal Type:"},
        {"Principal.Name.", "Principal Name:"},
        {"Target.Name.",
                "Target Name:                                                    "},
        {"Actions.",
                "Actions:                                                             "},
        {"OK.to.overwrite.existing.file.filename.",
                "OK to overwrite existing file {0}?"},
        {"Cancel", "Cancel"},
        {"CodeBase.", "&CodeBase:"},
        {"SignedBy.", "&SignedBy:"},
        {"Add.Principal", "&Add Principal"},
        {"Edit.Principal", "&Edit Principal"},
        {"Remove.Principal", "&Remove Principal"},
        {"Principals.", "&Principals:"},
        {".Add.Permission", "  A&dd Permission"},
        {".Edit.Permission", "  Ed&it Permission"},
        {"Remove.Permission", "Re&move Permission"},
        {"Done", "Done"},
        {"KeyStore.URL.", "KeyStore &URL:"},
        {"KeyStore.Type.", "KeyStore &Type:"},
        {"KeyStore.Provider.", "KeyStore &Provider:"},
        {"KeyStore.Password.URL.", "KeyStore Pass&word URL:"},
        {"Principals", "Principals"},
        {".Edit.Principal.", "  Edit Principal:"},
        {".Add.New.Principal.", "  Add New Principal:"},
        {"Permissions", "Permissions"},
        {".Edit.Permission.", "  Edit Permission:"},
        {".Add.New.Permission.", "  Add New Permission:"},
        {"Signed.By.", "Signed By:"},
        {"Cannot.Specify.Principal.with.a.Wildcard.Class.without.a.Wildcard.Name",
            "Cannot Specify Principal with a Wildcard Class without a Wildcard Name"},
        {"Cannot.Specify.Principal.without.a.Name",
            "Cannot Specify Principal without a Name"},
        {"Permission.and.Target.Name.must.have.a.value",
                "Permission and Target Name must have a value"},
        {"Remove.this.Policy.Entry.", "Remove this Policy Entry?"},
        {"Overwrite.File", "Overwrite File"},
        {"Policy.successfully.written.to.filename",
                "Policy successfully written to {0}"},
        {"null.filename", "null filename"},
        {"Save.changes.", "Save changes?"},
        {"Yes", "&Yes"},
        {"No", "&No"},
        {"Policy.Entry", "Policy Entry"},
        {"Save.Changes", "Save Changes"},
        {"No.Policy.Entry.selected", "No Policy Entry selected"},
        {"Unable.to.open.KeyStore.ex.toString.",
                "Unable to open KeyStore: {0}"},
        {"No.principal.selected", "No principal selected"},
        {"No.permission.selected", "No permission selected"},
        {"name", "name"},
        {"configuration.type", "configuration type"},
        {"environment.variable.name", "environment variable name"},
        {"library.name", "library name"},
        {"package.name", "package name"},
        {"policy.type", "policy type"},
        {"property.name", "property name"},
        {"provider.name", "provider name"},
        {"url", "url"},
        {"method.list", "method list"},
        {"request.headers.list", "request headers list"},
        {"Principal.List", "Principal List"},
        {"Permission.List", "Permission List"},
        {"Code.Base", "Code Base"},
        {"KeyStore.U.R.L.", "KeyStore U R L:"},
        {"KeyStore.Password.U.R.L.", "KeyStore Password U R L:"}
    };


    /**
     * Returns the contents of this <code>ResourceBundle</code>.
     *
     * <p>
     *
     * @return the contents of this <code>ResourceBundle</code>.
     */
    @Override
    public Object[][] getContents() {
        return contents;
    }
}
