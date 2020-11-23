package com.neusoft.dao.impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.utils.JDBCUtils;

import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        ArrayList<Food> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from food WHERE businessId=?");
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql.toString());
            pst.setInt(1,businessId);
            rs = pst.executeQuery();
            while (rs.next()){
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                list.add(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pst,conn);
        }
        return list;
    }

    @Override
    public int saveFood(Food food) {
        int result=0;
        String sql="insert into food values(null,?,?,?,?)";
        try {
            conn=JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, food.getFoodName());
            pst.setString(2,food.getFoodExplain());
            pst.setDouble(3,food.getFoodPrice());
            pst.setInt(4,food.getBusinessId());
            result=pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(null,pst,conn);
        }
        return result;
    }

    @Override
    public int updateFood(Food food) {
        int result = 0;
        String sql = "update food set foodName=?,foodExplain=?,foodPrice=? where foodId=?";
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, food.getFoodName());
            pst.setString(2, food.getFoodExplain());
            pst.setDouble(3, food.getFoodPrice());
            pst.setInt(4, food.getFoodId());
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pst, conn);
        }
        return result;
    }


    @Override
    public int removeFood(Integer foodId) {
        int result = 0;
        String sql = "delete from food where foodId=?";
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, foodId);
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pst, conn);
        }
        return result;
    }

    @Override
    public Food getFoodById(Integer foodId) {
        Food food = null;
        String sql = "select * from food where foodId=?";
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, foodId);
            rs = pst.executeQuery();
            while(rs.next()) {
                food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, pst, conn);
        }
        return food;
    }
}
