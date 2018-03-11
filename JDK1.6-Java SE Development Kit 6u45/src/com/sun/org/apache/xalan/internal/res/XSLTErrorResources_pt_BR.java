/*
 * Copyright 1999-2005 The Apache Software Foundation.
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
 * $Id: XSLTErrorResources.java,v 1.2.4.1 2005/09/13 09:55:37 pvedula Exp $
 */
package com.sun.org.apache.xalan.internal.res;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Set up error messages.
 * We build a two dimensional array of message keys and
 * message strings. In order to add a new message here,
 * you need to first add a String constant. And 
 *  you need to enter key , value pair as part of contents
 * Array. You also need to update MAX_CODE for error strings
 * and MAX_WARNING for warnings ( Needed for only information
 * purpose )
 */
public class XSLTErrorResources_pt_BR extends ListResourceBundle
{

/*
 * This file contains error and warning messages related to Xalan Error
 * Handling.
 *
 *  General notes to translators:
 *
 *  1) Xalan (or more properly, Xalan-interpretive) and XSLTC are names of
 *     components.
 *     XSLT is an acronym for "XML Stylesheet Language: Transformations".
 *     XSLTC is an acronym for XSLT Compiler.
 *
 *  2) A stylesheet is a description of how to transform an input XML document
 *     into a resultant XML document (or HTML document or text).  The
 *     stylesheet itself is described in the form of an XML document.
 *
 *  3) A template is a component of a stylesheet that is used to match a
 *     particular portion of an input document and specifies the form of the
 *     corresponding portion of the output document.
 *
 *  4) An element is a mark-up tag in an XML document; an attribute is a
 *     modifier on the tag.  For example, in <elem attr='val' attr2='val2'>
 *     "elem" is an element name, "attr" and "attr2" are attribute names with
 *     the values "val" and "val2", respectively.
 *
 *  5) A namespace declaration is a special attribute that is used to associate
 *     a prefix with a URI (the namespace).  The meanings of element names and
 *     attribute names that use that prefix are defined with respect to that
 *     namespace.
 *
 *  6) "Translet" is an invented term that describes the class file that
 *     results from compiling an XML stylesheet into a Java class.
 *
 *  7) XPath is a specification that describes a notation for identifying
 *     nodes in a tree-structured representation of an XML document.  An
 *     instance of that notation is referred to as an XPath expression.
 *
 */

  /* 
   * Static variables
   */
  public static final String ER_INVALID_NAMESPACE_URI_VALUE_FOR_RESULT_PREFIX = 
	"ER_INVALID_SET_NAMESPACE_URI_VALUE_FOR_RESULT_PREFIX"; 
	
  public static final String ER_INVALID_NAMESPACE_URI_VALUE_FOR_RESULT_PREFIX_FOR_DEFAULT =
	"ER_INVALID_NAMESPACE_URI_VALUE_FOR_RESULT_PREFIX_FOR_DEFAULT";
   
  public static final String ER_NO_CURLYBRACE = "ER_NO_CURLYBRACE";
  public static final String ER_FUNCTION_NOT_SUPPORTED = "ER_FUNCTION_NOT_SUPPORTED";
  public static final String ER_ILLEGAL_ATTRIBUTE = "ER_ILLEGAL_ATTRIBUTE";
  public static final String ER_NULL_SOURCENODE_APPLYIMPORTS = "ER_NULL_SOURCENODE_APPLYIMPORTS";
  public static final String ER_CANNOT_ADD = "ER_CANNOT_ADD"; 
  public static final String ER_NULL_SOURCENODE_HANDLEAPPLYTEMPLATES="ER_NULL_SOURCENODE_HANDLEAPPLYTEMPLATES";
  public static final String ER_NO_NAME_ATTRIB = "ER_NO_NAME_ATTRIB";
  public static final String ER_TEMPLATE_NOT_FOUND = "ER_TEMPLATE_NOT_FOUND";
  public static final String ER_CANT_RESOLVE_NAME_AVT = "ER_CANT_RESOLVE_NAME_AVT";
  public static final String ER_REQUIRES_ATTRIB = "ER_REQUIRES_ATTRIB";
  public static final String ER_MUST_HAVE_TEST_ATTRIB = "ER_MUST_HAVE_TEST_ATTRIB";
  public static final String ER_BAD_VAL_ON_LEVEL_ATTRIB =
	 "ER_BAD_VAL_ON_LEVEL_ATTRIB";
  public static final String ER_PROCESSINGINSTRUCTION_NAME_CANT_BE_XML =
	 "ER_PROCESSINGINSTRUCTION_NAME_CANT_BE_XML";
  public static final String ER_PROCESSINGINSTRUCTION_NOTVALID_NCNAME = 
	 "ER_PROCESSINGINSTRUCTION_NOTVALID_NCNAME";
  public static final String ER_NEED_MATCH_ATTRIB = "ER_NEED_MATCH_ATTRIB";
  public static final String ER_NEED_NAME_OR_MATCH_ATTRIB = 
	 "ER_NEED_NAME_OR_MATCH_ATTRIB";
  public static final String ER_CANT_RESOLVE_NSPREFIX =
	 "ER_CANT_RESOLVE_NSPREFIX";
  public static final String ER_ILLEGAL_VALUE = "ER_ILLEGAL_VALUE";
  public static final String ER_NO_OWNERDOC = "ER_NO_OWNERDOC";
  public static final String ER_ELEMTEMPLATEELEM_ERR ="ER_ELEMTEMPLATEELEM_ERR";
  public static final String ER_NULL_CHILD = "ER_NULL_CHILD";
  public static final String ER_NEED_SELECT_ATTRIB = "ER_NEED_SELECT_ATTRIB";
  public static final String ER_NEED_TEST_ATTRIB = "ER_NEED_TEST_ATTRIB";
  public static final String ER_NEED_NAME_ATTRIB = "ER_NEED_NAME_ATTRIB";
  public static final String ER_NO_CONTEXT_OWNERDOC = "ER_NO_CONTEXT_OWNERDOC";
  public static final String ER_COULD_NOT_CREATE_XML_PROC_LIAISON = 
	 "ER_COULD_NOT_CREATE_XML_PROC_LIAISON";
  public static final String ER_PROCESS_NOT_SUCCESSFUL = 
	 "ER_PROCESS_NOT_SUCCESSFUL";
  public static final String ER_NOT_SUCCESSFUL = "ER_NOT_SUCCESSFUL";
  public static final String ER_ENCODING_NOT_SUPPORTED = 
	 "ER_ENCODING_NOT_SUPPORTED";
  public static final String ER_COULD_NOT_CREATE_TRACELISTENER = 
	 "ER_COULD_NOT_CREATE_TRACELISTENER";
  public static final String ER_KEY_REQUIRES_NAME_ATTRIB = 
	 "ER_KEY_REQUIRES_NAME_ATTRIB";
  public static final String ER_KEY_REQUIRES_MATCH_ATTRIB = 
	 "ER_KEY_REQUIRES_MATCH_ATTRIB";
  public static final String ER_KEY_REQUIRES_USE_ATTRIB = 
	 "ER_KEY_REQUIRES_USE_ATTRIB";
  public static final String ER_REQUIRES_ELEMENTS_ATTRIB = 
	 "ER_REQUIRES_ELEMENTS_ATTRIB";
  public static final String ER_MISSING_PREFIX_ATTRIB = 
	 "ER_MISSING_PREFIX_ATTRIB";
  public static final String ER_BAD_STYLESHEET_URL = "ER_BAD_STYLESHEET_URL";
  public static final String ER_FILE_NOT_FOUND = "ER_FILE_NOT_FOUND";
  public static final String ER_IOEXCEPTION = "ER_IOEXCEPTION";
  public static final String ER_NO_HREF_ATTRIB = "ER_NO_HREF_ATTRIB";
  public static final String ER_STYLESHEET_INCLUDES_ITSELF = 
	 "ER_STYLESHEET_INCLUDES_ITSELF";
  public static final String ER_PROCESSINCLUDE_ERROR ="ER_PROCESSINCLUDE_ERROR";
  public static final String ER_MISSING_LANG_ATTRIB = "ER_MISSING_LANG_ATTRIB";
  public static final String ER_MISSING_CONTAINER_ELEMENT_COMPONENT = 
	 "ER_MISSING_CONTAINER_ELEMENT_COMPONENT";
  public static final String ER_CAN_ONLY_OUTPUT_TO_ELEMENT = 
	 "ER_CAN_ONLY_OUTPUT_TO_ELEMENT";
  public static final String ER_PROCESS_ERROR = "ER_PROCESS_ERROR";
  public static final String ER_UNIMPLNODE_ERROR = "ER_UNIMPLNODE_ERROR";
  public static final String ER_NO_SELECT_EXPRESSION ="ER_NO_SELECT_EXPRESSION";
  public static final String ER_CANNOT_SERIALIZE_XSLPROCESSOR = 
	 "ER_CANNOT_SERIALIZE_XSLPROCESSOR";
  public static final String ER_NO_INPUT_STYLESHEET = "ER_NO_INPUT_STYLESHEET";
  public static final String ER_FAILED_PROCESS_STYLESHEET = 
	 "ER_FAILED_PROCESS_STYLESHEET";
  public static final String ER_COULDNT_PARSE_DOC = "ER_COULDNT_PARSE_DOC";
  public static final String ER_COULDNT_FIND_FRAGMENT = 
	 "ER_COULDNT_FIND_FRAGMENT";
  public static final String ER_NODE_NOT_ELEMENT = "ER_NODE_NOT_ELEMENT";
  public static final String ER_FOREACH_NEED_MATCH_OR_NAME_ATTRIB = 
	 "ER_FOREACH_NEED_MATCH_OR_NAME_ATTRIB";
  public static final String ER_TEMPLATES_NEED_MATCH_OR_NAME_ATTRIB = 
	 "ER_TEMPLATES_NEED_MATCH_OR_NAME_ATTRIB";
  public static final String ER_NO_CLONE_OF_DOCUMENT_FRAG = 
	 "ER_NO_CLONE_OF_DOCUMENT_FRAG";
  public static final String ER_CANT_CREATE_ITEM = "ER_CANT_CREATE_ITEM";
  public static final String ER_XMLSPACE_ILLEGAL_VALUE = 
	 "ER_XMLSPACE_ILLEGAL_VALUE";
  public static final String ER_NO_XSLKEY_DECLARATION = 
	 "ER_NO_XSLKEY_DECLARATION";
  public static final String ER_CANT_CREATE_URL = "ER_CANT_CREATE_URL";
  public static final String ER_XSLFUNCTIONS_UNSUPPORTED = 
	 "ER_XSLFUNCTIONS_UNSUPPORTED";
  public static final String ER_PROCESSOR_ERROR = "ER_PROCESSOR_ERROR";
  public static final String ER_NOT_ALLOWED_INSIDE_STYLESHEET = 
	 "ER_NOT_ALLOWED_INSIDE_STYLESHEET";
  public static final String ER_RESULTNS_NOT_SUPPORTED = 
	 "ER_RESULTNS_NOT_SUPPORTED";
  public static final String ER_DEFAULTSPACE_NOT_SUPPORTED = 
	 "ER_DEFAULTSPACE_NOT_SUPPORTED";
  public static final String ER_INDENTRESULT_NOT_SUPPORTED = 
	 "ER_INDENTRESULT_NOT_SUPPORTED";
  public static final String ER_ILLEGAL_ATTRIB = "ER_ILLEGAL_ATTRIB";
  public static final String ER_UNKNOWN_XSL_ELEM = "ER_UNKNOWN_XSL_ELEM";
  public static final String ER_BAD_XSLSORT_USE = "ER_BAD_XSLSORT_USE";
  public static final String ER_MISPLACED_XSLWHEN = "ER_MISPLACED_XSLWHEN";
  public static final String ER_XSLWHEN_NOT_PARENTED_BY_XSLCHOOSE = 
	 "ER_XSLWHEN_NOT_PARENTED_BY_XSLCHOOSE";
  public static final String ER_MISPLACED_XSLOTHERWISE = 
	 "ER_MISPLACED_XSLOTHERWISE";
  public static final String ER_XSLOTHERWISE_NOT_PARENTED_BY_XSLCHOOSE = 
	 "ER_XSLOTHERWISE_NOT_PARENTED_BY_XSLCHOOSE";
  public static final String ER_NOT_ALLOWED_INSIDE_TEMPLATE = 
	 "ER_NOT_ALLOWED_INSIDE_TEMPLATE";
  public static final String ER_UNKNOWN_EXT_NS_PREFIX = 
	 "ER_UNKNOWN_EXT_NS_PREFIX";
  public static final String ER_IMPORTS_AS_FIRST_ELEM = 
	 "ER_IMPORTS_AS_FIRST_ELEM";
  public static final String ER_IMPORTING_ITSELF = "ER_IMPORTING_ITSELF";
  public static final String ER_XMLSPACE_ILLEGAL_VAL ="ER_XMLSPACE_ILLEGAL_VAL";
  public static final String ER_PROCESSSTYLESHEET_NOT_SUCCESSFUL = 
	 "ER_PROCESSSTYLESHEET_NOT_SUCCESSFUL";
  public static final String ER_SAX_EXCEPTION = "ER_SAX_EXCEPTION";
  public static final String ER_XSLT_ERROR = "ER_XSLT_ERROR";
  public static final String ER_CURRENCY_SIGN_ILLEGAL=
	 "ER_CURRENCY_SIGN_ILLEGAL";
  public static final String ER_DOCUMENT_FUNCTION_INVALID_IN_STYLESHEET_DOM = 
	 "ER_DOCUMENT_FUNCTION_INVALID_IN_STYLESHEET_DOM";
  public static final String ER_CANT_RESOLVE_PREFIX_OF_NON_PREFIX_RESOLVER = 
	 "ER_CANT_RESOLVE_PREFIX_OF_NON_PREFIX_RESOLVER";
  public static final String ER_REDIRECT_COULDNT_GET_FILENAME = 
	 "ER_REDIRECT_COULDNT_GET_FILENAME";
  public static final String ER_CANNOT_BUILD_FORMATTERLISTENER_IN_REDIRECT = 
	 "ER_CANNOT_BUILD_FORMATTERLISTENER_IN_REDIRECT";
  public static final String ER_INVALID_PREFIX_IN_EXCLUDERESULTPREFIX = 
	 "ER_INVALID_PREFIX_IN_EXCLUDERESULTPREFIX";
  public static final String ER_MISSING_NS_URI = "ER_MISSING_NS_URI";
  public static final String ER_MISSING_ARG_FOR_OPTION = 
	 "ER_MISSING_ARG_FOR_OPTION";
  public static final String ER_INVALID_OPTION = "ER_INVALID_OPTION";
  public static final String ER_MALFORMED_FORMAT_STRING = 
	 "ER_MALFORMED_FORMAT_STRING";
  public static final String ER_STYLESHEET_REQUIRES_VERSION_ATTRIB = 
	 "ER_STYLESHEET_REQUIRES_VERSION_ATTRIB";
  public static final String ER_ILLEGAL_ATTRIBUTE_VALUE = 
	 "ER_ILLEGAL_ATTRIBUTE_VALUE";
  public static final String ER_CHOOSE_REQUIRES_WHEN ="ER_CHOOSE_REQUIRES_WHEN";
  public static final String ER_NO_APPLY_IMPORT_IN_FOR_EACH = 
	 "ER_NO_APPLY_IMPORT_IN_FOR_EACH";
  public static final String ER_CANT_USE_DTM_FOR_OUTPUT = 
	 "ER_CANT_USE_DTM_FOR_OUTPUT";
  public static final String ER_CANT_USE_DTM_FOR_INPUT = 
	 "ER_CANT_USE_DTM_FOR_INPUT";
  public static final String ER_CALL_TO_EXT_FAILED = "ER_CALL_TO_EXT_FAILED";
  public static final String ER_PREFIX_MUST_RESOLVE = "ER_PREFIX_MUST_RESOLVE";
  public static final String ER_INVALID_UTF16_SURROGATE = 
	 "ER_INVALID_UTF16_SURROGATE";
  public static final String ER_XSLATTRSET_USED_ITSELF = 
	 "ER_XSLATTRSET_USED_ITSELF";
  public static final String ER_CANNOT_MIX_XERCESDOM ="ER_CANNOT_MIX_XERCESDOM";
  public static final String ER_TOO_MANY_LISTENERS = "ER_TOO_MANY_LISTENERS";
  public static final String ER_IN_ELEMTEMPLATEELEM_READOBJECT = 
	 "ER_IN_ELEMTEMPLATEELEM_READOBJECT";
  public static final String ER_DUPLICATE_NAMED_TEMPLATE = 
	 "ER_DUPLICATE_NAMED_TEMPLATE";
  public static final String ER_INVALID_KEY_CALL = "ER_INVALID_KEY_CALL";
  public static final String ER_REFERENCING_ITSELF = "ER_REFERENCING_ITSELF";
  public static final String ER_ILLEGAL_DOMSOURCE_INPUT = 
	 "ER_ILLEGAL_DOMSOURCE_INPUT";
  public static final String ER_CLASS_NOT_FOUND_FOR_OPTION = 
	 "ER_CLASS_NOT_FOUND_FOR_OPTION";
  public static final String ER_REQUIRED_ELEM_NOT_FOUND = 
	 "ER_REQUIRED_ELEM_NOT_FOUND";
  public static final String ER_INPUT_CANNOT_BE_NULL ="ER_INPUT_CANNOT_BE_NULL";
  public static final String ER_URI_CANNOT_BE_NULL = "ER_URI_CANNOT_BE_NULL";
  public static final String ER_FILE_CANNOT_BE_NULL = "ER_FILE_CANNOT_BE_NULL";
  public static final String ER_SOURCE_CANNOT_BE_NULL = 
	 "ER_SOURCE_CANNOT_BE_NULL";
  public static final String ER_CANNOT_INIT_BSFMGR = "ER_CANNOT_INIT_BSFMGR";
  public static final String ER_CANNOT_CMPL_EXTENSN = "ER_CANNOT_CMPL_EXTENSN";
  public static final String ER_CANNOT_CREATE_EXTENSN = 
	 "ER_CANNOT_CREATE_EXTENSN";
  public static final String ER_INSTANCE_MTHD_CALL_REQUIRES = 
	 "ER_INSTANCE_MTHD_CALL_REQUIRES";
  public static final String ER_INVALID_ELEMENT_NAME ="ER_INVALID_ELEMENT_NAME";
  public static final String ER_ELEMENT_NAME_METHOD_STATIC = 
	 "ER_ELEMENT_NAME_METHOD_STATIC";
  public static final String ER_EXTENSION_FUNC_UNKNOWN = 
	 "ER_EXTENSION_FUNC_UNKNOWN";
  public static final String ER_MORE_MATCH_CONSTRUCTOR = 
	 "ER_MORE_MATCH_CONSTRUCTOR";
  public static final String ER_MORE_MATCH_METHOD = "ER_MORE_MATCH_METHOD";
  public static final String ER_MORE_MATCH_ELEMENT = "ER_MORE_MATCH_ELEMENT";
  public static final String ER_INVALID_CONTEXT_PASSED = 
	 "ER_INVALID_CONTEXT_PASSED";
  public static final String ER_POOL_EXISTS = "ER_POOL_EXISTS";
  public static final String ER_NO_DRIVER_NAME = "ER_NO_DRIVER_NAME";
  public static final String ER_NO_URL = "ER_NO_URL";
  public static final String ER_POOL_SIZE_LESSTHAN_ONE = 
	 "ER_POOL_SIZE_LESSTHAN_ONE";
  public static final String ER_INVALID_DRIVER = "ER_INVALID_DRIVER";
  public static final String ER_NO_STYLESHEETROOT = "ER_NO_STYLESHEETROOT";
  public static final String ER_ILLEGAL_XMLSPACE_VALUE = 
	 "ER_ILLEGAL_XMLSPACE_VALUE";
  public static final String ER_PROCESSFROMNODE_FAILED = 
	 "ER_PROCESSFROMNODE_FAILED";
  public static final String ER_RESOURCE_COULD_NOT_LOAD = 
	 "ER_RESOURCE_COULD_NOT_LOAD";
  public static final String ER_BUFFER_SIZE_LESSTHAN_ZERO = 
	 "ER_BUFFER_SIZE_LESSTHAN_ZERO";
  public static final String ER_UNKNOWN_ERROR_CALLING_EXTENSION = 
	 "ER_UNKNOWN_ERROR_CALLING_EXTENSION";
  public static final String ER_NO_NAMESPACE_DECL = "ER_NO_NAMESPACE_DECL";
  public static final String ER_ELEM_CONTENT_NOT_ALLOWED = 
	 "ER_ELEM_CONTENT_NOT_ALLOWED";
  public static final String ER_STYLESHEET_DIRECTED_TERMINATION = 
	 "ER_STYLESHEET_DIRECTED_TERMINATION";
  public static final String ER_ONE_OR_TWO = "ER_ONE_OR_TWO";
  public static final String ER_TWO_OR_THREE = "ER_TWO_OR_THREE";
  public static final String ER_COULD_NOT_LOAD_RESOURCE = 
	 "ER_COULD_NOT_LOAD_RESOURCE";
  public static final String ER_CANNOT_INIT_DEFAULT_TEMPLATES = 
	 "ER_CANNOT_INIT_DEFAULT_TEMPLATES";
  public static final String ER_RESULT_NULL = "ER_RESULT_NULL";
  public static final String ER_RESULT_COULD_NOT_BE_SET = 
	 "ER_RESULT_COULD_NOT_BE_SET";
  public static final String ER_NO_OUTPUT_SPECIFIED = "ER_NO_OUTPUT_SPECIFIED";
  public static final String ER_CANNOT_TRANSFORM_TO_RESULT_TYPE = 
	 "ER_CANNOT_TRANSFORM_TO_RESULT_TYPE";
  public static final String ER_CANNOT_TRANSFORM_SOURCE_TYPE = 
	 "ER_CANNOT_TRANSFORM_SOURCE_TYPE";
  public static final String ER_NULL_CONTENT_HANDLER ="ER_NULL_CONTENT_HANDLER";
  public static final String ER_NULL_ERROR_HANDLER = "ER_NULL_ERROR_HANDLER";
  public static final String ER_CANNOT_CALL_PARSE = "ER_CANNOT_CALL_PARSE";
  public static final String ER_NO_PARENT_FOR_FILTER ="ER_NO_PARENT_FOR_FILTER";
  public static final String ER_NO_STYLESHEET_IN_MEDIA = 
	 "ER_NO_STYLESHEET_IN_MEDIA";
  public static final String ER_NO_STYLESHEET_PI = "ER_NO_STYLESHEET_PI";
  public static final String ER_NOT_SUPPORTED = "ER_NOT_SUPPORTED";
  public static final String ER_PROPERTY_VALUE_BOOLEAN = 
	 "ER_PROPERTY_VALUE_BOOLEAN";
  public static final String ER_COULD_NOT_FIND_EXTERN_SCRIPT = 
	 "ER_COULD_NOT_FIND_EXTERN_SCRIPT";
  public static final String ER_RESOURCE_COULD_NOT_FIND = 
	 "ER_RESOURCE_COULD_NOT_FIND";
  public static final String ER_OUTPUT_PROPERTY_NOT_RECOGNIZED = 
	 "ER_OUTPUT_PROPERTY_NOT_RECOGNIZED";
  public static final String ER_FAILED_CREATING_ELEMLITRSLT = 
	 "ER_FAILED_CREATING_ELEMLITRSLT";
  public static final String ER_VALUE_SHOULD_BE_NUMBER = 
	 "ER_VALUE_SHOULD_BE_NUMBER";
  public static final String ER_VALUE_SHOULD_EQUAL = "ER_VALUE_SHOULD_EQUAL";
  public static final String ER_FAILED_CALLING_METHOD = 
	 "ER_FAILED_CALLING_METHOD";
  public static final String ER_FAILED_CREATING_ELEMTMPL = 
	 "ER_FAILED_CREATING_ELEMTMPL";
  public static final String ER_CHARS_NOT_ALLOWED = "ER_CHARS_NOT_ALLOWED";
  public static final String ER_ATTR_NOT_ALLOWED = "ER_ATTR_NOT_ALLOWED";
  public static final String ER_BAD_VALUE = "ER_BAD_VALUE";
  public static final String ER_ATTRIB_VALUE_NOT_FOUND = 
	 "ER_ATTRIB_VALUE_NOT_FOUND";
  public static final String ER_ATTRIB_VALUE_NOT_RECOGNIZED = 
	 "ER_ATTRIB_VALUE_NOT_RECOGNIZED";
  public static final String ER_NULL_URI_NAMESPACE = "ER_NULL_URI_NAMESPACE";
  public static final String ER_NUMBER_TOO_BIG = "ER_NUMBER_TOO_BIG";
  public static final String  ER_CANNOT_FIND_SAX1_DRIVER = 
	 "ER_CANNOT_FIND_SAX1_DRIVER";
  public static final String  ER_SAX1_DRIVER_NOT_LOADED = 
	 "ER_SAX1_DRIVER_NOT_LOADED";
  public static final String  ER_SAX1_DRIVER_NOT_INSTANTIATED = 
	 "ER_SAX1_DRIVER_NOT_INSTANTIATED" ;
  public static final String ER_SAX1_DRIVER_NOT_IMPLEMENT_PARSER = 
	 "ER_SAX1_DRIVER_NOT_IMPLEMENT_PARSER";
  public static final String  ER_PARSER_PROPERTY_NOT_SPECIFIED = 
	 "ER_PARSER_PROPERTY_NOT_SPECIFIED";
  public static final String  ER_PARSER_ARG_CANNOT_BE_NULL = 
	 "ER_PARSER_ARG_CANNOT_BE_NULL" ;
  public static final String  ER_FEATURE = "ER_FEATURE";
  public static final String ER_PROPERTY = "ER_PROPERTY" ;
  public static final String ER_NULL_ENTITY_RESOLVER ="ER_NULL_ENTITY_RESOLVER";
  public static final String  ER_NULL_DTD_HANDLER = "ER_NULL_DTD_HANDLER" ;
  public static final String ER_NO_DRIVER_NAME_SPECIFIED = 
	 "ER_NO_DRIVER_NAME_SPECIFIED";
  public static final String ER_NO_URL_SPECIFIED = "ER_NO_URL_SPECIFIED";
  public static final String ER_POOLSIZE_LESS_THAN_ONE = 
	 "ER_POOLSIZE_LESS_THAN_ONE";
  public static final String ER_INVALID_DRIVER_NAME = "ER_INVALID_DRIVER_NAME";
  public static final String ER_ERRORLISTENER = "ER_ERRORLISTENER";
  public static final String ER_ASSERT_NO_TEMPLATE_PARENT = 
	 "ER_ASSERT_NO_TEMPLATE_PARENT";
  public static final String ER_ASSERT_REDUNDENT_EXPR_ELIMINATOR = 
	 "ER_ASSERT_REDUNDENT_EXPR_ELIMINATOR";
  public static final String ER_NOT_ALLOWED_IN_POSITION = 
	 "ER_NOT_ALLOWED_IN_POSITION";
  public static final String ER_NONWHITESPACE_NOT_ALLOWED_IN_POSITION = 
	 "ER_NONWHITESPACE_NOT_ALLOWED_IN_POSITION";
  public static final String ER_NAMESPACE_CONTEXT_NULL_NAMESPACE =
  	 "ER_NAMESPACE_CONTEXT_NULL_NAMESPACE";
  public static final String ER_NAMESPACE_CONTEXT_NULL_PREFIX =
 	 "ER_NAMESPACE_CONTEXT_NULL_PREFIX";
  public static final String ER_XPATH_RESOLVER_NULL_QNAME =
	 "ER_XPATH_RESOLVER_NULL_QNAME";
  public static final String ER_XPATH_RESOLVER_NEGATIVE_ARITY =
	 "ER_XPATH_RESOLVER_NEGATIVE_ARITY";
  public static final String INVALID_TCHAR = "INVALID_TCHAR";
  public static final String INVALID_QNAME = "INVALID_QNAME";
  public static final String INVALID_ENUM = "INVALID_ENUM";
  public static final String INVALID_NMTOKEN = "INVALID_NMTOKEN";
  public static final String INVALID_NCNAME = "INVALID_NCNAME";
  public static final String INVALID_BOOLEAN = "INVALID_BOOLEAN";
  public static final String INVALID_NUMBER = "INVALID_NUMBER";
  public static final String ER_ARG_LITERAL = "ER_ARG_LITERAL";
  public static final String ER_DUPLICATE_GLOBAL_VAR ="ER_DUPLICATE_GLOBAL_VAR";
  public static final String ER_DUPLICATE_VAR = "ER_DUPLICATE_VAR";
  public static final String ER_TEMPLATE_NAME_MATCH = "ER_TEMPLATE_NAME_MATCH";
  public static final String ER_INVALID_PREFIX = "ER_INVALID_PREFIX";
  public static final String ER_NO_ATTRIB_SET = "ER_NO_ATTRIB_SET";
  public static final String ER_FUNCTION_NOT_FOUND = 
	 "ER_FUNCTION_NOT_FOUND"; 
  public static final String ER_CANT_HAVE_CONTENT_AND_SELECT = 
     "ER_CANT_HAVE_CONTENT_AND_SELECT";
  public static final String ER_INVALID_SET_PARAM_VALUE = "ER_INVALID_SET_PARAM_VALUE";    
  public static final String ER_SET_FEATURE_NULL_NAME =
  	"ER_SET_FEATURE_NULL_NAME";
  public static final String ER_GET_FEATURE_NULL_NAME =
  	"ER_GET_FEATURE_NULL_NAME";
  public static final String ER_UNSUPPORTED_FEATURE =
  	"ER_UNSUPPORTED_FEATURE";
  public static final String ER_EXTENSION_ELEMENT_NOT_ALLOWED_IN_SECURE_PROCESSING =
  	"ER_EXTENSION_ELEMENT_NOT_ALLOWED_IN_SECURE_PROCESSING";
     
  public static final String WG_FOUND_CURLYBRACE = "WG_FOUND_CURLYBRACE";
  public static final String WG_COUNT_ATTRIB_MATCHES_NO_ANCESTOR = 
	 "WG_COUNT_ATTRIB_MATCHES_NO_ANCESTOR";
  public static final String WG_EXPR_ATTRIB_CHANGED_TO_SELECT = 
	 "WG_EXPR_ATTRIB_CHANGED_TO_SELECT";
  public static final String WG_NO_LOCALE_IN_FORMATNUMBER = 
	 "WG_NO_LOCALE_IN_FORMATNUMBER";
  public static final String WG_LOCALE_NOT_FOUND = "WG_LOCALE_NOT_FOUND";
  public static final String WG_CANNOT_MAKE_URL_FROM ="WG_CANNOT_MAKE_URL_FROM";
  public static final String WG_CANNOT_LOAD_REQUESTED_DOC = 
	 "WG_CANNOT_LOAD_REQUESTED_DOC";
  public static final String WG_CANNOT_FIND_COLLATOR ="WG_CANNOT_FIND_COLLATOR";
  public static final String WG_FUNCTIONS_SHOULD_USE_URL = 
	 "WG_FUNCTIONS_SHOULD_USE_URL";
  public static final String WG_ENCODING_NOT_SUPPORTED_USING_UTF8 = 
	 "WG_ENCODING_NOT_SUPPORTED_USING_UTF8";
  public static final String WG_ENCODING_NOT_SUPPORTED_USING_JAVA = 
	 "WG_ENCODING_NOT_SUPPORTED_USING_JAVA";
  public static final String WG_SPECIFICITY_CONFLICTS = 
	 "WG_SPECIFICITY_CONFLICTS";
  public static final String WG_PARSING_AND_PREPARING = 
	 "WG_PARSING_AND_PREPARING";
  public static final String WG_ATTR_TEMPLATE = "WG_ATTR_TEMPLATE";
  public static final String WG_CONFLICT_BETWEEN_XSLSTRIPSPACE_AND_XSLPRESERVESPACE = "WG_CONFLICT_BETWEEN_XSLSTRIPSPACE_AND_XSLPRESERVESP";
  public static final String WG_ATTRIB_NOT_HANDLED = "WG_ATTRIB_NOT_HANDLED";
  public static final String WG_NO_DECIMALFORMAT_DECLARATION = 
	 "WG_NO_DECIMALFORMAT_DECLARATION";
  public static final String WG_OLD_XSLT_NS = "WG_OLD_XSLT_NS";
  public static final String WG_ONE_DEFAULT_XSLDECIMALFORMAT_ALLOWED = 
	 "WG_ONE_DEFAULT_XSLDECIMALFORMAT_ALLOWED";
  public static final String WG_XSLDECIMALFORMAT_NAMES_MUST_BE_UNIQUE = 
	 "WG_XSLDECIMALFORMAT_NAMES_MUST_BE_UNIQUE";
  public static final String WG_ILLEGAL_ATTRIBUTE = "WG_ILLEGAL_ATTRIBUTE";
  public static final String WG_COULD_NOT_RESOLVE_PREFIX = 
	 "WG_COULD_NOT_RESOLVE_PREFIX";
  public static final String WG_STYLESHEET_REQUIRES_VERSION_ATTRIB = 
	 "WG_STYLESHEET_REQUIRES_VERSION_ATTRIB";
  public static final String WG_ILLEGAL_ATTRIBUTE_NAME = 
	 "WG_ILLEGAL_ATTRIBUTE_NAME";
  public static final String WG_ILLEGAL_ATTRIBUTE_VALUE = 
	 "WG_ILLEGAL_ATTRIBUTE_VALUE";
  public static final String WG_EMPTY_SECOND_ARG = "WG_EMPTY_SECOND_ARG";
  public static final String WG_PROCESSINGINSTRUCTION_NAME_CANT_BE_XML = 
	 "WG_PROCESSINGINSTRUCTION_NAME_CANT_BE_XML";
  public static final String WG_PROCESSINGINSTRUCTION_NOTVALID_NCNAME = 
	 "WG_PROCESSINGINSTRUCTION_NOTVALID_NCNAME";
  public static final String WG_ILLEGAL_ATTRIBUTE_POSITION = 
	 "WG_ILLEGAL_ATTRIBUTE_POSITION";
  public static final String NO_MODIFICATION_ALLOWED_ERR = 
         "NO_MODIFICATION_ALLOWED_ERR";

  /*
   * Now fill in the message text.
   * Then fill in the message text for that message code in the
   * array. Use the new error code as the index into the array.
   */

  // Error messages...

  /** Get the lookup table for error messages.   
   *
   * @return The int to message lookup table.
   */
  public Object[][] getContents()
  {
    return new Object[][] {

  /** Error message ID that has a null message, but takes in a single object.    */
  {"ER0000" , "{0}" },

    { ER_NO_CURLYBRACE,                            
      "Erro: n\u00e3o \u00e9 poss\u00edvel ter ''{'' dentro da express\u00e3o"},

    { ER_ILLEGAL_ATTRIBUTE , 
     "{0} possui um atributo ilegal: {1}"},

  {ER_NULL_SOURCENODE_APPLYIMPORTS ,
      "sourceNode \u00e9 nulo em xsl:apply-imports!"},

  {ER_CANNOT_ADD,
      "N\u00e3o \u00e9 poss\u00edvel adicionar {0} a {1}"},

    { ER_NULL_SOURCENODE_HANDLEAPPLYTEMPLATES, 
      "sourceNode \u00e9 nulo em handleApplyTemplatesInstruction!"},

    { ER_NO_NAME_ATTRIB, 
     "{0} deve ter um atributo de nome."},

    {ER_TEMPLATE_NOT_FOUND,
     "N\u00e3o foi poss\u00edvel encontrar o modelo denominado: {0}"},

    {ER_CANT_RESOLVE_NAME_AVT,
      "N\u00e3o foi poss\u00edvel resolver o nome AVT em xsl:call-template."},

    {ER_REQUIRES_ATTRIB,
     "{0} requer atributo: {1}"},

    { ER_MUST_HAVE_TEST_ATTRIB, 
      "{0} deve ter um atributo ''test''."},

    {ER_BAD_VAL_ON_LEVEL_ATTRIB,
      "Valor incorreto no atributo de n\u00edvel: {0}"},

    {ER_PROCESSINGINSTRUCTION_NAME_CANT_BE_XML, 
      "o nome da instru\u00e7\u00e3o de processamento n\u00e3o pode ser ''xml''"},

    { ER_PROCESSINGINSTRUCTION_NOTVALID_NCNAME,
      "o nome da instru\u00e7\u00e3o de processamento deve ser um NCName v\u00e1lido: {0}"},

    { ER_NEED_MATCH_ATTRIB,
      "{0} deve ter um atributo de correspond\u00eancia se tiver um modo."},

    { ER_NEED_NAME_OR_MATCH_ATTRIB,
      "{0} precisa de um nome ou de um atributo de correspond\u00eancia."},

    {ER_CANT_RESOLVE_NSPREFIX,
      "N\u00e3o \u00e9 poss\u00edvel resolver o prefixo do namespace: {0}"},

    { ER_ILLEGAL_VALUE,
     "xml:space possui um valor ilegal: {0}"},

    { ER_NO_OWNERDOC,
      "O n\u00f3 filho n\u00e3o possui um documento de propriet\u00e1rio!"},

    { ER_ELEMTEMPLATEELEM_ERR,
     "Erro de ElemTemplateElement: {0}"},

    { ER_NULL_CHILD,
     "Tentativa de adicionar um filho nulo!"},

    { ER_NEED_SELECT_ATTRIB,
     "{0} precisa de um atributo de sele\u00e7\u00e3o."},

    { ER_NEED_TEST_ATTRIB ,
      "xsl:when deve ter um atributo ''test''."},

    { ER_NEED_NAME_ATTRIB,
      "xsl:with-param deve ter um atributo ''name''."},

    { ER_NO_CONTEXT_OWNERDOC,
      "o contexto n\u00e3o possui um documento de propriet\u00e1rio!"},

    {ER_COULD_NOT_CREATE_XML_PROC_LIAISON,
      "N\u00e3o foi poss\u00edvel criar a liga\u00e7\u00e3o TransformerFactory XML: {0}"},

    {ER_PROCESS_NOT_SUCCESSFUL,
      "Xalan: o processo n\u00e3o foi bem sucedido."},

    { ER_NOT_SUCCESSFUL,
     "Xalan: n\u00e3o foi bem sucedido."},

    { ER_ENCODING_NOT_SUPPORTED,
     "Codifica\u00e7\u00e3o n\u00e3o suportada: {0}"},

    {ER_COULD_NOT_CREATE_TRACELISTENER,
      "N\u00e3o foi poss\u00edvel criar TraceListener: {0}"},

    {ER_KEY_REQUIRES_NAME_ATTRIB,
      "xsl:key precisa de um atributo ''name''!"},

    { ER_KEY_REQUIRES_MATCH_ATTRIB,
      "xsl:key precisa de um atributo ''match''!"},

    { ER_KEY_REQUIRES_USE_ATTRIB,
      "xsl:key precisa de um atributo ''use''!"},

    { ER_REQUIRES_ELEMENTS_ATTRIB,
      "(StylesheetHandler) {0} precisa de um atributo ''elements''!"},

    { ER_MISSING_PREFIX_ATTRIB,
      "(StylesheetHandler) {0} falta o atributo ''prefix''"},

    { ER_BAD_STYLESHEET_URL,
     "O URL da folha de estilos \u00e9 incorreto: {0}"},

    { ER_FILE_NOT_FOUND,
     "O arquivo de folha de estilos n\u00e3o foi encontrado: {0}"},

    { ER_IOEXCEPTION,
      "Houve exce\u00e7\u00e3o de ES com o arquivo de folha de estilos: {0}"},

    { ER_NO_HREF_ATTRIB, 
      "(StylesheetHandler) N\u00e3o foi poss\u00edvel encontrar o atributo href para {0}"},

    { ER_STYLESHEET_INCLUDES_ITSELF, 
      "(StylesheetHandler) {0} est\u00e1 incluindo a si mesmo direta ou indiretamente!"},

    { ER_PROCESSINCLUDE_ERROR,
      "Erro de StylesheetHandler.processInclude, {0}"},

    { ER_MISSING_LANG_ATTRIB,
      "(StylesheetHandler) Est\u00e1 faltando o atributo ''lang'' de {0} "},

    { ER_MISSING_CONTAINER_ELEMENT_COMPONENT,
      "(StylesheetHandler) elemento {0} mal colocado?? Falta o elemento de cont\u00eainer ''component''"},

    { ER_CAN_ONLY_OUTPUT_TO_ELEMENT,
      "\u00c9 poss\u00edvel exibir somente Element, DocumentFragment, Document ou PrintWriter."},

    { ER_PROCESS_ERROR,
     "Erro de StylesheetRoot.process"},

    { ER_UNIMPLNODE_ERROR,
     "Erro de UnImplNode: {0}"},

    { ER_NO_SELECT_EXPRESSION,
      "Erro! A express\u00e3o de sele\u00e7\u00e3o xpath n\u00e3o foi encontrada (-select)."},

    { ER_CANNOT_SERIALIZE_XSLPROCESSOR, 
      "N\u00e3o \u00e9 poss\u00edvel serializar um XSLProcessor!"},

    { ER_NO_INPUT_STYLESHEET,
      "A entrada da folha de estilos n\u00e3o foi especificada!"},

    { ER_FAILED_PROCESS_STYLESHEET,
      "O processo da folha de estilos falhou!"},

    { ER_COULDNT_PARSE_DOC,       
     "N\u00e3o foi poss\u00edvel processar o documento {0}!"},

    { ER_COULDNT_FIND_FRAGMENT,
     "N\u00e3o foi poss\u00edvel encontrar o fragmento: {0}"},

    { ER_NODE_NOT_ELEMENT,
      "O n\u00f3 indicado pelo identificador de fragmento n\u00e3o era um elemento: {0}"},

    { ER_FOREACH_NEED_MATCH_OR_NAME_ATTRIB,
      "for-each deve ter um atributo de correspond\u00eancia ou nome"},

    { ER_TEMPLATES_NEED_MATCH_OR_NAME_ATTRIB, 
      "os modelos devem ter um atributo de correspond\u00eancia ou nome"},

    { ER_NO_CLONE_OF_DOCUMENT_FRAG,
      "Nenhum clone de um fragmento de documento!"},

    { ER_CANT_CREATE_ITEM,
      "N\u00e3o \u00e9 poss\u00edvel criar item na \u00e1rvore de resultados: {0}"},

    { ER_XMLSPACE_ILLEGAL_VALUE,
      "xml:space no XML fonte tem um valor ilegal: {0}"},

    { ER_NO_XSLKEY_DECLARATION,
      "N\u00e3o h\u00e1 nenhuma declara\u00e7\u00e3o xsl:key para {0}!"},

    { ER_CANT_CREATE_URL, 
     "Erro! N\u00e3o \u00e9 poss\u00edvel criar url para: {0}"},

    { ER_XSLFUNCTIONS_UNSUPPORTED,
     "xsl:functions n\u00e3o \u00e9 suportado"},

    { ER_PROCESSOR_ERROR, 
     "Erro de TransformerFactory XSLT"},

    { ER_NOT_ALLOWED_INSIDE_STYLESHEET,
      "(StylesheetHandler) {0} n\u00e3o permitido dentro de uma folha de estilos!"},

    { ER_RESULTNS_NOT_SUPPORTED, 
      "result-ns n\u00e3o \u00e9 mais suportado!  Em vez disso, use xsl:output."},

    { ER_DEFAULTSPACE_NOT_SUPPORTED, 
      "default-space n\u00e3o \u00e9 mais suportado!  Em vez disso, use xsl:strip-space ou xsl:preserve-space."},

    { ER_INDENTRESULT_NOT_SUPPORTED,
      "indent-result n\u00e3o \u00e9 mais suportado!  Em vez disso, use xsl:output."},

    { ER_ILLEGAL_ATTRIB,
      "(StylesheetHandler) {0} possui um atributo ilegal: {1}"},

    { ER_UNKNOWN_XSL_ELEM,
     "Elemento XSL desconhecido: {0}"},

    { ER_BAD_XSLSORT_USE,
      "(StylesheetHandler) xsl:sort pode ser usado somente com xsl:apply-templates ou xsl:for-each."},

    { ER_MISPLACED_XSLWHEN,
      "(StylesheetHandler) xsl:when mal colocado!"},

    { ER_XSLWHEN_NOT_PARENTED_BY_XSLCHOOSE,
      "(StylesheetHandler) xsl:when n\u00e3o relacionado a xsl:choose!"},

    { ER_MISPLACED_XSLOTHERWISE,
      "(StylesheetHandler) xsl:otherwise mal colocado!"},

    { ER_XSLOTHERWISE_NOT_PARENTED_BY_XSLCHOOSE,
      "(StylesheetHandler) xsl:otherwise n\u00e3o relacionado a xsl:choose!"},

    { ER_NOT_ALLOWED_INSIDE_TEMPLATE,
      "(StylesheetHandler) {0} n\u00e3o \u00e9 permitido dentro de um modelo!"},

    { ER_UNKNOWN_EXT_NS_PREFIX, 
      "(StylesheetHandler) {0} prefixo de namespace da extens\u00e3o {1} desconhecido"},

    { ER_IMPORTS_AS_FIRST_ELEM, 
      "(StylesheetHandler) As importa\u00e7\u00f5es podem ocorrer somente como os primeiros elementos na folha de estilos!"},

    { ER_IMPORTING_ITSELF,
      "(StylesheetHandler) {0} est\u00e1 importando a si mesmo direta ou indiretamente!"},

    { ER_XMLSPACE_ILLEGAL_VAL,
      "(StylesheetHandler) xml:space possui um valor ilegal: {0}"},

    { ER_PROCESSSTYLESHEET_NOT_SUCCESSFUL,
      "processStylesheet mal sucedido!"},

    { ER_SAX_EXCEPTION, 
     "Exce\u00e7\u00e3o de SAX"},

//  add this message to fix bug 21478
    { ER_FUNCTION_NOT_SUPPORTED, 
     "Fun\u00e7\u00e3o n\u00e3o suportada!"},

    { ER_XSLT_ERROR,
     "Erro de XSLT"},

    { ER_CURRENCY_SIGN_ILLEGAL,
      "o sinal de cifr\u00e3o n\u00e3o \u00e9 permitido na sequ\u00eancia do padr\u00e3o de formato"},

    { ER_DOCUMENT_FUNCTION_INVALID_IN_STYLESHEET_DOM,
      "Fun\u00e7\u00e3o de documento n\u00e3o suportada no DOM da folha de estilos!"},

    { ER_CANT_RESOLVE_PREFIX_OF_NON_PREFIX_RESOLVER,
      "N\u00e3o \u00e9 poss\u00edvel resolver o prefixo do solucionador sem prefixo!"},

    { ER_REDIRECT_COULDNT_GET_FILENAME,
      "Redirecionamento de extens\u00e3o: n\u00e3o foi poss\u00edvel obter o nome do arquivo - arquivo ou atributo de sele\u00e7\u00e3o devem retornar uma sequ\u00eancia v\u00e1lida."},

    { ER_CANNOT_BUILD_FORMATTERLISTENER_IN_REDIRECT,
      "N\u00e3o foi poss\u00edvel construir FormatterListener no Redirecionamento de extens\u00e3o!"},

    { ER_INVALID_PREFIX_IN_EXCLUDERESULTPREFIX,
      "P prefixo em exclude-result-prefixes n\u00e3o \u00e9 v\u00e1lido: {0}"},

    { ER_MISSING_NS_URI, 
      "Falta o URI de namespace do prefixo especificado"},

    { ER_MISSING_ARG_FOR_OPTION,
      "Falta o argumento da op\u00e7\u00e3o: {0}"},

    { ER_INVALID_OPTION,
     "Op\u00e7\u00e3o inv\u00e1lida: {0}"},

    { ER_MALFORMED_FORMAT_STRING,
     "Sequ\u00eancia de formato malformado: {0}"},

    { ER_STYLESHEET_REQUIRES_VERSION_ATTRIB,
      "xsl:stylesheet requer um atributo 'version'!"},

    { ER_ILLEGAL_ATTRIBUTE_VALUE,
      "Atributo: {0} possui um valor ilegal: {1}"},

    { ER_CHOOSE_REQUIRES_WHEN,
     "xsl:choose requer um xsl:when"},

    { ER_NO_APPLY_IMPORT_IN_FOR_EACH,
      "xsl:apply-imports n\u00e3o permitido em um xsl:for-each"},

    { ER_CANT_USE_DTM_FOR_OUTPUT,
      "N\u00e3o \u00e9 poss\u00edvel usar um DTMLiaison para um n\u00f3 DOM de sa\u00edda... passar um com.sun.org.apache.xpath.internal.DOM2Helper em vez disso!"},

    { ER_CANT_USE_DTM_FOR_INPUT,
      "N\u00e3o \u00e9 poss\u00edvel usar um DTMLiaison para um n\u00f3 DOM de entrada... passar um com.sun.org.apache.xpath.internal.DOM2Helper em vez disso!"},

    { ER_CALL_TO_EXT_FAILED,
      "A chamada ao elemento de extens\u00e3o falhou: {0}"},

    { ER_PREFIX_MUST_RESOLVE,
      "O prefixo deve ser convertido em um namespace: {0}"},

    { ER_INVALID_UTF16_SURROGATE,
      "Substituto de UTF-16 inv\u00e1lido detectado: {0} ?"},

    { ER_XSLATTRSET_USED_ITSELF,
      "xsl:attribute-set {0} usou a si mesmo, que provocar\u00e1 um loop infinito."},

    { ER_CANNOT_MIX_XERCESDOM,
      "N\u00e3o \u00e9 poss\u00edvel misturar entradas de Xerces-DOM com sa\u00eddas de Xerces-DOM!"},

    { ER_TOO_MANY_LISTENERS,
      "addTraceListenersToStylesheet - TooManyListenersException"},

    { ER_IN_ELEMTEMPLATEELEM_READOBJECT,
      "Em ElemTemplateElement.readObject: {0}"},

    { ER_DUPLICATE_NAMED_TEMPLATE,
      "Encontrado mais de um modelo nomeado: {0}"},

    { ER_INVALID_KEY_CALL,
      "Chamada de fun\u00e7\u00e3o inv\u00e1lida: chamadas recursivas de key() n\u00e3o s\u00e3o permitidas"},

    { ER_REFERENCING_ITSELF,
      "A vari\u00e1vel {0} est\u00e1 fazendo refer\u00eancia a si mesma direta ou indiretamente!"},

    { ER_ILLEGAL_DOMSOURCE_INPUT,
      "O n\u00f3 de entrada n\u00e3o pode ser nulo para um DOMSource de newTemplates!"},

    { ER_CLASS_NOT_FOUND_FOR_OPTION,
	"Arquivo de classe n\u00e3o encontrado para a op\u00e7\u00e3o {0}"},

    { ER_REQUIRED_ELEM_NOT_FOUND,
	"Elemento requerido n\u00e3o encontrado: {0}"},

    { ER_INPUT_CANNOT_BE_NULL,
	"InputStream n\u00e3o pode ser nulo"},

    { ER_URI_CANNOT_BE_NULL,
	"O URI n\u00e3o pode ser nulo"},

    { ER_FILE_CANNOT_BE_NULL,
	"O arquivo n\u00e3o pode ser nulo"},

    { ER_SOURCE_CANNOT_BE_NULL,
		"InputSource n\u00e3o pode ser nulo"},

    { ER_CANNOT_INIT_BSFMGR,
		"N\u00e3o foi poss\u00edvel inicializar o gerenciador BSF"},

    { ER_CANNOT_CMPL_EXTENSN,
		"N\u00e3o foi poss\u00edvel compilar a extens\u00e3o"},

    { ER_CANNOT_CREATE_EXTENSN,
      "N\u00e3o foi poss\u00edvel criar a extens\u00e3o: {0} por causa de: {1}"},

    { ER_INSTANCE_MTHD_CALL_REQUIRES,
      "A chamada do m\u00e9todo de inst\u00e2ncia ao m\u00e9todo {0} requer uma inst\u00e2ncia de Object como primeiro argumento"},

    { ER_INVALID_ELEMENT_NAME,
      "Nome de elemento inv\u00e1lido especificado {0}"},

    { ER_ELEMENT_NAME_METHOD_STATIC,
      "O m\u00e9todo de nome do elemento deve ser est\u00e1tico {0}"},

    { ER_EXTENSION_FUNC_UNKNOWN,
             "A fun\u00e7\u00e3o da extens\u00e3o {0} : {1} \u00e9 desconhecida"},

    { ER_MORE_MATCH_CONSTRUCTOR,
             "Mais de uma correspond\u00eancia \u00f3tima para o construtor de {0}"},

    { ER_MORE_MATCH_METHOD,
             "Mais de uma correspond\u00eancia \u00f3tima para o m\u00e9todo {0}"},

    { ER_MORE_MATCH_ELEMENT,
             "Mais de uma correspond\u00eancia \u00f3tima para o m\u00e9todo do elemento {0}"},

    { ER_INVALID_CONTEXT_PASSED,
             "Contexto inv\u00e1lido transferido para avaliar {0}"},

    { ER_POOL_EXISTS,
             "O conjunto j\u00e1 existe"},

    { ER_NO_DRIVER_NAME,
             "Nenhum nome de driver especificado"},

    { ER_NO_URL,
             "Nenhuma URL especificada"},

    { ER_POOL_SIZE_LESSTHAN_ONE,
             "O tamanho do conjunto \u00e9 menor que um!"},

    { ER_INVALID_DRIVER,
             "Nome de driver inv\u00e1lido especificado!"},

    { ER_NO_STYLESHEETROOT,
             "A raiz da folha de estilos n\u00e3o foi encontrada!"},

    { ER_ILLEGAL_XMLSPACE_VALUE,
         "Valor ilegal de xml:space"},

    { ER_PROCESSFROMNODE_FAILED,
         "processFromNode falhou"},

    { ER_RESOURCE_COULD_NOT_LOAD,
        "N\u00e3o foi poss\u00edvel carregar o recurso [ {0} ]: {1} \n {2} \t {3}"},

    { ER_BUFFER_SIZE_LESSTHAN_ZERO,
        "Tamanho do buffer <=0"},

    { ER_UNKNOWN_ERROR_CALLING_EXTENSION,
        "Erro desconhecido ao chamar a extens\u00e3o"},

    { ER_NO_NAMESPACE_DECL,
        "O prefixo {0} n\u00e3o possui uma declara\u00e7\u00e3o de namespace correspondente"},

    { ER_ELEM_CONTENT_NOT_ALLOWED,
        "Conte\u00fado do elemento n\u00e3o permitido para lang=javaclass {0}"},

    { ER_STYLESHEET_DIRECTED_TERMINATION,
        "A folha de estilos ordenou o t\u00e9rmino"},

    { ER_ONE_OR_TWO,
        "1 ou 2"},

    { ER_TWO_OR_THREE,
        "2 ou 3"},

    { ER_COULD_NOT_LOAD_RESOURCE,
        "N\u00e3o foi poss\u00edvel carregar {0} (verificar CLASSPATH), usando agora apenas os padr\u00f5es"},

    { ER_CANNOT_INIT_DEFAULT_TEMPLATES,
        "N\u00e3o foi poss\u00edvel inicializar os modelos padr\u00e3o"},

    { ER_RESULT_NULL,
        "O resultado n\u00e3o deve ser nulo"},

    { ER_RESULT_COULD_NOT_BE_SET,
        "N\u00e3o foi poss\u00edvel definir o resultado"},

    { ER_NO_OUTPUT_SPECIFIED,
        "Nenhuma sa\u00edda especificada"},

    { ER_CANNOT_TRANSFORM_TO_RESULT_TYPE,
        "N\u00e3o \u00e9 poss\u00edvel transformar em um resultado de tipo {0}"},

    { ER_CANNOT_TRANSFORM_SOURCE_TYPE,
        "N\u00e3o \u00e9 poss\u00edvel transformar uma fonte de tipo {0}"},

    { ER_NULL_CONTENT_HANDLER,
        "Manipulador de conte\u00fado nulo"},

    { ER_NULL_ERROR_HANDLER,
        "Manipulador de erros nulo"},

    { ER_CANNOT_CALL_PARSE,
        "a an\u00e1lise n\u00e3o pode ser chamada se ContentHandler n\u00e3o tiver sido definido"},

    { ER_NO_PARENT_FOR_FILTER,
        "Nenhum pai para o filtro"},

    { ER_NO_STYLESHEET_IN_MEDIA,
         "Nenhuma folha de estilos encontrada em: {0}, m\u00eddia= {1}"},

    { ER_NO_STYLESHEET_PI,
         "Nenhuma PI xml-stylesheet encontrada em: {0}"},

    { ER_NOT_SUPPORTED,
       "N\u00e3o suportado: {0}"},

    { ER_PROPERTY_VALUE_BOOLEAN,
       "O valor de {0} deve ser uma inst\u00e2ncia booleana"},

    { ER_COULD_NOT_FIND_EXTERN_SCRIPT,
         "N\u00e3o foi poss\u00edvel obter script externo em {0}"},

    { ER_RESOURCE_COULD_NOT_FIND,
        "N\u00e3o foi poss\u00edvel encontrar o recurso [ {0} ].\n {1}"},

    { ER_OUTPUT_PROPERTY_NOT_RECOGNIZED,
        "Propriedade de sa\u00edda n\u00e3o reconhecida: {0}"},

    { ER_FAILED_CREATING_ELEMLITRSLT,
        "Falha ao criar a inst\u00e2ncia de ElemLiteralResult"},

  //Earlier (JDK 1.4 XALAN 2.2-D11) at key code '204' the key name was ER_PRIORITY_NOT_PARSABLE
  // In latest Xalan code base key name is  ER_VALUE_SHOULD_BE_NUMBER. This should also be taken care
  //in locale specific files like XSLTErrorResources_de.java, XSLTErrorResources_fr.java etc.
  //NOTE: Not only the key name but message has also been changed. 
    { ER_VALUE_SHOULD_BE_NUMBER,
        "O valor de {0} deve conter um n\u00famero analis\u00e1vel"},

    { ER_VALUE_SHOULD_EQUAL,
        "O valor de {0} deve ser igual a sim ou n\u00e3o"},

    { ER_FAILED_CALLING_METHOD,
        "Falha ao chamar o m\u00e9todo {0}"},

    { ER_FAILED_CREATING_ELEMTMPL,
        "Falha ao criar a inst\u00e2ncia de ElemTemplateElement"},

    { ER_CHARS_NOT_ALLOWED,
        "Caracteres n\u00e3o s\u00e3o permitidos neste ponto do documento"},

    { ER_ATTR_NOT_ALLOWED,
        "atributo \"{0}\" n\u00e3o \u00e9 permitido no elemento {1}!"},

    { ER_BAD_VALUE,
     "{0} possui valor inv\u00e1lido {1} "},

    { ER_ATTRIB_VALUE_NOT_FOUND,
     "Valor do atributo {0} n\u00e3o encontrado "},

    { ER_ATTRIB_VALUE_NOT_RECOGNIZED,
     "Valor do atributo {0} n\u00e3o reconhecido "},

    { ER_NULL_URI_NAMESPACE,
     "Tentativa de gerar um prefixo de namespace com um  URI nulo"},

    { ER_NUMBER_TOO_BIG,
     "Tentativa de formatar um n\u00famero superior ao maior inteiro Longo"},

    { ER_CANNOT_FIND_SAX1_DRIVER,
     "N\u00e3o \u00e9 poss\u00edvel encontrar a classe de driver SAX1 {0}"},

    { ER_SAX1_DRIVER_NOT_LOADED,
     "Classe de driver SAX1 {0} encontrada, mas n\u00e3o pode ser carregada"},

    { ER_SAX1_DRIVER_NOT_INSTANTIATED,
     "Classe de driver SAX1 {0} carregada, mas n\u00e3o pode ser instanciada"},

    { ER_SAX1_DRIVER_NOT_IMPLEMENT_PARSER,
     "A classe de driver SAX1 {0} n\u00e3o implementa org.xml.sax.Parser"},

    { ER_PARSER_PROPERTY_NOT_SPECIFIED,
     "Propriedade de sistema org.xml.sax.parser n\u00e3o especificada"},

    { ER_PARSER_ARG_CANNOT_BE_NULL,
     "O argumento do analisador n\u00e3o deve ser nulo"},

    { ER_FEATURE,
     "Recurso: {0}"},

    { ER_PROPERTY,
     "Propriedade: {0}"},

    { ER_NULL_ENTITY_RESOLVER,
     "Solucionado de entidade nulo"},

    { ER_NULL_DTD_HANDLER,
     "Manipulador de DTD nulo"},

    { ER_NO_DRIVER_NAME_SPECIFIED,
     "Nenhum nome de driver especificado!"},

    { ER_NO_URL_SPECIFIED,
     "Nenhuma URL especificada!"},

    { ER_POOLSIZE_LESS_THAN_ONE,
     "O tamanho do conjunto \u00e9 menor que 1!"},

    { ER_INVALID_DRIVER_NAME,
     "Nome de driver inv\u00e1lido especificado!"},

    { ER_ERRORLISTENER,
     "ErrorListener"},


// Note to translators:  The following message should not normally be displayed
//   to users.  It describes a situation in which the processor has detected
//   an internal consistency problem in itself, and it provides this message
//   for the developer to help diagnose the problem.  The name
//   'ElemTemplateElement' is the name of a class, and should not be
//   translated.
    { ER_ASSERT_NO_TEMPLATE_PARENT,
     "Erro do programador! A express\u00e3o n\u00e3o possui pai ElemTemplateElement!"},


// Note to translators:  The following message should not normally be displayed
//   to users.  It describes a situation in which the processor has detected
//   an internal consistency problem in itself, and it provides this message
//   for the developer to help diagnose the problem.  The substitution text
//   provides further information in order to diagnose the problem.  The name
//   'RedundentExprEliminator' is the name of a class, and should not be
//   translated.
    { ER_ASSERT_REDUNDENT_EXPR_ELIMINATOR,
     "Afirma\u00e7\u00e3o do programador em RedundentExprEliminator: {0}"},

    { ER_NOT_ALLOWED_IN_POSITION,
     "{0} n\u00e3o \u00e9 permitido nesta posi\u00e7\u00e3o na folha de estilos!"},

    { ER_NONWHITESPACE_NOT_ALLOWED_IN_POSITION,
     "N\u00e3o \u00e9 permitido texto sem espa\u00e7os em branco nesta posi\u00e7\u00e3o na folha de estilo!"},

  // This code is shared with warning codes.
  // SystemId Unknown
    { INVALID_TCHAR,
     "Valor ilegal: {1} usado para o atributo CHAR: {0}.  Um atributo de tipo CHAR deve ser somente 1 caractere!"},

    // Note to translators:  The following message is used if the value of
    // an attribute in a stylesheet is invalid.  "QNAME" is the XML data-type of
    // the attribute, and should not be translated.  The substitution text {1} is
    // the attribute value and {0} is the attribute name.
  //The following codes are shared with the warning codes...
    { INVALID_QNAME,
     "Valor ilegal: {1} usado para o atributo QNAME: {0}"},

    // Note to translators:  The following message is used if the value of
    // an attribute in a stylesheet is invalid.  "ENUM" is the XML data-type of
    // the attribute, and should not be translated.  The substitution text {1} is
    // the attribute value, {0} is the attribute name, and {2} is a list of valid
    // values.
    { INVALID_ENUM,
     "Valor ilegal: {1} usado para o atributo ENUM: {0}.  Os valores v\u00e1lidos s\u00e3o: {2}."},

// Note to translators:  The following message is used if the value of
// an attribute in a stylesheet is invalid.  "NMTOKEN" is the XML data-type
// of the attribute, and should not be translated.  The substitution text {1} is
// the attribute value and {0} is the attribute name.
    { INVALID_NMTOKEN,
     "Valor ilegal: {1} usado para o atributo NMTOKEN: {0} "},

// Note to translators:  The following message is used if the value of
// an attribute in a stylesheet is invalid.  "NCNAME" is the XML data-type
// of the attribute, and should not be translated.  The substitution text {1} is
// the attribute value and {0} is the attribute name.
    { INVALID_NCNAME,
     "Valor ilegal: {1} usado para o atributo NCNAME: {0} "},

// Note to translators:  The following message is used if the value of
// an attribute in a stylesheet is invalid.  "boolean" is the XSLT data-type
// of the attribute, and should not be translated.  The substitution text {1} is
// the attribute value and {0} is the attribute name.
    { INVALID_BOOLEAN,
     "Valor ilegal: {1} usado para o atributo booleano: {0} "},

// Note to translators:  The following message is used if the value of
// an attribute in a stylesheet is invalid.  "number" is the XSLT data-type
// of the attribute, and should not be translated.  The substitution text {1} is
// the attribute value and {0} is the attribute name.
     { INVALID_NUMBER,
     "Valor ilegal: {1} usado para o atributo de n\u00famero: {0} "},


  // End of shared codes...

// Note to translators:  A "match pattern" is a special form of XPath expression
// that is used for matching patterns.  The substitution text is the name of
// a function.  The message indicates that when this function is referenced in
// a match pattern, its argument must be a string literal (or constant.)
// ER_ARG_LITERAL - new error message for bugzilla //5202
    { ER_ARG_LITERAL,
     "Argumento para {0} no padr\u00e3o de correspond\u00eancia deve ser um literal."},

// Note to translators:  The following message indicates that two definitions of
// a variable.  A "global variable" is a variable that is accessible everywher
// in the stylesheet.
// ER_DUPLICATE_GLOBAL_VAR - new error message for bugzilla #790
    { ER_DUPLICATE_GLOBAL_VAR,
     "Declara\u00e7\u00e3o de vari\u00e1vel global duplicada."},


// Note to translators:  The following message indicates that two definitions of
// a variable were encountered.
// ER_DUPLICATE_VAR - new error message for bugzilla #790
    { ER_DUPLICATE_VAR,
     "Declara\u00e7\u00e3o de vari\u00e1vel duplicada."},

    // Note to translators:  "xsl:template, "name" and "match" are XSLT keywords
    // which must not be translated.
    // ER_TEMPLATE_NAME_MATCH - new error message for bugzilla #789
    { ER_TEMPLATE_NAME_MATCH,
     "xsl:template deve ter um atributo de nome ou de correspond\u00eancia (ou ambos)"},

    // Note to translators:  "exclude-result-prefixes" is an XSLT keyword which
    // should not be translated.  The message indicates that a namespace prefix
    // encountered as part of the value of the exclude-result-prefixes attribute
    // was in error.
    // ER_INVALID_PREFIX - new error message for bugzilla #788
    { ER_INVALID_PREFIX,
     "P prefixo em exclude-result-prefixes n\u00e3o \u00e9 v\u00e1lido: {0}"},

    // Note to translators:  An "attribute set" is a set of attributes that can
    // be added to an element in the output document as a group.  The message
    // indicates that there was a reference to an attribute set named {0} that
    // was never defined.
    // ER_NO_ATTRIB_SET - new error message for bugzilla #782
    { ER_NO_ATTRIB_SET,
     "O attribute-set denominado {0} n\u00e3o existe"},
     
    // Note to translators:  This message indicates that there was a reference
    // to a function named {0} for which no function definition could be found.
    { ER_FUNCTION_NOT_FOUND,
     "A fun\u00e7\u00e3o denominada {0} n\u00e3o existe"},

    // Note to translators:  This message indicates that the XSLT instruction
    // that is named by the substitution text {0} must not contain other XSLT
    // instructions (content) or a "select" attribute.  The word "select" is
    // an XSLT keyword in this case and must not be translated.
    { ER_CANT_HAVE_CONTENT_AND_SELECT,
     "O elemento {0} n\u00e3o deve ter conte\u00fados e um atributo de sele\u00e7\u00e3o."},

    // Note to translators:  This message indicates that the value argument
    // of setParameter must be a valid Java Object.
    { ER_INVALID_SET_PARAM_VALUE,
     "O valor do par\u00e2metro {0} deve ser um objeto Java v\u00e1lido"},

    { ER_INVALID_NAMESPACE_URI_VALUE_FOR_RESULT_PREFIX_FOR_DEFAULT,
      "O atributo result-prefix de um elemento xsl:namespace-alias possui o valor '#default', mas n\u00e3o h\u00e1 nenhuma declara\u00e7\u00e3o do namespace padr\u00e3o no escopo do elemento"},

    { ER_INVALID_NAMESPACE_URI_VALUE_FOR_RESULT_PREFIX,
      "O atributo result-prefix de um elemento xsl:namespace-alias possui o valor ''{0}'', mas n\u00e3o h\u00e1 nenhuma declara\u00e7\u00e3o para o prefixo ''{0}'' no escopo do elemento"},

    { ER_SET_FEATURE_NULL_NAME,
      "O nome do recurso n\u00e3o pode ser nulo no TransformerFactory.setFeature(nome da sequ\u00eancia, valor booleano)."},
    
    { ER_GET_FEATURE_NULL_NAME,
      "O nome do recurso n\u00e3o pode ser nulo no TransformerFactory.getFeature(nome da sequ\u00eancia)."},
    
    { ER_UNSUPPORTED_FEATURE,
      "N\u00e3o \u00e9 poss\u00edvel definir o recurso ''{0}'' neste TransformerFactory."},
    
    { ER_EXTENSION_ELEMENT_NOT_ALLOWED_IN_SECURE_PROCESSING,
  	  "O uso do elemento de extens\u00e3o ''{0}'' n\u00e3o \u00e9 permitido quando o recurso de processamento seguro estiver definido como verdadeiro."},
    
    { ER_NAMESPACE_CONTEXT_NULL_NAMESPACE, 		
      "N\u00e3o \u00e9 poss\u00edvel obter o prefixo para um URI de namespace nulo."},

    { ER_NAMESPACE_CONTEXT_NULL_PREFIX, 		
      "N\u00e3o \u00e9 poss\u00edvel obter o URI de namespace para prefixo nulo."},

    { ER_XPATH_RESOLVER_NULL_QNAME, 		
      "O nome da fun\u00e7\u00e3o n\u00e3o pode ser nulo."},

    { ER_XPATH_RESOLVER_NEGATIVE_ARITY, 		
      "A aridade n\u00e3o pode ser negativa."},
  // Warnings...

    { WG_FOUND_CURLYBRACE,
      "Encontrado ''}'' mas n\u00e3o h\u00e1 nenhum modelo de atributo aberto!"},

    { WG_COUNT_ATTRIB_MATCHES_NO_ANCESTOR,
      "Aviso: o atributo de contagem n\u00e3o corresponde a um ancestral no xsl:number! Destino = {0}"},

    { WG_EXPR_ATTRIB_CHANGED_TO_SELECT,
      "Sintaxe antiga: o nome do atributo ''expr'' foi alterado por ''select''."},

    { WG_NO_LOCALE_IN_FORMATNUMBER,
      "Xalan ainda n\u00e3o manipula o nome de localidade na fun\u00e7\u00e3o format-number."},

    { WG_LOCALE_NOT_FOUND,
      "Aviso: n\u00e3o foi poss\u00edvel encontrar a localidade de xml:lang={0}"},

    { WG_CANNOT_MAKE_URL_FROM,
      "N\u00e3o \u00e9 poss\u00edvel criar URL de: {0}"},

    { WG_CANNOT_LOAD_REQUESTED_DOC,
      "N\u00e3o \u00e9 poss\u00edvel carregar o doc solicitado: {0}"},

    { WG_CANNOT_FIND_COLLATOR,
      "N\u00e3o foi poss\u00edvel encontrar intercalador para <sort xml:lang={0}"},

    { WG_FUNCTIONS_SHOULD_USE_URL,
      "Sintaxe antiga: a instru\u00e7\u00e3o das fun\u00e7\u00f5es deve ser uma url de {0}"},

    { WG_ENCODING_NOT_SUPPORTED_USING_UTF8,
      "codifica\u00e7\u00e3o n\u00e3o suportada: usando UTF-8"},

    { WG_ENCODING_NOT_SUPPORTED_USING_JAVA,
      "codifica\u00e7\u00e3o n\u00e3o suportada: {0}, usando Java {1}"},

    { WG_SPECIFICITY_CONFLICTS,
      "Encontrados conflitos de especifica\u00e7\u00e3o: o \u00faltimo {0} encontrado na folha de estilos ser\u00e1 usado."},

    { WG_PARSING_AND_PREPARING,
      "========= Analisando e preparando {0} =========="},

    { WG_ATTR_TEMPLATE,
     "Modelo de atributo, {0}"},

    { WG_CONFLICT_BETWEEN_XSLSTRIPSPACE_AND_XSLPRESERVESPACE,
      "Conflito de correspond\u00eancia entre xsl:strip-space e xsl:preserve-space"},

    { WG_ATTRIB_NOT_HANDLED,
      "Xalan ainda n\u00e3o manipula o atributo {0}!"},

    { WG_NO_DECIMALFORMAT_DECLARATION,
      "Nenhum declara\u00e7\u00e3o encontrada para o formato decimal: {0}"},

    { WG_OLD_XSLT_NS,
     "Namespace XSLT ausente ou incorreto. "},

    { WG_ONE_DEFAULT_XSLDECIMALFORMAT_ALLOWED,
      "Somente uma declara\u00e7\u00e3o xsl:decimal-format padr\u00e3o \u00e9 permitida."},

    { WG_XSLDECIMALFORMAT_NAMES_MUST_BE_UNIQUE,
      "Os nomes de xsl:decimal-format devem ser exclusivos. O nome \"{0}\" foi duplicado."},

    { WG_ILLEGAL_ATTRIBUTE,
      "{0} possui um atributo ilegal: {1}"},

    { WG_COULD_NOT_RESOLVE_PREFIX,
      "N\u00e3o foi poss\u00edvel resolver o prefixo de namespace: {0}. O n\u00f3 ser\u00e1 ignorado."},

    { WG_STYLESHEET_REQUIRES_VERSION_ATTRIB,
      "xsl:stylesheet requer um atributo 'version'!"},

    { WG_ILLEGAL_ATTRIBUTE_NAME,
      "Nome de atributo ilegal: {0}"},

    { WG_ILLEGAL_ATTRIBUTE_VALUE,
      "Valor ilegal usado para o atributo {0}: {1}"},

    { WG_EMPTY_SECOND_ARG,
      "O nodeset resultante do segundo argumento da fun\u00e7\u00e3o de documento est\u00e1 vazio. Retornar um node-set vazio."},

  //Following are the new WARNING keys added in XALAN code base after Jdk 1.4 (Xalan 2.2-D11)

    // Note to translators:  "name" and "xsl:processing-instruction" are keywords
    // and must not be translated.
    { WG_PROCESSINGINSTRUCTION_NAME_CANT_BE_XML,
      "O valor do atributo 'name' do nome xsl:processing-instruction n\u00e3o deve ser 'xml'"},

    // Note to translators:  "name" and "xsl:processing-instruction" are keywords
    // and must not be translated.  "NCName" is an XML data-type and must not be
    // translated.
    { WG_PROCESSINGINSTRUCTION_NOTVALID_NCNAME,
      "O valor do atributo ''name'' do nome xsl:processing-instruction deve ser um NCName v\u00e1lido: {0}"},

    // Note to translators:  This message is reported if the stylesheet that is
    // being processed attempted to construct an XML document with an attribute in a
    // place other than on an element.  The substitution text specifies the name of
    // the attribute.
    { WG_ILLEGAL_ATTRIBUTE_POSITION,
      "N\u00e3o \u00e9 poss\u00edvel adicionar o atributo {0} antes que n\u00f3s filhos ou depois que um elemento sejam produzidos.  O atributo ser\u00e1 ignorado."},

    { NO_MODIFICATION_ALLOWED_ERR,
      "\u00c9 feita uma tentativa de modificar um objeto onde n\u00e3o modifica\u00e7\u00f5es n\u00e3o s\u00e3o permitidas."
    },

    //Check: WHY THERE IS A GAP B/W NUMBERS in the XSLTErrorResources properties file?

  // Other miscellaneous text used inside the code...
  { "ui_language", "pt_BR"},
  {  "help_language",  "pt_BR" },
  {  "language",  "pt_BR" },
  { "BAD_CODE", "O par\u00e2metro de createMessage estava fora do limite"},
  {  "FORMAT_FAILED", "Exce\u00e7\u00e3o lan\u00e7ada durante a chamada a messageFormat"},
  {  "version", ">>>>>>> Vers\u00e3o Xalan "},
  {  "version2",  "<<<<<<<"},
  {  "yes", "sim"},
  { "line", "Linha #"},
  { "column","Coluna #"},
  { "xsldone", "XSLProcessor: conclu\u00eddo"},


  // Note to translators:  The following messages provide usage information
  // for the Xalan Process command line.  "Process" is the name of a Java class,
  // and should not be translated.
  { "xslProc_option", "Op\u00e7\u00f5es da classe Process da linha de comando de Xalan-J:"},
  { "xslProc_option", "Op\u00e7\u00f5es da classe Process da linha de comando de Xalan-J:"},
  { "xslProc_invalid_xsltc_option", "A op\u00e7\u00e3o {0} n\u00e3o \u00e9 suportada no modo XSLTC."},
  { "xslProc_invalid_xalan_option", "A op\u00e7\u00e3o {0} pode ser usada somente com -XSLTC."},
  { "xslProc_no_input", "Erro: nenhuma folha de estilos ou xml de entrada foram especificados. Execute este comando sem nenhuma op\u00e7\u00e3o para instru\u00e7\u00f5es de uso."},
  { "xslProc_common_options", "-Op\u00e7\u00f5es comuns-"},
  { "xslProc_xalan_options", "-Op\u00e7\u00f5es para Xalan-"},
  { "xslProc_xsltc_options", "-Op\u00e7\u00f5es para XSLTC-"},
  { "xslProc_return_to_continue", "(pressione <return> para continuar)"},

   // Note to translators: The option name and the parameter name do not need to
   // be translated. Only translate the messages in parentheses.  Note also that
   // leading whitespace in the messages is used to indent the usage information
   // for each option in the English messages.
   // Do not translate the keywords: XSLTC, SAX, DOM and DTM.
  { "optionXSLTC", "   [-XSLTC (usar XSLTC para transforma\u00e7\u00e3o)]"},
  { "optionIN", "   [-IN inputXMLURL]"},
  { "optionXSL", "   [-XSL XSLTransformationURL]"},
  { "optionOUT",  "   [-OUT outputFileName]"},
  { "optionLXCIN", "   [-LXCIN compiledStylesheetFileNameIn]"},
  { "optionLXCOUT", "   [-LXCOUT compiledStylesheetFileNameOutOut]"},
  { "optionPARSER", "   [-PARSER nome totalmente qualificado da classe do analisador liaison]"},
  {  "optionE", "   [-E (N\u00e3o expandir refs de entidade)]"},
  {  "optionV",  "   [-E (N\u00e3o expandir refs de entidade)]"},
  {  "optionQC", "   [-QC (Avisos de conflitos de padr\u00e3o silencioso)]"},
  {  "optionQ", "   [-Q  (Modo silencioso)]"},
  {  "optionLF", "   [-LF (Usar avan\u00e7os de linha somente na sa\u00edda {o padr\u00e3o \u00e9 CR/LF})]"},
  {  "optionCR", "   [-CR (Usar retornos de carro somente na sa\u00edda {o padr\u00e3o \u00e9 CR/LF})]"},
  { "optionESCAPE", "   [-ESCAPE (Quais caracteres de escape {o padr\u00e3o \u00e9 <>&\"\'\\r\\n}]"},
  { "optionINDENT", "   [-INDENT (Controlar como os espa\u00e7os s\u00e3o recuados {o padr\u00e3o \u00e9 0})]"},
  { "optionTT", "   [-TT (Rastrear os modelos enquanto est\u00e3o sendo chamados.)]"},
  { "optionTG", "   [-TG (Rastrear cada evento de gera\u00e7\u00e3o.)]"},
  { "optionTS", "   [-TS (Rastrear cada evento de sele\u00e7\u00e3o.)]"},
  {  "optionTTC", "   [-TTC (Rastrear os modelos filhos enquanto est\u00e3o sendo processados.)]"},
  { "optionTCLASS", "   [-TCLASS (Classe TraceListener para extens\u00f5es de rastreamento.)]"},
  { "optionVALIDATE", "   [-VALIDATE (Definir se a valida\u00e7\u00e3o ocorre.  A valida\u00e7\u00e3o est\u00e1 desativada por padr\u00e3o.)]"},
  { "optionEDUMP", "   [-EDUMP {nome de arquivo opcional} (Executar stackdump sob erro.)]"},
  {  "optionXML", "   [-XML (Usar formatador XML e adicionar cabe\u00e7alho XML.)]"},
  {  "optionTEXT", "   [-TEXT (Usar formatador de texto simples.)]"},
  {  "optionHTML", "   [-HTML (Usar formatador HTML.)]"},
  {  "optionPARAM", "   [-PARAM express\u00e3o de nome (Definir uma par\u00e2metro da folha de estilos)]"},
  {  "noParsermsg1", "O processo XSL n\u00e3o foi bem sucedido."},
  {  "noParsermsg2", "** N\u00e3o foi poss\u00edvel encontrar o analisador **"},
  { "noParsermsg3",  "Verifique seu classpath."},
  { "noParsermsg4", "Se n\u00e3o tiver o analisador XML da IBM para Java, voc\u00ea pode baix\u00e1-lo em"},
  { "noParsermsg5", "AlphaWorks da IBM: http://www.alphaworks.ibm.com/formula/xml"},
  { "optionURIRESOLVER", "   [-URIRESOLVER nome de classe completo (URIResolver a ser utilizado para resolver URIs)]"},
  { "optionENTITYRESOLVER",  "   [-ENTITYRESOLVER nome de classe completo (EntityResolver a ser utilizado para resolver entidades)]"},
  { "optionCONTENTHANDLER",  "   [-CONTENTHANDLER nome de classe completo (ContentHandler a ser utilizado para serializar a sa\u00edda)]"},
  {  "optionLINENUMBERS",  "   [-L usar n\u00fameros de linha no documento de origem]"},
  { "optionSECUREPROCESSING", "   [-SECURE (definir o processamento de seguran\u00e7a como verdadeiro.)]"},

    // Following are the new options added in XSLTErrorResources.properties files after Jdk 1.4 (Xalan 2.2-D11)


  {  "optionMEDIA",  "   [-MEDIA mediaType (usar atributo de m\u00eddia para encontrar a folha de estilos associada a um documento.)]"},
  {  "optionFLAVOR",  "   [-FLAVOR flavorName (Usar explicitamente s2s=SAX ou d2d=DOM para executar a transforma\u00e7\u00e3o.)] "}, // Added by sboag/scurcuru; experimental
  { "optionDIAG", "   [-DIAG (Exibir o total de milissegundos que a transforma\u00e7\u00e3o gastou.)]"},
  { "optionINCREMENTAL",  "   [-INCREMENTAL (solicitar constru\u00e7\u00e3o DTM incremental definindo http://xml.apache.org/xalan/features/incremental verdadeiro.)]"},
  {  "optionNOOPTIMIMIZE",  "   [-NOOPTIMIMIZE (solicitar processamento de otimiza\u00e7\u00e3o sem folha de estilos definindo http://xml.apache.org/xalan/features/optimize falso.)]"},
  { "optionRL",  "   [-RL recursionlimit (declarar limite num\u00e9rico na profundidade de recurs\u00e3o da folha de estilos.)]"},
  {   "optionXO",  "   [-XO [transletName] (atribuir nome ao translet gerado)]"},
  {  "optionXD", "   [-XD destinationDirectory (especificar um diret\u00f3rio de destino para o translet)]"},
  {  "optionXJ",  "   [-XJ jarfile (empacota classes translet em um arquivo jar denominado <jarfile>)]"},
  {   "optionXP",  "   [-XP package (especifica um prefixo de nome de pacote para todas as classes translet geradas)]"},

  //AddITIONAL  STRINGS that need L10n
  // Note to translators:  The following message describes usage of a particular
  // command-line option that is used to enable the "template inlining"
  // optimization.  The optimization involves making a copy of the code
  // generated for a template in another template that refers to it.
  { "optionXN",  "   [-XN (ativa a sequ\u00eancia de modelo)]" },
  { "optionXX",  "   [-XX (ativa a sa\u00edda da mensagem de depura\u00e7\u00e3o adicional)]"},
  { "optionXT" , "   [-XT (usar translet para transforma\u00e7\u00e3o, se poss\u00edvel)]"},
  { "diagTiming"," --------- Transforma\u00e7\u00e3o de {0} via {1} demorou {2} ms" },
  { "recursionTooDeep","Aninhamento de modelo muito extenso. aninhamento = {0}, modelo {1} {2}" },
  { "nameIs", "o nome \u00e9" },
  { "matchPatternIs", "o padr\u00e3o de correspond\u00eancia \u00e9" }

  };
  }
  // ================= INFRASTRUCTURE ======================

  /** String for use when a bad error code was encountered.    */
  public static final String BAD_CODE = "BAD_CODE";

  /** String for use when formatting of the error string failed.   */
  public static final String FORMAT_FAILED = "FORMAT_FAILED";

  /** General error string.   */
  public static final String ERROR_STRING = "#error";

  /** String to prepend to error messages.  */
  public static final String ERROR_HEADER = "Error: ";

  /** String to prepend to warning messages.    */
  public static final String WARNING_HEADER = "Warning: ";

  /** String to specify the XSLT module.  */
  public static final String XSL_HEADER = "XSLT ";

  /** String to specify the XML parser module.  */
  public static final String XML_HEADER = "XML ";

  /** I don't think this is used any more.
   * @deprecated  */
  public static final String QUERY_HEADER = "PATTERN ";



}
