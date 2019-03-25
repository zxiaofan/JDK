/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.lir.util;

import java.util.function.BiConsumer;

import jdk.vm.ci.code.Architecture;
import jdk.vm.ci.code.Register;
import jdk.vm.ci.code.RegisterArray;

public class RegisterMap<T> {
    private final Object[] values;
    private final Architecture architecture;

    public RegisterMap(Architecture arch) {
        assert checkArchitecture(arch);
        this.values = new Object[arch.getRegisters().size()];
        this.architecture = arch;
    }

    @SuppressWarnings("unchecked")
    public T get(Register reg) {
        return (T) values[index(reg)];
    }

    public void remove(Register reg) {
        values[index(reg)] = null;
    }

    public void put(Register reg, T value) {
        values[index(reg)] = value;
    }

    @SuppressWarnings("unchecked")
    public void forEach(BiConsumer<? super Register, ? super T> consumer) {
        for (int i = 0; i < values.length; ++i) {
            T value = (T) values[i];
            if (value != null) {
                consumer.accept(architecture.getRegisters().get(i), value);
            }
        }
    }

    private static int index(Register reg) {
        return reg.number;
    }

    private static boolean checkArchitecture(Architecture arch) {
        RegisterArray registers = arch.getRegisters();
        for (int i = 0; i < registers.size(); ++i) {
            assert registers.get(i).number == i : registers.get(i) + ": " + registers.get(i).number + "!=" + i;
        }
        return true;
    }
}
