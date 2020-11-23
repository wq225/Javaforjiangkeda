package com.neusoft.view;

public interface FoodView {
    //显示所有的食品
    public void showFoodList(Integer businessId);
    //保存食品
    public void saveFood(Integer businessId);
    //更新食品
    public void updateFood(Integer businessId);
    //删除食品
    public void removeFood(Integer businessId);
}