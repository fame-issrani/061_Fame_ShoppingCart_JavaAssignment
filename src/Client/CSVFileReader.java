package Client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Domain.Product;
import Domain.User;

/**
 * Created by fame.issrani on 2/17/17.
 */
public class CSVFileReader {

    final static List<User> users=new ArrayList<User>();
    final static List<Product> products=new ArrayList<Product>();

            public static List<User> readUserCSV()throws Exception{
                FileInputStream fis=new FileInputStream("resources/userCSV.csv");
                InputStreamReader isr=new InputStreamReader(fis);
                BufferedReader br=new BufferedReader(isr);
                String line=br.readLine();

                while(line != null){
                    String[] comSeperated=line.split(",");
                    int id=Integer.parseInt(comSeperated[0]);
                    String name=comSeperated[1];
                    String address=comSeperated[2];
                    String email=comSeperated[3];
                    User u=new User();
                    u.setUserId(id);
                    u.setAddress(address);
                    u.setName(name);
                    u.setEmail(email);
                    users.add(u);
                    line=br.readLine();
                }
                return users;
            }

            public static List<Product> readProductCSV()throws Exception{
                FileInputStream fis=new FileInputStream("resources/productCsv.csv");
                InputStreamReader isr=new InputStreamReader(fis);
                BufferedReader br=new BufferedReader(isr);
                String line=br.readLine();

                while(line != null){
                    String[] comSeperated=line.split(",");
                    int id=Integer.parseInt(comSeperated[0]);
                    String code=comSeperated[1];
                    String name=comSeperated[2];
                    int qty=Integer.parseInt(comSeperated[3]);
                    int unitPrice=Integer.parseInt(comSeperated[4]);
                    Product p=new Product();
                    p.setProductId(id);
                    p.setProductCode(code);
                    p.setProductName(name);
                    p.setQuantity(qty);
                    p.setUnitPrice(unitPrice);
                    products.add(p);
                    line=br.readLine();
                }
                return products;
            }


}
