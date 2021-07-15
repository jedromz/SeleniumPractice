package utils;

import config.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static config.WebDriverFactory.*;

public class Screenshot {
    private static int count = 1;

    public static void captureScreenshot() throws IOException {
        File src =  ((TakesScreenshot) getWebDriver(CHROME_DRIVER)

                .orElseThrow(IllegalAccessError::new)).getScreenshotAs(OutputType.FILE);
        var dstFile = new File(String.format("src/test/java/screenshots/screen%d.png",count));
        FileUtils.copyFile(src,dstFile);
        count++;

    }
}
