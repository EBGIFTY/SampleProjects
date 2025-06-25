package pages;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import stepDefs.Hooks;
import utilities.NHSConstants;


public class JobsearchPage {

public	WebDriver driver;

	@FindBy(xpath = "//button[@name='accept-cookies'][@value='true']")  WebElement acceptCookies;
	@FindBy(xpath = "//input[contains(@aria-label, 'Search What?')]")  WebElement jobTitleSearch;
	@FindBy(xpath = "//input[@id='location']")  WebElement jobLocationSearch;
	@FindBy(xpath = "//input[@id='search']") WebElement jobSearch;
	@FindBy(xpath = "//h1[@id='search-results-heading']")  WebElement searchResultText;
	@FindBy(xpath = "//h2[@id='search-results-heading']")  WebElement searchResultText1;
	@FindBy(xpath = "//*[@data-test='search-result-query']")  WebElement searchFailureResultText;
	@FindBy(xpath = "//a[@data-test='search-result-job-title']") List<WebElement> searchJobResultHeadings;
	@FindBy(xpath = "//*[contains(@class, 'nhsuk-list search-results')]") List<WebElement> jobResults;
	@FindBy(id = "sort")  WebElement sortDropdown;
	@FindBy(xpath = "//li[@data-test='search-result-publicationDate']") List<WebElement> publicationDateList;
	@FindBy(id="searchOptionsBtn")  WebElement searchOptionsBtn;
	@FindBy(xpath = "//input[@id='jobReference']")  WebElement   jobReferenceValue;
	@FindBy(id="employer")  WebElement   employerValue;
	@FindBy(xpath = "//select[@id='distance']")  WebElement distanceValue;
	@FindBy(xpath = "//select[@id='payRange']")  WebElement payRange;
	
	
	
	
	private WebDriverWait wait;

	public JobsearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}



	public void clickCookies() {
		wait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
		acceptCookies.click();
		Hooks.test.log(LogStatus.INFO,"Click and accept the cookies");
	}

	public void scrollFunction(int xOffset, int yOffset) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", xOffset, yOffset);
		Hooks.test.log(LogStatus.INFO,"Scroll to down");
	}

	public void enterJobsearch(String jobTitle) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", jobTitleSearch);
		wait.until(ExpectedConditions.elementToBeClickable(jobTitleSearch)).clear();
		jobTitleSearch.sendKeys(jobTitle);
		Hooks.test.log(LogStatus.INFO,"Enter the job Title");
	}

	public void enterLocation(String location) {
		wait.until(ExpectedConditions.elementToBeClickable(jobLocationSearch)).clear();
		jobLocationSearch.sendKeys(location);
		Hooks.test.log(LogStatus.INFO,"Enter the location");
	}

	public void clickSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(jobSearch)).click();
		Hooks.test.log(LogStatus.INFO,"Clicked the search button");
	}

	
	public void enterJobReference(String jobReference) {
		
		jobReferenceValue.clear();
		jobReferenceValue.sendKeys(jobReference);
		wait.until(ExpectedConditions.attributeToBe(jobReferenceValue, "value", jobReference));
		Hooks.test.log(LogStatus.INFO,"jobReference value is:"+jobReference);
		
	}
	
	public void enterEmployer(String employer) {
		wait.until(ExpectedConditions.elementToBeClickable(employerValue)).clear();
		employerValue.sendKeys(employer);
		Hooks.test.log(LogStatus.INFO,"Enter the employer deatils");
	}

	public void selectDistance(String distance,String distanceId) {
		
		selectSortOption(distance, distanceId);
		Hooks.test.log(LogStatus.INFO,"select the distance");
		
	}
	
	public void selectPayRange(String payRange,String PAYRANGE_ID) {
		selectSortOption(payRange, PAYRANGE_ID);
		Hooks.test.log(LogStatus.INFO,"select the pay range");
		
	}
	public void clicksearchOptionsBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(searchOptionsBtn));
		searchOptionsBtn.click();
		Hooks.test.log(LogStatus.INFO,"Clicked the more search option button");
	}
	
	public boolean resultsExist() {
		try {
		
			scrollFunction(0,150);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='search-results-heading']")));
			String actualSearchResultText = searchResultText.getText();
			Hooks.test.log(LogStatus.INFO,"actualSearchResultText is: " + actualSearchResultText);
			assertTrue("Summary text does not contain expected job title.",
					
			StringUtils.containsAny(actualSearchResultText.toLowerCase(), NHSConstants.JOBS_FOUND_STR,NHSConstants.JOB_FOUND_STR));

			return !jobResults.isEmpty();

		} catch (TimeoutException e) {
			Hooks.test.log(LogStatus.FAIL,"No job results found after waiting.");
			return false;
		}
	}

	public List<WebElement> jobResults() {
		return jobResults;
	}

	public List<WebElement> getJobResultHeadings() {
		return searchJobResultHeadings;
	}

	public String getSearchSummaryText() {
		return wait.until(ExpectedConditions.visibilityOf(searchResultText)).getText();
	}

	public void selectSortOption(String OptionText, String DropdownId) {
		
		Hooks.test.log(LogStatus.INFO," Tring to select "+OptionText+ "from dropdown"+DropdownId);
		By dropdownLocator = By.id(DropdownId);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select dropdownElement = new Select(dropdown);
		dropdownElement.selectByVisibleText(OptionText);
		
	}

	public boolean areResultsSortedByDate() {
		
		
		List<String> postedDateList = new ArrayList<String>();
		for (WebElement element : publicationDateList) 
		{
			postedDateList.add(element.getText().replace("Date posted: ", ""));
			Hooks.test.log(LogStatus.INFO,"publication date in the first page:" +element.getText() );
		}
		
		Hooks.test.log(LogStatus.INFO,"Date sorting verification is active");
		
		return isSortedNewestFirst(postedDateList);
	}

	
	public boolean resultsNotExist() {
		try {
		
			
			Hooks.test.log(LogStatus.INFO,"waiting for the error heading");
			String actualError = getErrorMessage();
			if (!actualError.isEmpty() && actualError!=null)
			{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-test='search-result-query']")));
			String actualSearchResultText = searchFailureResultText.getText();
			Hooks.test.log(LogStatus.INFO,"actualSearchResultText is NOT empty and message is: " + actualSearchResultText);
			assertTrue("Summary text does not contain expected job title.",StringUtils.containsAny(actualSearchResultText.toLowerCase(), NHSConstants.ERROR_MSG1,NHSConstants.ERROR_MSG2));
		
		
			}
			else
			{    
				String actualSearchResultText = searchResultText1.getText();
				Hooks.test.log(LogStatus.INFO,"actualSearchResultText is Empty");
				assertTrue(actualSearchResultText.isEmpty() || actualSearchResultText.equalsIgnoreCase(NHSConstants.ERROR_MSG2),
				    	"Expected an error message, but none was shown.");
			}
			return CollectionUtils.isEmpty(jobResults);
		} catch (TimeoutException e) {
			Hooks.test.log(LogStatus.FAIL,"Job results found after waiting.");
			return false;
		}
	}
	
	public String getErrorMessage() {
	    try {
	    	Hooks.test.log(LogStatus.INFO, "Actual errormsg via getErrorMessage method: " + searchFailureResultText.getText().trim());
	        return searchFailureResultText.getText().trim();
	    } catch (NoSuchElementException e) {
	    	Hooks.test.log(LogStatus.FAIL,"No results found after waiting.");
	        return "no result found"; 
	    }
	}

	public void validate_error_message(DataTable dataTable) {
	    Map<String, String> data = dataTable.asMaps().get(0);
	    try {
	   
	        String expectedError = data.get("ErrorMsg") == null ? "" :data.get("ErrorMsg").trim(); 
	        String actualError = getErrorMessage();

	        Hooks.test.log(LogStatus.INFO,"Expected: " + expectedError);
	        Hooks.test.log(LogStatus.INFO,"Actual: " + actualError);
	        
	        if (actualError.isEmpty()) 
	        {
	        	 Hooks.test.log(LogStatus.INFO,"Actual error message is empty and validation started.");
	    	assertTrue(expectedError.isEmpty() || expectedError.equals(NHSConstants.ERROR_MSG2),
	    	"Expected an error message, but none was shown.");
	    	 Hooks.test.log(LogStatus.PASS,"No error message was displayed and validation Ended.");
	    		} 
	        else {
	        	 Hooks.test.log(LogStatus.INFO,"Actual error message is not empty and validation started.");
	        assertTrue("Expected message not found", StringUtils.contains(actualError.toLowerCase(), expectedError));
	        Hooks.test.log(LogStatus.PASS," Error message found: " + actualError+ " and Validation Ended.");
	    }
	    }
	    catch (NoSuchElementException e) {
	    	Hooks.test.log(LogStatus.FAIL,"Incorrect error message.");
	        
	    }
	}
	
	  public  boolean isSortedNewestFirst(List<String> dateStrings) {
	        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
	        try {
	            for (int i = 0; i < dateStrings.size() - 1; i++) {
	                Date current = formatter.parse(dateStrings.get(i));
	                Date next = formatter.parse(dateStrings.get(i + 1));
	                if (current.before(next)) {
	                    return false; 
	                }
	            }
	        } catch (ParseException e) {
	        	 Hooks.test.log(LogStatus.FAIL,"error msg " +e.getMessage()); 
	            return false;
	        }
	        return true;
	    }


}
