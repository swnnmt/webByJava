/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Cartegory;
import model.Brand;
import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Product_detail;
import model.Account;
import model.Product_done;
import model.Statistical_product;
import model.Statistical_customer;
/**
 *
 * @author mactu
 */
public class cartegoryDAO extends DBContext{
    //--------------------------CARTEGORY---------------------------------------
    public List<Cartegory> getAll (){
        List<Cartegory> list = new ArrayList<>();
        String sql="select * from tbl_cartegory order by cartegory_id desc";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Cartegory c = new Cartegory(rs.getInt("cartegory_id"), rs.getString("cartegory_name"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    }
    public List<Cartegory> showAll (){
        List<Cartegory> list = new ArrayList<>();
        String sql="select * from tbl_cartegory ";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Cartegory c = new Cartegory(rs.getInt("cartegory_id"), rs.getString("cartegory_name"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    }
    public void insertCartegory(Cartegory c){
        String sql ="Insert into tbl_cartegory (cartegory_name)values(?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString (1,c. getCartegory_name());
           st.executeUpdate();
        } catch (Exception e) {
        }
    }
    public Cartegory getCartegoryByName (String name){
        String sql="select * from tbl_cartegory where cartegory_name like ? ";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              st. setString(1, name);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
               Cartegory c = new Cartegory( rs.getString("cartegory_name"));
               return c;
              }
        } catch (SQLException e) {
        }
        
    return null;
    }
 public Cartegory getCartegoryById (int cartegory_id){
        String sql="select * from tbl_cartegory where cartegory_id = ? ";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              st. setInt(1, cartegory_id);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
               Cartegory c = new Cartegory( rs.getInt("cartegory_id"), rs.getString("cartegory_name"));
               return c;
              }
        } catch (SQLException e) {
        }
        
    return null;
    }
    public  void delete (int cartegory_id){
        String sql = "DELETE FROM [dbo].[tbl_cartegory]\n"
                + "      WHERE cartegory_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
              st. setInt(1, cartegory_id);
              st.executeUpdate();
        } catch (SQLException e) {
                System.out.println(e);
        }
    }
    public void update (String cartegory_name, int cartegory_id){
        String sql = "UPDATE [dbo].[tbl_cartegory]\n"
                + "   SET [cartegory_name] = ? \n"
                + " WHERE cartegory_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cartegory_name);
            st.setInt(2,cartegory_id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
//-----------------------------Brand-------------------------------------------
        public void insertBrand(Brand c){
        String sql ="Insert into tbl_brand (cartegory_id,brand_name)values(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,c. getCartegory_id());
            st.setString(2,c.getBrand_name());
           st.executeUpdate();
        } catch (Exception e) {
        }
    }
         public List<Brand> getAll_Brand (){
        List<Brand> list = new ArrayList<>();
        String sql="select * from tbl_brand order by brand_id desc";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Brand c = new Brand(rs.getInt("brand_id"), rs.getInt("cartegory_id"), rs.getString("brand_name"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }

         public List<Brand> showAll_Brand (){
        List<Brand> list = new ArrayList<>();
        String sql="select * from tbl_brand";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Brand c = new Brand(rs.getInt("brand_id"), rs.getInt("cartegory_id"), rs.getString("brand_name"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
         }
         
        public  void delete_brand (int brand_id){
        String sql = "DELETE FROM [dbo].[tbl_brand]\n"
                + "      WHERE brand_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
              st. setInt(1, brand_id);
              st.executeUpdate();
        } catch (SQLException e) {
                System.out.println(e);
        }
    }
           public void update_brand (int brand_id,String brand_name, int cartegory_id){
               String sql = "UPDATE [dbo].[tbl_brand]\n"
                       + "   SET [cartegory_id] = ?\n"
                       + "      ,[brand_name] = ?\n"
                       + " WHERE brand_id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartegory_id);
            st.setString(2,brand_name);
            st.setInt(3, brand_id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
            public Brand getBrandById (int brand_id){
        String sql="select * from tbl_brand where brand_id = ? ";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              st. setInt(1, brand_id);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
               Brand c = new Brand(rs.getInt("brand_id"),rs.getInt("cartegory_id"), rs.getString("brand_name"));
               return c;
              }
        } catch (SQLException e) {
        }
        
    return null;
    }
             public Cartegory getCartegoryByBrandId (int brand_id){
                 String sql = "select * from tbl_cartegory\n"
                         + "join tbl_brand on tbl_brand.cartegory_id=tbl_cartegory.cartegory_id\n"
                         + "where tbl_brand.brand_id=? ";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              st. setInt(1, brand_id);
              ResultSet rs = st.executeQuery();
              if(rs.next()){
               Cartegory c = new Cartegory( rs.getInt("cartegory_id"), rs.getString("cartegory_name"));
               return c;
              }
        } catch (SQLException e) {
        }
        
    return null;
    }
        public List<Brand> getBrandByCartegoryId (int cartegory_id){
    List<Brand> list = new ArrayList<>();
        String sql="select * from tbl_brand where cartegory_id=?";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              st.setInt(1, cartegory_id);
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Brand c = new Brand(rs.getInt("brand_id"), rs.getInt("cartegory_id"), rs.getString("brand_name"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    }
//        ----------------------------product--------------------------------------------------
                public void insertProduct(Product c){
        String sql ="INSERT INTO [dbo].[tbl_product]\n" +
"           ([product_quantity]\n" +
"           ,[product_name]\n" +
"           ,[cartegory_id]\n" +
"           ,[brand_id]\n" +
"           ,[product_price]\n" +
"           ,[product_price_sale]\n" +
"           ,[product_img]\n" +
"           ,[product_desc])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,c. getProduct_quantity());
            st.setString(2,c.getProduct_name());
            st.setInt(3,c. getCartegory_id());
            st.setInt(4,c. getBrand_id());
            st.setDouble(5,c. getProduct_price());
            st.setDouble(6,c. getProduct_price_sale());
            st.setString(7,c. getProduct_img());
            st.setString(8,c. getProduct_desc());
           st.executeUpdate();
        } catch (Exception e) {
        }
    }
//             
            public List<Product> getAll_Products (){
        List<Product> list = new ArrayList<>();
        String sql="select * from tbl_product order by product_id desc";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Product c = new Product(rs.getInt("product_id"), rs.getInt("product_quantity"), rs.getString("product_name"),rs.getInt("cartegory_id"),rs.getInt("brand_id"),rs.getDouble("product_price"),rs.getDouble("product_price_sale"),rs.getString("product_img"),rs.getString("product_desc"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
//            
        public List<Product> ShowProductsByCartegoryIdAndBrandId (int cartegory_id, int brand_id){
        List<Product> list = new ArrayList<>();
        String sql="select * from tbl_product where cartegory_id=? and brand_id = ?";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
               st.setInt(1, cartegory_id);
               st.setInt(2, brand_id);
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Product c = new Product(rs.getInt("product_id"), rs.getInt("product_quantity"), rs.getString("product_name"),rs.getInt("cartegory_id"),rs.getInt("brand_id"),rs.getDouble("product_price"),rs.getDouble("product_price_sale"),rs.getString("product_img"),rs.getString("product_desc"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
//        
                public Product ShowProductByProductId (int product_id){
        String sql="select * from tbl_product where product_id=?";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
               st.setInt(1, product_id);
               
              ResultSet rs = st.executeQuery();
               
              if(rs.next()){
               Product c = new Product(rs.getInt("product_id"), rs.getInt("product_quantity"), rs.getString("product_name"),rs.getInt("cartegory_id"),rs.getInt("brand_id"),rs.getDouble("product_price"),rs.getDouble("product_price_sale"),rs.getString("product_img"),rs.getString("product_desc"));
               return c;
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return null;
    
    }
//
        public List<Product> ShowProductsByFindDing(String finding){
        List<Product> list = new ArrayList<>();
        String sql="select * from tbl_product where product_name like N'%?%'";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
               st.setString(1, finding);
              
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Product c = new Product(rs.getInt("product_id"), rs.getInt("product_quantity"), rs.getString("product_name"),rs.getInt("cartegory_id"),rs.getInt("brand_id"),rs.getDouble("product_price"),rs.getDouble("product_price_sale"),rs.getString("product_img"),rs.getString("product_desc"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
//
            public void delete_product (int product_id){
        String sql="DELETE FROM tbl_product where product_id=?";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
               st.setInt(1, product_id);
                st.executeUpdate();           
        } catch (SQLException e) {
            System.out.println("error");
        }
    }
        public void update_product (int product_id, int product_quantity, String product_name, int cartegory_id, int brand_id, double product_price, double product_price_sale, String product_img, String product_desc){
            String sql = "UPDATE [dbo].[tbl_product]\n"
                    + "   SET [product_quantity] = ?\n"
                    + "      ,[product_name] = ?\n"
                    + "      ,[cartegory_id] = ?\n"
                    + "      ,[brand_id] = ?\n"
                    + "      ,[product_price] = ?\n"
                    + "      ,[product_price_sale] = ?\n"
                    + "      ,[product_img] = ?\n"
                    + "      ,[product_desc] = ?\n"
                    + " WHERE  product_id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, product_quantity);
            st.setString(2,product_name);
            st.setInt(3, cartegory_id);
            st.setInt(4, brand_id);
            st.setDouble(5, product_price);
            st.setDouble(6, product_price_sale);
            st.setString(7, product_img);
            st.setString(8, product_desc);
            st.setInt(9, product_id);
            st.executeUpdate();
        } catch (Exception e) {
        }
        }
        
          public void update_quantity (int product_id, int product_quantity){
            String sql = "UPDATE [dbo].[tbl_product]\n"
                    + "   SET [product_quantity] = ?\n"
                    + " WHERE  product_id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, product_quantity);
            st.setInt(2, product_id);
            st.executeUpdate();
        } catch (Exception e) {
        }
        }
          
       public List<Product> ShowProductsTop5Woman (){
        List<Product> list = new ArrayList<>();
        String sql="SELECT TOP 5\n"
                + " *\n"
                + "FROM \n"
                + "    tbl_product\n"
                + "WHERE \n"
                + "    cartegory_id =24\n"
                + "ORDER BY \n"
                + "    product_quantity DESC";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
               
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Product c = new Product(rs.getInt("product_id"), rs.getInt("product_quantity"), rs.getString("product_name"),rs.getInt("cartegory_id"),rs.getInt("brand_id"),rs.getDouble("product_price"),rs.getDouble("product_price_sale"),rs.getString("product_img"),rs.getString("product_desc"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
              public List<Product> ShowProductsTop5Men (){
        List<Product> list = new ArrayList<>();
        String sql="SELECT TOP 5\n"
                + " *\n"
                + "FROM \n"
                + "    tbl_product\n"
                + "WHERE \n"
                + "    cartegory_id =25\n"
                + "ORDER BY \n"
                + "    product_quantity DESC";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
               
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Product c = new Product(rs.getInt("product_id"), rs.getInt("product_quantity"), rs.getString("product_name"),rs.getInt("cartegory_id"),rs.getInt("brand_id"),rs.getDouble("product_price"),rs.getDouble("product_price_sale"),rs.getString("product_img"),rs.getString("product_desc"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
        public List<Product> ShowProductsTop5Bayby (){
        List<Product> list = new ArrayList<>();
        String sql="SELECT TOP 5\n"
                + " *\n"
                + "FROM \n"
                + "    tbl_product\n"
                + "WHERE \n"
                + "    cartegory_id =26\n"
                + "ORDER BY \n"
                + "    product_quantity DESC";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
               
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Product c = new Product(rs.getInt("product_id"), rs.getInt("product_quantity"), rs.getString("product_name"),rs.getInt("cartegory_id"),rs.getInt("brand_id"),rs.getDouble("product_price"),rs.getDouble("product_price_sale"),rs.getString("product_img"),rs.getString("product_desc"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
                public List<Product> ShowProductsTop5CartegoryIdAndBrandId (int cartegory_id, int brand_id, int product_id){
        List<Product> list = new ArrayList<>();
        String sql="select Top 5 * from tbl_product where cartegory_id=? and brand_id = ? and product_id!=?";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
               st.setInt(1, cartegory_id);
               st.setInt(2, brand_id);
               st.setInt(3, product_id);
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Product c = new Product(rs.getInt("product_id"), rs.getInt("product_quantity"), rs.getString("product_name"),rs.getInt("cartegory_id"),rs.getInt("brand_id"),rs.getDouble("product_price"),rs.getDouble("product_price_sale"),rs.getString("product_img"),rs.getString("product_desc"));
               list.add(c);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
        //---------------------product_detail----------------------------
        public void insertProduct_detail(Product_detail c){
        String sql ="INSERT INTO [dbo].[tbl_product_detail]\n" +
"           ([product_id]\n" +
"           ,[product_img_desc_1]\n" +
"           ,[product_img_desc_2]\n" +
"           ,[product_img_desc_3]\n" +
"           ,[product_img_desc_4]\n" +
"           ,[product_color]\n" +
"           ,[product_intro]\n" +
"           ,[product_prever])\n" +
"     VALUES\n" +
"           (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1,c. getProduct_id());
            st.setString(2,c.getProduct_img_desc_1());
            st.setString(3,c.getProduct_img_desc_2());
            st.setString(4,c.getProduct_img_desc_3());
            st.setString(5,c.getProduct_img_desc_4());
             st.setString(6,c.getProduct_color());
            st.setString(7,c.getProduct_intro());
            st.setString(8,c. getProduct_prever());
           st.executeUpdate();
        } catch (Exception e) {
        }
    }
            public List<Product_detail> getAll_Products_detail (){
        List<Product_detail> list = new ArrayList<>();
        String sql="select * from tbl_product_detail order by product_id desc";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Product_detail product_detail= new Product_detail(rs.getInt("product_id"),rs.getString("product_img_desc_1"),rs.getString("product_img_desc_2"),rs.getString("product_img_desc_3"),rs.getString("product_img_desc_4"),rs.getString("product_color"),rs.getString("product_intro"),rs.getString("product_prever"));
               list.add(product_detail);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
            //
        public Product_detail showProducts_detailbyProductId (int product_id){
        String sql="select * from tbl_product_detail where product_id=?";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              st.setInt(1, product_id);
              ResultSet rs = st.executeQuery();
               
              if(rs.next()){
               Product_detail product_detail= new Product_detail(rs.getInt("product_id"),rs.getString("product_img_desc_1"),rs.getString("product_img_desc_2"),rs.getString("product_img_desc_3"),rs.getString("product_img_desc_4"),rs.getString("product_color"),rs.getString("product_intro"),rs.getString("product_prever"));
              return product_detail;
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return null;
    
    }
        //
                   public void delete_product_detail (int product_id){
        String sql="DELETE FROM tbl_product_detail where product_id=?";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
               st.setInt(1, product_id);
                st.executeUpdate();           
        } catch (SQLException e) {
            System.out.println("error");
        }
    }
   //-------------------account------------------------
    public void insertAccount(Account c){
        String sql =" INSERT INTO [dbo].[tbl_account]\n" +
"           ([username]\n" +
"           ,[email]\n" +
"           ,[password]\n" +
"           ,[role])\n" +
"     VALUES\n" +
"           (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,c.getUsername());
            st.setString(2,c.getEmail());
            st.setString(3,c.getPassword());
            st.setInt(4, c.getRole());
           st.executeUpdate();
        } catch (SQLException e) { 
        }
    }         
        public Account getAccountByUsername(String username, String password){
        String sql ="SELECT * FROM tbl_account where username=? and password=? ";
//        or 1=1 and username='HE170091'
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,username);         
            st.setString(2,password);
            ResultSet rs = st.executeQuery();
           if(rs.next()){
            Account account= new Account(rs.getInt("id_account"),rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getInt("role"));
            return account;
           }
        } catch (SQLException e) { 
            System.out.println(e);
        }
        return null;
    } 
         public void updateAccountById (int id_account, String username, String email,String password ){
            String sql = "UPDATE [dbo].[tbl_account]\n"
                    + "   SET [username] = ?\n"
                    + "      ,[email] = ?\n"
                    + "      ,[password] = ?\n"
                    + " WHERE  id_account =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2,email);
            st.setString(3, password);
            st.setInt(4, id_account);
            st.executeUpdate();
        } catch (Exception e) {
            
        }
         }
//         --------------------done product------------------------
         public void insertDoneProduct(Product_done c){
        String sql =" INSERT INTO [dbo].[tbl_product_done]\n" +
    "           ([username]\n" +
    "           ,[product_id]\n" +
    "           ,[product_quantity]\n" +
    "           ,[product_size]\n" +
    "           ,[name_custom]\n" +
    "           ,[phone_number]\n" +
    "           ,[province]\n" +
    "           ,[districts]\n" +
    "           ,[address]\n" +
    "           ,[product_done_price])\n" +
    "     VALUES\n" +
    "           (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getUsername());
            st.setInt(2, c.getProduct_id());
            st.setInt(3, c.getProduct_quantity());
            st.setString(4, c.getProduct_size());
            st.setString(5, c.getName_custom());
            st.setString(6, c.getPhone_number());
            st.setString(7, c.getProvince());
            st.setString(8, c.getDistricts());
            st.setString(9, c.getAddress());
            st.setDouble(10, c.getProduct_done_price());
           st.executeUpdate();
        } catch (SQLException e) { 
        }
    } 
             public List<Product_done> getAllProductDone(){
            List<Product_done> list = new ArrayList<>();
        String sql ="select* from tbl_product_done order by id_done desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
           while(rs.next()){
            Product_done product_done = new Product_done(rs.getString("username"),rs.getString("product_size"),rs.getString("name_custom"),rs.getString("phone_number"),rs.getString("province"),rs.getString("districts"),rs.getString("address"),rs.getInt("product_id"),rs.getInt("product_quantity"),rs.getInt("id_done"),rs.getDouble("product_done_price"));
            list.add(product_done);
           }
        } catch (SQLException e) { 
            System.out.println(e);
        }
       return list;
    } 
//         ------------------------statistical--------------------------
         //product nhiều nhất
                 public Statistical_product showBestProduct (){
                     String sql = "SELECT TOP 1\n"
                             + "    product_id,\n"
                             + "    COUNT(product_id) AS total_quantity_sold\n"
                             + "FROM\n"
                             + "    tbl_product_done\n"
                             + "GROUP BY\n"
                             + "    product_id\n"
                             + "ORDER BY\n"
                             + "    COUNT(product_id) DESC;";
        try {
              PreparedStatement st = connection.prepareStatement(sql);          
              ResultSet rs = st.executeQuery();
              if(rs.next()){
                  Statistical_product top1product= new Statistical_product(rs.getInt("product_id"), rs.getInt("total_quantity_sold"));
              return top1product;
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return null;
    
    }
                 //product ít nhất
                 public Statistical_product showleastProduct (){
                     String sql = "	SELECT TOP 1\n"
                             + "    product_id,\n"
                             + "    COUNT(product_id) AS total_quantity_sold\n"
                             + "FROM\n"
                             + "    tbl_product_done\n"
                             + "GROUP BY\n"
                             + "    product_id\n"
                             + "ORDER BY\n"
                             + "    COUNT(product_id) ASC;\n"
                             + "select * from tbl_account";
        try {
              PreparedStatement st = connection.prepareStatement(sql);          
              ResultSet rs = st.executeQuery();
              if(rs.next()){
                  Statistical_product top1product= new Statistical_product(rs.getInt("product_id"), rs.getInt("total_quantity_sold"));
              return top1product;
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return null;
    
    }
                 // top 3 nhiều nhất
          public List<Statistical_product> getTop3BestProduct (){
        List<Statistical_product> list = new ArrayList<>();
              String sql = "SELECT TOP 3\n"
                      + "    product_id,\n"
                      + "    COUNT(product_id) AS total_quantity_sold\n"
                      + "FROM\n"
                      + "    tbl_product_done\n"
                      + "GROUP BY\n"
                      + "    product_id\n"
                      + "ORDER BY\n"
                      + "    COUNT(product_id) DESC;";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Statistical_product top3_product= new Statistical_product(rs.getInt("product_id"), rs.getInt("total_quantity_sold"));
               list.add(top3_product);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
// top 3 ít nhất
                        
          public List<Statistical_product> getTop3LeastProduct (){
        List<Statistical_product> list = new ArrayList<>();
              String sql = "SELECT TOP 3\n"
                      + "    product_id,\n"
                      + "    COUNT(product_id) AS total_quantity_sold\n"
                      + "FROM\n"
                      + "    tbl_product_done\n"
                      + "GROUP BY\n"
                      + "    product_id\n"
                      + "ORDER BY\n"
                      + "    COUNT(product_id) ASC;";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
               Statistical_product top3_product= new Statistical_product(rs.getInt("product_id"), rs.getInt("total_quantity_sold"));
               list.add(top3_product);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
          // người mua nhiều nhất
                 public Statistical_customer showBestCustomer (){
                     String sql = "SELECT TOP 1\n"
                             + "    username,\n"
                             + "    COUNT(*) AS total_products_bought\n"
                             + "FROM\n"
                             + "    tbl_product_done\n"
                             + "GROUP BY\n"
                             + "    username\n"
                             + "ORDER BY\n"
                             + "    COUNT(*) DESC;";
        try {
              PreparedStatement st = connection.prepareStatement(sql);          
              ResultSet rs = st.executeQuery();
              if(rs.next()){
                  Statistical_customer top1customer= new Statistical_customer(rs.getString("username"), rs.getInt("total_products_bought"));
              return top1customer;
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return null;
    
    }
                 // top 3 người mua nhiều nhất
                                         
          public List<Statistical_customer> getTop3BestCustomer (){
        List<Statistical_customer> list = new ArrayList<>();
              String sql = "SELECT TOP 3\n"
                      + "    username,\n"
                      + "    COUNT(*) AS total_products_bought\n"
                      + "FROM\n"
                      + "    tbl_product_done\n"
                      + "GROUP BY\n"
                      + "    username\n"
                      + "ORDER BY\n"
                      + "    COUNT(*) DESC;";
        try {
              PreparedStatement st = connection.prepareStatement(sql);
              
              ResultSet rs = st.executeQuery();
               
              while(rs.next()){
                Statistical_customer top3customer= new Statistical_customer(rs.getString("username"), rs.getInt("total_products_bought"));
               list.add(top3customer);
              }
        } catch (SQLException e) {
            System.out.println("error");
        }
        
    return list;
    
    }
}