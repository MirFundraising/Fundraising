package com.example.demo.controllers;


import com.example.demo.serverClasses.Fundraising;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fundraising")
public class FundraisingController {
    //TODO МБ НУЖНЫ ЕЩЕ ССЫЛКИ, ОБЬЕКТЫ, ТАМ ЮЗЕР, КЛАСТЕР, НЕ ЗНАЮ, ДОБАВЬ ЕСЛИ НАДО
    @GetMapping
    public List<Fundraising> getFundraisingListOfCluster(){
        //TODO СВЯЗЬ С БД И ВОЗВРАТ ВСЕХ СБОРОВ КОНКРЕТНОГО КЛАСТЕРА
    }
    @GetMapping("{id}")
    public Fundraising getFundraisingById(@PathVariable String id){
        //TODO ПОЛУЧИТЬ КОНКРЕТНЫЙ СБОР КЛАСТЕРА ПО АЙДИ (МБ ИНАЧЕ, ПО НАЗВАНИЮ ТАМ, ПОДУМАЙ КАК ВОЗМОЖНО)
    }

    @PostMapping
    public Fundraising createNewFundraising(@RequestBody Fundraising fundraising){
        //TODO ДОБАВИТЬ СБОР В БД И ВЕРНУТЬ ЕГО ОБРАТНО ПРИ УСПЕШНОМ ДОБАВЛЕНИИ В БД
    }

    @PutMapping("{id}")
    public Fundraising changeFundraisingCurrentFunds(@PathVariable String id,@RequestBody Fundraising fundraising){
        //TODO МЕНЯТЬ В КОНКРЕТНОМ СБОРЕ ТЕКУЩУЮ СУММУ СБОРА ПОЭТОМУ И ПУТ
    }

}
