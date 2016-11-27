package XYZ.methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignUp {

    public static String[] SignUpNewMember(String name, String address, String dateOfBirth) {

        String username = generateUsername(name);
        String password = generatePassword(dateOfBirth);
        
        //check if username is already used in the database or not, and if it's 
        //used, add 1 to the end of the username
        String usernameUsed = isUsernameUsed(username);
        
        //the method isUsernameUsed returns the exact same username if it's not in use yet
        //otherwise it returns the latest entry of the same name in the database , i.e ja-bond1
        if (usernameUsed != username) {
            username = generateNewUsername(usernameUsed);
        } 
        
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
    
    public static String isUsernameUsed(String username) {
        String query = "SELECT * from users where id like '%" + username + "%' order by id desc";
        
        ResultSet rs = OpenConnectionSQL.getData(query);

        try {
            if (rs.next()) {
                return rs.getString("id");
            } else {
                return username;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            OpenConnectionSQL.closeConn();
            OpenConnectionSQL.closeResultSet();
        }
        return username;
    }
    
    public static String generateNewUsername(String username) {
        char lastChar = username.charAt(username.length() - 1);
        char secondLastChar = username.charAt(username.length() - 2);
        boolean isTwoDigits = false;
        int digit = 0;
        String newUsername = null;
        
        //check if the username has a digit already behind it or not
        if (Character.isDigit(lastChar)) {
            //if it yes, see if the second last char is a digit as well or not i.e ja-holding12

            if (Character.isDigit(secondLastChar)) {
                //meaning the digit is more than 9
                isTwoDigits = true;
                digit = (Character.getNumericValue(secondLastChar) * 10) + Character.getNumericValue(lastChar);
            } else {
                digit = Character.getNumericValue(lastChar);
            }

            digit++;

            if (isTwoDigits) {
                newUsername = username.substring(0, username.length() - 2);
                newUsername = newUsername.concat(Integer.toString(digit));
            } else {
                newUsername = username.substring(0, username.length() - 1);
                newUsername = newUsername.concat(Integer.toString(digit));
            }
        } else {
            //if there is no digit behind this username, just add 1 to his username
            newUsername = username.concat(Integer.toString(1));
        }
        
        return newUsername;
    }

}
