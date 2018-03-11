/*
 * Copyright 2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * $Id: SerializerMessages.java,v 1.1.4.1 2005/09/08 11:03:11 suresh_emailid Exp $
 */
package com.sun.org.apache.xml.internal.serializer.utils;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * An instance of this class is a ListResourceBundle that
 * has the required getContents() method that returns
 * an array of message-key/message associations.
 * <p>
 * The message keys are defined in {@link MsgKey}. The
 * messages that those keys map to are defined here.
 * <p>
 * The messages in the English version are intended to be
 * translated. 
 * 
 * This class is not a public API, it is only public because it is 
 * used in com.sun.org.apache.xml.internal.serializer.
 * 
 * @xsl.usage internal
 */
public class SerializerMessages_pt_BR extends ListResourceBundle {

    /*
     * This file contains error and warning messages related to
     * Serializer Error Handling.
     *
     *  General notes to translators:
    
     *  1) A stylesheet is a description of how to transform an input XML document
     *     into a resultant XML document (or HTML document or text).  The
     *     stylesheet itself is described in the form of an XML document.
    
     *
     *  2) An element is a mark-up tag in an XML document; an attribute is a
     *     modifier on the tag.  For example, in <elem attr='val' attr2='val2'>
     *     "elem" is an element name, "attr" and "attr2" are attribute names with
     *     the values "val" and "val2", respectively.
     *
     *  3) A namespace declaration is a special attribute that is used to associate
     *     a prefix with a URI (the namespace).  The meanings of element names and
     *     attribute names that use that prefix are defined with respect to that
     *     namespace.
     *
     *
     */

    /** The lookup table for error messages.   */
    public Object[][] getContents() {
        Object[][] contents = new Object[][] {
            {   MsgKey.BAD_MSGKEY,
                "A chave da mensagem ''{0}'' n\u00e3o est\u00e1 na classe de mensagem ''{1}''" },
                
            {   MsgKey.BAD_MSGFORMAT,
                "O formato da mensagem ''{0}'' na classe da mensagem ''{1}'' falhou." },

            {   MsgKey.ER_SERIALIZER_NOT_CONTENTHANDLER,
                "A classe ''{0}'' do serializador n\u00e3o implementa org.xml.sax.ContentHandler." },

            {   MsgKey.ER_RESOURCE_COULD_NOT_FIND,
                    "N\u00e3o foi poss\u00edvel encontrar o recurso [ {0} ].\n {1}" },

            {   MsgKey.ER_RESOURCE_COULD_NOT_LOAD,
                    "N\u00e3o foi poss\u00edvel carregar o recurso [ {0} ]: {1} \n {2} \t {3}" },

            {   MsgKey.ER_BUFFER_SIZE_LESSTHAN_ZERO, 
                    "Tamanho do buffer <=0" }, 

            {   MsgKey.ER_INVALID_UTF16_SURROGATE,
                    "Substituto de UTF-16 inv\u00e1lido detectado: {0} ?" },

            {   MsgKey.ER_OIERROR, 
                "Erro de ES" }, 

            {   MsgKey.ER_ILLEGAL_ATTRIBUTE_POSITION,
                "N\u00e3o \u00e9 poss\u00edvel adicionar o atributo {0} antes que n\u00f3s filhos ou depois que um elemento sejam produzidos.  O atributo ser\u00e1 ignorado." },

            /*
             * Note to translators:  The stylesheet contained a reference to a
             * namespace prefix that was undefined.  The value of the substitution
             * text is the name of the prefix.
             */ 
            {   MsgKey.ER_NAMESPACE_PREFIX,
                "O namespace do prefixo ''{0}'' n\u00e3o foi declarado." },

            /*
             * Note to translators:  This message is reported if the stylesheet
             * being processed attempted to construct an XML document with an
             * attribute in a place other than on an element.  The substitution text
             * specifies the name of the attribute.
             */ 
            {   MsgKey.ER_STRAY_ATTRIBUTE,
                "Atributo ''{0}'' fora do elemento." },

            /*
             * Note to translators:  As with the preceding message, a namespace
             * declaration has the form of an attribute and is only permitted to
             * appear on an element.  The substitution text {0} is the namespace
             * prefix and {1} is the URI that was being used in the erroneous
             * namespace declaration.
             */ 
            {   MsgKey.ER_STRAY_NAMESPACE,
                "Declara\u00e7\u00e3o de namespace ''{0}''=''{1}'' fora do elemento." },

            {   MsgKey.ER_COULD_NOT_LOAD_RESOURCE,
                "N\u00e3o foi poss\u00edvel carregar ''{0}'' (verificar CLASSPATH), usando agora apenas os padr\u00f5es" },

            {   MsgKey.ER_ILLEGAL_CHARACTER,
                "Tentativa de exibir caractere de valor integral {0} que n\u00e3o est\u00e1 representado na codifica\u00e7\u00e3o de sa\u00edda especificada de {1}." },

            {   MsgKey.ER_COULD_NOT_LOAD_METHOD_PROPERTY,
                "N\u00e3o foi poss\u00edvel carregar o arquivo de propriedade ''{0}'' para o m\u00e9todo de sa\u00edda ''{1}'' (verificar CLASSPATH)" },

            {   MsgKey.ER_INVALID_PORT, 
                "N\u00famero de porta inv\u00e1lido" }, 

            {   MsgKey.ER_PORT_WHEN_HOST_NULL,
                "A porta n\u00e3o pode ser definida quando o host for nulo" },

            {   MsgKey.ER_HOST_ADDRESS_NOT_WELLFORMED,
                "O host n\u00e3o \u00e9 um endere\u00e7o bem formado" },

            {   MsgKey.ER_SCHEME_NOT_CONFORMANT,
                "O esquema n\u00e3o \u00e9 compat\u00edvel." },

            {   MsgKey.ER_SCHEME_FROM_NULL_STRING,
                "N\u00e3o \u00e9 poss\u00edvel definir o esquema de uma sequ\u00eancia nula" },

            {   MsgKey.ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE,
                "O caminho cont\u00e9m uma sequ\u00eancia inv\u00e1lida de caracteres de escape" },

            {   MsgKey.ER_PATH_INVALID_CHAR,
                "O caminho cont\u00e9m caractere inv\u00e1lido: {0}" },

            {   MsgKey.ER_FRAG_INVALID_CHAR,
                "O fragmento cont\u00e9m caractere inv\u00e1lido" },

            {   MsgKey.ER_FRAG_WHEN_PATH_NULL,
                "O fragmento n\u00e3o pode ser definida quando o caminho for nulo" },

            {   MsgKey.ER_FRAG_FOR_GENERIC_URI,
                "O fragmento pode ser definido somente para um URI gen\u00e9rico" },

            {   MsgKey.ER_NO_SCHEME_IN_URI, 
                "Nenhum esquema encontrado no URI" }, 

            {   MsgKey.ER_CANNOT_INIT_URI_EMPTY_PARMS,
                "N\u00e3o \u00e9 poss\u00edvel inicializar o URI com par\u00e2metros vazios" },

            {   MsgKey.ER_NO_FRAGMENT_STRING_IN_PATH,
                "O fragmento n\u00e3o pode ser especificado no caminho nem no fragmento" },

            {   MsgKey.ER_NO_QUERY_STRING_IN_PATH,
                "A sequ\u00eancia de consulta n\u00e3o pode ser especificada no caminho nem na sequ\u00eancia de consulta" },

            {   MsgKey.ER_NO_PORT_IF_NO_HOST,
                "A porta n\u00e3o pode ser especificada se o host n\u00e3o estiver especificado" },

            {   MsgKey.ER_NO_USERINFO_IF_NO_HOST,
                "As informa\u00e7\u00f5es do usu\u00e1rio n\u00e3o podem ser especificadas se o host n\u00e3o estiver especificado" },

            {   MsgKey.ER_XML_VERSION_NOT_SUPPORTED,
                "Aviso:  a vers\u00e3o do documento de sa\u00edda precisa ser ''{0}''.  Esta vers\u00e3o de XML n\u00e3o \u00e9 suportada.  A vers\u00e3o do documento de sa\u00edda ser\u00e1 ''1.0''." },

            {   MsgKey.ER_SCHEME_REQUIRED, 
                "\u00c9 necess\u00e1rio esquema!" },
                
            /*
             * Note to translators:  The words 'Properties' and
             * 'SerializerFactory' in this message are Java class names
             * and should not be translated.
             */    
            {   MsgKey.ER_FACTORY_PROPERTY_MISSING,
                "O objeto Properties transferido para o SerializerFactory n\u00e3o tem uma propriedade ''{0}''." },

            {   MsgKey.ER_ENCODING_NOT_SUPPORTED,
                "Aviso:  a codifica\u00e7\u00e3o ''{0}'' n\u00e3o \u00e9 suportada pelo Java Runtime." },
                

        };

        return contents;
    }
}
