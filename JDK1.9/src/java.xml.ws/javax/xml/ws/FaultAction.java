/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.ws;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The {@code FaultAction} annotation is used inside an {@link Action}
 * annotation to allow an explicit association of a WS-Addressing
 * {@code Action} message addressing property with the {@code fault}
 * messages of the WSDL operation mapped from the exception class.
 * <p>
 * The {@code wsam:Action} attribute value in the {@code fault}
 * message in the generated WSDL operation mapped for {@code className}
 * class is equal to the corresponding value in the {@code FaultAction}.
 * For the exact computation of {@code wsam:Action} values for the
 * fault messages, refer to the algorithm in the JAX-WS specification.
 *
 * <p>
 * <b>Example 1</b>: Specify explicit values for {@code Action} message addressing
 * property for the {@code input}, {@code output} and {@code fault} message
 * if the Java method throws only one service specific exception.
 *
 * <pre>
 * {@literal @}WebService(targetNamespace="http://example.com/numbers")
 *  public class AddNumbersImpl {
 *    {@literal @}Action(
 *         fault = {
 *             <b>{@literal @}FaultAction(className=AddNumbersException.class, value="http://example.com/faultAction")</b>
 *         })
 *     public int addNumbers(int number1, int number2)
 *         throws AddNumbersException {
 *         return number1 + number2;
 *     }
 * }
 * </pre>
 *
 * The generated WSDL looks like:
 *
 * <pre> {@code
 *   <definitions targetNamespace="http://example.com/numbers" ...>
 *     ...
 *     <portType name="AddNumbersPortType">
 *       <operation name="AddNumbers">
 *         ...
 *         <fault message="tns:AddNumbersException" name="AddNumbersException"}
 *           <b>wsam:Action="http://example.com/faultAction"</b>{@code />
 *       </operation>
 *     </portType>
 *     ...
 *   </definitions> }
 * </pre>
 *
 * <p>
 * Example 2: Here is an example that shows if the explicit value for {@code Action}
 * message addressing property for the service specific exception is not present.
 *
 * <pre>
 * {@literal @}WebService(targetNamespace="http://example.com/numbers")
 *  public class AddNumbersImpl {
 *     public int addNumbers(int number1, int number2)
 *         throws AddNumbersException {
 *         return number1 + number2;
 *     }
 *  }
 * </pre>
 *
 * The generated WSDL looks like:
 *
 * <pre>{@code
 *   <definitions targetNamespace="http://example.com/numbers" ...>
 *     ...
 *     <portType name="AddNumbersPortType">
 *       <operation name="AddNumbers">
 *         ...
 *         <fault message="tns:addNumbersFault" name="InvalidNumbers"}
 *           <b>wsam:Action="http://example.com/numbers/AddNumbersPortType/AddNumbers/Fault/AddNumbersException"</b>{@code />
 *       </operation>
 *     </portType>
 *     ...
 *   </definitions>
 * }</pre>
 *
 * <p>
 * Example 3: Here is an example that shows how to specify explicit values for {@code Action}
 * message addressing property if the Java method throws more than one service specific exception.
 *
 * <pre>
 * {@literal @}WebService(targetNamespace="http://example.com/numbers")
 *  public class AddNumbersImpl {
 *    {@literal @}Action(
 *         fault = {
 *             <b>{@literal @}FaultAction(className=AddNumbersException.class, value="http://example.com/addFaultAction"),
 *             {@literal @}FaultAction(className=TooBigNumbersException.class, value="http://example.com/toobigFaultAction")</b>
 *         })
 *     public int addNumbers(int number1, int number2)
 *         throws AddNumbersException, TooBigNumbersException {
 *         return number1 + number2;
 *     }
 *  }
 * </pre>
 *
 * The generated WSDL looks like:
 *
 * <pre> {@code
 *   <definitions targetNamespace="http://example.com/numbers" ...>
 *     ...
 *     <portType name="AddNumbersPortType">
 *       <operation name="AddNumbers">
 *         ...
 *         <fault message="tns:addNumbersFault" name="AddNumbersException"}
 *           <b>wsam:Action="http://example.com/addFaultAction"</b>{@code />
 *         <fault message="tns:tooBigNumbersFault" name="TooBigNumbersException"}
 *           <b>wsam:Action="http://example.com/toobigFaultAction"</b>{@code />
 *       </operation>
 *     </portType>
 *     ...
 *   </definitions>
 * }</pre>
 *
 * @since 1.6, JAX-WS 2.1
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FaultAction {
    /**
     * Name of the exception class.
     *
     * @return the name of the exception class
     */
    Class<? extends Exception> className();

    /**
     * Value of WS-Addressing {@code Action} message addressing property for the exception.
     *
     * @return WS-Addressing {@code Action} message addressing property for the exception
     */
    String value() default "";
}
