package io.nicky.client.base.transformation.targets;

public enum TargetType {
    HEAD("HEAD"),
    RETURN("RETURN"),
    THROW("THROW"),
    TAIL("TAIL"),
    FIELD("FIELD"),
    INVOKE("INVOKE"),
    GET("GET"),
    SET("SET"),
    INIT("INIT"),
    OPCODE("OPCODE"),

    ;

    private final String name;

    TargetType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
