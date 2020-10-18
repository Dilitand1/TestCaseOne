package ru.litvinov.javapool;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.litvinov.javapool.config.ConfigClass;
import ru.litvinov.javapool.model.dao.Dao;

import java.net.InetAddress;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("main");
        /*
        String sql = "Select * from ppl where 1=1 and id = ?";
        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/test2", "postgres", "password"))
        {
            if (conn != null) {
                System.out.println("Connected to the database!");
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1,1);
                statement.execute();
                ResultSet rs = statement.getResultSet();
                while (rs.next()){
                    System.out.println(rs.getString("name"));
                }

            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        ping("172.17.0.1");
        ping("172.17.0.2");
        ping("127.0.0.1");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);

        Dao dao = context.getBean("daoImpl", Dao.class);
        List l = dao.getAllStudents();
        System.out.println(l);
    }

    public static void ping(String ip){
        try{
            InetAddress address = InetAddress.getByName(ip);
            boolean reachable = address.isReachable(10000);

            System.out.println("ip " + ip + "is reachable");
        } catch (Exception e){

            System.out.println("ip " + ip + "is not reachable");
        }
    }
}
