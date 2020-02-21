package com.cmb.controller;

import com.cmb.entity.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "hero")
public class HeroController {

    @RequestMapping(value = "heroes", method = RequestMethod.GET)
    @ResponseBody
    public Hero[] getHeroes(){
        System.out.println("getHeroes");

        Hero hero =  new Hero();
        hero.setId(50);
        hero.setName("dulv");
        Hero[] array = new Hero[]{hero};
        return array;
    }

    @RequestMapping(value = "heroes/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Hero getHero(@PathVariable("id") Integer id){
        System.out.println(id);
        Hero hero =  new Hero();
        hero.setId(50);
        hero.setName("dulv");
        return hero;
    }
}
