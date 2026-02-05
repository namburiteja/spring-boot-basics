package org.example.springbootbasics.service;

import org.example.springbootbasics.entity.FlamesEntity;
import org.example.springbootbasics.repository.FlamesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Service
public class FlamesService {
    private final FlamesRepository flamesRepository;
    public FlamesService(FlamesRepository flamesRepository){
        this.flamesRepository = flamesRepository;
    }
    public String flames(String s1,String s2){
        s1 = s1.replace(" ","");
        s2 = s2.replace(" ","");
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        System.out.println(s1+" "+s2);
        HashMap<Character,Integer> hm1 = new HashMap<>();
        HashMap<Character,Integer> hm2 = new HashMap<>();
        for(Character s:s1.toCharArray()){
            if(hm1.containsKey(s)){
                hm1.put(s,hm1.get(s)+1);
            }else{
                hm1.put(s,1);
            }
        }
        for(Character s:s2.toCharArray()){
            if(hm2.containsKey(s)){
                hm2.put(s,hm2.get(s)+1);
            }else{
                hm2.put(s,1);
            }
        }
        int count = 0;
        ArrayList<Character> toBeRemove = new ArrayList<>();
        for(Character x:hm1.keySet()){
            if(hm2.containsKey(x)){
                int a = hm1.get(x)-hm2.get(x);
                int b = hm2.get(x)-hm1.get(x);
                hm1.put(x,a);
                hm2.put(x,b);
                if(hm1.get(x)<=0) toBeRemove.add(x);
                if(hm2.get(x)<=0) hm2.remove(x);
            }
        }
        for(Character c:toBeRemove) hm1.remove(c);
        int times = 0;
        for(Character x:s1.toCharArray()){
            if(hm1.containsKey(x) && hm1.get(x)>0){
                times++;
                hm1.put(x,hm1.get(x)-1);
            }
        }
        for(Character x:s2.toCharArray()){
            if(hm2.containsKey(x) && hm2.get(x)>0){
                times++;
                hm2.put(x,hm2.get(x)-1);
            }
        }
        ArrayList<String> res = new ArrayList<>(Arrays.asList("Friends","Lovers","Attraction","Married","Enemies","Siblings"));
        while(res.size()>1){
            int ind = (times%res.size())-1;
            if(ind>=0){
                ArrayList<String> right = new ArrayList<>(res.subList(ind+1,res.size()));
                ArrayList<String> left = new ArrayList<>(res.subList(0,ind));
                res.clear();
                res.addAll(right);
                res.addAll(left);
            }else{
                res.remove(res.size()-1);
            }
        }
        String finalResult =  res.get(0);

        FlamesEntity entity = new FlamesEntity();
        entity.setBoyName(s1);
        entity.setGirlName(s2);
        entity.setResult(finalResult);

        flamesRepository.save(entity);
        return finalResult;
    }
}
