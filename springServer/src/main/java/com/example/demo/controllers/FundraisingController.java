package com.example.demo.controllers;


import com.example.demo.serverClasses.Cluster;
import com.example.demo.serverClasses.Fundraising;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("fundraising")
public class FundraisingController {
    // в силу того, что БД не до конца реализована, я не могу наладить связь с БД,
    // поэтому написал методы как мог
    @GetMapping
    public List<Fundraising> getFundraisingListOfCluster(@RequestBody Cluster cluster){
        //СВЯЗЬ С БД И ВОЗВРАТ ВСЕХ СБОРОВ КОНКРЕТНОГО КЛАСТЕРА
        return cluster.getFundraisings();
    }

    @GetMapping("{id}")
    public Fundraising getFundraisingById(@PathVariable String id, @RequestBody Cluster cluster){
        //ПОЛУЧИТЬ КОНКРЕТНЫЙ СБОР КЛАСТЕРА ПО АЙДИ
        Fundraising fundraising = null;
        List<Fundraising> fundraisings = cluster.getFundraisings();
        for (int i = 0; i < fundraisings.size(); i++) {
            String strNumber = getString(fundraisings.get(i).getFundraisingId());
            if (strNumber.equals(id)) {
                fundraising = fundraisings.get(i);
                break;
            }
        }
        return fundraising;
    }

    private String getString(long fundraisingId) {
        String str = "";
        while (fundraisingId > 0) {
            str = fundraisingId % 10 + str;
            fundraisingId = fundraisingId / 10;
        }
        return  str;
    }

    @PostMapping
    public Fundraising createNewFundraising(@RequestBody Fundraising fundraising, @RequestBody Cluster cluster){
        // ДОБАВИТЬ СБОР В БД И ВЕРНУТЬ ЕГО ОБРАТНО ПРИ УСПЕШНОМ ДОБАВЛЕНИИ В БД
        try {
            List<Fundraising> fundraisings = cluster.getFundraisings();
            fundraisings.add(fundraising);
            cluster.setFundraisings(fundraisings);
            return fundraising;
        }
        catch (RuntimeException e) {
            return null;
        }
    }

    @PutMapping("{id}")
    public Fundraising changeFundraisingCurrentFunds(@PathVariable String id, @RequestBody Fundraising fundraising,
                                                     @RequestBody Cluster cluster){
        // МЕНЯТЬ В КОНКРЕТНОМ СБОРЕ ТЕКУЩУЮ СУММУ СБОРА ПОЭТОМУ И ПУТ
        try {
            Fundraising fundraising1 = null;
            List<Fundraising> fundraisings = cluster.getFundraisings();
            List<Fundraising> fundraisings1 = new ArrayList<Fundraising>();
            for (int i = 0; i < fundraisings.size(); i++) {
                String strNumber = getString(fundraisings.get(i).getFundraisingId());
                if (!strNumber.equals(id)) {
                    fundraisings1.add(fundraisings.get(i));
                }
                else {
                    fundraisings1.add(fundraising);
                    fundraising1 = fundraising;
                }
            }
            cluster.setFundraisings(fundraisings1);
            return fundraising1;
        }
        catch (RuntimeException e) {
            return null;
        }
    }

}
