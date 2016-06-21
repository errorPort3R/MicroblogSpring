package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by jeffryporter on 6/20/16.
 */

@Controller
public class BlogController
{
    ArrayList<Message> messages = new ArrayList<>();


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session)
    {
        String username = (String)session.getAttribute("username");
        String user = null;
        if (username != null)
        {
            user = (username);
        }
        model.addAttribute("messages", messages);
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String username, HttpSession session, String text)
    {
        Message message = new Message(text);
        messages.add(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, HttpSession session)
    {
        session.setAttribute("username",username);

        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String delete(HttpSession session, int id)
    {
        String username = (String)session.getAttribute("username");
        for (int i=0;i<messages.size();i++)
        {
            if (messages.get(i).id == id)
            {
                messages.remove(i);
            }
        }
        return "redirect:/";
    }
}
