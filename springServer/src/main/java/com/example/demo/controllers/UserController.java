//package com.example.demo.controllers;
//
//import com.example.demo.serverClasses.Cluster;
//import com.example.demo.serverClasses.User;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("user")
//public class UserController {
//    // в силу того, что БД не до конца реализована, я не могу наладить связь с БД,
//    // поэтому написал методы как мог
//    @GetMapping
//    public List<User> getClusterUsers(@RequestBody Cluster cluster){
//        // ПОЛУЧАТЬ ВСЕХ УЧАСТНИКОВ КЛАСТЕРА И ВОЗВРАЩАТЬ ИХ
//        return cluster.getUsers();
//    }
//    @GetMapping("{phone}")
//    public User getCurrentUser(@PathVariable String phone, @RequestBody Cluster cluster){
//        //ПОЛУЧАТЬ ПОЛЬЗОВАТЕЛЯ ПО НОМЕРУ ТЕЛЕФОНА, ПОДХОДИТ КАК ПОЛУЧЕНИЯ ТЕКУЩЕГО ПОЛЬЗОВАТЕЛЯ
//        //В АТОРИЗАЦИИ, ТАК И ДЛЯ ДОБАВЛЕНИЯ ПОЛЬЗОВАТЕЛЯ В НОВЫЙ КЛАСТЕР
//        User user = null;
//        List<User> users = cluster.getUsers();
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getTelephone().equals(phone)) {
//                user = users.get(i);
//                break;
//            }
//        }
//        return user;
//    }
//    @PostMapping
//    public User createNewUser(@RequestBody User user, @RequestBody Cluster cluster){
//        //СОЗДАНИЕ И ДОБАВЛЕНИЕ НОВОГО ПОЛЬЗОВАТЕЛЯ В БД И ВОЗВРАТ ЕГО ЕСЛИ ВСЕ ОК
//        try {
//            List<User> users = cluster.getUsers();
//            users.add(user);
//            cluster.setUsers(users);
//            return user;
//        }
//        catch (Exception e) {
//            return  null;
//        }
//    }
//}
