package com.example.rdb.utilities;

import com.example.rdb.DataBase.NoteEntiity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SampleData
{

    private static final String SAMPLE_TEXT_1="A simple note";
    private static final String SAMPLE_TEXT_2="A note with a \n line feed";
    private static final String SAMPLE_TEXT_3="Traditionally, a text is understood to be a \npiece of written or" +
            " spoken material in its primary form\n (as opposed to a paraphrase or summary). A text is" +
            " any stretch of language that can be \nunderstood in context. " +
            "It may be as simple as 1-2 words (such as a stop sign) or\n as complex as a novel";
    private static Date getdate(int diff)
    {
        GregorianCalendar cal=new GregorianCalendar();
        cal.add(Calendar.MILLISECOND,diff);
        return cal.getTime();

    }

    public static List<NoteEntiity> getnotes(){
        List<NoteEntiity> notes=new ArrayList<>();
        notes.add(new NoteEntiity(getdate(0),SAMPLE_TEXT_1));
        notes.add(new NoteEntiity(getdate(-1),SAMPLE_TEXT_2));
        notes.add(new NoteEntiity(getdate(-2),SAMPLE_TEXT_3));
        return notes;
    }
}
