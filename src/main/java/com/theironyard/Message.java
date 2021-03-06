package com.theironyard;

import javax.persistence.*;

/**
 * Created by jeffryporter on 6/20/16.
 */

@Entity
@Table(name = "messages")

public class Message implements Comparable<Message>
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

    @Override
    public int compareTo(Message o)
    {
        if (this.id > o.id)
        {
            return -1;
        }
        if (this.id < o.id)
        {
            return 1;
        }
        return 0;
    }
}
