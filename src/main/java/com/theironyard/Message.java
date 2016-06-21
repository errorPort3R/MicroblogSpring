package com.theironyard;

import javax.persistence.*;

/**
 * Created by jeffryporter on 6/20/16.
 */

@Entity
@Table(name = "messages")

public class Message
{
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;


    public Message()
    {
    }

    public Message(String text)
    {
        this.text = text;
    }

    public Message(int id, String text)
    {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString()
    {
        return String.format("%s",text);
    }
}
