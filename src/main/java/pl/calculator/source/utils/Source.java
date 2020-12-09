package pl.calculator.source.utils;

public enum Source {
    JAVA_API("JavaAPI"),
    RANDOM_ORG("random.org");

    private final String value;

    Source(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

}
