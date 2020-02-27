package com.cmb.controller;

import com.cmb.entity.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "postHeroes", method = RequestMethod.POST)
    @ResponseBody
    public Hero postHeroes(@RequestParam("id") Integer id){
        System.out.println(id);
        Hero hero =  new Hero();
        hero.setId(50);
        hero.setName("dulv");
        return hero;
    }

    @RequestMapping(value = "getHeroes", method = RequestMethod.GET)
    @ResponseBody
    public Hero getHeroes(@RequestParam("id") Integer id){
        System.out.println(id);
        Hero hero =  new Hero();
        hero.setId(50);
        hero.setName("dulv");
        return hero;
    }

    @RequestMapping(value = "jsonHeroes", method = RequestMethod.POST)
    @ResponseBody
    public Hero jsonHeroes(@RequestBody Hero paraHero){

        System.out.println(paraHero);
        return paraHero;
    }
}
