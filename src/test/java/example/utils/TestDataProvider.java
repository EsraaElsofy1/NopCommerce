package example.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    JsonFileManager jsonFileManager;

    @DataProvider(name = "getPositiveRegisterData")
    public Object[][] getPositiveRegisterData() {
        jsonFileManager = new JsonFileManager("src/main/resources/PositiveTestCases/Register_data.json");
        return jsonFileManager.getObjectData();
    }

    @DataProvider(name = "getNegativeRegisterData")
    public Object[][] getNegativeRegisterData() {
        jsonFileManager = new JsonFileManager("src/main/resources/NegativeTestCases/Register_data.json");
        return jsonFileManager.getObjectData();
    }

    @DataProvider(name = "positiveLoginData")
    public Object[][] getPositiveLoginData() {
        jsonFileManager = new JsonFileManager("src/main/resources/PositiveTestCases/Login_data.json");
        return jsonFileManager.getObjectData();
    }

    @DataProvider(name = "NegativeLoginData")
    public Object[][] getNegativeLoginData() {
        jsonFileManager = new JsonFileManager("src/main/resources/NegativeTestCases/Login_data.json");
        return jsonFileManager.getObjectData();
    }

    @DataProvider(name = "searchData")
    public Object[][] getSearchData() {
        jsonFileManager = new JsonFileManager("src/main/resources/PositiveTestCases/Search_data.json");
        return jsonFileManager.getObjectData();
    }

    @DataProvider(name = "wishListSearch")
    public Object[][] getWishListSearch() {
        jsonFileManager = new JsonFileManager("src/main/resources/PositiveTestCases/Wishlist_search_data.json");
        return jsonFileManager.getObjectData();
    }


    @DataProvider(name = "checkOutData")
    public Object[][] getCheckOutData() {
        jsonFileManager = new JsonFileManager("src/main/resources/PositiveTestCases/CheckOut_data.json");
        return jsonFileManager.getObjectData();
    }

}
