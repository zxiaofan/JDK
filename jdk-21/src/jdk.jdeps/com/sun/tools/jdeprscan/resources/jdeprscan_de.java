package com.sun.tools.jdeprscan.resources;

public final class jdeprscan_de extends java.util.ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            { "main.help", "Scannt jedes Argument auf die Verwendung veralteter APIs. Ein Argument\nkann ein Verzeichnis, das die Root einer Packagehierarchie angibt,\neine JAR-Datei, eine Klassendatei oder ein Klassenname sein. Der Klassenname\nmuss durch einen vollst\u00E4ndig qualifizierten Klassennamen mit $ als Trennzeichen\nf\u00FCr verschachtelte Klassen angegeben werden. Beispiel:\n\n    java.lang.Thread$State\n\nDie Option --class-path liefert einen Suchpfad f\u00FCr die Aufl\u00F6sung\nvon abh\u00E4ngigen Klassen.\n\nDie Option --for-removal begrenzt das Scannen oder Auflisten auf APIs, die veraltet sind\nund entfernt werden sollen. Kann nicht mit den Releasewerten 6, 7, oder 8 verwendet werden.\n\nDie Option --full-version gibt die vollst\u00E4ndige Versionszeichenfolge des Tools aus.\n\nDie Option --help (-? -h) gibt eine vollst\u00E4ndige Hilfemeldung aus.\n\nDie Option --list (-l) gibt die Gruppe der veralteten APIs aus. Es wird nicht gescannt,\ndaher d\u00FCrfen keine Verzeichnis-, JAR- oder Klassenargumente angegeben werden.\n\nDie Option --release gibt das Java SE-Release an, das die Gruppe\nder veralteten APIS zum Scannen liefert.\n\nDie Option --verbose (-v) aktiviert die Ausgabe zus\u00E4tzlicher Meldungen w\u00E4hrend der Verarbeitung.\n\nDie Option --version gibt die verk\u00FCrzte Versionszeichenfolge des Tools aus." },
            { "main.usage", "Verwendung: jdeprscan [Optionen] '{dir|jar|class}' ...\n\nOptionen:\n        --class-path PATH\n        --for-removal\n        --full-version\n  -? -h --help\n  -l    --list\n        --release {0}\n  -v    --verbose\n        --version" },
            { "main.xhelp", "Nicht unterst\u00FCtzte Optionen:\n\n  --Xload-class CLASS\n      L\u00E4dt Veraltungsinformationen aus der benannten Klasse.\n  --Xload-csv CSVFILE\n      L\u00E4dt Veraltungsinformationen aus der benannten CSV-Datei.\n  --Xload-dir DIR\n      L\u00E4dt Veraltungsinformationen aus der Klassenhierarchie\n      im benannten Verzeichnis.\n  --Xload-jar JARFILE\n      L\u00E4dt Veraltungsinformationen aus der benannten JAR-Datei.\n  --Xload-jdk9 JAVA_HOME\n      L\u00E4dt Veraltungsinformationen aus dem JDK in\n      JAVA_HOME, das ein modulares JDK sein muss.\n  --Xload-old-jdk JAVA_HOME\n      L\u00E4dt Veraltungsinformationen aus dem JDK in\n      JAVA_HOME, das kein modulares JDK sein darf. Stattdessen\n      muss das benannte JDK ein \"klassisches\" JDK mit einer rt.jar-Datei sein.\n  --Xload-self\n      L\u00E4dt Veraltungsinformationen durch Traversieren des jrt:-\n      Dateisystems des ausgef\u00FChrten JDK-Images.\n  --Xcompiler-arg ARG\n      F\u00FCgt ARG der Liste der Compilerargumente hinzu.\n  --Xcsv-comment COMMENT\n      F\u00FCgt COMMENT als Kommentarzeile der CSV-Ausgabedatei hinzu.\n      Nur effektiv, wenn auch -Xprint-csv angegeben wird.\n  --Xhelp\n      Gibt diese Meldung aus.\n  --Xprint-csv\n      Gibt eine CSV-Datei aus, welche die geladenen Veraltungsinformationen enth\u00E4lt,\n      statt Klassen oder JAR-Dateien zu scannen." },
            { "scan.dep.normal", "" },
            { "scan.dep.removal", "(forRemoval=true)" },
            { "scan.err.exception", "Fehler: unerwartete Ausnahme {0}" },
            { "scan.err.noclass", "Fehler: Klasse {0} nicht gefunden" },
            { "scan.err.nofile", "Fehler: Datei {0} nicht gefunden" },
            { "scan.err.nomethod", "Fehler: Methodref {0}.{1}:{2} kann nicht aufgel\u00F6st werden" },
            { "scan.head.dir", "Verzeichnis {0}:" },
            { "scan.head.jar", "JAR-Datei {0}:" },
            { "scan.out.extends", "{0} {1} erweitert die veraltete Klasse {2} {3}" },
            { "scan.out.hasfield", "{0} {1} hat den Feldnamen {2} des veralteten Typs {3} {4}" },
            { "scan.out.implements", "{0} {1} implementiert die veraltete Schnittstelle {2} {3}" },
            { "scan.out.methodoverride", "{0} {1} setzt die veraltete Methode {2}::{3}{4} {5} au\u00DFer Kraft" },
            { "scan.out.methodparmtype", "{0} {1} hat eine Methode namens {2} mit dem veralteten Parametertyp {3} {4}" },
            { "scan.out.methodrettype", "{0} {1} hat eine Methode namens {2} mit dem veralteten R\u00FCckgabetyp {3} {4}" },
            { "scan.out.usesclass", "{0} {1} verwendet die veraltete Klasse {2} {3}" },
            { "scan.out.usesfield", "{0} {1} verwendet das veraltete Feld {2}::{3} {4}" },
            { "scan.out.usesintfmethod", "{0} {1} verwendet die veraltete Methode {2}::{3}{4} {5}" },
            { "scan.out.usesmethod", "{0} {1} verwendet die veraltete Methode {2}::{3}{4} {5}" },
            { "scan.process.class", "Klasse {0} wird verarbeitet..." },
        };
    }
}
