package XYZ.methods;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignUp {

    public static String[] SignUpNewMember(String name, String address, String dateOfBirth) {

        String username = generateUsername(name);
        String password = generatePassword(dateOfBirth);
        //this variable is to be returned to the servlet
        String userInfo[] = new String[2];
        userInfo[0] = username;
        userInfo[1] = password;

        //get today's date and convert to sql date format for DOR
        Date date = new Date();
        java.sql.Date dor = new java.sql.Date(date.getTime());

        //convert dateOfBirth to String, and to sql date format for dob
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = null;
        try {
            birthDate = df.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        java.sql.Date dob = new java.sql.Date(birthDate.getTime());

        //add member info into users table
        String sql_query = "INSERT into users "
                + "VALUES ('" + username + "', '" + password + "', 'APPLIED')";
        OpenConnectionSQL.executeQuery(sql_query);

        //now add member info into members table
        sql_query = "INSERT into members "
                + "VALUES ('" + username + "', '" + name + "', '" + address
                + "', '" + dob + "', '" + dor + "', 'APPLIED', 10)";
        OpenConnectionSQL.executeQuery(sql_query);

        OpenConnectionSQL.closeConn();

        return userInfo;
    }

    public static String generateUsername(String name) {
        String username;
        String[] splitter = name.split(" ", 2);
        splitter[0] = splitter[0].substring(0, 2);
        splitter[0] = splitter[0].concat("-");

        username = splitter[0].concat(splitter[1]);
        username = username.toLowerCase();

        return username;
    }

    public static String generatePassword(String dob) {
        String[] splitter = dob.split("/", 3);
        splitter[2] = splitter[2].substring(2, 4);

        String password = splitter[0].concat(splitter[1]);
        password = password.concat(splitter[2]);

        return password;
    }

}
