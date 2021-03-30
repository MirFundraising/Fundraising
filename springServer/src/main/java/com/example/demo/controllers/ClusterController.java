package com.example.demo.controllers;

import com.example.demo.serverClasses.Cluster;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cluster")
public class ClusterController {
    //TODO МБ НУЖНЫ ЕЩЕ ССЫЛКИ, ОБЬЕКТЫ, ТАМ ЮЗЕР, КЛАСТЕР, НЕ ЗНАЮ, ДОБАВЬ ЕСЛИ НАДО
    @GetMapping
    public List<Cluster> getUserClusterList(){
        //TODO ПОЛУЧАТЬ СПИСОК КЛАСТЕРОВ ЮЗЕРА ИЗ БД И ВОЗВРАЩАТЬ ИХ
    }
    @GetMapping("{name}")
    public Cluster getUserClusterByClusterName(String clusterName){
        //TODO ПОЛУЧАТЬ КЛАСТЕР ЮЗЕРА ПО НАЗВАНИ КЛАСТЕРА ИЗ БД И ВОЗВРАЩАТЬ ЕГО

    }
    @PostMapping
    public Cluster createNewUserCluster(@RequestBody Cluster cluster){
        //TODO СОЗДАВАТЬ НОВЫЙ КЛАСТЕР ПОЛЬЗОВАТЕЛЯ, ДОБАВЛЯТЬ В БД И ЕСЛИ ВСЕ УСПЕШНО, ОТПРАВЛЯТЬ ЕГО НАЗАД
        return cluster;
    }

    @PutMapping("{name}")//тут сам думай
    public  Cluster addNewMemberToCluster(@PathVariable String name,@RequestBody Cluster cluster){//тут тоже
        //TODO ДОБАВЛЯТЬ НОВОГО ЮЗЕРА В КЛАСТЕР ПО НОМЕРУ ТЕЛЕФОНА ЮЗЕРА (У НАС УЖЕ ЕСТЬ КЛАСТЕР,
        // МЫ ПРОСТО ОБНОВЛЯЕМ ЕГО ДАННЫЕ
        // ПОЭТОМУ И PUT ЗАПРОС)
    }
}
