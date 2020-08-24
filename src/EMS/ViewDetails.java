package EMS;

public class ViewDetails {

    private String id;
    private String name;
    private String lastname;
    private String price;
    private int catId;
    private byte[] Image;
    
    public ViewDetails(){}
    
    public ViewDetails(String Id, String Name, String LastName, String Price,byte[] image, int CatId){
    
        this.id = Id;
        this.name = Name;
        this.lastname=LastName;
        this.price = Price;
        this.Image = image;
        this.catId = CatId;
       
    }
    
    
    public String getID(){
      return id;
    }
    
    public void setID(String ID){
        this.id = ID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String Name){
        this.name = Name;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public void setLastname(String Qte){
        this.lastname = Qte;
    }
    
    public String getPrice(){
        return price;
    }
    
    public void setPrice(String Price){
        this.price = Price;
    }
    
    public int getCatID(){
        return catId;
    }
    
    public void setCatID(int CatID){
        this.catId = CatID;
    }
    
    public byte[] getMyImage(){
        return Image;
    }
}


