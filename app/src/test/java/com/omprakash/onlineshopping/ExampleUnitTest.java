package com.omprakash.onlineshopping;

import org.junit.Test;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.omprakash.onlineshopping.network.ShoppingApi;
import com.omprakash.onlineshopping.network.ShoppingService;
import com.omprakash.onlineshopping.network.model.Product;
import com.omprakash.onlineshopping.network.model.ProductApiResponse;
import com.omprakash.onlineshopping.network.model.ProductsRequest;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getProducts() throws IOException {
        ShoppingApi api = new ShoppingApi();
        ShoppingService service = api.createShoppingService();
        Call<ProductApiResponse> call = service.fetchProducts(new ProductsRequest("1", "1"));
        List<Product> products = call.execute().body().getResponse().getProducts();
        assertNotNull(products);
        assertFalse(products.isEmpty());
        System.out.println(new Gson().toJson(products));
    }
}