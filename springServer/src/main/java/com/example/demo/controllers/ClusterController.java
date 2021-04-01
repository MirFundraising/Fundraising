package com.example.demo.controllers;

import com.example.demo.serverClasses.Cluster;
import com.example.demo.serverClasses.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cluster")
public class ClusterController {
    // в силу того, что БД не до конца реализована, я не могу наладить связь с БД,
    // поэтому написал методы как мог
    @GetMapping
    public List<Cluster> getUserClusterList(@RequestBody User user){
        //ПОЛУЧАТЬ СПИСОК КЛАСТЕРОВ ЮЗЕРА ИЗ БД И ВОЗВРАЩАТЬ ИХ
        return user.getClusters();
    }
    @GetMapping("{clusterName}")
    public Cluster getUserClusterByClusterName(@PathVariable String clusterName, @RequestBody User user){
        //ПОЛУЧАТЬ КЛАСТЕР ЮЗЕРА ПО НАЗВАНИ КЛАСТЕРА ИЗ БД И ВОЗВРАЩАТЬ ЕГО
        List<Cluster> clusters = user.getClusters();
        Cluster cluster = null;
        for (int i = 0; i < clusters.size(); i++) {
            if (clusters.get(i).getClusterName().equals(clusterName)) {
                cluster = clusters.get(i);
                break;
            }
        }
        return  cluster;
    }

    @PostMapping
    public Cluster createNewUserCluster(@RequestBody Cluster cluster, @RequestBody User user) {
        // СОЗДАВАТЬ НОВЫЙ КЛАСТЕР ПОЛЬЗОВАТЕЛЯ, ДОБАВЛЯТЬ В БД И ЕСЛИ ВСЕ УСПЕШНО, ОТПРАВЛЯТЬ ЕГО НАЗАД
        try {
            user.addCluster(cluster);
            return cluster;
        }
        catch (Exception e) {
            return null;
        }
    }

    @PutMapping("{name}")
    public  Cluster addNewMemberToCluster(@PathVariable String name, @RequestBody Cluster cluster,
                                          @RequestBody User user){
        // ДОБАВЛЯТЬ НОВОГО ЮЗЕРА В КЛАСТЕР ПО НОМЕРУ ТЕЛЕФОНА ЮЗЕРА (У НАС УЖЕ ЕСТЬ КЛАСТЕР,
        // МЫ ПРОСТО ОБНОВЛЯЕМ ЕГО ДАННЫЕ
        // ПОЭТОМУ И PUT ЗАПРОС)

        // name не смог использовать, так как не могу обращаться к БД
        try {
            cluster.addUser(user);
            return cluster;
        }
        catch (Exception e) {
            return null;
        }
    }
}
