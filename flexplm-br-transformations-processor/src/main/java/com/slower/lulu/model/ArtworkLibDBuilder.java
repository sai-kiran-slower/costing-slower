package com.slower.lulu.model;

import com.slower.lulu.utils.Functions;

public class ArtworkLibDBuilder {
    private String memo3;
    private String colorPos;
    private String memo1;
    private String comboId;

    public void setMemo3(String memo3) {
        this.memo3 = Functions.charLimit(memo3, 10);
    }

    public void setColorPos(String colorPos) {
        if (colorPos.matches("ground"))
            this.colorPos = "0";
        else if (colorPos.matches("color[1-9]*$"))
            this.colorPos = colorPos.split("color")[1];
    }

    public void setMemo1(String memo1) {
        this.memo1 = Functions.charLimit(memo1, 10);
    }

    public void setComboId(String comboId) {
        this.comboId = Functions.charLimit(comboId, 10);
    }

    public ArtworkLibD createArtworkLibD() {
        return new ArtworkLibD(memo3, colorPos, memo1, comboId);
    }
}