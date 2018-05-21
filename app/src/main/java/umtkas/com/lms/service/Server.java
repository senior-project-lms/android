package umtkas.com.lms.service;

import okhttp3.Credentials;

public class Server {

    public static final String BASE_URL = "http://10.0.2.2:8090/";

    public static final String CLIENT_ID = "learningmanagementsystem";

    public static final String CLIENT_SECRET = "df05e4ef-08ae-4950-aaec-29dabda5ad62";

    public static final String GRANT_TYPE = "password";

    public static String getCredentials(){
        return Credentials.basic(CLIENT_ID, CLIENT_SECRET);
    }
}
