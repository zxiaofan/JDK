/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.ec;

import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.NamedParameterSpec;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class ParametersMap<T> {

    private Map<Integer, T> sizeMap = new HashMap<Integer, T>();
    private Map<ObjectIdentifier, T> oidMap =
        new HashMap<ObjectIdentifier, T>();
    private Map<String, T> nameMap = new HashMap<String, T>();


    public void fix() {

        sizeMap = Collections.unmodifiableMap(sizeMap);
        oidMap = Collections.unmodifiableMap(oidMap);
        nameMap = Collections.unmodifiableMap(nameMap);
    }

    public void put(String name, ObjectIdentifier oid, int size, T params) {
        nameMap.put(name.toLowerCase(), params);
        oidMap.put(oid, params);
        sizeMap.put(size, params);
    }

    public Optional<T> getByOid(ObjectIdentifier id) {
        return Optional.ofNullable(oidMap.get(id));
    }
    public Optional<T> getBySize(int size) {
        return Optional.ofNullable(sizeMap.get(size));
    }
    public Optional<T> getByName(String name) {
        return Optional.ofNullable(nameMap.get(name.toLowerCase()));
    }

    // Utility method that is used by the methods below to handle exception
    // suppliers
    private static
    <A, B> Supplier<B> apply(final Function<A, B> func, final A a) {
        return new Supplier<B>() {
            @Override
            public B get() {
                return func.apply(a);
            }
        };
    }

    /**
     * Get parameters by key size, or throw an exception if no parameters are
     * defined for the specified key size. This method is used in several
     * contexts that should throw different exceptions when the parameters
     * are not found. The first argument is a function that produces the
     * desired exception.
     *
     * @param exception a function that produces an exception from a string
     * @param size the desired key size
     * @param <E> the type of exception that is thrown
     * @return the parameters for the specified key size
     * @throws T when suitable parameters do not exist
     */
    public
    <E extends Throwable>
    T getBySize(Function<String, E> exception,
                              int size) throws E {

        Optional<T> paramsOpt = getBySize(size);
        return paramsOpt.orElseThrow(
            apply(exception, "Unsupported size: " + size));
    }

    /**
     * Get parameters by algorithm ID, or throw an exception if no
     * parameters are defined for the specified ID. This method is used in
     * several contexts that should throw different exceptions when the
     * parameters are not found. The first argument is a function that produces
     * the desired exception.
     *
     * @param exception a function that produces an exception from a string
     * @param algId the algorithm ID
     * @param <E> the type of exception that is thrown
     * @return the parameters for the specified algorithm ID
     * @throws E when suitable parameters do not exist
     */
    public
    <E extends Throwable>
    T get(Function<String, E> exception,
                        AlgorithmId algId) throws E {

        Optional<T> paramsOpt = getByOid(algId.getOID());
        return paramsOpt.orElseThrow(
            apply(exception, "Unsupported OID: " + algId.getOID()));
    }

    /**
     * Get parameters by algorithm parameter spec, or throw an exception if no
     * parameters are defined for the spec. This method is used in
     * several contexts that should throw different exceptions when the
     * parameters are not found. The first argument is a function that produces
     * the desired exception.
     *
     * @param exception a function that produces an exception from a string
     * @param params the algorithm parameters spec
     * @param <E> the type of exception that is thrown
     * @return the parameters for the spec
     * @throws E when suitable parameters do not exist
     */
    public
    <E extends Throwable>
    T get(Function<String, E> exception,
                        AlgorithmParameterSpec params) throws E {

        if (params instanceof NamedParameterSpec) {
            NamedParameterSpec namedParams = (NamedParameterSpec) params;
            Optional<T> paramsOpt = getByName(namedParams.getName());
            return paramsOpt.orElseThrow(
            apply(exception, "Unsupported name: " + namedParams.getName()));
        } else {
            throw exception.apply("Only NamedParameterSpec is supported.");
        }
    }
}
