package XYZ.methods;

public class ChargeAllMembers {

    public static void chargeMembers(float fee) {
        
        String sql_query = "UPDATE Members SET balance= balance + " + fee;
        OpenConnectionSQL.executeQuery(sql_query);
        OpenConnectionSQL.closeConn();
        
    }
}
