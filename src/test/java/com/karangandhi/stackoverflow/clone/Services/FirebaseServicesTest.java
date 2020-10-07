package com.karangandhi.stackoverflow.clone.Services;

import com.karangandhi.stackoverflow.clone.Services.FirebaseAuthService;
import com.karangandhi.stackoverflow.clone.Services.FirebaseService;
import com.karangandhi.stackoverflow.clone.Services.FirestoreService;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class FirebaseServicesTest {
    @Test public void testInitialiseApp() {
        try {
            FirebaseService.InitializeApp();
            FirebaseAuthService.Init();
            FirestoreService.Init();
        } catch (IOException exception) {
            exception.printStackTrace();
            assert(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
            assert(false);
        } catch (ExecutionException e) {
            e.printStackTrace();
            assert(false);
        }
    }

    @Test public void testUploadAndRetrieveDataFromDatabase() {
        class TestData {
            public String key;
            public TestData(String val) { this.key = val; }
        }

        TestData testData = new TestData("testVal");
        HashMap<String, TestData> testMap = new HashMap<>();
        testMap.put("Test Map", testData);

    }
}
