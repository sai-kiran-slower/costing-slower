package com.slower.lulu.model;

import com.slower.lulu.utils.Functions;
import io.swagger.client.model.SizeRange;

public class SizeRangeBuilder extends SizeRange {
    private String sizeRange;

    public void setSizeRange(final String sizeRange) {
        this.sizeRange = Functions.charLimit(sizeRange, 20);
    }

    public SizeRange createSizeRange() {
        return new SizeRange()
                .sizeRange(sizeRange);
    }
}