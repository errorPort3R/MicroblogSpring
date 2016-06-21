package com.theironyard;

/**
 * Created by jeffryporter on 6/20/16.
 */
public class Message
{
    int id;
    String text;
    static int uniqueIdList = 10110;

    public Message(String text)
    {
        id = uniqueIdList;
        this.text = text;
        uniqueIdList++;
    }

    @Override
    public String toString()
    {
        return String.format("%s",text);
    }
}
