package netWork.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerParam {
    public static int PORT;
    public static String HOST;
    static {
        try(InputStream in = ServerParam.class.getResourceAsStream("Server.properties")){
            Properties properties1 = new Properties();
            properties1.load(in);
            PORT = Integer.parseInt(properties1.getProperty("port"));
            HOST = properties1.getProperty("host");
        }catch (IOException e){
            System.out.println("can't load the properties");
        }
    }
}
