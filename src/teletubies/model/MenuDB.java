package teletubies.model;

public class MenuDB {
    private int foodid;
    private String foodname; 
    private int foodprice;
    
    public MenuDB(){
        
    }

    public MenuDB(int foodid, String foodname, int foodprice){
        this.foodid = foodid;
        this.foodname = foodname;
        this.foodprice = foodprice;
    }
    
    public int getFoodID() {
        return foodid;
    }

    public void setFoodID(int id) {
        foodid = id;
    }

    public String getFoodName() {
        return foodname;
    }

    public void setFoodName(String name) {
        foodname = name;
    }

    public int getFoodPrice() {
        return foodprice;
    }

    public void setFoodPrice(int price) {
        foodprice = price;
    }
}
