package data;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "nav buttons")
    public Object[] data(){
        Object[] obj = new String[] {"data1","data2"};

        return obj;
    }


}
