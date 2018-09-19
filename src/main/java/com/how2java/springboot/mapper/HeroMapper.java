package com.how2java.springboot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
 
import com.how2java.springboot.pojo.Hero;
  
@Mapper
public interface HeroMapper {
    public int add(Hero hero);
     
    public void delete(int id);
         
    public Hero get(int id);
       
    public int update(Hero hero); 
         
    public List<Hero> list();
    
    public List<Hero> searchByName(Map paraMap);
    
    public List<Hero> searchByHp(Map paraMap);
}