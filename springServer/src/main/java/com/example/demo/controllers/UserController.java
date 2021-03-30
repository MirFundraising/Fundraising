package com.example.demo.controllers;

import com.example.demo.serverClasses.User;
import com.sun.org.apache.bcel.internal.generic.PUSH;
import org.graalvm.compiler.lir.LIRInstruction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    //TODO МБ НУЖНЫ ЕЩЕ ССЫЛКИ, ОБЬЕКТЫ, ТАМ ЮЗЕР, КЛАСТЕР, НЕ ЗНАЮ, ДОБАВЬ ЕСЛИ НАДО
    @GetMapping
    public List<User> getClusterUsers(){
        //TODO ПОЛУЧАТЬ ВСЕХ УЧАСТНИКОВ КЛАСТЕРА И ВОЗВРАЩАТЬ ИХ
    }
    @GetMapping("{phone}")
    public User getCurrentUser(@PathVariable String phone){
        //TODO ПОЛУЧАТЬ ПОЛЬЗОВАТЕЛЯ ПО НОМЕРУ ТЕЛЕФОНА, ПОДХОДИТ КАК ПОЛУЧЕНИЯ ТЕКУЩЕГО ПОЛЬЗОВАТЕЛЯ
        //TODO В АТОРИЗАЦИИ, ТАК И ДЛЯ ДОБАВЛЕНИЯ ПОЛЬЗОВАТЕЛЯ В НОВЫЙ КЛАСТЕР
    }
    @PostMapping
    public User createNewUser(){
        //TODO СОЗДАНИЕ И ДОБАВЛЕНИЕ НОВОГО ПОЛЬЗОВАТЕЛЯ В БД И ВОЗВРАТ ЕГО ЕСЛИ ВСЕ ОК
    }
}
