package com.strumbystrum.controllers;

import com.strumbystrum.model.User;
import com.strumbystrum.persistence.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: neilpoulin
 * Date: 11/4/13
 * Time: 10:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping(value="/test/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld( @PathVariable(value = "name")String name )
    {

        return "Hello, " + name;

    }

    @RequestMapping(value="/name/{name}", method = RequestMethod.GET)
    public ModelAndView getView( @PathVariable(value = "name")String name ){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", name);

        mav.setViewName("/test/mytest");
        return mav;
    }

    @RequestMapping( value="/login", method=RequestMethod.GET )
    public ModelAndView getLogin( )
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping( value="/login", method=RequestMethod.POST)
    public ModelAndView login(@RequestParam( value="username" )String username, @RequestParam(value="password")String password, HttpServletRequest request )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        ModelAndView mav;

        mav = getLogin();
        session.beginTransaction();
        User user = new User();
        user.setName(username);
        session.save(user);
        session.getTransaction().commit();

        mav.addObject("usernameInvalid", username);
        return mav;
    }
}
