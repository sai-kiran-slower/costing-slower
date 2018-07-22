package com.slower.lulu.model;

import com.slower.lulu.utils.Functions;

public class NoteBuilder extends Note{
    public NoteBuilder(final String text) {
        setNoteId("PROTOREVIEW");
        setText(Functions.charLimit(text, 4000));
    }
}