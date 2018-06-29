package model;

public class SizeRangeBuilder {
    private String sizeRange;

    public SizeRangeBuilder setSizeRange(String sizeRange) {
        this.sizeRange = sizeRange;
        return this;
    }

    public SizeRange createSizeRange() {
        return new SizeRange(sizeRange);
    }
}