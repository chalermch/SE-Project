package teletubies;

public class Food {
    private int foodID;
    private String foodName;
    private int foodPrice;
    
    public Food(){
        
    }
    
    public Food(int foodID,String foodName,int foodPrice){
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
    
    public int getfoodID(){
        return foodID;
    }
    
    public void setfoodID(int foodID){
        this.foodID = foodID;
    }
    
    public String getfoodName(){
        return foodName;
    }
    
    public void setfoodName(String foodName){
        this.foodName = foodName;
    }
    
    public int getfoodPrice(){
        return foodPrice;
    }
    
    public void setfoodPrice(int foodPrice){
        this.foodPrice = foodPrice;
    }
}
