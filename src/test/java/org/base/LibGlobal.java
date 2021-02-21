package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {
	public  WebDriver driver;

	// To Intallize Driver
	public void getDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Programs\\SampleMaven\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// To Launch URL
	public void launchUrl(String url) {
		driver.get(url);
	}

	// To get Title of Particular Link
	public void title() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// To get Current WebPage URL Title
	public void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	// To Close My Current WebPage
	public void close() {
		driver.close();
	}

	// To Quit My Browser and it will Destroy Object also
	public void quit() {
		driver.quit();
	}

	// To Enter My Own Values in TextBox of WebPage
	public void enterText(WebElement element, String data) {
		element.sendKeys(data);
	}

	// To Click Particular Button present in WebPage
	public void btnClick(WebElement element) {
		element.click();
	}

	// To Clear All My Values Which i have Already entered into TextBox
	public void clearEnteredData(WebElement element) {
		element.clear();
	}

	// To GetText from WebPage
	public void textfromPage(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	// To Print the TextBox values from WebPage into Console
	public void getEnterText(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
	}

	public void allWebElements(List<WebElement> elements) {
		for (int i = 0; i < elements.size(); i++) {
			WebElement webElement = elements.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
	}

	// To Check Radio Button Was Selected OR Not
	public void checkingSelectedRadioButton(WebElement element) {
		boolean selected = element.isSelected();
		if (selected == true) {
			System.out.println("Button is Selected");
		} else {
			System.out.println("Button is not Selected");
		}
	}

	// To Perform MouseOver Actions on WebPage
	public void moveToElement(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}

	// To Perform Drag_Drop Actions on WebPage
	public void drag_drop(WebElement element_1, WebElement element_2) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(element_1, element_2);
	}

	// To perform RightClick Action in WebPage
	public void rightClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element).perform();
	}

	// To perform DoubleClick Action in WebPage
	public void doubleClick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.doubleClick(element).perform();
	}

	// Enter Values into TextBox through JavaScript
	public void entryTextByJs(WebElement element, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}

	// Click Button through JavaScript
	public void clickByJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	// Print Entered Values to TextBox through JavaScript
	public void getValuesByJs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object value = js.executeScript("return arguments[0].getAttribute('value')", element);
		System.out.println(value);
	}

	// Perform Scroll_Down through JavaScript
	public void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// Perform Scroll_Up through JavaScript
	public void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// To take ScreenShot
	public void screenShot(String des) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File(des);
		FileUtils.copyFile(src, dest);
	}

	// To handle Alert by Pressing OK
	public void confirmAlert(WebElement element) {
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// To handle Alert by Pressing CANCEL
	public void dismissAlert(WebElement element) {
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// To handle Alert by Passing Values into TextBox of Alert
	public void enterValuesAlert(WebElement element, String value) {
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	// To Perform Key_Board Actions
	public  void keyboardAction(int keycode) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keycode);
		r.keyRelease(keycode);
	}

	// Selecting Drop_Down option by Value
	public void selectByValue(WebElement element, String value) {
		Select byValue = new Select(element);
		byValue.selectByValue(value);
	}

	// Selecting Drop_Down option by Index
	public void selectByIndex(WebElement element, int num) {
		Select byIndex = new Select(element);
		byIndex.selectByIndex(num);
	}

	// Selecting Drop_Down option by VisibleText
	public void selectByVisisbleText(WebElement element, String value) {
		Select byVisibleText = new Select(element);
		byVisibleText.selectByVisibleText(value);
	}

	// DeSelecting Drop_Down option by Value
	public void deselectByValue(WebElement element, String value) {
		Select byValue = new Select(element);
		byValue.selectByValue(value);
	}

	// DeSelecting Drop_Down option by Index
	public void deselectByIndex(WebElement element, int num) {
		Select byIndex = new Select(element);
		byIndex.selectByIndex(num);
	}

	// DeSelecting Drop_Down option by VisibleText
	public void deselectByVisisbleText(WebElement element, String value) {
		Select byVisibleText = new Select(element);
		byVisibleText.selectByVisibleText(value);
	}

	// Selecting Drop_Down Alloptions
	public void allOptionsInDropDown(WebElement element) {
		Select options = new Select(element);
		List<WebElement> alloptionsInDropDown = options.getOptions();
		for (int i = 0; i < alloptionsInDropDown.size(); i++) {
			WebElement value = alloptionsInDropDown.get(i);
			String text = value.getText();
			System.out.println(text);
		}
	}

	// To Check Drop_Down option is Selected OR Not
	public void checkDropDownSlected(WebElement element) {
		Select select = new Select(element);
		boolean selected = select.isMultiple();
		if (selected == true) {
			System.out.println("Option is Slected");
		} else {
			System.out.println("Option is not Selected");
		}
	}

	// To get Values from Excel
	public String readFromExcel(String path, String sheetName, int rowNo, int cellNo) throws IOException {
		File f = new File(path);
		FileInputStream stream1 = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(stream1);
		Sheet sht1 = wb.getSheet(sheetName);
		Row row = sht1.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int type = cell.getCellType();
		String value = "";
		if (type == 1) {
			value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dt = cell.getDateCellValue();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			value = dateFormat.format(dt);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
		}
		return value;

	}

	// To get Total Number of Links Present in WebPage
	public void totalNumOfLinks(String linkTageName) {
		List<WebElement> link = driver.findElements(By.tagName(linkTageName));
		int size = link.size();
		System.out.println(size);
	}

	// To get Total Number of Tables Present in WebPage
	public void totalNumOfTables(String tableTagName) {
		List<WebElement> table = driver.findElements(By.tagName(tableTagName));
		int size = table.size();
		System.out.println(size);
	}
	
}
