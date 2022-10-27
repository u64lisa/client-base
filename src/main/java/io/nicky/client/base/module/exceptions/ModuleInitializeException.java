package io.nicky.client.base.module.exceptions;

import io.nicky.client.base.module.Module;

public final class ModuleInitializeException extends RuntimeException {

    public ModuleInitializeException(Module module) {
        super("Can't initialize module: " + module.getClass().getName());
    }

}
