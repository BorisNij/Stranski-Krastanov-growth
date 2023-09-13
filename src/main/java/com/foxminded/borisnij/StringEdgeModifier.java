package com.foxminded.borisnij;

public class StringEdgeModifier implements CharSequence {
    private final StringBuilder input;

    public StringEdgeModifier(String input) {
        this.input = new StringBuilder(null != input ? input : "");
    }

    public StringEdgeModifier() {
        this("");
    }

    public StringEdgeModifier setValue(String value) {
        if (null != value && !value.isEmpty()) {
            input.setLength(0);
            input.append(value);
        }
        return this;
    }

    public StringEdgeModifier addPrefix(String prefix, int prefixRepeat) {
        if (prefixRepeat < 0) {
            throw new IllegalArgumentException("Prefix cannot be repeated a negative number of times");
        }
        if (null != prefix && !prefix.isEmpty()) {
            String currentInput = input.toString();
            input.setLength(0);
            input.append(prefix.repeat(prefixRepeat)).append(currentInput);
        }
        return this;
    }

    public StringEdgeModifier addPrefix(String prefix) {
        return this.addPrefix(prefix, 1);
    }

    public StringEdgeModifier addSuffix(String suffix, int suffixRepeat) {
        if (suffixRepeat < 0) {
            throw new IllegalArgumentException("Suffix cannot be repeated a negative number of times");
        }
        if (null != suffix && !suffix.isEmpty()) {
            input.append(suffix.repeat(suffixRepeat));
        }
        return this;
    }

    public StringEdgeModifier addSuffix(String suffix) {
        return this.addSuffix(suffix, 1);
    }

    @Override
    public int length() {
        return input.length();
    }

    @Override
    public char charAt(int index) {
        return input.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return input.subSequence(start, end);
    }

    @Override
    public String toString() {
        return input.toString();
    }
}
