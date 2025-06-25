package stepDefs;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.JobsearchPage;
import utilities.NHSConstants;


public class NhsJobSearchStepDef {

	WebDriver driver = Hooks.driver;

	private WebDriverWait wait;
	JobsearchPage jobsearchPage = new JobsearchPage(driver);

	@Given("I am a jobseeker on NHS Jobs website")
	public void i_am_a_jobseeker_on_nhs_jobs_website()
	{
		Hooks.test.log(LogStatus.INFO, "Step starting: Trying to Launch the search application");
		driver.get(NHSConstants.NHS_SEARCH_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		Hooks.test.log(LogStatus.PASS, "NHS Jobs website Launched");
		
	}

	@When("I put {string} and {string} into the Search functionality")

	public void i_put_preferences_into_the_search_functionality(String jobTitle, String location) 
	{

		Hooks.test.log(LogStatus.INFO,"Entering job title: '" + jobTitle + "' and location: '" + location + "'");

		jobsearchPage.clickCookies();

	if (jobTitle.equals(NHSConstants.MAX_CHAR_LIMIT)) {
		jobTitle = "J".repeat(256);
	}
			if (location.equals(NHSConstants.MAX_CHAR_LIMIT)) {
		location = "L".repeat(256);
			}
		jobsearchPage.enterJobsearch(jobTitle);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		jobsearchPage.enterLocation(location);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		jobsearchPage.clickSearch();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		jobsearchPage.scrollFunction(0, 150);

		Hooks.test.log(LogStatus.PASS, "Check the Search functionality");
	}

	@Then("I should get a list of jobs which matches my preferences")
	public void i_should_get_a_list_of_jobs_which_matches_my_preferences() 
	{

		Hooks.test.log(LogStatus.INFO,"I should get a list of jobs which matches my preferences started");

		List<WebElement> jobResultHeadingsList = jobsearchPage.getJobResultHeadings();

		if (CollectionUtils.isNotEmpty(jobResultHeadingsList)) 
		{

			Hooks.test.log(LogStatus.INFO,"jobresults in the first page");
			for (WebElement element : jobResultHeadingsList) 
			{
				Hooks.test.log(LogStatus.INFO,"jobresults in the first page:" + element.getText());
			}
			assert jobsearchPage.resultsExist();
			Hooks.test.log(LogStatus.INFO,"jobresults in the first page and success the assert validation");
		} 
		else
		{
			Hooks.test.log(LogStatus.INFO,"No jobresults in the first page");
			assert jobsearchPage.resultsNotExist();
		}

		Hooks.test.log(LogStatus.PASS, "Check the preference and list of jobs which matches my preferences");

	}

	@Then("sort my search results with {string}  and from dropdown {string}")
	public void sort_my_search_results_with_the_newest_date_posted_if_the_job_results_avialable(String OptionText, String DropdownId) {

		
		List<WebElement> jobResultHeadingsList = jobsearchPage.getJobResultHeadings();
		if (CollectionUtils.isNotEmpty(jobResultHeadingsList))
		{
			jobsearchPage.scrollFunction(0, 200);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			jobsearchPage.selectSortOption(OptionText, DropdownId);
			
			assert jobsearchPage.areResultsSortedByDate();
			
			Hooks.test.log(LogStatus.INFO,"Sorted by Date Posted (newest)");
			Hooks.test.log(LogStatus.PASS, "Sort the Results");
		} 
		else
		{
			Hooks.test.log(LogStatus.INFO,"No jobresults in the first page and sort function is not available");
		}
	}
	
	@Then("Validate the error message")
	public void Validate_the_error_message(DataTable dataTable) {
		jobsearchPage.validate_error_message(dataTable);
		Hooks.test.log(LogStatus.PASS, "Validate the error message");
	}
	
	@Then("I put all values into the Search functionality")
	public void I_put_all_values_into_the_Search_functionalitys(DataTable dataTable) {
		
		Map<String, String> data = dataTable.asMaps().get(0);

		String jobTitle = data.get("jobTitle") == null ? "" :data.get("jobTitle").trim();
		String location = data.get("location") == null ? "" :data.get("location").trim();
		String jobReference = data.get("jobReference") == null ? "" :data.get("jobReference").trim();
		String distance = data.get("distance") == null ? "" :data.get("distance").trim();
		String payRange = data.get("payRange") == null ? "" :data.get("payRange").trim();
		String employer = data.get("employer") == null ? "" :data.get("employer").trim();

		Hooks.test.log(LogStatus.INFO,"User adding filters : Entering job title: '" + jobTitle + "' and location: '" + location + "'");
		Hooks.test.log(LogStatus.INFO,"jobReference: '" + jobReference + "' and distance: '" + distance + "' ");
		Hooks.test.log(LogStatus.INFO,"payRange: '" + payRange + "' and employer: '" + employer + "'");

		jobsearchPage.clickCookies();

		if (jobTitle.equals(NHSConstants.MAX_CHAR_LIMIT)) {
			jobTitle = "J".repeat(256);
		}
		if (location.equals(NHSConstants.MAX_CHAR_LIMIT)) {
			location = "L".repeat(256);
		}
		jobsearchPage.enterJobsearch(jobTitle);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		jobsearchPage.enterLocation(location);

		jobsearchPage.selectDistance(distance, NHSConstants.DISTANCE_ID);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		jobsearchPage.clicksearchOptionsBtn();

		jobsearchPage.enterJobReference(jobReference);

		jobsearchPage.enterEmployer(employer);

		jobsearchPage.selectPayRange(payRange, NHSConstants.PAYRANGE_ID);

		jobsearchPage.clickSearch();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

		jobsearchPage.scrollFunction(0, 150);

		Hooks.test.log(LogStatus.PASS, "Check the Search functionality with more filters");
	}
	

}
