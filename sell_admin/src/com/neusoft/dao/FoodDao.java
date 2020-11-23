package com.neusoft.dao;

import com.neusoft.domain.Food;

import java.util.List;

public interface FoodDao {
    //返回食品列表
    public List<Food> listFoodByBusinessId(Integer businessId );
    //保存食品
    public int saveFood(Food food);
    //更新食品列表
    public int updateFood(Food food);
    //删除食品
    public int removeFood(Integer foodId);
    //通过id查询食品
    public Food getFoodById(Integer foodId);
}
